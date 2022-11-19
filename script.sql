use grupo9;

	CREATE TABLE hospital (
	idHospital int primary key auto_increment, -- IDENTITY(1,1),
	nome_Hospital varchar (45),
	cnpj varchar(45),
	endereco varchar (100),
	numeroHospital int
	);
    
insert into hospital values
(null, "Santa Catarina", "59.546.515/0001-34", "Av. Paulista", 200);

-- azure
-- insert into hospital values 
-- ('Santa Catarina', '59.546.515/0001-34', 'Av. Paulista', 200);

create table usuario (
id int primary key auto_increment, -- IDENTITY(1,1),
nome varchar (45),
cnpj varchar (45),
email varchar (45),
check (email like '%@%' and email like '%.com%'),
senha varchar (45)
);



CREATE TABLE maquina (
idMaquina int primary key auto_increment, -- IDENTITY(1,1),
ala_Hospitalar varchar (45), -- inserir manualmente
sistema_Operacional varchar (100), -- sistema.getSistema
fabricante varchar (45), -- sistema.getfabricante
nome_Processador varchar (100), -- processador get.nome
frequencia_Processador decimal (10,2), -- frequencia do processador processador.getfrequencia
capacidade_Total_Memoria decimal(10,2), -- memoria.gettotal
tamanho_Disco decimal(10,2), -- long disco.gettamanho
numero_CPU_fisica int, -- processador.getnumeroscpusfisicas
fkHospital int,
foreign key (fkHospital) references hospital(idHospital)
);


CREATE TABLE medida (
idMedida int primary key auto_increment,  -- IDENTITY(1,1),
percent_Memoria_Em_Uso decimal(10,2), -- long memoria.getemuso
uso_Cpu_Processo decimal(10,2), -- processo.getusocpu 
uso_Processador decimal(10,2), -- double processador.getuso
uso_Ram_Processo decimal(10,2), -- double processo.getUsoMemoria
percent_Uso_Disco decimal(10,2), -- long disco.getleituras
momento varchar (50), -- datetime default current_timestamp
fkMaquina int,
foreign key (fkMaquina) references maquina (idMaquina)
);
