-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Temps de generació: 23-02-2024 a les 22:30:19
-- Versió del servidor: 10.4.32-MariaDB
-- Versió de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `branchdb`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `branch`
--

CREATE TABLE `branch` (
  `pk_branchid` int(11) NOT NULL,
  `branch_country` varchar(255) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Bolcament de dades per a la taula `branch`
--

INSERT INTO `branch` (`pk_branchid`, `branch_country`, `branch_name`) VALUES
(1, 'Spain', 'Barcelona Financial Inc'),
(2, 'United Kingdom', 'London Branch'),
(3, 'spain', 'Valencia centre'),
(4, 'Australia', 'Melbourne'),
(5, 'Canada', 'Vancouver Inc'),
(6, 'South Korea', 'Daegu'),
(7, 'USA', 'New York Brokers'),
(8, 'Netherlands', 'Rotterdam'),
(9, 'Japan', 'Tokio'),
(10, 'New Zealand', 'Auckland'),
(12, 'France', 'Paris'),
(13, 'Italy', 'Pordoi'),
(14, 'Swiss', 'Zurich'),
(15, 'Russia', 'Moscow'),
(16, 'Germany', 'Berlin'),
(17, 'Portugal', 'Lisbon');

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`pk_branchid`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `branch`
--
ALTER TABLE `branch`
  MODIFY `pk_branchid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
