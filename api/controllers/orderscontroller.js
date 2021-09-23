const models = require('../repositories/eats-data')

class OrderController
{
    constructor()
    {
    }

    // list all products
    listProducts()
    {
        return models.ea_products.findAll()
    }

    // list all products by a restaurant
    async productsByRestaurant(name)
    {
        // get restaurant by name
        console.log(name)
        const rest = await models.ea_restaurants.findOne({where: {name: name}})
        return await models.ea_products.findAll({where: {idRestaurant: rest.idRestaurant}})
    }

    // create new order
    async createOrder(body)
    {
        // get the restaurant by its name
        const rest = await models.ea_restaurants.findOne({where: {name: body.restaurantName}})
        // get the user by its name
        const user = await models.ea_users.findOne({where: {username: body.username}})
        // insert the new order
        const order = await models.ea_orders.create({
            posttime: body.posttime,
            canceled: 0,
            restaurantName: body.restaurantName,
            idUser: user.idUser    
        })
        // total price
        var totalPrice = 0
        // parse the products of the order
        for (var i = 0; i < body.products.length; i++)
        {   
            // get each order
            var bodyProduct = body.products[i]
            // get the corresponding product object for each or product name
            const product = await models.ea_products.findOne({where: {name: bodyProduct.name}})
            // create the products per order
            models.ea_productsPerOrder.create({
                quantity: bodyProduct.quantity,
                idOrder: order.idOrder,
                idProduct: product.idProduct
            })
            // add to the total price
            totalPrice = totalPrice + (bodyProduct.quantity * product.price)
        }
        await models.ea_orders.update({totalPrice: totalPrice}, {where: {idOrder: order.idOrder}})
        const completeOrder = await models.ea_orders.findOne({where: {idOrder: order.idOrder}})
        console.log(completeOrder)
        return completeOrder
    }
 }

 module.exports = new OrderController()