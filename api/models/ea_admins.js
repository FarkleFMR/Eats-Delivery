const Sequelize = require('sequelize');
module.exports = function(sequelize, DataTypes) {
  return sequelize.define('ea_admins', {
    idAdmin: {
      autoIncrement: true,
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    name: {
      type: DataTypes.TEXT,
      allowNull: false
    },
    lastname: {
      type: DataTypes.TEXT,
      allowNull: false
    },
    countryid: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    workid: {
      type: DataTypes.TEXT,
      allowNull: false
    },
    idAdminCategory: {
      type: DataTypes.INTEGER,
      allowNull: false,
      references: {
        model: 'ea_adminCategory',
        key: 'idAdminCategory'
      }
    }
  }, {
    sequelize,
    tableName: 'ea_admins',
    timestamps: false
  });
};
