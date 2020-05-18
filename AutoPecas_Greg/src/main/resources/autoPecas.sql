create table usuario
(
nome varchar(30) not null primary key,
email varchar(30) not null,
senha varchar(15) not null
);

create table cadastro
(
email varchar2(30) not null primary key,
nome varchar(30) not null,
veiculo varchar2(10) not null,
FOREIGN key (veiculo) references carros(placa)
);

create table pecas
(
cpf VARCHAR2(15) not null primary key,
nomePeca varchar(30)
);

select * from cadastro;

create table carros
(
placa varchar2(10) not null  primary key,
modelo varchar2(10) not null,
marca varchar2(10) not null,
ano int not null,
pecas varchar2(15) not null,
foreign key (pecas) references pecas(cpf)
);
drop table carros;
drop table pecas;

CREATE SEQUENCE SPECAS MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;

