const models = require('../repositories/eats-data')

class ProductController
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

    // create new restaurant
    async createProduct(body)
    {
        // get the restaurant by its name
        const rest = await models.ea_restaurants.findOne({where: {name: body.restaurant}})
        // insert the new product
        return await models.ea_products.create({
            name: body.name,
            image: body.image,
            price: body.price,
            ingredients: body.ingredients,
            description: body.description,
            quantity: body.quantity,
            idRestaurant: rest.idRestaurant,
        })
    }

    // find product by name
    async findByName(name)
    {
        // return all the restaurants that match a name
        return await models.ea_products.findOne({where: {name: name}})
    }
 }

 module.exports = new ProductController()