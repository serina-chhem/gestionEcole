-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 09, 2019 at 09:09 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `ecole`
--

-- --------------------------------------------------------

--
-- Table structure for table `anneeScolaire`
--

CREATE TABLE `anneeScolaire` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `anneeScolaire`
--

INSERT INTO `anneeScolaire` (`id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6);

-- --------------------------------------------------------

--
-- Table structure for table `bulletin`
--

CREATE TABLE `bulletin` (
  `id` int(11) NOT NULL,
  `moyenneG` float NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  `trimestre_id` int(11) NOT NULL,
  `inscription_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bulletin`
--

INSERT INTO `bulletin` (`id`, `moyenneG`, `appreciation`, `trimestre_id`, `inscription_id`) VALUES
(1, 12.56, 'correct', 1, 1),
(2, 11.5, 'Peu mieux faire', 2, 15),
(3, 15, 'Très bien', 6, 17),
(4, 9.99, 'Rattrapage', 5, 21),
(5, 10.05, 'Duh', 2, 4),
(6, 18.5, 'Excellent', 7, 4),
(7, 12.35, 'Hmmm', 5, 21),
(8, 13.4, 'Correct', 6, 22),
(9, 14.5, 'Bien', 8, 25);

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

CREATE TABLE `classe` (
  `id` int(11) NOT NULL,
  `nom` varchar(5) NOT NULL,
  `anneeScolaire_id` int(11) NOT NULL,
  `niveau_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`id`, `nom`, `anneeScolaire_id`, `niveau_id`) VALUES
