const express = require("express")
const directionRouter = require("./directionsrouter")
const userRouter = require("./usersrouter") 
const restaurantRouter = require("./restaurantrouter")
const adminRouter = require("./adminsrouter")
const productRouter = require("./productsrouter")
const orderRouter = require("./ordersrouter")

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
        this.app.use('/product', productRouter)
        this.app.use('/order', orderRouter)
    }
}

module.exports = new Routes().app;