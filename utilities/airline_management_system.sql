-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 09, 2024 at 03:05 PM
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

--
-- Dumping data for table `cancellation`
--

INSERT INTO `cancellation` (`pnr_no`, `cancellation_no`, `cancellation_date`, `fli_code`) VALUES
('PNR567890', 'CAN005', '2024-02-14 14:00:00', 'FLI005'),
('PNR012345', 'CAN020', '2024-02-29 19:00:00', 'FLI010'),
('PNR901234', 'CAN025', '2024-02-25', ' FLI014'),
('PNR123456', 'CAN030', '2024-02-10 15:00:00 ', 'FLI001');

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

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`f_code`, `f_name`, `src`, `dst`) VALUES
('FLI001', 'Flight 1', 'City A', 'City B'),
('FLI002', 'Flight 2', 'City B', 'City C'),
('FLI003', 'Flight 3', 'City C', 'City D'),
('FLI004', 'Flight 4', 'City D', 'City E'),
('FLI005', 'Flight 5', 'City E', 'City F'),
('FLI006', 'Flight 6', 'City F', 'City G'),
('FLI007', 'Flight 7', 'City G', 'City H'),
('FLI008', 'Flight 8', 'City H', 'City I'),
('FLI009', 'Flight 9', 'City I', 'City J'),
('FLI010', 'Flight 10', 'City J', 'City K'),
('FLI011', 'Flight 11', 'City K', 'City L'),
('FLI012', 'Flight 12', 'City L', 'City M'),
('FLI013', 'Flight 13', 'City M', 'City N'),
('FLI014', 'Flight 14', 'City N', 'City O'),
('FLI015', 'Flight 15', 'City O', 'City P'),
('FLI016', 'Flight 16', 'City P', 'City Q'),
('FLI017', 'Flight 17', 'City Q', 'City R'),
('FLI018', 'Flight 18', 'City R', 'City S'),
('FLI019', 'Flight 19', 'City S', 'City T'),
('FLI020', 'Flight 20', 'City T', 'City U');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '123456');

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

--
-- Dumping data for table `passenger`
--

