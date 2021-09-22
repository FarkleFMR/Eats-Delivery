const { Sequelize } = require('sequelize')
var initModels = require("../models/init-models");

const sequelize = new Sequelize('sqlite:../db/eats-delivery.db')
var models = initModels(sequelize)

module.exports = models