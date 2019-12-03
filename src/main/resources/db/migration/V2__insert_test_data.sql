START TRANSACTION;

INSERT INTO `actors` (`id`, `birth_date`, `name`, `surname`, `country_id`) VALUES
(6, '1954-10-27', 'Arnold', 'Schwarzenegger', 1),
(7, '1950-09-10', 'Sylvester', 'Stallone', 5),
(8, '1960-05-24', 'Antonio', 'Banderas', 2);

INSERT INTO `countries` (`id`, `code`, `name`) VALUES
(1, 'USA', 'United States of America'),
(2, 'ES', 'Spain'),
(3, 'FR', 'France'),
(4, 'PL', 'Poland'),
(5, 'UK', 'United Kingdom');

INSERT INTO `directors` (`id`, `birth_date`, `name`, `surname`, `country_id`) VALUES
(9, '1967-03-10', 'Michael', 'Bay', 1),
(10, '1945-05-13', 'Roman', 'Polanski', 4);

INSERT INTO `films` (`id`, `premiere_year`, `prizes_won`, `rate`, `synopsis`, `title`, `country`, `director`) VALUES
(17, 2000, 3, 8.8, 'Synopsis Eraser', 'Eraser', 1, 9),
(18, 1997, 6, 7.5, 'Synopsis Rambo', 'Rambo', 1, 10);

INSERT INTO `films_actors` (`film_id`, `actor_id`) VALUES
(17, 6),
(18, 7),
(18, 8);

INSERT INTO `films_genres` (`film_id`, `genre_id`) VALUES
(17, 11),
(18, 11),
(18, 14);

INSERT INTO `genres` (`id`, `name`) VALUES
(11, 'Action'),
(12, 'Drama'),
(13, 'Thriller'),
(14, 'War'),
(15, 'Romantic'),
(16, 'Sci-Fi');

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(19),
(19),
(19),
(19);

COMMIT;