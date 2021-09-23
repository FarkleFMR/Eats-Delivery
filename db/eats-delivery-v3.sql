BEGIN TRANSACTION;
DROP TABLE IF EXISTS "ea_users";
CREATE TABLE IF NOT EXISTS "ea_users" (
	"idUser"	INTEGER NOT NULL,
	"username"	TEXT NOT NULL,
	"name"	TEXT NOT NULL,
	"lastname"	TEXT NOT NULL,
	"password"	TEXT NOT NULL,
	"email"	INTEGER NOT NULL,
	PRIMARY KEY("idUser")
);
DROP TABLE IF EXISTS "ea_locations";
CREATE TABLE IF NOT EXISTS "ea_locations" (
	"idLocation"	INTEGER NOT NULL,
	"location"	TEXT NOT NULL,
	PRIMARY KEY("idLocation")
);
DROP TABLE IF EXISTS "ea_locationPerUsers";
CREATE TABLE IF NOT EXISTS "ea_locationPerUsers" (
	"idUser"	INTEGER NOT NULL,
	"idLocation"	INTEGER NOT NULL,
	FOREIGN KEY("idUser") REFERENCES "ea_users"("idUser"),
	FOREIGN KEY("idLocation") REFERENCES "ea_locations"("idLocation")
);
DROP TABLE IF EXISTS "ea_cardInfo";
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
DROP TABLE IF EXISTS "ea_restaurantCategory";
CREATE TABLE IF NOT EXISTS "ea_restaurantCategory" (
	"idRestaurantCategory"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("idRestaurantCategory")
);
DROP TABLE IF EXISTS "ea_adminCategory";
CREATE TABLE IF NOT EXISTS "ea_adminCategory" (
	"idAdminCategory"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("idAdminCategory")
);
DROP TABLE IF EXISTS "ea_restaurants";
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
DROP TABLE IF EXISTS "ea_locationsPerRestaurant";
CREATE TABLE IF NOT EXISTS "ea_locationsPerRestaurant" (
	"idRestaurant"	INTEGER NOT NULL,
	"idLocation"	INTEGER NOT NULL,
	FOREIGN KEY("idRestaurant") REFERENCES "ea_restaurants"("idRestaurant"),
	FOREIGN KEY("idLocation") REFERENCES "ea_locations"("idLocation")
);
DROP TABLE IF EXISTS "ea_products";
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
DROP TABLE IF EXISTS "ea_productsPerOrder";
CREATE TABLE IF NOT EXISTS "ea_productsPerOrder" (
	"quantity"	INTEGER NOT NULL,
	"idOrder"	INTEGER NOT NULL,
	"idProduct"	INTEGER NOT NULL,
	FOREIGN KEY("idOrder") REFERENCES "ea_orders"("idOrder"),
	FOREIGN KEY("idProduct") REFERENCES "ea_products"("idProduct")
);
DROP TABLE IF EXISTS "ea_driverStates";
CREATE TABLE IF NOT EXISTS "ea_driverStates" (
	"idDriverState"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	PRIMARY KEY("idDriverState")
);
DROP TABLE IF EXISTS "ea_deletionApplication";
CREATE TABLE IF NOT EXISTS "ea_deletionApplication" (
	"idApplication"	INTEGER NOT NULL,
	"posttime"	TEXT NOT NULL,
	"accepted"	INTEGER NOT NULL,
	"idRestaurant"	INTEGER NOT NULL,
	FOREIGN KEY("idRestaurant") REFERENCES "ea_restaurants"("idRestaurant"),
	PRIMARY KEY("idApplication")
);
DROP TABLE IF EXISTS "ea_admins";
CREATE TABLE IF NOT EXISTS "ea_admins" (
	"idAdmin"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"lastname"	TEXT NOT NULL,
	"countryid"	INTEGER NOT NULL,
	"workid"	TEXT NOT NULL,
	"idAdminCategory"	INTEGER NOT NULL,
	"password"	TEXT NOT NULL,
	FOREIGN KEY("idAdminCategory") REFERENCES "ea_adminCategory"("idAdminCategory"),
	PRIMARY KEY("idAdmin")
);
DROP TABLE IF EXISTS "ea_drivers";
CREATE TABLE IF NOT EXISTS "ea_drivers" (
	"idAdmin"	INTEGER NOT NULL,
	"idDriverState"	INTEGER NOT NULL,
	"rating"	INTEGER NOT NULL DEFAULT 5,
	FOREIGN KEY("idDriverState") REFERENCES "ea_driverStates"("idDriverState"),
	FOREIGN KEY("idAdmin") REFERENCES "ea_admins"("idAdmin")
);
DROP TABLE IF EXISTS "ea_orders";
CREATE TABLE IF NOT EXISTS "ea_orders" (
	"idOrder"	INTEGER NOT NULL,
	"posttime"	TEXT NOT NULL,
	"totalPrice"	INTEGER,
	"canceled"	INTEGER NOT NULL,
	"restaurantName"	TEXT NOT NULL,
	"idUser"	INTEGER NOT NULL,
	FOREIGN KEY("idUser") REFERENCES "ea_users"("idUser"),
	PRIMARY KEY("idOrder")
);
INSERT INTO "ea_users" VALUES (1,'joseacuna','Jose','Acuna','contrasena1','joseacunacarrera@gmail.com');
INSERT INTO "ea_users" VALUES (2,'client1','name1','name2','contrasena2','lataste123@gmail.com');
INSERT INTO "ea_users" VALUES (3,'jenaro','Jenaro','Murillo','contrasena1','jenaromurillo@gmail.com');
INSERT INTO "ea_users" VALUES (4,'jenaro','Jenaro','Murillo','contrasena1','jenaromurillo@gmail.com');
INSERT INTO "ea_users" VALUES (5,'jenaro','Jenaro','Murillo','contrasena1','jenaromurillo@gmail.com');
INSERT INTO "ea_users" VALUES (6,'jenaro','Jenaro','Murillo','contrasena1','jenaromurillo@gmail.com');
INSERT INTO "ea_users" VALUES (7,'jenaro','Jenaro','Murillo','contrasena1','jenaromurillo@gmail.com');
INSERT INTO "ea_users" VALUES (8,'jenaro','Jenaro','Murillo','3ee038f48ba3eec527edeb404ff9ea82','jenaromurillo@gmail.com');
INSERT INTO "ea_users" VALUES (9,'jenaro','Jenaro','Murillo','be3bcac297d8f7756d77374420ad246133390ab261ea76c24579b29a59b35321','jenaromurillo@gmail.com');
INSERT INTO "ea_users" VALUES (10,'jenaro','Jenaro','Murillo','be3bcac297d8f7756d77374420ad246133390ab261ea76c24579b29a59b35321','jenaromurillo@gmail.com');
INSERT INTO "ea_locations" VALUES (1,'Barrondo Segunda Etapa, Paraiso, Cartago');
INSERT INTO "ea_locations" VALUES (2,'La Joya, Paraiso, Cartago');
INSERT INTO "ea_locations" VALUES (3,'Barrondo Segunda Etapa, Paraiso, Cartago');
INSERT INTO "ea_locations" VALUES (4,'Barrondo Segunda Etapa, Paraiso, Cartago');
INSERT INTO "ea_locations" VALUES (5,'Barrondo Segunda Etapa, Paraiso, Cartago');
INSERT INTO "ea_locations" VALUES (6,'Tejar, Cartago');
INSERT INTO "ea_locations" VALUES (7,'Tejar, Cartago');
INSERT INTO "ea_locations" VALUES (8,'Tejar, Cartago');
INSERT INTO "ea_locations" VALUES (9,'Tejar, Cartago');
INSERT INTO "ea_locationPerUsers" VALUES (1,5);
INSERT INTO "ea_locationPerUsers" VALUES (3,7);
INSERT INTO "ea_locationPerUsers" VALUES (3,8);
INSERT INTO "ea_locationPerUsers" VALUES (3,9);
INSERT INTO "ea_cardInfo" VALUES (1,'1234567891011121','Jose Acuna Carrera',123,'01/22',1);
INSERT INTO "ea_cardInfo" VALUES (2,'1234567891011121','Usuario 1',123,'01/22',2);
INSERT INTO "ea_cardInfo" VALUES (3,'1234567891011121','Jose Acuna Carrera',123,'01/22',1);
INSERT INTO "ea_cardInfo" VALUES (4,'d8862431a9c06b2c504aa8421f412f05a1238b41c9d55fafced7d0c3de0e3abe','Jenaro Murillo','6741db87fbb049ee0c301f4ac87770ec23717eb1f2a54389d03dd616cecb42ce','01/22',3);
INSERT INTO "ea_restaurantCategory" VALUES (1,'Pollo Frito');
INSERT INTO "ea_restaurantCategory" VALUES (2,'Hamburguesas');
INSERT INTO "ea_restaurantCategory" VALUES (3,'Soda');
INSERT INTO "ea_restaurantCategory" VALUES (4,'Mexicano');
INSERT INTO "ea_restaurantCategory" VALUES (5,'Pizza');
INSERT INTO "ea_adminCategory" VALUES (1,'Repartidor');
INSERT INTO "ea_adminCategory" VALUES (2,'Gerente');
INSERT INTO "ea_adminCategory" VALUES (3,'Encargado de Restaurante');
INSERT INTO "ea_restaurants" VALUES (1,'Mex-Eats','imageUrl',750,0,4,1);
INSERT INTO "ea_products" VALUES (1,'Tacos de Suadero','imageUrl',2000,'Carne de suadero, tortillas, salsa verde o roja.','Jugosa carne de suadero en taco.',10,1);
INSERT INTO "ea_driverStates" VALUES (0,'Disponible');
INSERT INTO "ea_driverStates" VALUES (1,'En camino');
INSERT INTO "ea_driverStates" VALUES (2,'Recogiendo el pedido');
INSERT INTO "ea_driverStates" VALUES (3,'En el punto');
INSERT INTO "ea_admins" VALUES (1,'Ronald','Cordero',1234234,'ronaldcordero',3,'22ffd8f7d9915eb274a7fa624885968266f5c5058f445b0439e1cea58075c4f2');
COMMIT;
