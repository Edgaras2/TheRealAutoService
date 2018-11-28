CREATE TABLE IF NOT EXISTS autoservice.car (
  id INT NOT NULL AUTO_INCREMENT,
  model VARCHAR(68) NOT NULL,
  car_plate VARCHAR(45) NOT NULL,
  user_id INT(11) NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_USER FOREIGN KEY (user_id) REFERENCES autoservice.user (id)
 );
  
  
