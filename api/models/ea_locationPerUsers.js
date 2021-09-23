const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('ea_locationPerUsers', {
    idUser: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_users',
        key: 'idUser'
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
    tableName: 'ea_locationPerUsers',
    timestamps: false
  });
};

