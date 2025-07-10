CREATE TABLE IF NOT EXISTS utilisateur (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
    );

INSERT INTO utilisateur (firstname, lastname, email, password) VALUES
('Mathieu', 'Mithridate', 'mathieumith@test.com', '1234'),
('Jean', 'Albert', 'jeanalbert@test.fr', '1234'),
('Marie', 'Durand', 'mariedurand@mail.com', '1234');