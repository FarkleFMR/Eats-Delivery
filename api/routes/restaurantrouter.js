const express = require("express");
const RestaurantController = require("../controllers/restaurantscontroller")

const app = express()
app.use(express.json())

// create restaurant
app.post('/create', async (req, res) => {
    const rest = await RestaurantController.createRestaurant(req.body)
    res.send(rest)
})

module.exports = app
