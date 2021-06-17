CREATE TABLE year(
	year INT(11) NOT NULL,
	y_accident INT(11),
	y_death INT(11),
	y_injured1 INT(11),
	y_injured2 INT(11),
	y_injured3 INT(11),
	PRIMARY KEY(year)
)DEFAULT CHARSET = utf8;

LOAD DATA INFILE "D:\\Project\\Web_Server\\TAproject\\api\\change\\year.csv" INTO TABLE year FIELDS TERMINATED BY "," LINES TERMINATED BY "\n";