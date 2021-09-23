const express = require("express")
const directionRouter = require("./directionsrouter")
const userRouter = require("./usersrouter") 
const restaurantRouter = require("./restaurantrouter")
const adminRouter = require("./adminsrouter")

class Routes
{
    app
    constructor()
    {
        this.app = express()
        this.app.use(express.json())
        this.routes()
    }

    routes()
    {
        this.app.use("/user", userRouter)  
        this.app.use("/direction", directionRouter)
        this.app.use('/restaurant', restaurantRouter)
        this.app.use('/admin', adminRouter)
    }
}

module.exports = new Routes().app;