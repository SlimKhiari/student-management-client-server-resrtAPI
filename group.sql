-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : lun. 07 nov. 2022 à 09:47
-- Version du serveur :  8.0.31-0ubuntu0.20.04.1
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `group`
--

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE `groupe` (
  `idgroup` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `teachingunit` int NOT NULL,
  `subject` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`idgroup`, `name`, `teachingunit`, `subject`) VALUES
(63, 'G1', 20, 13),
(65, 'kAi7gLQUB4', 21, 15);

-- --------------------------------------------------------

--
-- Structure de la table `groupstudent`
--

CREATE TABLE `groupstudent` (
  `idgroupStudent` int NOT NULL,
  `idstudent` int NOT NULL,
  `idgroup` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `groupstudent`
--

INSERT INTO `groupstudent` (`idgroupStudent`, `idstudent`, `idgroup`) VALUES
(54, 13, 63),
(55, 13, 64),
(56, 16, 64),
(57, 14, 65);

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

CREATE TABLE `student` (
  `idstudent` int NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `student`
--

INSERT INTO `student` (`idstudent`, `firstname`, `lastname`) VALUES
(13, 'Desnoux', 'Adrien'),
(14, 'SONWA', 'Triom'),
(16, 'SATCHIVI', 'Yannick'),
(17, 'Toto', 'Yannick');

-- --------------------------------------------------------

--
-- Structure de la table `subject`
--

CREATE TABLE `subject` (
  `idsubject` int NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `subject`
--

INSERT INTO `subject` (`idsubject`, `title`, `description`) VALUES
(13, 'Cloud computing', ''),
(14, 'calcule de perf', 'lalal'),
(15, 'Architecture', 'Sujet');

-- --------------------------------------------------------

--
-- Structure de la table `teachingunit`
--

CREATE TABLE `teachingunit` (
  `idteachingunit` int NOT NULL,
  `title` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `teachingunit`
--

INSERT INTO `teachingunit` (`idteachingunit`, `title`) VALUES
(21, 'Architecture logicielle'),
(22, 'Anglais');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`idgroup`);

--
-- Index pour la table `groupstudent`
--
ALTER TABLE `groupstudent`
  ADD PRIMARY KEY (`idgroupStudent`);

--
-- Index pour la table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`idstudent`);

--
-- Index pour la table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`idsubject`);

--
-- Index pour la table `teachingunit`
--
ALTER TABLE `teachingunit`
  ADD PRIMARY KEY (`idteachingunit`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `idgroup` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT pour la table `groupstudent`
--
ALTER TABLE `groupstudent`
  MODIFY `idgroupStudent` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT pour la table `student`
--
ALTER TABLE `student`
  MODIFY `idstudent` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `subject`
--
ALTER TABLE `subject`
  MODIFY `idsubject` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `teachingunit`
--
ALTER TABLE `teachingunit`
  MODIFY `idteachingunit` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
