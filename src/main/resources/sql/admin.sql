-- database
DROP DATABASE IF EXISTS bootcamp;
CREATE DATABASE bootcamp;

-- user
DROP USER IF EXISTS spring;
CREATE USER spring WITH PASSWORD 'spring123';

-- privileges
GRANT ALL PRIVILEGES ON DATABASE bootcamp TO spring;
GRANT USAGE ON SCHEMA public TO spring;
ALTER USER spring WITH SUPERUSER;