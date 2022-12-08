create database mabiblio;

use mabiblio;

CREATE TABLE livre (
  id_livre INT NOT NULL AUTO_INCREMENT,
  cote VARCHAR(128) NOT NULL,
  titre VARCHAR(128) NOT NULL,  
  date_publication DATETIME NULL,
  CONSTRAINT pk_livre PRIMARY KEY (id_livre)
);

CREATE TABLE auteur (
  id_auteur INT NOT NULL AUTO_INCREMENT,
  prenom VARCHAR(128) NOT NULL,
  nom VARCHAR(128) NOT NULL,
  CONSTRAINT pk_auteur PRIMARY KEY (id_auteur)
);

CREATE TABLE livre_auteur (
  id_livre INT NOT NULL,
  id_auteur INT NOT NULL,
  CONSTRAINT livre_auteur_pk PRIMARY KEY (id_livre,id_auteur),
  CONSTRAINT livre_auteur_fk1 FOREIGN KEY (id_livre) REFERENCES livre(id_livre),
  CONSTRAINT livre_auteur_fk2 FOREIGN KEY (id_auteur) REFERENCES auteur(id_auteur)
);

INSERT INTO livre values(1,'1998-HUG-MIS', 'Les Misérables','1998-01-01 00:00:00'); 
INSERT INTO livre values(2,'2004-RAB-GAR', 'Gargantua','2004-01-01 00:00:00');
INSERT INTO livre values(3,'2002-ROW-HAR', 'Harry Potter à l\'école des sorciers','2002-01-01 00:00:00');
INSERT INTO livre values(4,'2012-DEL-PRO', 'Programmer en Java','2012-01-01 00:00:00');
INSERT INTO livre values(5,'2011-DEL-APA', 'Apache Maven: Version 2 et 3','2011-01-01 00:00:00');

INSERT INTO auteur values(1,'Victor','Hugo'); 
INSERT INTO auteur values(2,'Francois','Rabelais');
INSERT INTO auteur values(3,'J. K.','Rowling');
INSERT INTO auteur values(4,'Claude','Delannoy');
INSERT INTO auteur values(5,'Nicolas','De Loof');
INSERT INTO auteur values(6,'Arnaud','Héritier');

INSERT INTO livre_auteur values(1,1); 
INSERT INTO livre_auteur values(2,2);
INSERT INTO livre_auteur values(3,3);
INSERT INTO livre_auteur values(4,4);
INSERT INTO livre_auteur values(5,5);
INSERT INTO livre_auteur values(5,6);
