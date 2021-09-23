var DataTypes = require("sequelize").DataTypes;
var _ea_adminCategory = require("./ea_adminCategory");
var _ea_admins = require("./ea_admins");
var _ea_cardInfo = require("./ea_cardInfo");
var _ea_deletionApplication = require("./ea_deletionApplication");
var _ea_driverStates = require("./ea_driverStates");
var _ea_drivers = require("./ea_drivers");
var _ea_locationPerUsers = require("./ea_locationPerUsers");
var _ea_locations = require("./ea_locations");
var _ea_locationsPerRestaurant = require("./ea_locationsPerRestaurant");
var _ea_orders = require("./ea_orders");
var _ea_products = require("./ea_products");
var _ea_productsPerOrder = require("./ea_productsPerOrder");
var _ea_restaurantCategory = require("./ea_restaurantCategory");
var _ea_restaurants = require("./ea_restaurants");
var _ea_users = require("./ea_users");

function initModels(sequelize) {
  var ea_adminCategory = _ea_adminCategory(sequelize, DataTypes);
  var ea_admins = _ea_admins(sequelize, DataTypes);
  var ea_cardInfo = _ea_cardInfo(sequelize, DataTypes);
  var ea_deletionApplication = _ea_deletionApplication(sequelize, DataTypes);
  var ea_driverStates = _ea_driverStates(sequelize, DataTypes);
  var ea_drivers = _ea_drivers(sequelize, DataTypes);
  var ea_locationPerUsers = _ea_locationPerUsers(sequelize, DataTypes);
  var ea_locations = _ea_locations(sequelize, DataTypes);
  var ea_locationsPerRestaurant = _ea_locationsPerRestaurant(sequelize, DataTypes);
  var ea_orders = _ea_orders(sequelize, DataTypes);
  var ea_products = _ea_products(sequelize, DataTypes);
  var ea_productsPerOrder = _ea_productsPerOrder(sequelize, DataTypes);
  var ea_restaurantCategory = _ea_restaurantCategory(sequelize, DataTypes);
  var ea_restaurants = _ea_restaurants(sequelize, DataTypes);
  var ea_users = _ea_users(sequelize, DataTypes);

  ea_admins.belongsTo(ea_adminCategory, { as: "idAdminCategory_ea_adminCategory", foreignKey: "idAdminCategory"});
  ea_adminCategory.hasMany(ea_admins, { as: "ea_admins", foreignKey: "idAdminCategory"});
  ea_drivers.belongsTo(ea_admins, { as: "idAdmin_ea_admin", foreignKey: "idAdmin"});
  ea_admins.hasMany(ea_drivers, { as: "ea_drivers", foreignKey: "idAdmin"});
  ea_drivers.belongsTo(ea_driverStates, { as: "idDriverState_ea_driverState", foreignKey: "idDriverState"});
  ea_driverStates.hasMany(ea_drivers, { as: "ea_drivers", foreignKey: "idDriverState"});
  ea_locationPerUsers.belongsTo(ea_locations, { as: "idLocation_ea_location", foreignKey: "idLocation"});
  ea_locationPerUsers.removeAttribute('id');
  ea_locations.hasMany(ea_locationPerUsers, { as: "ea_locationPerUsers", foreignKey: "idLocation"});
  ea_locationsPerRestaurant.belongsTo(ea_locations, { as: "idLocation_ea_location", foreignKey: "idLocation"});
  ea_locations.hasMany(ea_locationsPerRestaurant, { as: "ea_locationsPerRestaurants", foreignKey: "idLocation"});
  ea_productsPerOrder.belongsTo(ea_orders, { as: "idOrder_ea_order", foreignKey: "idOrder"});
  ea_orders.hasMany(ea_productsPerOrder, { as: "ea_productsPerOrders", foreignKey: "idOrder"});
  ea_productsPerOrder.belongsTo(ea_products, { as: "idProduct_ea_product", foreignKey: "idProduct"});
  ea_products.hasMany(ea_productsPerOrder, { as: "ea_productsPerOrders", foreignKey: "idProduct"});
  ea_restaurants.belongsTo(ea_restaurantCategory, { as: "idAdmin_ea_restaurantCategory", foreignKey: "idAdmin"});
  ea_restaurantCategory.hasMany(ea_restaurants, { as: "ea_restaurants", foreignKey: "idAdmin"});
  ea_restaurants.belongsTo(ea_restaurantCategory, { as: "idRestaurantCategory_ea_restaurantCategory", foreignKey: "idRestaurantCategory"});
  ea_restaurantCategory.hasMany(ea_restaurants, { as: "idRestaurantCategory_ea_restaurants", foreignKey: "idRestaurantCategory"});
  ea_deletionApplication.belongsTo(ea_restaurants, { as: "idRestaurant_ea_restaurant", foreignKey: "idRestaurant"});
  ea_restaurants.hasMany(ea_deletionApplication, { as: "ea_deletionApplications", foreignKey: "idRestaurant"});
  ea_locationsPerRestaurant.belongsTo(ea_restaurants, { as: "idRestaurant_ea_restaurant", foreignKey: "idRestaurant"});
  ea_restaurants.hasMany(ea_locationsPerRestaurant, { as: "ea_locationsPerRestaurants", foreignKey: "idRestaurant"});
  ea_products.belongsTo(ea_restaurants, { as: "idRestaurant_ea_restaurant", foreignKey: "idRestaurant"});
  ea_restaurants.hasMany(ea_products, { as: "ea_products", foreignKey: "idRestaurant"});
  ea_cardInfo.belongsTo(ea_users, { as: "idUser_ea_user", foreignKey: "idUser"});
  ea_users.hasMany(ea_cardInfo, { as: "ea_cardInfos", foreignKey: "idUser"});
  ea_locationPerUsers.belongsTo(ea_users, { as: "idUser_ea_user", foreignKey: "idUser"});
  ea_users.hasMany(ea_locationPerUsers, { as: "ea_locationPerUsers", foreignKey: "idUser"});
  ea_orders.belongsTo(ea_users, { as: "idUser_ea_user", foreignKey: "idUser"});
  ea_users.hasMany(ea_orders, { as: "ea_orders", foreignKey: "idUser"});

  return {
    ea_adminCategory,
    ea_admins,
    ea_cardInfo,
    ea_deletionApplication,
    ea_driverStates,
    ea_drivers,
    ea_locationPerUsers,
    ea_locations,
    ea_locationsPerRestaurant,
    ea_orders,
    ea_products,
    ea_productsPerOrder,
    ea_restaurantCategory,
    ea_restaurants,
    ea_users,
  };
}
module.exports = initModels;
module.exports.initModels = initModels;
module.exports.default = initModels;
