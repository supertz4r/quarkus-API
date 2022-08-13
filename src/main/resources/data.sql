/* CREATE TABLE IF NOT EXISTS CATEGORIA (
   id INT NOT NULL,
   nome VARCHAR(20) NOT NULL,
   PRIMARY KEY (id)
); */

CREATE TABLE IF NOT EXISTS CLIENT (
   id INT NOT NULL,
   name VARCHAR(100) NOT NULL,
   age INT NOT NULL,
   vatNumber VARCHAR(11) NOT NULL,
   email VARCHAR(20) NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO CLIENT(id, name, age, vatNumber, email) VALUES (1, 'Jr', 24, 'BR122868440', 'jr@email.com');
INSERT INTO CLIENT(id, name, age, vatNumber, email) VALUES (2, 'Marta', 36, 'SP654895741', 'marta@email.com');
INSERT INTO CLIENT(id, name, age, vatNumber, email) VALUES (3, 'John', 64, 'EN398712453', 'john@email.com');
INSERT INTO CLIENT(id, name, age, vatNumber, email) VALUES (4, 'Susy', 29, 'RU199774800', 'susy@email.com');