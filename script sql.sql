use grupo9;
create table usuario (
id int primary key auto_increment,
nome varchar (45),
cnpj varchar (45),
email varchar (45),
check (email like '%@%' and email like '%.com%'),
senha varchar (45)
);
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
frequencia_Processador decimal (5,2), -- frequencia do processador processador.getfrequencia
capacidade_Total_Memoria decimal(5,2), -- memoria.gettotal
tamanho_Disco decimal(5,2), -- long disco.gettamanho
numero_CPU_fisica int, -- processador.getnumeroscpusfisicas
fkHospital int,
foreign key (fkHospital) references hospital(idHospital)
);


CREATE TABLE medida (
idMedida int primary key auto_increment,
percent_Memoria_Em_Uso decimal(5,2), -- long memoria.getemuso
uso_Cpu_Processo decimal(5,2), -- processo.getusocpu 
uso_Processador decimal(5,2), -- double processador.getuso
uso_Ram_Processo decimal(5,2), -- double processo.getUsoMemoria
percent_Uso_Disco decimal(5,2), -- long disco.getleituras
momento varchar (50), -- datetime default current_timestamp
fkMaquina int,
foreign key (fkMaquina) references maquina (idMaquina)
);


-- alter table medida modify column memoria_Em_Uso decimal(5,2);

select * from hospital;
select * from maquina;
select * from medida;

select hospital.nome_Hospital, ala_Hospitalar, sistema_Operacional, fabricante, nome_Processador, frequencia_Processador, capacidade_Total_Memoria, tamanho_Disco, numero_CPU_fisica from maquina
left join hospital on maquina.fkHospital = hospital.idHospital;
update maquina set ala_Hospitalar = "recepcao" where idMaquina = 1;

select maquina.idMaquina, idMedida, maquina.ala_Hospitalar, percent_Memoria_Em_Uso, 
uso_Cpu_Processo, uso_Processador, uso_Ram_Processo, 
percent_Uso_Disco, momento  from medida left join maquina 
on medida.fkMaquina = maquina.idMaquina
where fkMaquina = 1
group by idMedida, momento
order by idMedida desc;

select convert(medida.memoria_Em_Uso, decimal(3,1)),cast(medida.memoria_Em_Uso as decimal(3,1)),medida.memoria_Em_Uso,  maquina.capacidade_Total_Memoria from medida join maquina 
on medida.fkMaquina = maquina.idMaquina;
-- TO_NUMBER(REPLACE(LINHA1, ‘,’,’.’), ‘9999.99’)
select idMedida, convert(replace(medida.memoria_Em_Uso, ',','.'), decimal(3,1)), medida.memoria_Em_Uso, maquina.capacidade_Total_Memoria from medida join maquina 
on medida.fkMaquina = maquina.idMaquina
order by idMedida desc;

desc medida;
truncate medida;
-- caso de erro em algo
drop table medida;
drop table maquina;
drop TABLE HOSPITAL;
