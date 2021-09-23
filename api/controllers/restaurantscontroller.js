const models = require('../repositories/eats-data')

class RestaurantController
{
    constructor()
    {
    }

    // list all restaurants
    listRestaurants()
    {
        return models.ea_restaurants.findAll()
    }

    // create new restaurant
    async createRestaurant(body)
    {
        // get category id by category name
        const category = await models.ea_restaurantCategory.findOne({where: {name: body.category}}) 
        // get the ownerid by its working id
        const owner = await models.ea_admins.findOne({where: {workid: body.workid}})
        // insert the new restaurant
        return await models.ea_restaurants.create({
            name: body.name,
            image: body.image,
            deleted: body.deleted,
            idRestaurantCategory: category.idRestaurantCategory,
            idAdmin: owner.idAdmin
        })
    }

    // list restaurants per category
    async listPerCategory(body)
    {
        // get the category object to get the id
        const category = await models.ea_restaurantCategory.findOne({where: {name: body.category}})
        // search all the restaurants that match the category id
        return await models.ea_restaurants.findAll({where: {idRestaurantCategory: category.idRestaurantCategory}})
    }

    // find restaurant by name
    async findByName(body)
    {
        // return all the restaurants that match a name
        return await models.ea_restaurants.findAll({where: {name: body.name}})
    }

 }

 module.exports = new RestaurantController()