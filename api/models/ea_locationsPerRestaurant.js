const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('ea_locationsPerRestaurant', {
    idRestaurant: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_restaurants',
        key: 'idRestaurant'
      }
    },
    idLocation: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_locations',
        key: 'idLocation'
      }
    }
  }, {
    sequelize,
    tableName: 'ea_locationsPerRestaurant',
    timestamps: false
  });
};
