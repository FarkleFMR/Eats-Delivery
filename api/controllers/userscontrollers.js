const models = require('../repositories/eats-data')
const { createHmac } = require('crypto');

class UserController
{ 
    secret 
    
    constructor(){
        this.secret = 'jjramcreq'
    }

    // encrypt 
    encrypt(newSecret, text)
    {
        const hash = createHmac('sha256', newSecret)
               .update(text)
               .digest('hex');
        return hash
    }

    // get all users
    listUsers()
    {
        return models.ea_users.findAll()
    }

    // create account
    createUser(body)
    {
        const password = body.password
        const userSecret = body.username + this.secret 
        const hash = createHmac('sha256', userSecret)
               .update(password)
               .digest('hex');
        body.password = hash
        // create user
        models.ea_users.create(body)
    }

    // login
    async authUser(body)
    {
        // users password
        const password = body.password
        // create usersecrete
        const userSecret = body.username + this.secret
        // hash the incoming password 
        const hash = createHmac('sha256', userSecret)
               .update(password)
               .digest('hex');
        // get the user password that match the incoming username 
        const user = await models.ea_users.findOne({attributes: ['password'], where: {username: body.username}})
        // if it matches the hashed incoming password, the password is correct
        if(hash == user.password)
        {
            return 'Autenticado correctamente.'
        }
        else
        {
            return 'No se ha podido autenticar correctamente.'
        }
    }

    // add direction to user
    async addDirection(body)
    {
        // get the username
        const username = body.username
        // get its respective id
        const user = await models.ea_users.findOne({where: {username: username}})
        // insert a direction
        const location = body.location
        const direction = await models.ea_locations.create({location: location})
        // insert into locationsPerUser
        const directionPerUser = await models.ea_locationPerUsers.create({idUser: user.idUser, idLocation: direction.idLocation})
        // return the query of the username and locationx
        return directionPerUser
    }

    // add card info
    async addCard(body)
    {
        // get user
        const username = body.username
        const user = await models.ea_users.findOne({where: {username: username}})
        // encrypt number
        const encryptedNumber = this.encrypt(this.secret, body.number)
        // encrypt code
        const encryptedCode = this.encrypt(this.secret, body.code.toString())

        // create a new card associated w/ the user
        const card = await models.ea_cardInfo.create({number: encryptedNumber,
                                                    name: body.name,
                                                    code: encryptedCode,
                                                    date: body.date,
                                                    idUser: user.idUser})
        return card
    }
}

module.exports = new UserController()