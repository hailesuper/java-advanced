DROP DATABASE IF EXISTS hai_java_advanced_final02;

CREATE DATABASE hai_java_advanced_final02;

USE hai_java_advanced_final02;

CREATE TABLE users (
	PRIMARY KEY (id),
    id INT UNSIGNED AUTO_INCREMENT,
    full_name VARCHAR(50) NOT NULL,
    username VARCHAR(20) UNIQUE NOT NULL,
    `password` VARCHAR(200) NOT NULL,
    `role` ENUM("ADMIN", "MANAGER", "USER") DEFAULT "USER"
);

CREATE TABLE `groups` (
	PRIMARY KEY (id),
    id INT UNSIGNED AUTO_INCREMENT,
    group_name VARCHAR(50) NOT NULL UNIQUE,
    total_member INT,
    creator_id INT UNSIGNED,
    create_date DATE DEFAULT (CURDATE()),
    FOREIGN KEY (creator_id) REFERENCES users(id)
);

INSERT INTO users(full_name, username, `password`, `role`)
VALUES

("Hai 1", "hai01", "$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi", "ADMIN"),
("Hai 2", "hai02", "$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi", "MANAGER"),
("Hai 3", "hai03", "$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi", "USER")
;

INSERT INTO `groups` (group_name, total_member, creator_id, create_date) 
VALUES 
('Hai Group 1', 1, 1, '2022-07-10'),
('Hai Group 2', 2, 2, '2022-06-10'),
('Hai Group 3', 3, 1, '2022-07-10'),
('Hai Group 4', 4, 2, '2022-07-10'),
('Hai Group 5', 5, 1, '2022-07-10'),
('Hai Group 6', 6, 2, '2022-07-10'),
('Hai Group 7', 7, 1, CURDATE())
;

