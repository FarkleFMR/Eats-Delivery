const models = require('../repositories/eats-data')

class DirectionsController
{ 
    
    constructor(){
    }

    // get all directions
    listDirections()
    {
        return models.ea_locations.findAll()
    }

    // add direction
    async addDirection(body)
    {
        return await models.ea_locations.create(body)
    }

}

module.exports = new DirectionsController()