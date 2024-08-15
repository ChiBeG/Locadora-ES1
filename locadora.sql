-- database: d:\Pedro\Documents\Eclipse Projects\Locadora\locadora.db
CREATE TABLE clientes (
	
	id 			varchar (36) 	PRIMARY KEY, 
	cpf 		long 			NOT NULL UNIQUE, 
	nome 		varchar (80) 	NOT NULL, 
	datanasc 	text 			NOT NULL, 
	logradouro 	varchar (80) 	NOT NULL, 
	numero 		varchar (10) 	NOT NULL, 
	complemento varchar (20) 	NOT NULL, 
	bairro 		varchar (40) 	NOT NULL, 
	cidade 		varchar (40) 	NOT NULL, 
	uf 			char (2) 		NOT NULL, 
	cep 		integer 		NOT NULL, 
	ddd 		integer 		NOT NULL, 
	telefone 	integer 		NOT NULL
	
);

CREATE TABLE veiculos (
	
	id				varchar (36)		PRIMARY KEY,
	placa			char(8)				NOT NULL UNIQUE,
	modelo 			varchar(30)			NOT NULL,
	anoFabricacao	integer 			NOT NULL,
	diaria			real 				NOT NULL,
	quilometragem	integer				NOT NULL


);