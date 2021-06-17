CREATE TABLE region(
	cityName VARCHAR(50) NOT NULL,
	regName VARCHAR(50) NOT NULL,
	re_accident INT(11),
	re_death INT(11),
	re_injured1 INT(11),
	re_injured2 INT(11),
	re_injured3 INT(11),
	PRIMARY KEY(cityName, regName)
)DEFAULT CHARSET = utf8;

LOAD DATA INFILE "D:\\Project\\Web_Server\\TAproject\\api\\change\\region.csv" INTO TABLE region FIELDS TERMINATED BY "," LINES TERMINATED BY "\n";