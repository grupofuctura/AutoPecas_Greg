create table usuario
(
nome varchar(30) not null primary key,
email varchar(30) not null,
senha varchar(15) not null
);

create table pecas
(
id_peca int not null primary key,
nomePeca varchar(30)
);

create table carros
(
placa varchar(10) not null  primary key,
modelo varchar(10) not null,
marca varchar(10) not null,
ano int not null,
pecas int not null,
foreign key (pecas) references pecas(id_peca)
);

CREATE SEQUENCE SPECAS MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;

