const express = require("express");
const ProductController = require("../controllers/productscontroller")

const app = express()
app.use(express.json())

// create product
app.post('/create', async (req, res) => {
    const product = await ProductController.createProduct(req.body)
    res.send(product)
})

// products by restaurant
app.get('/productsByRestaurant/:name', async (req, res) => {
    const products = await ProductController.productsByRestaurant(req.params.name)
    res.send(products)
})

// watch product
app.get('/product/:name', async (req, res) => {
    const product = await ProductController.findByName(req.params.name)
    res.send(product)
})

module.exports = app
