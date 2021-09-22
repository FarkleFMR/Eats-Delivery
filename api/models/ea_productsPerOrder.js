const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('ea_productsPerOrder', {
    quantity: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    idOrder: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_orders',
        key: 'idOrder'
      }
    },
    idProduct: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_products',
        key: 'idProduct'
      }
    }
  }, {
    sequelize,
    tableName: 'ea_productsPerOrder',
    timestamps: false
  });
};
