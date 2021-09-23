const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('ea_drivers', {
    idAdmin: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_admins',
        key: 'idAdmin'
      }
    },
    idDriverState: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_driverStates',
        key: 'idDriverState'
      }
    },
    rating: {
      type: DataTypes.INTEGER,
      allowNull: false,
      defaultValue: 5
    }
  }, {
    sequelize,
    tableName: 'ea_drivers',
    timestamps: false
  });
};
