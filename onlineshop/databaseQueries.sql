drop all objects;

CREATE TABLE catalog (
	id_catalog IDENTITY,
	name VARCHAR(50),
	image VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_catalog_id PRIMARY KEY (id_catalog)
);

INSERT INTO CATALOG(name,image,is_active) VALUES('SmartPhones','Catalog_SmartPhones.png', true);
INSERT INTO CATALOG(name,image,is_active) VALUES('Computers','Catalog_Computers.png', true);
INSERT INTO CATALOG(name,image,is_active) VALUES('Videogames','Catalog_Videogames.png', true);

CREATE TABLE usr (
	id_user IDENTITY,
	name VARCHAR(50),
	admin BOOLEAN,
	enabled BOOLEAN,
	email VARCHAR(100),
	password VARCHAR(50),
	CONSTRAINT pk_usr_id PRIMARY KEY (id_user)
);

INSERT INTO usr(name,admin,enabled,email,password) VALUES ('David',true,true,'doriveramirez@gmail.com','123456');
INSERT INTO usr(name,admin,enabled,email,password) VALUES ('Rodolfo',false,true,'Rodolfo@gmail.com','123456');
INSERT INTO usr(name,admin,enabled,email,password) VALUES ('Juan',false,false,'Juan@gmail.com','123456');

CREATE TABLE item (
	id_item IDENTITY,
	code VARCHAR(36),
	name VARCHAR(50),
	stock INT,
	price DECIMAL(10,2),
	image VARCHAR(50),
	is_active BOOLEAN,
	id_catalog INT,
	purchases INT default 0,
	views INT default 0,
	CONSTRAINT pk_item_id PRIMARY KEY (id_item),
	CONSTRAINT fk_item_catalog_id FOREIGN KEY (id_catalog) REFERENCES catalog (id_catalog)
);

INSERT INTO item(code,name,stock,price,image,is_active,id_catalog) VALUES  ('27f5b3a8-5ee3-4d86-b7a5-1c3eba195d70','Samsung Galaxy S8',4,150,'27f5b3a8-5ee3-4d86-b7a5-1c3eba195d70.jpg',true,1);
INSERT INTO item(code,name,stock,price,image,is_active,id_catalog) VALUES  ('06176689-18d6-44cc-82d7-9291375bdf0d','Xiaomi pocophone F1',4,300,'06176689-18d6-44cc-82d7-9291375bdf0d.jpg',true,1);
INSERT INTO item(code,name,stock,price,image,is_active,id_catalog) VALUES  ('468b6b48-ab41-48f1-9329-263b12db69ca','Xiaomi pocophone F2',4,450,'468b6b48-ab41-48f1-9329-263b12db69ca.jpg',true,1);
INSERT INTO item(code,name,stock,price,image,is_active,id_catalog) VALUES  ('9cbd94d0-31b0-4673-bc33-39c5b7a29f1c','Asus ROG Strix G15',4,1300,'9cbd94d0-31b0-4673-bc33-39c5b7a29f1c.jpg',true,2);
INSERT INTO item(code,name,stock,price,image,is_active,id_catalog) VALUES  ('e2dfc049-9702-49a1-a2d3-f66b2f2a8e70','Lenovo ideapad S340',4,1300,'e2dfc049-9702-49a1-a2d3-f66b2f2a8e70.jpg',false,2);
INSERT INTO item(code,name,stock,price,image,is_active,id_catalog) VALUES  ('bbc489dc-3925-4c4f-b59a-ee7f4a96476a','The Last Of Us 2',4,60,'bbc489dc-3925-4c4f-b59a-ee7f4a96476a.jpg',true,3);
