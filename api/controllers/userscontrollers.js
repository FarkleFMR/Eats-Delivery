const models = require('../repositories/eats-data')

class UserController
{   
    constructor(){}

    listUsers()
    {
        return models.ea_users.findAll()
    }
}

module.exports = new UserController()