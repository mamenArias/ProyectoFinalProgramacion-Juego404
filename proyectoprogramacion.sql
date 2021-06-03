create database proyectoprogramacion;

use proyectoprogramacion;

create table protagonista(
	nombre varchar(50) primary key,
    genero boolean,
    vida int(3),
    ataque int(3),
    pantalla int(1)
);

-- Para borrar todos los registros de la tabla protagonista. El set es para quitar el modo seguro
SET SQL_SAFE_UPDATES = 0;
delete from protagonista;