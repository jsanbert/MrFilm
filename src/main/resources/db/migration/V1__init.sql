SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `actors` (
                          `id` bigint(20) NOT NULL,
                          `birth_date` date DEFAULT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          `surname` varchar(255) DEFAULT NULL,
                          `country_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `countries` (
                             `id` bigint(20) NOT NULL,
                             `code` varchar(255) DEFAULT NULL,
                             `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `directors` (
                             `id` bigint(20) NOT NULL,
                             `birth_date` date DEFAULT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `surname` varchar(255) DEFAULT NULL,
                             `country_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `films` (
                         `id` bigint(20) NOT NULL,
                         `premiere_year` int(11) DEFAULT NULL,
                         `prizes_won` int(11) DEFAULT NULL,
                         `rate` float DEFAULT NULL,
                         `synopsis` varchar(255) DEFAULT NULL,
                         `title` varchar(255) DEFAULT NULL,
                         `country` bigint(20) DEFAULT NULL,
                         `director` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `films_actors` (
                                `film_id` bigint(20) NOT NULL,
                                `actor_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `films_genres` (
                                `film_id` bigint(20) NOT NULL,
                                `genre_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `genres` (
                          `id` bigint(20) NOT NULL,
                          `name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `people` (
                          `id` bigint(20) NOT NULL,
                          `birth_date` date DEFAULT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          `surname` varchar(255) DEFAULT NULL,
                          `country_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

ALTER TABLE `actors`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FK_7y56ctb9jojloj0k9cigenku5` (`country_id`);

ALTER TABLE `countries`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `directors`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FK_r6ygloutntrppsund5lran3j1` (`country_id`);

ALTER TABLE `films`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FKc0g9lb8th8x3on0j9rqut7k8w` (`country`),
    ADD KEY `FKjgje3bnnhqy9jm6br6uux20gb` (`director`);

ALTER TABLE `films_actors`
    ADD KEY `FKdjtf3dy8e0s3x13r8noaif9w` (`actor_id`),
    ADD KEY `FKm871tpbjgvlefqev7aaq827s0` (`film_id`);

ALTER TABLE `films_genres`
    ADD KEY `FKtcwy3ocjyhnni2yr22y2hpb9p` (`genre_id`),
    ADD KEY `FKqr8m71obccc9w6cp91l3k8r2w` (`film_id`);

ALTER TABLE `genres`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `people`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FK90csifbkadfg0r9i15ja4i564` (`country_id`);
COMMIT;
