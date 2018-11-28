CREATE TABLE IF NOT EXISTS autoservice.roles(
user_id int NOT NULL,
name VARCHAR(50) NOT NULL,
FOREIGN KEY FK_USER2 (user_id) REFERENCES autoservice.user (id));
  
