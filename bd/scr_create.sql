CREATE TABLE Paciente (
  codpac    SERIAL NOT NULL, 
  nompac    varchar(40) NOT NULL, 
  datnaspac date, 
  sexpac    char(1), 
  latlocpac numeric(12, 8), 
  lonlocpac numeric(12, 8), 
  PRIMARY KEY (codpac));
  
CREATE TABLE Sintoma (
  codsin SERIAL NOT NULL, 
  dessin varchar(40) NOT NULL, 
  PRIMARY KEY (codsin));

CREATE TABLE Sintoma_Paciente (
  codsin int4 NOT NULL, 
  codpac int4 NOT NULL, 
  PRIMARY KEY (codsin, 
  codpac));

CREATE TABLE Usuario (
  codusu SERIAL NOT NULL, 
  emausu varchar(200) NOT NULL UNIQUE, 
  senusu varchar(32), 
  PRIMARY KEY (codusu));

ALTER TABLE Sintoma_Paciente ADD CONSTRAINT FKSintoma_Pa678034 FOREIGN KEY (codpac) REFERENCES Paciente (codpac);
ALTER TABLE Sintoma_Paciente ADD CONSTRAINT FKSintoma_Pa499888 FOREIGN KEY (codsin) REFERENCES Sintoma (codsin);
