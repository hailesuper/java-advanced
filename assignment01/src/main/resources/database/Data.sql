-- Table 1
INSERT INTO departments (department_name)
VALUES
						('Ban giám đốc'),
                        ('Marketing'),
                        ('Sales'),
                        ('Nhân sự'),
                        ('Hành chính'),
                        ('Kỹ thuật'),
                        ('Sản xuất'),
                        ('Tài chính'),
                        ('Thư ký'),
                        ('Bảo vệ'),
                        ('先生');
                        
INSERT INTO positions (position_name)
VALUES
						('Dev'),
						('Test'),
						('Scrum Master'),
						('PM');
                        
-- Table 3
INSERT INTO accounts (email,								username,				full_name,							department_id, 			position_id, create_date)
VALUES				('kattie.corkery@yahoo.com',			'dutyhungarian',		'Phạm Thiên An',					1,						1, '2020-03-22'),
					('aleen57@hotmail.com',					'toupeeaustralian',		'Trần Ngọc Bảo',					1,						2, '2020-11-02'),
					('grimes.alek@hotmail.com',				'bowyangslovakian',		'Hoàng Nguyễn Phúc Nguyên Chương',	1,						3, '2021-06-12'),
					('cleveland.schneider@williamson.com',	'rickshawliberian',		'Nguyễn Thanh Danh',				4,						4, '2021-10-13'),
					('stephania.weimann@collins.com',		'gewgawturkish',		'Nguyễn Trần Quốc Duy',				5,						1, '2021-10-26'),
					('afeeney@hotmail.com',					'wobblepanamanian',		'Phan Đức Thanh Duy',				6,						2, '2019-08-11'),
					('heaney.edwina@denesik.com',			'jigglepakistani',		'Trần Đình Hưng',					7,						3, '2019-08-20'),
					('marcel.gleason@yahoo.com',			'gubbinsindonesian',	'Trần Kiên Hưng',					8,						4, '2019-12-08'),
					('aeffertz@rippin.net',					'queerbosnian',			'Hứa Tuấn Hữu',						9,						1, '2020-03-06'),
					('glindgren@hotmail.com',				'topplepolish',			'Hà Đình Đức Huy',					3,						2, now()),
					('stephania.imann@collins.com',		'gewgawtur2kish',		'Trần Nguyễn Quốc Duy',				5,						1, '2021-10-26'),
                    ('stephaa.imann@collins.com',		'gewgawtuish',		'Nguyen Tran Quoc  Huy',				5,						1, '2021-10-26');

				

INSERT INTO company_groups (group_name, 			creator_id)
VALUES						
							("Dumbledore' \"Army.",			1),
							('The Nerd Herd' '   '  '1',				2),
							('Fantastic Four',				3),
							('Life of Pi',					4),
							('We Who Shall Not Be Named',	5),
							('This Group is A+',			6),
							('The Collective',				7),
							('39 Clues',					8),
							('The Meme Team',				9),
							('Best Fries Forever',			10),
							('The Friendship Ship',			1);
                            
-- Table 5                            
INSERT INTO group_accounts (group_id, account_id, join_date)
VALUES
						(9,           6,          '2021-03-03'),
						(7,           5,          '2021-04-23'),
						(6,           9,          '2021-04-29'),
						(1,           10,         '2021-08-10'),
						(2,           1,          '2021-10-06'),
                        (2,           2,          '2021-10-06'),
                        (2,           3,          '2021-10-06'),
                        (2,           5,          '2021-10-06'),
                        (2,           6,          '2021-10-06'),
                        (2,           7,          '2021-10-06'),
						(10,          7,          '2021-10-11'),
						(10,          6,          '2021-10-11'),
						(10,          5,          '2021-10-11'),
						(10,          4,          '2021-10-11'),
						(10,          3,          '2021-10-11'),
						(10,          2,          '2021-10-11'),
						(10,          1,          '2021-10-11'),
						(10,          8,          '2021-10-11'),
						(10,          9,          '2021-10-11'),
						(4,           1,          '2021-10-20'),
						(8,           2,          '2021-10-21'),
						(3,           8,          '2021-11-24'),
						(4,           4,          '2021-12-21');

