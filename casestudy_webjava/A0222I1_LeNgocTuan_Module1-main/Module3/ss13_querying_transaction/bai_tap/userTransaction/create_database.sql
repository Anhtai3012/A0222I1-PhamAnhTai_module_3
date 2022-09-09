create database ss13;
use ss13;
CREATE TABLE users (
    user_id INT PRIMARY KEY,
    `name` VARCHAR(50),
    email VARCHAR(50),
    country VARCHAR(50)
);

CREATE TABLE Permision (
    permision_id INT PRIMARY KEY,
    name_permision VARCHAR(50)
);

CREATE TABLE User_Permision (
    permision_id INT,
    user_id INT,
    CONSTRAINT fk_us_pr FOREIGN KEY (user_id)
        REFERENCES users (user_id),
    CONSTRAINT fk_up_pr FOREIGN KEY (permision_id)
        REFERENCES Permision (permision_id)
);

insert into Permision values(1, 'add'),(2, 'edit'),(3, 'delete'),(4, 'view');

INSERT INTO `ss13`.`users` (`user_id`, `name`, `email`, `country`) VALUES 
('12', 'Minh', 'minh@codegym.com', 'vietnam'),
('13', 'Kante', 'kante@gmail.com', 'France'),
('14', 'chanathip', 'chanathip@thailand.com', 'thailand'),
('19', 'kien', 'kien@yahoo.com', 'vietnam'),
('20', 'Yen', 'yensao@gmail.com.vn', 'vietnam');
