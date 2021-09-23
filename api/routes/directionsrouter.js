const express = require("express");
const DirectionsController = require("../controllers/directionscontroller")

const app = express()
app.use(express.json())

// get all the locations
app.get('/directions', async (req, res) => {
    const directions = await DirectionsController.listDirections()
    res.send(directions)  
})

app.post('/createDirection', async (req, res) => {
    const response = await DirectionsController.addDirection(req.body)
    res.send(response)
})

module.exports = app
