CREATE TABLE IF NOT EXISTS autoservice.user (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(68) NOT NULL,
  password VARCHAR(100) NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
