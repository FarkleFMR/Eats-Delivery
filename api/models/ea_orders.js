const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('ea_orders', {
    idOrder: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    posttime: {
      type: DataTypes.TEXT,
      allowNull: false
    },
    totalPrice: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    canceled: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    restaurantName: {
      type: DataTypes.TEXT,
      allowNull: false
    },
    idUser: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_users',
        key: 'idUser'
      }
    }
  }, {
    sequelize,
    tableName: 'ea_orders',
    timestamps: false
  });
};
