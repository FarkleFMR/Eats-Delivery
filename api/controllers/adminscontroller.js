const models = require('../repositories/eats-data')
const { createHmac } = require('crypto');

class AdminController
{
    secret 

    constructor()
    {
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

    // list all admins
    listAdmins()
    {
        return models.ea_admins.findAll()
    }

    // create new restaurant
    async createAdmin(body)
    {
        // get category id by category name
        const category = await models.ea_adminCategory.findOne({where: {name: body.category}}) 
        // encrypt password
        const encryptedPassword = this.encrypt(body.workid+this.secret, body.password)
        // create new admin 
        return await models.ea_admins.create({
            name: body.name,
            lastname: body.lastname,
            countryid: body.countryid,
            workid: body.workid,
            idAdminCategory: category.idAdminCategory,
            password: encryptedPassword
        })
    }

    // login admin
    async authAdmin(body)
    {
        // users password
        const hashedPassword = this.encrypt(body.workid+this.secret, body.password)
        
        // get the admin password that match the incoming username 
        const admin = await models.ea_admins.findOne({attributes: ['password'], where: {workid: body.workid}})
        // if it matches the hashed incoming password, the password is correct
        console.log(admin.password)
        if(hashedPassword == admin.password)
        {
            return 'Autenticado correctamente.'
        }
        else
        {
            return 'No se ha podido autenticar correctamente.'
        }
    }
 }

 module.exports = new AdminController()