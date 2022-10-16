use grupo9;

select email, senha from usuario;

CREATE TABLE hospital (
idHospital int primary key auto_increment,
nome_Hospital varchar (45),
cnpj varchar(45),
endereco varchar (100),
numeroHospital int,
qtdMaquinas Int
);

insert into hospital values
(null, "Santa Catarina", "59.546.515/0001-34", "Av. Paulista", 200, 10);

insert into hospital values
(null, "Grajau", "18.601.672/0007-91", "Av. Belmira Marin", 982, 7);

CREATE TABLE maquina (
idMaquina int primary key auto_increment,
ala_Hospitalar varchar (45), -- inserir manualmente
sistema_Operacional varchar (100), -- sistema.getSistema
fabricante varchar (45), -- sistema.getfabricante
nome_Processador varchar (100), -- processador get.nome
frequencia_Processador varchar(45), -- frequencia do processador processador.getfrequencia
capacidade_Total_Memoria varchar(45), -- memoria.gettotal
tamanho_Disco varchar(45), -- long disco.gettamanho
numero_CPU_fisica int, -- processador.getnumeroscpusfisicas
fkHospital int,
foreign key (fkHospital) references hospital(idHospital)
);
 alter table medida modify column tamanho_Disco varchar(50);
-- alter table maquina add column frequencia_Processador long after numero_CPU_fisica; 

CREATE TABLE medida (
idMedida int primary key auto_increment,
memoria_Em_Uso VARCHAR (45), -- long memoria.getemuso
percent_Uso_Cpu_Processo decimal(5,2), -- processo.getusocpu 
percent_Uso_Processador decimal(5,2), -- double processador.getuso
percent_Uso_Ram_Processo float, -- double processo.getUsoMemoria
numero_Leituras_Disco varchar(45), -- long disco.getleituras
momento varchar (50), -- datetime default current_timestamp
fkMaquina int,
foreign key (fkMaquina) references maquina (idMaquina)
);

-- alter table medida modify column momento varchar(50);

select * from hospital;
select * from maquina;
select * from medida;

select Hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador, frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina
RIGHT join hospital on maquina.fkHospital = hospital.idHospital;

select maquina.idMaquina, idMedida, memoria_Em_Uso as "Uso da memoria", 
percent_Uso_Cpu_Processo as "%Uso da CPU no processo", percent_Uso_Processador as "%uso do Processador", percent_Uso_Ram_Processo as "%Uso da RAM no processo", 
numero_Leituras_Disco as "Numero de leituras no disco", momento as "data" from medida right join maquina 
on medida.fkMaquina = maquina.idMaquina
order by idMedida
;


truncate medida;
-- caso de erro em algo
drop table medida;
drop table maquina;
drop TABLE HOSPITAL;
