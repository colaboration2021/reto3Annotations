DROP TABLE IF EXISTS audience;
CREATE TABLE audience (
     id INT AUTO_INCREMENT PRIMARY KEY,
     owner VARCHAR2(45) NOT NULL,
     name VARCHAR(45) NOT NULL,
     capacity NUMBER(5) NOT NULL,
     description VARCHAR(250) NOT NULL);