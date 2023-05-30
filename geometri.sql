-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2023 at 04:36 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `geomteri`
--

-- --------------------------------------------------------

--
-- Table structure for table `bola`
--

CREATE TABLE `bola` (
  `id` int(11) NOT NULL,
  `jar_jari` double NOT NULL,
  `luas` double NOT NULL,
  `volume` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bola`
--

INSERT INTO `bola` (`id`, `jar_jari`, `luas`, `volume`) VALUES
(1, 10, 1256.6370614359173, 4188.790204786391);

-- --------------------------------------------------------

--
-- Table structure for table `juring`
--

CREATE TABLE `juring` (
  `id` int(11) NOT NULL,
  `jari_jari` double NOT NULL,
  `luas` double NOT NULL,
  `volume` double NOT NULL,
  `tetha` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `juring`
--

INSERT INTO `juring` (`id`, `jari_jari`, `luas`, `volume`, `tetha`) VALUES
(1, 3, 2.356194490192345, 44.413219804902106, 0.5235987755982988);

-- --------------------------------------------------------

--
-- Table structure for table `keratan`
--

CREATE TABLE `keratan` (
  `id` int(11) NOT NULL,
  `jari_atas` double NOT NULL,
  `jari_bawah` double NOT NULL,
  `tinggi` double NOT NULL,
  `volume` double NOT NULL,
  `luas` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `keratan`
--

INSERT INTO `keratan` (`id`, `jari_atas`, `jari_bawah`, `tinggi`, `volume`, `luas`) VALUES
(1, 5, 10, 10, 2487.0941840919195, 628.3185307179587);

-- --------------------------------------------------------

--
-- Table structure for table `kerucut`
--

CREATE TABLE `kerucut` (
  `id` int(11) NOT NULL,
  `jari_jari` double NOT NULL,
  `tinggi` double NOT NULL,
  `luas_kerucut` double NOT NULL,
  `volume_kerucut` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kerucut`
--

INSERT INTO `kerucut` (`id`, `jari_jari`, `tinggi`, `luas_kerucut`, `volume_kerucut`) VALUES
(1, 4, 5, 130.72951471480383, 83.7758040957278);

-- --------------------------------------------------------

--
-- Table structure for table `lingkaran`
--

CREATE TABLE `lingkaran` (
  `id` int(20) NOT NULL,
  `jari_jari` double NOT NULL,
  `luas` double NOT NULL,
  `keliling` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lingkaran`
--

INSERT INTO `lingkaran` (`id`, `jari_jari`, `luas`, `keliling`) VALUES
(1, 10, 314.1592653589793, 62.83185307179586);

-- --------------------------------------------------------

--
-- Table structure for table `tabung`
--

CREATE TABLE `tabung` (
  `id` int(11) NOT NULL,
  `jari_jari` double NOT NULL,
  `tinggi` double NOT NULL,
  `luas_alas` double NOT NULL,
  `volume` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabung`
--

INSERT INTO `tabung` (`id`, `jari_jari`, `tinggi`, `luas_alas`, `volume`) VALUES
(1, 39, 47, 21073.803520280333, 224583.03402717353);

-- --------------------------------------------------------

--
-- Table structure for table `tembereng`
--

CREATE TABLE `tembereng` (
  `id` int(11) NOT NULL,
  `jari_jari` double NOT NULL,
  `jarak_bidang` double NOT NULL,
  `luas` double NOT NULL,
  `volume` double NOT NULL,
  `tetha` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tembereng`
--

INSERT INTO `tembereng` (`id`, `jari_jari`, `jarak_bidang`, `luas`, `volume`, `tetha`) VALUES
(1, 8, 2, 0.6796029442633653, 1.6047219682825475, 0.5053605102841571);

-- --------------------------------------------------------

--
-- Table structure for table `terpancung`
--

CREATE TABLE `terpancung` (
  `id` int(11) NOT NULL,
  `jari_besar` double NOT NULL,
  `jari_kecil` double NOT NULL,
  `tinggi` double NOT NULL,
  `luas_selimut` double NOT NULL,
  `volume` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `terpancung`
--

INSERT INTO `terpancung` (`id`, `jari_besar`, `jari_kecil`, `tinggi`, `luas_selimut`, `volume`) VALUES
(1, 10, 10, 11, 691.1503837897545, 3455.751918948772);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bola`
--
ALTER TABLE `bola`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `juring`
--
ALTER TABLE `juring`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `keratan`
--
ALTER TABLE `keratan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kerucut`
--
ALTER TABLE `kerucut`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lingkaran`
--
ALTER TABLE `lingkaran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tabung`
--
ALTER TABLE `tabung`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tembereng`
--
ALTER TABLE `tembereng`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `terpancung`
--
ALTER TABLE `terpancung`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bola`
--
ALTER TABLE `bola`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `juring`
--
ALTER TABLE `juring`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `keratan`
--
ALTER TABLE `keratan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `kerucut`
--
ALTER TABLE `kerucut`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `lingkaran`
--
ALTER TABLE `lingkaran`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tabung`
--
ALTER TABLE `tabung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tembereng`
--
ALTER TABLE `tembereng`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `terpancung`
--
ALTER TABLE `terpancung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
