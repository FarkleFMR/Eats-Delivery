const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('ea_deletionApplication', {
    idApplication: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    posttime: {
      type: DataTypes.TEXT,
      allowNull: false
    },
    accepted: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    idRestaurant: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_restaurants',
        key: 'idRestaurant'
      }
    }
  }, {
    sequelize,
    tableName: 'ea_deletionApplication',
    timestamps: false
  });
};