(1, 'TD1', 1, 1),
(2, 'TD2', 1, 1),
(3, 'TD3', 1, 1),
(4, 'TD4', 1, 1),
(5, 'TD1', 1, 2),
(6, 'TD2', 1, 2),
(7, 'TD3', 1, 2),
(8, 'TD1', 1, 3),
(9, 'TD2', 1, 3),
(10, 'TD3', 1, 3),
(11, 'TD1', 1, 4),
(12, 'TD1', 1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `detailBulletin`
--

CREATE TABLE `detailBulletin` (
  `id` int(11) NOT NULL,
  `moyenneG` float NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  `bulletin_id` int(11) NOT NULL,
  `enseignement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detailBulletin`
--

INSERT INTO `detailBulletin` (`id`, `moyenneG`, `appreciation`, `bulletin_id`, `enseignement_id`) VALUES
(1, 12.56, 'plutot bon', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `discipline`
--

CREATE TABLE `discipline` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `discipline`
--

INSERT INTO `discipline` (`id`, `nom`) VALUES
(1, 'Maths'),
(2, 'Francais'),
(3, 'Anglais'),
(4, 'Histoire-Geo'),
(5, 'Sports'),
(6, 'Arts Plastiques');

-- --------------------------------------------------------

--
-- Table structure for table `enseignement`
--

CREATE TABLE `enseignement` (
  `id` int(11) NOT NULL,
  `classe_id` int(11) NOT NULL,
  `discipline_id` int(11) NOT NULL,
  `personne_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `enseignement`
--

INSERT INTO `enseignement` (`id`, `classe_id`, `discipline_id`, `personne_id`) VALUES
(1, 1, 3, 74),
(4, 3, 2, 65),
(5, 2, 6, 64),
(6, 7, 4, 71),
(7, 1, 1, 107),
(8, 1, 2, 77),
(9, 12, 4, 109);

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL,
  `note` float NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  `detailBulletin_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `evaluation`
--

INSERT INTO `evaluation` (`id`, `note`, `appreciation`, `detailBulletin_id`) VALUES
(7, 12, 'travail correct', 1),
(8, 6, 'insuffisant', 1);

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

CREATE TABLE `inscription` (
  `id` int(11) NOT NULL,
  `classe_id` int(11) NOT NULL,
  `personne_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inscription`
--

INSERT INTO `inscription` (`id`, `classe_id`, `personne_id`) VALUES
(1, 8, 70),
(4, 1, 60),
(14, 10, 85),
(15, 9, 86),
(17, 10, 76),
(18, 12, 87),
(19, 5, 88),
(21, 1, 89),
(22, 1, 90),
(23, 1, 100),
(24, 8, 103),
(25, 2, 92),
(26, 2, 95),
(27, 1, 94),
(28, 1, 104),
(29, 1, 74),
(30, 10, 102);

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

CREATE TABLE `niveau` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `niveau`
--

INSERT INTO `niveau` (`id`, `nom`) VALUES
(1, 'ING1'),
(2, 'ING2'),
(3, 'ING3'),
(4, 'ING4'),
(5, 'ING5');

-- --------------------------------------------------------

--
-- Table structure for table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `type` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `type`) VALUES
(60, 'kann', 'kevin', 1),
(64, 'mokhber', 'arash', 2),
(65, 'le cor', 'luc', 2),
(66, 'romeo', 'elvis', 3),
(69, 'swift', 'taylor', 3),
(70, ' benten ', ' lucas', 1),
(71, 'jonas', 'joe', 2),
(74, 'bentala', 'malik', 2),
(75, 'bieber', 'justin', 1),
(76, 'palvin', 'barbara', 1),
(77, 'mercury', 'freddie', 2),
(78, 'john', 'elton', 2),
(83, 'holmes', 'sherlock', 2),
(84, 'bat', 'man', 2),
(85, 'Kendrick', 'Anna', 1),
(86, ' Justin ', ' Balvin', 1),
(87, 'tang', 'thomas', 1),
(88, 'Scott', 'Kathryn', 1),
(89, 'bizu', 'izzy', 1),
(90, 'zouai', 'lolo', 1),
(91, 'Park', 'Anderson', 1),
(92, ' Jolie ', ' Angelina', 1),
(93, 'Martin', 'Benoit', 1),
(94, 'Dubois', 'Tom', 1),
(95, 'Moreau', 'Jacques', 1),
(96, 'Laurent', 'Laura', 1),
(97, 'Fourier', 'Jenny', 1),
(98, 'Lamb', 'Bamby', 1),
(99, 'Rousseau', 'Lena', 1),
(100, 'Roux', 'Alice', 1),
(101, 'Leroux', 'Celine', 1),
(102, 'Martinez', 'Lola', 1),
(103, 'Picard', 'Valentine', 1),
(104, 'Arthur', 'Maelle', 1),
(105, 'belo', 'dimitri', 2),
(106, 'duper', 'tristan', 2),
(107, 'paris', 'alexandra', 2),
(108, ' booba ', ' shawna', 2),
(109, 'super', 'woman', 2);

-- --------------------------------------------------------

--
-- Table structure for table `trimestre`
--

CREATE TABLE `trimestre` (
  `id` int(11) NOT NULL,
  `anneeScolaire_id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `trimestre`
--

INSERT INTO `trimestre` (`id`, `anneeScolaire_id`, `numero`, `debut`, `fin`) VALUES
(1, 1, 1, '2020-09-09', '2020-12-09'),
(2, 1, 2, '2020-12-10', '2021-03-09'),
(3, 1, 3, '2021-03-10', '2021-06-09'),
(5, 2, 1, '2021-09-09', '2021-12-09'),
(6, 2, 2, '2021-12-10', '2022-03-09'),
(7, 2, 3, '2022-03-10', '2022-06-09'),
(8, 3, 1, '2022-09-09', '2022-12-09'),
(9, 3, 2, '2022-12-10', '2023-03-09'),
(10, 3, 3, '2023-03-10', '2023-06-09');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anneeScolaire`
--
ALTER TABLE `anneeScolaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bulletin`
--
ALTER TABLE `bulletin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `trimestre_id` (`trimestre_id`),
  ADD KEY `inscription_id` (`inscription_id`);

--
-- Indexes for table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `anneeScolaire_id` (`anneeScolaire_id`),
  ADD KEY `niveau_id` (`niveau_id`);

--
-- Indexes for table `detailBulletin`
--
ALTER TABLE `detailBulletin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bulletin_id` (`bulletin_id`),
  ADD KEY `enseignement_id` (`enseignement_id`);

--
-- Indexes for table `discipline`
--
ALTER TABLE `discipline`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enseignement`
--
ALTER TABLE `enseignement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `classe_id` (`classe_id`),
  ADD KEY `discipline_id` (`discipline_id`),
  ADD KEY `personne_id` (`personne_id`);

--
-- Indexes for table `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `detailBulletin_id` (`detailBulletin_id`);

--
-- Indexes for table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personne_id` (`personne_id`) USING BTREE,
  ADD KEY `classe_id` (`classe_id`);

--
-- Indexes for table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trimestre`
--
ALTER TABLE `trimestre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `anneeScolaire_id` (`anneeScolaire_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anneeScolaire`
--
ALTER TABLE `anneeScolaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `bulletin`
--
ALTER TABLE `bulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `classe`
--
ALTER TABLE `classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `detailBulletin`
--
ALTER TABLE `detailBulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `discipline`
--
ALTER TABLE `discipline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `enseignement`
--
ALTER TABLE `enseignement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT for table `trimestre`
--
ALTER TABLE `trimestre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `bulletin_ibfk_1` FOREIGN KEY (`trimestre_id`) REFERENCES `trimestre` (`id`),
  ADD CONSTRAINT `bulletin_ibfk_2` FOREIGN KEY (`inscription_id`) REFERENCES `inscription` (`id`);

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`anneeScolaire_id`) REFERENCES `anneeScolaire` (`id`),
  ADD CONSTRAINT `classe_ibfk_2` FOREIGN KEY (`niveau_id`) REFERENCES `niveau` (`id`);

--
-- Constraints for table `detailBulletin`
--
ALTER TABLE `detailBulletin`
  ADD CONSTRAINT `detailbulletin_ibfk_1` FOREIGN KEY (`bulletin_id`) REFERENCES `bulletin` (`id`),
  ADD CONSTRAINT `detailbulletin_ibfk_2` FOREIGN KEY (`enseignement_id`) REFERENCES `enseignement` (`id`);

--
-- Constraints for table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `enseignement_ibfk_1` FOREIGN KEY (`classe_id`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `enseignement_ibfk_2` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`),
  ADD CONSTRAINT `enseignement_ibfk_3` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`id`);

--
-- Constraints for table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`detailBulletin_id`) REFERENCES `detailBulletin` (`id`);

--
-- Constraints for table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`classe_id`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `inscription_ibfk_2` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`id`),
  ADD CONSTRAINT `personne_id` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`id`);

--
-- Constraints for table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `trimestre_ibfk_1` FOREIGN KEY (`anneeScolaire_id`) REFERENCES `anneeScolaire` (`id`);
