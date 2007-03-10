Create database `jenquete`;

use jenquete;

Create table Enquetes (
	CodEnquete Int NOT NULL AUTO_INCREMENT,
	QuestaoEnquete varchar(255),
	StatusEnquete Char(1),
	DataCriacao Datetime,
 Primary Key (CodEnquete)) ENGINE = MyISAM;

Create table Alternativas (
	CodAlternativa Int NOT NULL AUTO_INCREMENT,
	CodEnquete Int NOT NULL,
	TxtAlternativa Varchar(255),
	QtdVoto Int,
 Primary Key (CodAlternativa,CodEnquete)) ENGINE = MyISAM;


Alter table Alternativas add Foreign Key (CodEnquete) references Enquetes (CodEnquete) on delete  restrict on update  restrict;


