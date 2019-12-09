START TRANSACTION;
INSERT INTO `actors` (`id`, `birth_date`, `name`, `surname`, `country_id`) VALUES
(7, '1947-07-29', 'Arnold', 'Schwarzenegger', 5),
(8, '1946-07-05', 'Sylvester', 'Stallone', 3),
(9, '1960-05-24', 'Richard', 'Crenna', 1),
(10, '1938-07-09', 'Bryan', 'Dennehy', 1),
(11, '1956-07-31', 'Michael', 'Bienne', 2),
(12, '1956-09-26', 'Linda', 'Hamilton', 2);

INSERT INTO `countries` (`id`, `code`, `name`) VALUES
(1, 'USA', 'United States of America'),
(2, 'ES', 'Spain'),
(3, 'FR', 'France'),
(4, 'PL', 'Poland'),
(5, 'AT', 'Austria'),
(6, 'UK', 'United Kingdom');

INSERT INTO `directors` (`id`, `birth_date`, `name`, `surname`, `country_id`) VALUES
(13, '1954-08-16', 'James', 'Cameron', 1),
(14, '1931-07-07', 'Ted', 'Kotcheff', 4);

INSERT INTO `films` (`id`, `premiere_year`, `prizes_won`, `rate`, `synopsis`, `title`, `country_id`, `director`) VALUES
(21, 1982, 1, 8.8, 'A veteran Green Beret is forced by a cruel Sheriff and his deputies to flee into the mountains and wage an escalating one-man war against his pursuers.', 'Rambo', 1, 14),
(22, 1997, 6, 7.5, 'In 1984, a human soldier is tasked to stop an indestructible cyborg killing machine, both sent from 2029, from executing a young woman, whose unborn son is the key to humanity\'s future salvation.', 'Terminator', 1, 13);

INSERT INTO `films_actors` (`film_id`, `actor_id`) VALUES
(21, 8),
(21, 9),
(21, 10),
(22, 7),
(22, 11);

INSERT INTO `films_genres` (`film_id`, `genre_id`) VALUES
(21, 15),
(21, 17),
(21, 19),
(22, 15),
(22, 16),
(22, 17),
(22, 20);

INSERT INTO `genres` (`id`, `name`) VALUES
(15, 'Action'),
(16, 'Drama'),
(17, 'Thriller'),
(18, 'Romantic'),
(19, 'War'),
(20, 'Sci-Fi');

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(23),
(23),
(23),
(23);

COMMIT;