INSERT INTO `passenger` (`pnr_no`, `address`, `nationality`, `name`, `gender`, `ph_no`, `passport_no`, `fl_code`) VALUES
('PNR123456', '123 Street, City A', 'Country A', 'John Doe', 'Male', '1234567890', 'AB1234567', 'FLI001'),
('PNR234567', '456 Avenue, City B', 'Country B', 'Jane Smith', 'Female', '2345678901', 'CD2345678', 'FLI002'),
('PNR345678', '789 Road, City C', 'Country C', 'Alice Johnson', 'Female', '3456789012', 'EF3456789', 'FLI003'),
('PNR456789', '012 Boulevard, City D', 'Country D', 'Bob Williams', 'Male', '4567890123', 'GH4567890', 'FLI004'),
('PNR567890', '345 Lane, City E', 'Country E', 'Emily Brown', 'Female', '5678901234', 'IJ5678901', 'FLI005'),
('PNR678901', '678 Drive, City F', 'Country F', 'Michael Jones', 'Male', '6789012345', 'KL6789012', 'FLI006'),
('PNR789012', '901 Place, City G', 'Country G', 'Jessica Davis', 'Female', '7890123456', 'MN7890123', 'FLI007'),
('PNR890123', '234 Court, City H', 'Country H', 'David Garcia', 'Male', '8901234567', 'OP8901234', 'FLI008'),
('PNR901234', '567 Park, City I', 'Country I', 'Sarah Martinez', 'Female', '9012345678', 'QR9012345', 'FLI009'),
('PNR012345', '890 Square, City J', 'Country J', 'Daniel Rodriguez', 'Male', '0123456789', 'ST0123456', 'FLI010'),
('PNR123456', '123 Street, City A', 'Country A', 'John Doe', 'Male', '1234567890', 'AB1234567', 'FLI001'),
('PNR234567', '456 Avenue, City B', 'Country B', 'Jane Smith', 'Female', '2345678901', 'CD2345678', 'FLI002'),
('PNR345678', '789 Road, City C', 'Country C', 'Alice Johnson', 'Female', '3456789012', 'EF3456789', 'FLI003'),
('PNR456789', '012 Boulevard, City D', 'Country D', 'Bob Williams', 'Male', '4567890123', 'GH4567890', 'FLI004'),
('PNR567890', '345 Lane, City E', 'Country E', 'Emily Brown', 'Female', '5678901234', 'IJ5678901', 'FLI005'),
('PNR678901', '678 Drive, City F', 'Country F', 'Michael Jones', 'Male', '6789012345', 'KL6789012', 'FLI006'),
('PNR789012', '901 Place, City G', 'Country G', 'Jessica Davis', 'Female', '7890123456', 'MN7890123', 'FLI007'),
('PNR890123', '234 Court, City H', 'Country H', 'David Garcia', 'Male', '8901234567', 'OP8901234', 'FLI008'),
('PNR901234', '567 Park, City I', 'Country I', 'Sarah Martinez', 'Female', '9012345678', 'QR9012345', 'FLI009'),
('PNR012345', '890 Square, City J', 'Country J', 'Daniel Rodriguez', 'Male', '0123456789', 'ST0123456', 'FLI010'),
('PNR012370', '900 Square, City A', 'Country J', 'Mihai Albu', 'male', '0123456780', 'ST0123460', 'FLI010'),
('PAI012400', '110 Court, City H', 'Country A', 'Robert Doroftei', 'male', '8901230123', 'IJ5678901', 'FLI004');

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
  `pay_date` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`pnr_no`, `ph_no`, `cheque_no`, `card_no`, `paid_amt`, `pay_date`) VALUES
