create database ImovelFacil
default character set utf8
default collate utf8_general_ci;

use imovelfacil;

drop table locador;
drop table fisico_locador;
drop table juridico_locador;
drop table locatario;
drop table fisico_locatario;
drop table juridico_locatario;
drop table imovel;
drop table imagem;

delete from locador where Cod_Locador = 4;

create table if not exists Locador(
Cod_Locador INT NOT NULL AUTO_INCREMENT,
Nome_Locador VARCHAR(50) not null,
Endereco_Locador VARCHAR(60) not null,
Bairro_Locador VARCHAR(20) not null,
Cidade_Locador VARCHAR(20) not null,
Estado_Locador VARCHAR(20) not null,
Celular_Locador VARCHAR(15) not null,
Telefone_Locador VARCHAR(15),
Email_Locador VARCHAR(45) not null,
Senha_Locador VARCHAR(20) not null DEFAULT "admin",
Primary key(Cod_Locador)
)DEFAULT CHARSET = utf8 engine = InnoDB;

use imovelfacil;
SELECT max(Cod_Locador) FROM Locador;

create table if not exists Fisico_Locador(
Cod_Locador INT not null,
Sexo_Locador enum('M','F') NOT NULL,
CPF_Locador varchar(15) not null,
Primary key(Cod_Locador),
Foreign key(Cod_Locador) references Locador(Cod_Locador) ON DELETE cascade ON UPDATE cascade
)DEFAULT CHARSET = utf8 engine = InnoDB;

create table if not exists Juridico_Locador(
Cod_Locador INT not null,
Razao_Social_Locador varchar(50) not null,
CNPJ_Locador varchar(15) not null,
Primary key(Cod_Locador),
Foreign key(Cod_Locador) references Locador(Cod_Locador) ON DELETE cascade ON UPDATE cascade
)DEFAULT CHARSET = utf8 engine = InnoDB;

create table if not exists Locatario(
Cod_Locatario integer not null auto_increment,
Nome_Locatario varchar(50) not null,
Endereco_Locatario varchar(60) not null,
Bairro_Locatario varchar(20) not null,
Cidade_Locatario varchar(15) not null,
Estado_Locatario varchar(15) not null,
Celeluar_Locatario varchar(15) not null,
Telefone_Locatario varchar(15) null,
Email_Locatario varchar(45) not null,
Senha_Locatario varchar(12) not null,
Primary key(Cod_Locatario)
)DEFAULT CHARSET = utf8 engine = InnoDB;

create table if not exists Fisico_Locatario(
Cod_Locatario integer not null,
Sexo_Locatario ENUM('M','F') not null,
CPF_Locatario varchar(15) not null,
Primary key(Cod_Locatario),
Foreign key(Cod_Locatario) references Locatario(Cod_Locatario) ON DELETE cascade
)DEFAULT CHARSET = utf8 engine = InnoDB;

create table if not exists Juridico_Locatario(
Cod_Locatario integer not null,
Razao_Social_Locatario varchar(50) not null,
CNPJ_Locatario varchar(15) not null,
Primary key(Cod_Locatario),
Foreign key(Cod_Locatario) references Locatario(Cod_Locatario) ON DELETE cascade
)DEFAULT CHARSET = utf8 engine = InnoDB;

create table if not exists Imovel(
Cod_Imovel integer not null auto_increment,
Nome_Imovel varchar(50) not null,
Cod_Locador INT not null,
Endereco_Imovel varchar(60) NOT NULL,
Bairro_Imovel varchar(20) not null,
Cidade_Imovel varchar(15) not null,
Estado_Imovel varchar(15) not null,
Descricao_Imovel text null,
Categoria_Imovel INT NOT NULL,
Primary key(Cod_Imovel),
Foreign key(Cod_Locador) references Locador(Cod_Locador) ON DELETE cascade
)DEFAULT CHARSET = utf8 engine = InnoDB;

create table if not exists Imagem(
Cod_Imagem integer not null auto_increment,
Cod_Imovel integer not null,
Descricao_Imagem text null,
Imagem longblob not null,
Primary key(Cod_Imagem),
Foreign key(Cod_Imovel) references Imovel(Cod_Imovel) ON DELETE cascade
)DEFAULT CHARSET = utf8 engine = InnoDB;

