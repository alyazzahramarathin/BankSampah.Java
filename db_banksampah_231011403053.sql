-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2026 at 11:20 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_banksampah`
--

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

CREATE TABLE `nasabah` (
  `id_nasabah` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `no_hp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`id_nasabah`, `nama`, `alamat`, `no_hp`) VALUES
(101, 'Alya', 'Priyang', '089531422685'),
(102, 'Sahla', 'Griya Asri', '0812345678'),
(103, 'sall', 'Paku Jaya', '12345690'),
(104, 'marr', 'Tangerang Selatan', '37282919'),
(105, 'jijah', 'bintaro', '1111111111'),
(106, 'Siska', 'Pal Merah', '22222222'),
(107, 'Nadiya', 'Jelupang', '012345678'),
(108, 'Muhammad', 'Serpong', '089898989898'),
(109, 'Andifka Andreansyah Maulana', 'Lampung', '012356789906'),
(403053, 'Alya Azzahra Marathin', 'Pondok Jagung, Serpong Utara', '231011403053');

-- --------------------------------------------------------

--
-- Table structure for table `sampah`
--

CREATE TABLE `sampah` (
  `id_sampah` int(11) NOT NULL,
  `nama_sampah` varchar(100) NOT NULL,
  `harga` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sampah`
--

INSERT INTO `sampah` (`id_sampah`, `nama_sampah`, `harga`) VALUES
(201, 'Plastik', 5000.00),
(202, 'E.Rice Cooker', 50000.00),
(203, 'kaleng', 1000.00),
(204, 'Kertas', 10000.00),
(205, 'E.TV', 100000.00),
(206, 'Baju Bekas', 50000.00);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `id_nasabah` int(11) NOT NULL,
  `id_sampah` int(11) NOT NULL,
  `berat` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal`, `id_nasabah`, `id_sampah`, `berat`, `total`) VALUES
(1, '2026-06-21', 103, 201, 5.00, 25000.00),
(3, '2026-06-22', 101, 201, 19.00, 95000.00),
(4, '2026-06-23', 101, 203, 25.00, 25000.00),
(5, '2026-06-23', 104, 204, 4.00, 40000.00),
(6, '2026-06-23', 105, 205, 2.00, 200000.00),
(7, '2026-06-23', 106, 205, 6.00, 600000.00),
(8, '2026-06-24', 403053, 206, 2.00, 100000.00),
(9, '2026-06-24', 107, 202, 5.00, 250000.00),
(10, '2026-06-24', 109, 201, 10.00, 50000.00);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`) VALUES
(1, 'admin', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`id_nasabah`);

--
-- Indexes for table `sampah`
--
ALTER TABLE `sampah`
  ADD PRIMARY KEY (`id_sampah`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `fk_nasabah` (`id_nasabah`),
  ADD KEY `fk_sampah` (`id_sampah`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `id_nasabah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=403054;

--
-- AUTO_INCREMENT for table `sampah`
--
ALTER TABLE `sampah`
  MODIFY `id_sampah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=207;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_nasabah` FOREIGN KEY (`id_nasabah`) REFERENCES `nasabah` (`id_nasabah`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sampah` FOREIGN KEY (`id_sampah`) REFERENCES `sampah` (`id_sampah`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
