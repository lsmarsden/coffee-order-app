CREATE TABLE IF NOT EXISTS `order` (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cost decimal NOT NULL,
    description varchar(255)
);