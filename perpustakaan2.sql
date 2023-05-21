-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 20 Bulan Mei 2023 pada 18.45
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `nis` varchar(80) NOT NULL,
  `nama_siswa` varchar(100) NOT NULL,
  `jenis_kelamin` varchar(80) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `no_hp` varchar(56) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`nis`, `nama_siswa`, `jenis_kelamin`, `tanggal_lahir`, `tempat_lahir`, `no_hp`, `alamat`) VALUES
('001', 'Bella', 'Perempuan', '2016-05-13', 'Jakarta', '002121', 'Jakarta'),
('002', 'Putra', 'Laki - Laki', '2016-08-15', 'Aceh', '0121312312', 'Jakarta'),
('003', 'Jefri Kumala', 'Laki - Laki', '2016-05-11', 'Subang', '00121212', 'Jakarta'),
('004', 'Bivo Septiansyah', 'Laki - Laki', '2017-11-14', 'Sumatra', '12131231', 'Jakarta'),
('005', 'Rina', 'Laki - Laki', '2016-11-14', 'Bekasi', '68876', 'Jakarta');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `kode_buku` varchar(60) NOT NULL,
  `judul_buku` varchar(200) NOT NULL,
  `tanggal_beli` date NOT NULL,
  `pengarang` varchar(100) NOT NULL,
  `tahun_terbit` varchar(16) NOT NULL,
  `jumlah_buku` varchar(20) NOT NULL,
  `penerbit` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`kode_buku`, `judul_buku`, `tanggal_beli`, `pengarang`, `tahun_terbit`, `jumlah_buku`, `penerbit`) VALUES
('BK0001', 'Pengetahuan Alam', '2023-05-12', 'Abdul Vascues', '2019', '2', 'Bintang Medisa'),
('BK0002', 'Teknik Informatika', '2023-05-05', 'Agung Hernandes', '2018', '3', 'Gramedia'),
('BK0003', 'Ilmu Pertaniam', '2023-05-11', 'Agung Hernandes', '2019', '3', 'Gramedia'),
('BK0004', 'Ilmu Komputer', '2023-05-17', 'Jefri Septiansyah', '2014', '3', 'Bintang Media'),
('BK0005', 'Bahasa Indonesia', '2023-05-17', 'Abdul Vascues', '2019', '2', 'Gramedia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengembalian`
--

CREATE TABLE `pengembalian` (
  `kode_pengembalian` varchar(80) NOT NULL,
  `nis` varchar(20) NOT NULL,
  `nama_siswa` varchar(20) NOT NULL,
  `nama_pustakawan` varchar(80) NOT NULL,
  `judul_buku` varchar(80) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `jumlah_telat` int(10) NOT NULL,
  `denda` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pengembalian`
--

INSERT INTO `pengembalian` (`kode_pengembalian`, `nis`, `nama_siswa`, `nama_pustakawan`, `judul_buku`, `tanggal_pinjam`, `tanggal_kembali`, `jumlah_telat`, `denda`) VALUES
('PB0001', '001', 'Bella', 'Ridwan', 'Pengetahuan Alam', '2023-05-20', '2023-06-02', 6, '6000'),
('PB0002', '002', 'Putra', 'Riki', 'Ilmu Pertaniam', '2023-05-17', '2023-05-30', 6, '6000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pinjam`
--

CREATE TABLE `pinjam` (
  `kode_pinjam` varchar(80) NOT NULL,
  `nis` varchar(80) NOT NULL,
  `nama_siswa` varchar(200) NOT NULL,
  `kd_buku` varchar(60) NOT NULL,
  `judul_buku` varchar(200) NOT NULL,
  `id_pustakawan` varchar(80) NOT NULL,
  `nama_pustakawan` varchar(200) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `jumlah_pinjam` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pinjam`
--

INSERT INTO `pinjam` (`kode_pinjam`, `nis`, `nama_siswa`, `kd_buku`, `judul_buku`, `id_pustakawan`, `nama_pustakawan`, `tanggal_pinjam`, `tanggal_kembali`, `jumlah_pinjam`) VALUES
('PB0001', '001', 'Bella', 'BK0001', 'Pengetahuan Alam', 'PW00001', 'Ridwan', '2023-05-20', '2023-05-27', 1),
('PB0002', '002', 'Putra', 'BK0003', 'Ilmu Pertaniam', 'PW00003', 'Riki', '2023-05-17', '2023-05-30', 1),
('PB0003', '004', 'Bivo Septiansyah', 'BK0005', 'Bahasa Indonesia', 'PW00003', 'Riki', '2023-05-17', '2023-05-18', 1),
('PB0004', '002', 'Putra', 'BK0004', 'Ilmu Komputer', 'PW00003', 'Riki', '2023-05-20', '2023-05-27', 1),
('PB0005', '001', 'Bella', 'BK0005', 'Bahasa Indonesia', 'PW00003', 'Riki', '2023-05-20', '2023-05-12', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pustakawan`
--

CREATE TABLE `pustakawan` (
  `id_pustakawan` varchar(80) NOT NULL,
  `no_ktp` varchar(80) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `jenis_kelamin` varchar(60) NOT NULL,
  `agama` varchar(60) NOT NULL,
  `no_hp` varchar(60) NOT NULL,
  `alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pustakawan`
--

INSERT INTO `pustakawan` (`id_pustakawan`, `no_ktp`, `nama`, `jenis_kelamin`, `agama`, `no_hp`, `alamat`) VALUES
('PW00001', '123123123', 'Ridwan', 'Laki - Laki', 'Islam', '02131231230', 'Jakarta'),
('PW00002', '00013231', 'Wahyu', 'Laki - Laki', 'Islam', '02112312', 'Depok'),
('PW00003', '01923132', 'Riki', 'Laki - Laki', 'Islam', '000121212', 'Bekasi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` varchar(80) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `nama` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama`) VALUES
('001Admin', 'Admin', 'admin123', 'Admin'),
('001Pustakawan', 'Pustakawan', 'pustakawan2123', 'Pustakawan'),
('002Admin', 'Admin', 'admin2123', 'Admin'),
('002Pustakawan', 'Pustakawan', 'pustakawan123', 'Pustakawan'),
('003Anggota', 'Anggota', 'anggota123', 'Anggota');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`nis`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kode_buku`);

--
-- Indeks untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`kode_pengembalian`);

--
-- Indeks untuk tabel `pinjam`
--
ALTER TABLE `pinjam`
  ADD PRIMARY KEY (`kode_pinjam`);

--
-- Indeks untuk tabel `pustakawan`
--
ALTER TABLE `pustakawan`
  ADD PRIMARY KEY (`id_pustakawan`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
