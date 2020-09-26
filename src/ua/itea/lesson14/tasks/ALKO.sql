-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 26, 2020 at 08:41 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ALKO`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `d_id` tinyint(4) NOT NULL,
  `cat_name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`d_id`, `cat_name`) VALUES
(1, 'soft drinks'),
(2, 'wine'),
(3, 'beer'),
(4, 'vodka'),
(5, 'shot');

-- --------------------------------------------------------

--
-- Table structure for table `drinks`
--

CREATE TABLE `drinks` (
  `d_id` bigint(20) UNSIGNED NOT NULL,
  `d_name` varchar(255) NOT NULL,
  `d_degree` tinyint(3) UNSIGNED DEFAULT NULL,
  `d_category` tinyint(4) DEFAULT NULL,
  `d_volume` float(6,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `drinks`
--

INSERT INTO `drinks` (`d_id`, `d_name`, `d_degree`, `d_category`, `d_volume`) VALUES
(1, 'water', 0, 1, 456.23),
(2, 'juice', 0, 1, 123.13),
(3, 'milk', 0, 1, 235.10),
(4, 'Sauvignon Blanc', 17, 2, 43.10),
(5, 'Semillon', 20, 2, 54.10),
(6, 'Chardonnay', 18, 2, 0.00),
(7, 'Verdelho', 17, 2, 8.50),
(8, 'Witbier', 5, 3, 235.54),
(9, 'Tripel', 8, 3, 12.30),
(10, 'Münchener Hell', 5, 3, 34.24),
(11, 'Doppelbock', 9, 3, 32.40),
(12, 'Bière de Garde', 7, 3, 2.80),
(13, 'Reyka', 39, 4, 6.45),
(14, 'Smirnoff', 41, 4, 54.54),
(15, 'Vermont Spirits', 39, 4, 34.11),
(16, 'B-52', 3, 5, 3.30),
(17, 'Tequila Slammer', 18, 5, 45.15),
(18, 'Irish Car Bomb', 31, 5, 0.30);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `drinks`
--
ALTER TABLE `drinks`
  ADD PRIMARY KEY (`d_id`),
  ADD KEY `d_category` (`d_category`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `d_id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `drinks`
--
ALTER TABLE `drinks`
  MODIFY `d_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `drinks`
--
ALTER TABLE `drinks`
  ADD CONSTRAINT `drinks_ibfk_1` FOREIGN KEY (`d_category`) REFERENCES `category` (`d_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
