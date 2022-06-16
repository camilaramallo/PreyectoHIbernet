drop table if exists categorias;
drop table if exists productos;
drop table if exists clientes;

create table categorias(id_catg int primary key auto_increment,nombre varchar(45));

create table clientes(id_Client int primary key auto_increment,nombre varchar(45), apellido varchar(45),forma_pago varchar(45));

create table productos(id_prod int primary key auto_increment,TIPO_CAT INT, nombre varchar(75),
precio int,fecha_ingreso date, sku varchar (10)  unique, CONSTRAINT FK_CATEG FOREIGN KEY (TIPO_CAT) REFERENCES CATEGORIAS (ID_CATG));

insert into categorias(nombre) values('Tecnología');
insert into categorias(nombre) values('Hogar');
insert into categorias(nombre) values('Deporte');
insert into categorias(nombre) values('computación');

insert into productos(nombre,precio,fecha_ingreso,tipo_cat,sku) values('teclado',8000,'2004-12-03',1,'ab1234');
insert into productos(nombre,precio,fecha_ingreso,tipo_cat,sku) values('Gabinete',20000,'2004-12-13',4,'ab1236');
insert into productos(nombre,precio,fecha_ingreso,tipo_cat,sku) values('Monitor',40000,'2005-01-03',4,'ab3252');
insert into productos(nombre,precio,fecha_ingreso,tipo_cat,sku) values('Silla',6000,'2005-02-10',2,'ab2587');
insert into productos(nombre,precio,fecha_ingreso,tipo_cat,sku) values('Mesa',50000,'2006-04-15',2,'ab6587');
insert into productos(nombre,precio,fecha_ingreso,tipo_cat,sku) values('Armario',45000,'2006-11-10',2,'ab2547');
insert into productos(nombre,precio,fecha_ingreso,tipo_cat,sku) values('lavarropas Automatico',80000,'2008-01-10',1,'ab4712');
insert into productos(nombre,precio,fecha_ingreso,tipo_cat,sku) values('lavavajillas',60000,'2008-02-20',1,'ab8945');

insert into clientes(nombre,apellido,forma_pago) values('Carla','Ramallo','debito');
insert into clientes(nombre,apellido,forma_pago) values('Carlos','Ramirez','credito');
insert into clientes(nombre,apellido,forma_pago) values('Maria','Pizarro','paypal');
insert into clientes(nombre,apellido,forma_pago) values('Ximena','Moore','efectivo');
insert into clientes(nombre,apellido,forma_pago) values('Facundo','Contreras','debito');
insert into clientes(nombre,apellido,forma_pago) values('Brisa','Paez','credito');








