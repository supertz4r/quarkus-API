CREATE TABLE IF NOT EXISTS CATEGORIA (
   codigo INT NOT NULL,
   nomeCategoria VARCHAR(20) NOT NULL,
   PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS CLIENT (
   id INT NOT NULL,
   name VARCHAR(100) NOT NULL,
   age INT NOT NULL,
   vatNumber VARCHAR(11) NOT NULL,
   email VARCHAR(20) NOT NULL,
   categoria INT NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (categoria) REFERENCES CATEGORIA(codigo)
);

INSERT INTO CATEGORIA(codigo, nomeCategoria) VALUES (1, 'Programador');
INSERT INTO CATEGORIA(codigo, nomeCategoria) VALUES (2, 'Comerciante');

INSERT INTO CLIENT(id, name, age, vatNumber, email, categoria) VALUES (1, 'Jr', 24, 'BR122868440', 'jr@email.com', 1);
INSERT INTO CLIENT(id, name, age, vatNumber, email, categoria) VALUES (2, 'Marta', 36, 'SP654895741', 'marta@email.com', 2);
INSERT INTO CLIENT(id, name, age, vatNumber, email, categoria) VALUES (3, 'John', 64, 'EN398712453', 'john@email.com', 2);
INSERT INTO CLIENT(id, name, age, vatNumber, email, categoria) VALUES (4, 'Susy', 29, 'RU199774800', 'susy@email.com', 1);