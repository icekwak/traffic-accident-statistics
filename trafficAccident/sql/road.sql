CREATE TABLE road(
	roadName VARCHAR(50) NOT NULL,
	ro_accident INT(11),
	ro_death INT(11),
	ro_injured1 INT(11),
	ro_injured2 INT(11),
	ro_injured3 INT(11),
	PRIMARY KEY(roadName)
)DEFAULT CHARSET = utf8;

CREATE TABLE roadd(
	dname VARCHAR(50) NOT NULL,
	ddname VARCHAR(50) NOT NULL,
	d_accident INT(11),
	d_death INT(11),
	d_injured1 INT(11),
	d_injured2 INT(11),
	d_injured3 INT(11),
	PRIMARY KEY(dname, ddname)
)DEFAULT CHARSET = utf8;

LOAD DATA INFILE "D:\\Project\\Web_Server\\TAproject\\api\\change\\road.csv" INTO TABLE road FIELDS TERMINATED BY "," LINES TERMINATED BY "\n";