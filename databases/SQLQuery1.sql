-- Cria a base de dados
CREATE DATABASE BD_20250564_2526_INF
-- Usa a nossa BD
USE BD_20250563_2526_INF

-- 
Create TABLE EMP(
empnum INT,
funcao VARCHAR(50),
nome VARCHAR,
chefe INT,
data_adm DATETIME,
salario Decimal(8, 2),
comissao DECIMAL(8, 2),
deptnus INT,
PRIMARY KEY (empnum)
);


--Listar o conteudo da tabela EMP

SELECT *
FROM emp;

--DELETAR UMA TABELA

DROP TABLE emp

--Voltar a criar depois de dar delete tenho de voltar a escrever a mesma tabela

Create TABLE emp(
empnum INT,
funcao VARCHAR(50),
nome VARCHAR,
chefe INT,
data_adm DATETIME,
salario Decimal(8, 2),
comissao DECIMAL(8, 2),
deptnus INT,
PRIMARY KEY (empnum));

--Inserir uma linha
SELECT *
FROM emp;
INSERT INTO emp(empnum,funcao,nome,chefe,data_adm,salario,comissao,deptnus)
Values(89, 'Antunes', 'Admin', 35, '2001.10.10', 14000, Null, 10);

drop table emp


--B tentar fazer

Create Table B(
empnum INT,
nome VARCHAR UNIQUE,
funcao VARCHAR(50),
chefe INT,
data_adm DATETIME,
salario Decimal(8, 2),
comissao DECIMAL(8, 2),
deptnus INT,
PRIMARY KEY (empnum));

SELECT *
FROM B;

INSERT INTO B(empnum, nome, funcao, chefe, data_adm, salario, comissao, deptnus)
VALUES(15, 'Amaro', 'Admin', 35, '2001.10.10', 14000, Null, 10);

