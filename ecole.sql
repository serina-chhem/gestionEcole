CREATE TABLE anneeScolaire(
	id int primary key auto_increment
);

CREATE TABLE trimestre(
	id int primary key auto_increment,
	anneeScolaire_id int not null,
	numero int not null,
	debut date not null,
	fin date not null,
	foreign key (anneeScolaire_id) references anneeScolaire(id)   
);

CREATE TABLE niveau(
	id int primary key auto_increment,
	nom varchar(255) not null
);

CREATE TABLE classe(
	id int primary key auto_increment,
	nom int not null,
	anneeScolaire_id int not null,
	niveau_id int not null,
	foreign key (anneeScolaire_id) references anneeScolaire(id),
	foreign key (niveau_id) references niveau(id)
);

CREATE TABLE discipline(
	id int primary key auto_increment,
	nom varchar(255) not null
);

CREATE TABLE personne(
	id int primary key auto_increment,
	nom varchar(30) not null,
	prenom varchar(30) not null,
	type int(5) not null
);

CREATE TABLE enseignement(
	id int primary key auto_increment,
	classe_id int not null,
	discipline_id int not null,
	personne_id int not null,
	foreign key (classe_id) references classe(id),
	foreign key (discipline_id) references discipline(id),
	foreign key (personne_id) references personne(id)
);

CREATE TABLE inscription(
	id int primary key auto_increment,
	classe_id int not null,
	
	personne_id int not null,
	foreign key (classe_id) references classe(id),
	foreign key (personne_id) references personne(id)
);

CREATE TABLE bulletin(
	id int primary key auto_increment,
	moyenneG float(10) not null,
	appreciation varchar(255) not null,
	trimestre_id int not null,
	inscription_id int not null,
	foreign key (trimestre_id) references trimestre(id),
	foreign key (inscription_id) references inscription(id)
);


CREATE TABLE detailBulletin(
	id int primary key auto_increment,
	moyenneG float(10) not null,
	appreciation varchar(255) not null,
	bulletin_id int not null,
	enseignement_id int not null,
	foreign key (bulletin_id) references bulletin(id),
	foreign key (enseignement_id) references enseignement(id)
);

CREATE TABLE evalutation(
	id int primary key auto_increment,
	note float(10) not null,
	appreciation varchar(255) not null, 
	detailBulletin_id int not null,
	foreign key (detailBulletin_id) references detailBulletin(id)
);













