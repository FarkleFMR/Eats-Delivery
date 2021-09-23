BEGIN TRANSACTION;
INSERT INTO "ea_users" VALUES (1,'joseacuna','Jose','Acuna','contrasena1','joseacunacarrera@gmail.com');
INSERT INTO "ea_users" VALUES (2,'client1','name1','name2','contrasena2','lataste123@gmail.com');
INSERT INTO "ea_cardInfo" VALUES (1,'1234567891011121','Jose Acuna Carrera',123,'01/22',1);
INSERT INTO "ea_cardInfo" VALUES (2,'1234567891011121','Usuario 1',123,'01/22',2);
COMMIT;
