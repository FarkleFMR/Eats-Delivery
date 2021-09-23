BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "ea_users" (
	"idUser"	INTEGER NOT NULL,
	"username"	TEXT NOT NULL,
	"name"	TEXT NOT NULL,
	"lastname"	TEXT NOT NULL,
	"password"	TEXT NOT NULL,
	"email"	INTEGER NOT NULL,
	PRIMARY KEY("idUser")
);
CREATE TABLE IF NOT EXISTS "ea_locations" (
	"idLocation"	INTEGER NOT NULL,
	"location"	TEXT NOT NULL,
	PRIMARY KEY("idLocation")
);
CREATE TABLE IF NOT EXISTS "ea_locationPerUsers" (
	"idUser"	INTEGER NOT NULL,
	"idLocation"	INTEGER NOT NULL,
	FOREIGN KEY("idLocation") REFERENCES "ea_locations"("idLocation"),
	FOREIGN KEY("idUser") REFERENCES "ea_users"("idUser")
);
CREATE TABLE IF NOT EXISTS "ea_cardInfo" (
	"idCardInfo"	INTEGER NOT NULL,
	"number"	TEXT NOT NULL,
	"name"	TEXT NOT NULL,
	"code"	INTEGER NOT NULL,
	"date"	TEXT NOT NULL,
	"idUser"	INTEGER NOT NULL,
	FOREIGN KEY("idUser") REFERENCES "ea_users"("idUser"),
	PRIMARY KEY("idCardInfo")
);
CREATE TABLE IF NOT EXISTS "ea_restaurantCategory" (
	"idRestaurantCategory"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("idRestaurantCategory")
);
CREATE TABLE IF NOT EXISTS "ea_adminCategory" (
	"idAdminCategory"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("idAdminCategory")
);
CREATE TABLE IF NOT EXISTS "ea_admins" (
	"idAdmin"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"lastname"	TEXT NOT NULL,
	"countryid"	INTEGER NOT NULL,
	"workid"	TEXT NOT NULL,
	"idAdminCategory"	INTEGER NOT NULL,
	FOREIGN KEY("idAdminCategory") REFERENCES "ea_adminCategory"("idAdminCategory"),
	PRIMARY KEY("idAdmin")
);
CREATE TABLE IF NOT EXISTS "ea_restaurants" (
	"idRestaurant"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"image"	TEXT NOT NULL,
	"shippingcost"	INTEGER NOT NULL DEFAULT 750,
	"deleted"	INTEGER NOT NULL,
	"idRestaurantCategory"	INTEGER NOT NULL,
	"idAdmin"	INTEGER NOT NULL,
	FOREIGN KEY("idAdmin") REFERENCES "ea_restaurantCategory"("idRestaurantCategory"),
	FOREIGN KEY("idRestaurantCategory") REFERENCES "ea_restaurantCategory"("idRestaurantCategory"),
	PRIMARY KEY("idRestaurant")
);
CREATE TABLE IF NOT EXISTS "ea_locationsPerRestaurant" (
	"idRestaurant"	INTEGER NOT NULL,
	"idLocation"	INTEGER NOT NULL,
	FOREIGN KEY("idRestaurant") REFERENCES "ea_restaurants"("idRestaurant"),
	FOREIGN KEY("idLocation") REFERENCES "ea_locations"("idLocation")
);
CREATE TABLE IF NOT EXISTS "ea_orders" (
	"idOrder"	INTEGER NOT NULL,
	"posttime"	TEXT NOT NULL,
	"totalPrice"	INTEGER NOT NULL,
	"canceled"	INTEGER NOT NULL,
	"restaurantName"	TEXT NOT NULL,
	"idUser"	INTEGER NOT NULL,
	FOREIGN KEY("idUser") REFERENCES "ea_users"("idUser"),
	PRIMARY KEY("idOrder")
);
CREATE TABLE IF NOT EXISTS "ea_products" (
	"idProduct"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"image"	TEXT NOT NULL,
	"price"	INTEGER NOT NULL,
	"ingredients"	TEXT NOT NULL,
	"description"	TEXT NOT NULL,
	"quantity"	INTEGER NOT NULL,
	"idRestaurant"	INTEGER NOT NULL,
	FOREIGN KEY("idRestaurant") REFERENCES "ea_restaurants"("idRestaurant"),
	PRIMARY KEY("idProduct")
);
CREATE TABLE IF NOT EXISTS "ea_productsPerOrder" (
	"quantity"	INTEGER NOT NULL,
	"idOrder"	INTEGER NOT NULL,
	"idProduct"	INTEGER NOT NULL,
	FOREIGN KEY("idOrder") REFERENCES "ea_orders"("idOrder"),
	FOREIGN KEY("idProduct") REFERENCES "ea_products"("idProduct")
);
CREATE TABLE IF NOT EXISTS "ea_driverStates" (
	"idDriverState"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("idDriverState")
);
CREATE TABLE IF NOT EXISTS "ea_drivers" (
	"idAdmin"	INTEGER NOT NULL,
	"idDriverState"	INTEGER NOT NULL,
	FOREIGN KEY("idDriverState") REFERENCES "ea_driverStates"("idDriverState"),
	FOREIGN KEY("idAdmin") REFERENCES "ea_admins"("idAdmin")
);
CREATE TABLE IF NOT EXISTS "ea_deletionApplication" (
	"idApplication"	INTEGER NOT NULL,
	"posttime"	TEXT NOT NULL,
	"accepted"	INTEGER NOT NULL,
	"idRestaurant"	INTEGER NOT NULL,
	FOREIGN KEY("idRestaurant") REFERENCES "ea_restaurants"("idRestaurant"),
	PRIMARY KEY("idApplication")
);
COMMIT;
