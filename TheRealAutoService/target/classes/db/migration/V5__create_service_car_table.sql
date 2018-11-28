CREATE TABLE car_service (
  car_id int(11) NOT NULL,
  service_id int(11) NOT NULL,
  PRIMARY KEY (car_id,service_id),
  CONSTRAINT FK_CAR_i FOREIGN KEY (car_id) REFERENCES car (id),
  CONSTRAINT FK_SERVICE FOREIGN KEY (service_id) REFERENCES services (id)
) 
