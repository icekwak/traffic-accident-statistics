CREATE TABLE accident(
	accType VARCHAR(50) NOT NULL,
	accName VARCHAR(100) NOT NULL,
	ac_accident INT(11),
	ac_death INT(11),
	ac_injured1 INT(11),
	ac_injured2 INT(11),
	ac_injured3 INT(11),
	PRIMARY KEY(accType, accName)
)DEFAULT CHARSET = utf8;

LOAD DATA INFILE "D:\\Project\\Web_Server\\TAproject\\api\\change\\accident.csv" INTO TABLE accident FIELDS TERMINATED BY "," LINES TERMINATED BY "\n";