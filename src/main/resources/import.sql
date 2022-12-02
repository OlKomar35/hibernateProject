DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, price int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Walnut', 10), ('Hazelnut', 15), ('Peanut', 3),('Almond',14),('Cashews',12),('Coconut',8);