('PNR123456', '1234567890', 'CHQ001', NULL, '100', '2024-02-10 10:00:00'),
('PNR234567', '2345678901', 'CHQ002', NULL, '150', '2024-02-11 11:00:00'),
('PNR345678', '3456789012', 'CHQ003', NULL, '200', '2024-02-12 12:00:00'),
('PNR456789', '4567890123', NULL, 'CARD001', '250', '2024-02-13 13:00:00'),
('PNR567890', '5678901234', NULL, 'CARD002', '300', '2024-02-14 14:00:00'),
('PNR678901', '6789012345', 'CHQ004', NULL, '350', '2024-02-15 15:00:00'),
('PNR789012', '7890123456', 'CHQ005', NULL, '400', '2024-02-16 16:00:00'),
('PNR890123', '8901234567', NULL, 'CARD003', '450', '2024-02-17 17:00:00'),
('PNR901234', '9012345678', 'CHQ006', NULL, '500', '2024-02-18 18:00:00'),
('PNR012345', '0123456789', NULL, 'CARD004', '550', '2024-02-19 19:00:00'),
('PNR123456', '1234567890', 'CHQ007', NULL, '600', '2024-02-20 10:00:00'),
('PNR234567', '2345678901', 'CHQ008', NULL, '650', '2024-02-21 11:00:00'),
('PNR345678', '3456789012', 'CHQ009', NULL, '700', '2024-02-22 12:00:00'),
('PNR456789', '4567890123', NULL, 'CARD005', '750', '2024-02-23 13:00:00'),
('PNR567890', '5678901234', NULL, 'CARD006', '800', '2024-02-24 14:00:00'),
('PNR678901', '6789012345', 'CHQ010', NULL, '850', '2024-02-25 15:00:00'),
('PNR789012', '7890123456', 'CHQ011', NULL, '900', '2024-02-26 16:00:00'),
('PNR890123', '8901234567', NULL, 'CARD007', '950', '2024-02-27 17:00:00'),
('PNR901234', '9012345678', 'CHQ012', NULL, '1000', '2024-02-28 18:00:00'),
('PNR012345', '0123456789', NULL, 'CARD008', '1050', '2024-02-29 19:00:00');

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

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`pnr_no`, `ticket_id`, `f_code`, `jny_data`, `jny_time`, `src`, `dst`) VALUES
('PNR123456', 'TCKT001', 'FLI001', '2024-02-10', '10:00', 'City A', 'City B'),
('PNR234567', 'TCKT002', 'FLI002', '2024-02-11', '11:00', 'City B', 'City C'),
('PNR345678', 'TCKT003', 'FLI003', '2024-02-12', '12:00', 'City C', 'City D'),
('PNR456789', 'TCKT004', 'FLI004', '2024-02-13', '13:00', 'City D', 'City E'),
('PNR567890', 'TCKT005', 'FLI005', '2024-02-14', '14:00', 'City E', 'City F'),
('PNR678901', 'TCKT006', 'FLI006', '2024-02-15', '15:00', 'City F', 'City G'),
('PNR789012', 'TCKT007', 'FLI007', '2024-02-16', '16:00', 'City G', 'City H'),
('PNR890123', 'TCKT008', 'FLI008', '2024-02-17', '17:00', 'City H', 'City I'),
('PNR901234', 'TCKT009', 'FLI009', '2024-02-18', '18:00', 'City I', 'City J'),
('PNR012345', 'TCKT010', 'FLI010', '2024-02-19', '19:00', 'City J', 'City K'),
('PNR123456', 'TCKT011', 'FLI001', '2024-02-20', '10:00', 'City A', 'City B'),
('PNR234567', 'TCKT012', 'FLI002', '2024-02-21', '11:00', 'City B', 'City C'),
('PNR345678', 'TCKT013', 'FLI003', '2024-02-22', '12:00', 'City C', 'City D'),
('PNR456789', 'TCKT014', 'FLI004', '2024-02-23', '13:00', 'City D', 'City E'),
('PNR567890', 'TCKT015', 'FLI005', '2024-02-24', '14:00', 'City E', 'City F'),
('PNR678901', 'TCKT016', 'FLI006', '2024-02-25', '15:00', 'City F', 'City G'),
('PNR789012', 'TCKT017', 'FLI007', '2024-02-26', '16:00', 'City G', 'City H'),
('PNR890123', 'TCKT018', 'FLI008', '2024-02-27', '17:00', 'City H', 'City I'),
('PNR901234', 'TCKT019', 'FLI009', '2024-02-28', '18:00', 'City I', 'City J'),
('PNR012345', 'TCKT020', 'FLI010', '2024-02-29', '19:00', 'City J', 'City K');

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

--
-- Dumping data for table `sector`
--

INSERT INTO `sector` (`flight_code`, `capacity`, `class_code`, `class_name`) VALUES
('FLI001', '100', 'E', 'Economy'),
('FLI001', '30', 'B', 'Business'),
('FLI002', '120', 'E', 'Economy'),
('FLI002', '40', 'B', 'Business'),
('FLI003', '150', 'E', 'Economy'),
('FLI003', '50', 'B', 'Business'),
('FLI004', '110', 'E', 'Economy'),
('FLI004', '35', 'B', 'Business'),
('FLI005', '130', 'E', 'Economy'),
('FLI005', '45', 'B', 'Business'),
('FLI006', '140', 'E', 'Economy'),
('FLI006', '55', 'B', 'Business'),
('FLI007', '120', 'E', 'Economy'),
('FLI007', '30', 'B', 'Business'),
('FLI008', '100', 'E', 'Economy'),
('FLI008', '25', 'B', 'Business'),
('FLI009', '110', 'E', 'Economy'),
('FLI009', '40', 'B', 'Business'),
('FLI010', '120', 'E', 'Economy'),
('FLI010', '50', 'B', 'Business');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
