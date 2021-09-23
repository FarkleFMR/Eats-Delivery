const express = require("express");
const AdminController = require("../controllers/adminscontroller")

const app = express()
app.use(express.json())

// create a new admin
app.post('/create', async (req, res) => {
    const admin = await AdminController.createAdmin(req.body)
    res.send(admin)
})

// login
app.post('/login', async (req, res) => {
    const response = await AdminController.authAdmin(req.body)
    res.send(response)
})

module.exports = app