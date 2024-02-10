-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2024 at 09:50 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `cancellation`
--

CREATE TABLE `cancellation` (
  `pnr_no` varchar(10) DEFAULT NULL,
  `cancellation_no` varchar(10) DEFAULT NULL,
  `cancellation_date` varchar(20) DEFAULT NULL,
  `fli_code` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `f_code` varchar(10) DEFAULT NULL,
  `f_name` varchar(20) DEFAULT NULL,
  `src` varchar(30) DEFAULT NULL,
  `dst` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

CREATE TABLE `passenger` (
  `pnr_no` varchar(10) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `nationality` varchar(15) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `ph_no` varchar(15) DEFAULT NULL,
  `passport_no` varchar(20) DEFAULT NULL,
  `fl_code` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `pnr_no` varchar(10) DEFAULT NULL,
  `ph_no` varchar(15) DEFAULT NULL,
  `cheque_no` varchar(15) DEFAULT NULL,
  `card_no` varchar(20) DEFAULT NULL,
  `paid_amt` varchar(10) DEFAULT NULL,
  `pay_data` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `pnr_no` varchar(10) DEFAULT NULL,
  `ticket_id` varchar(10) DEFAULT NULL,
  `f_code` varchar(10) DEFAULT NULL,
  `jny_data` varchar(20) DEFAULT NULL,
  `jny_time` varchar(10) DEFAULT NULL,
  `src` varchar(20) DEFAULT NULL,
  `dst` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sector`
--

CREATE TABLE `sector` (
  `flight_code` varchar(20) DEFAULT NULL,
  `capacity` varchar(10) DEFAULT NULL,
  `class_code` varchar(5) DEFAULT NULL,
  `class_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
