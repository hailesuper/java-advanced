-- create database
DROP DATABASE IF EXISTS hai_java_advanced_a1e2;
CREATE DATABASE hai_java_advanced_a1e2;
USE hai_java_advanced_a1e2;

-- Table 1
CREATE TABLE departments (
	PRIMARY KEY (department_id),
	department_id	TINYINT	UNSIGNED	AUTO_INCREMENT,
    department_name	VARCHAR(50) UNIQUE NOT NULL
);


CREATE TABLE positions (
	PRIMARY KEY (position_id),
	position_id		TINYINT				AUTO_INCREMENT,
    position_name	ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL
);

-- Table 3
CREATE TABLE accounts (
	PRIMARY KEY (account_id),
	account_id		MEDIUMINT UNSIGNED	AUTO_INCREMENT,
    email			VARCHAR(320) UNIQUE, -- maximum of 64 characters (octets) in the "local part" (before the "@") and a maximum of 255 characters (octets) in the domain part (after the "@") for a total length of 320 characters.
    username		VARCHAR(50) UNIQUE,
    full_name		VARCHAR(100) NOT NULL,
    department_id	TINYINT UNSIGNED,
    position_id		TINYINT,
    create_date		DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (department_id) REFERENCES departments(department_id) ON DELETE CASCADE,
    FOREIGN KEY (position_id) REFERENCES positions(position_id) ON DELETE CASCADE
);

CREATE TABLE company_groups (
	PRIMARY KEY (group_id),
	group_id		SMALLINT UNSIGNED	AUTO_INCREMENT,
    group_name		VARCHAR(50) UNIQUE NOT NULL,
    creator_id		MEDIUMINT UNSIGNED NOT NULL,
    create_date		DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (creator_id) REFERENCES accounts(account_id) ON DELETE CASCADE
);

-- Table 5
CREATE TABLE group_accounts (
	PRIMARY KEY (group_id, account_id),
	group_id		SMALLINT UNSIGNED,
    account_id		MEDIUMINT UNSIGNED,
    join_date		DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (group_id) REFERENCES company_groups(group_id) ON DELETE CASCADE,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id) ON DELETE CASCADE
);

CREATE TABLE question_types (
	PRIMARY KEY (type_id),
	type_id			TINYINT 			AUTO_INCREMENT,
    type_name		ENUM('Essay', 'Multiple-Choice') NOT NULL
);

-- Table 7
CREATE TABLE question_categories (
	PRIMARY KEY (category_id),
	category_id		TINYINT UNSIGNED	AUTO_INCREMENT,
    category_name	VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE questions (
	PRIMARY KEY (question_id),
	question_id		INT UNSIGNED		AUTO_INCREMENT,
    content			VARCHAR(10000) NOT NULL,
    category_id		TINYINT UNSIGNED NOT NULL,
    type_id			TINYINT NOT NULL,
    creator_id		MEDIUMINT UNSIGNED NOT NULL,
    create_date		DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (category_id) REFERENCES question_categories(category_id) ON DELETE CASCADE,
	FOREIGN KEY (type_id) REFERENCES question_types(type_id) ON DELETE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES accounts(account_id) ON DELETE CASCADE
);

-- Table 9
CREATE TABLE answers (
	PRIMARY KEY (answer_id),
	answer_id		BIGINT				AUTO_INCREMENT,
    content			VARCHAR(500),
    question_id		INT UNSIGNED NOT NULL,
    is_correct		BIT,
    FOREIGN KEY (question_id) REFERENCES questions(question_id) ON DELETE CASCADE
);

CREATE TABLE exams (
	PRIMARY KEY (exam_id),
	exam_id			SMALLINT UNSIGNED	AUTO_INCREMENT,
    exam_code		VARCHAR(10) UNIQUE NOT NULL, -- both letters and numbers
    title			VARCHAR(100) NOT NULL,
    category_id		TINYINT UNSIGNED NOT NULL,
    duration		SMALLINT UNSIGNED NOT NULL, -- in minutes
    creator_id		MEDIUMINT UNSIGNED NOT NULL,
    create_date		DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (category_id) REFERENCES question_categories(category_id) ON DELETE CASCADE,
    FOREIGN KEY (creator_id) REFERENCES accounts(account_id) ON DELETE CASCADE
);

-- Table 11
CREATE TABLE exam_questions (
	PRIMARY KEY (exam_id, question_id),
	exam_id			SMALLINT UNSIGNED,
    question_id		INT UNSIGNED,
    FOREIGN KEY (exam_id) REFERENCES exams(exam_id) ON DELETE CASCADE,
    FOREIGN KEY (question_id) REFERENCES questions(question_id) ON DELETE CASCADE
);