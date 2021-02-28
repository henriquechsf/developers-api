CREATE TABLE desenvolvedor (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    sexo CHAR(1) NOT NULL,
    idade INTEGER,
    hobby VARCHAR(255),
    nascimento DATE
);