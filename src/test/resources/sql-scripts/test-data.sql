-- THIS COULD BE USED INSTEAD OF TEARDOWN METHOD IN TESTS...
-- drop TABLE IF EXISTS movies;

CREATE TABLE IF NOT EXISTS movies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    director VARCHAR(50) NOT NULL
);

INSERT INTO movies (name, minutes, genre, director) VALUES
    ('Dark Knight', 152, 'ACTION', 'Director 1'),
    ('Memento', 113, 'THRILLER', 'Director 2'),
    ('Matrix', 136, 'ACTION', 'Director 3'),
    ('Super 8', 112, 'THRILLER', 'Director 4'),
    ('Superman', 135, 'ACTION', 'Director 5')