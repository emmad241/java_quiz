CREATE TABLE IF NOT EXISTS questions (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    question_text TEXT NOT NULL,
    correct_answer TEXT NOT NULL,
    incorrect_answer1 TEXT NOT NULL,
    incorrect_answer2 TEXT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO questions (question_text, correct_answer, incorrect_answer1, incorrect_answer2) VALUES
    ('What is the capital of France?', 'Paris', 'London', 'Berlin'),
    ('What is the capital of Germany?', 'Berlin', 'Paris', 'London'),
    ('What is the capital of the United Kingdom?', 'London', 'Paris', 'Berlin'),
    ('What is the capital of Spain?', 'Madrid', 'Paris', 'London'),
    ('What is the capital of Italy?', 'Rome', 'Paris', 'London');
    
