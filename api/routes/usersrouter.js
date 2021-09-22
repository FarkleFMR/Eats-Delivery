const express = require("express");
const UserController = require("../controllers/userscontrollers")

const userRouter = express.Router()

userRouter.get('/users', async (req, res) => {
    const users = await UserController.listUsers()
    res.send(users)  
})

module.exports = userRouter