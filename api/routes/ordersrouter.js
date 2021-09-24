const express = require("express");
const OrderController = require("../controllers/orderscontroller")

const app = express()
app.use(express.json())

// create a new order
app.post('/create', async (req, res) => {
    const order = OrderController.createOrder(req.body)
    res.send(order)
})

app.get('/prueba', async (req, res) => {
    res.send('prueba')
})

module.exports = app