-- Table 6
INSERT INTO question_types (type_name)
VALUES
							('Essay'),
							('Multiple-Choice');
                            
-- Table 7
INSERT INTO question_categories (category_name)
VALUES
							('HTML and CSS'),
							('Python'),
							('Java'),
							('JavaScript'),
							('Swift'),
							('C++'),
							('C#'),
							('R'),
							('Golang (Go)'),
							('Others');

-- Table 8
INSERT INTO questions (category_id, type_id, creator_id, content)
VALUES
						(1,            2,             2,         'What does HTML stand for?'),
						(1,            1,             2,         'Describe HTML.'),
						(1,            1,             2,         'Write the basic structure of the HTML template?'),
						(1,            1,             2,         'What is HTML5?'),
						(2,            1,             2,         'What are the key features of Python?'),
						(2,            2,             2,         'Differentiate between lists and tuples. '),
						(3,            1,             3,         'Why is Java a platform independent language?'),
						(3,            1,             3,         'Why is Java not a pure object oriented language?'),
						(4,            1,             3,         'What are the different data types present in javascript?'),
						(4,            1,             3,         'Explain Hoisting in javascript.'),
						(4,            2,             3,         'Difference between "==" and " === " operators.'),
						(4,            2,             3,         'Explain Implicit Type Coercion in javascript. '),
						(5,            1,             3,         'Why is immutability important?'),
						(5,            1,             4,        'When using arrays, what’s the difference between map() and compactMap()?'),
						(6,            1,             4,        'Explain constructor in C++'),
						(7,            1,             4,        'What is Common Language Runtime (CLR)?'),
						(8,            1,             4,        'What are the different data structures in R?'),
						(9,            1,             4,        'Is Golang case sensitive or insensitive?'),
						(9,           2,             12,        ' How do you find the missing number in a given integer array of 1 to 100?'),
						(9,           2,             5,        ' Do I really need to change my password often?');
                        
-- Table 9
INSERT INTO answers (content, question_id, is_correct)
VALUES
						('A',    1,      0),
						('B',    1,      1),
						('C',    1,      0),
						('D',    1,      0),
						('A',    2,      0),
						('B',    2,      0),
						('C',    2,      1),
						('D',    2,      0),
						('A',    2,      0),
						('B',    3,      1),
						('C',    3,      0),
						('D',    3,      0),
						('A',    4,      1),
						('B',    4,      1),
						('C',    4,      0),
						('D',    4,      0),
						('E',    4,      0);
                        

-- Table 10
INSERT INTO exams (exam_code, 	title, 								category_id, duration, creator_id, create_date)
VALUES							
				('GK',         'Gaokao', 							1,     		 30,       7,       '2008-02-08'),
				('GE',         'IIT-JEE',							1,     		 30,       7,       '2022-02-13'),
				('GU',         'UPSC',   							1,      	30,       7,       '2022-03-31'),
				('GM',         'Mensa',  							1,      	30,       7,       '1998-04-11'),
				('GR',         'GRE',    							1,      	50,      7,       '2022-05-08'),
				('GF',         'CFA',    							2,      	180,      8,       '2022-06-10'),
				('GC',         'CCIE',   							2,      	180,      8,       '2022-06-23'),
				('GA',         'GATE',   							2,      	480,      8,       '2022-09-16'),
				('GS',         'Master Sommelier Diploma Exam',    	2,       	480,       8,       '2022-10-05'),
				('GX',         'All Souls Prize Fellowship Exam',  	2,      	 480,       8,       '2022-12-26');


-- Table 11
INSERT INTO exam_questions (exam_id, question_id)
VALUES
				(1,        1),
				(1,        2),
				(1,        5),
				(2,        6),
				(3,        7),
				(3,        8),
				(3,        5),
				(4,        6),
				(5,        7),
				(6,        8),
				(7,        9),
				(8,        1),
				(8,        2),
				(9,        3),
				(9,        9),
				(10,       2);