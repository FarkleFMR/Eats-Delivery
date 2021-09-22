const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('ea_restaurants', {
    idRestaurant: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    name: {
      type: DataTypes.TEXT,
      allowNull: false
    },
    image: {
      type: DataTypes.TEXT,
      allowNull: false
    },
    shippingcost: {
      type: DataTypes.INTEGER,
      allowNull: false,
      defaultValue: 750
    },
    deleted: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    idRestaurantCategory: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_restaurantCategory',
        key: 'idRestaurantCategory'
      }
    },
    idAdmin: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_restaurantCategory',
        key: 'idRestaurantCategory'
      }
    }
  }, {
    sequelize,
    tableName: 'ea_restaurants',
    timestamps: false
  });
};
