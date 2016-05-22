-- phpMyAdmin SQL Dump
-- version 4.6.0
-- http://www.phpmyadmin.net
--
-- Host: db
-- Generation Time: Apr 19, 2016 at 09:54 AM
-- Server version: 10.1.13-MariaDB-1~jessie
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `assessments`
--

CREATE TABLE `assessments` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `mark` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `semester_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assessments`
--

INSERT INTO `assessments` (`id`, `name`, `mark`, `type_id`, `semester_id`) VALUES
(1, 'Finish Assignment 1 in 1 day', 10, 1, 2),
(2, 'Critical Analysis of the Flaws of Java', 60, 1, 2),
(3, 'DHMO Detection Research', 100, 2, 1),
(4, 'Differences between Java and JavaScript', 100, 3, 2),
(5, 'Java Final Exam', 100, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `name`) VALUES
(1, 'Computer Science'),
(2, 'Chemical Engineering');

-- --------------------------------------------------------

--
-- Table structure for table `semesters`
--

CREATE TABLE `semesters` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `semesters`
--

INSERT INTO `semesters` (`id`, `name`) VALUES
(1, '2015 Semester 2'),
(2, '2016 Semester 1');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `identification` varchar(255) NOT NULL,
  `course_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `name`, `identification`, `course_id`) VALUES
(1, 'John Doe', '111111', 1),
(2, 'Katie Doe', '111112', 1),
(3, 'Jackie Chan', '111113', 1),
(4, 'Kung Fu Panda', '111114', 1),
(5, 'Kevin Wong Ong Tek', '111115', 1),
(6, 'Belial Sim', '111116', 1),
(7, 'Christine Chan', '111117', 2),
(8, 'Nur Fatimah', '111118', 2),
(9, 'Billy Jeans', '111119', 2),
(10, 'Susan Wee', '111120', 2);

-- --------------------------------------------------------

--
-- Table structure for table `student_assessments`
--

CREATE TABLE `student_assessments` (
  `id` int(11) NOT NULL,
  `mark` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `assessment_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_assessments`
--

INSERT INTO `student_assessments` (`id`, `mark`, `student_id`, `assessment_id`) VALUES
(1, 0, 1, 1),
(2, 50, 1, 2),
(3, 100, 8, 4),
(4, 20, 7, 3);

-- --------------------------------------------------------

--
-- Table structure for table `student_units`
--

CREATE TABLE `student_units` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  `semester_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_units`
--

INSERT INTO `student_units` (`id`, `student_id`, `unit_id`, `semester_id`) VALUES
(1, 1, 1, 2),
(2, 1, 4, 2),
(3, 2, 3, 2),
(4, 7, 6, 1),
(5, 8, 10, 2),
(6, 4, 2, 1),
(7, 7, 7, 2),
(8, 2, 2, 2),
(9, 4, 4, 1),
(10, 4, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `types`
--

CREATE TABLE `types` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `types`
--

INSERT INTO `types` (`id`, `name`) VALUES
(1, 'Assignment'),
(2, 'Presentation'),
(3, 'Exam');

-- --------------------------------------------------------

--
-- Table structure for table `units`
--

CREATE TABLE `units` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `units`
--

INSERT INTO `units` (`id`, `name`, `code`) VALUES
(1, 'Introduction to Java', 'JAVA0001'),
(2, 'Intermediate Java', 'JAVA0002'),
(3, 'Java for Professionals', 'JAVA0002'),
(4, 'Porting Java to Rust', 'USEBRAIN0000'),
(5, 'Professional Issues in Chemical Engineering', 'BOMB0001'),
(6, 'Applied Theory of Dangerous Chemicals', 'DHMO0001'),
(7, 'Engineering Chemical Appliances in Java', 'JAVA0007'),
(8, 'Chemical Engineering Java Coffee', 'DHMO0002'),
(9, 'JavaScript is not Java', 'USEBRAIN0001'),
(10, 'Java is not JavaScript', 'USEBRAIN0002');

-- --------------------------------------------------------

--
-- Table structure for table `unit_assessments`
--

CREATE TABLE `unit_assessments` (
  `id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  `assessment_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unit_assessments`
--

INSERT INTO `unit_assessments` (`id`, `unit_id`, `assessment_id`) VALUES
(1, 1, 1),
(2, 4, 2),
(3, 6, 3),
(4, 10, 4),
(5, 3, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assessments`
--
ALTER TABLE `assessments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `semesters`
--
ALTER TABLE `semesters`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_assessments`
--
ALTER TABLE `student_assessments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_units`
--
ALTER TABLE `student_units`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `units`
--
ALTER TABLE `units`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unit_assessments`
--
ALTER TABLE `unit_assessments`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assessments`
--
ALTER TABLE `assessments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `semesters`
--
ALTER TABLE `semesters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `student_assessments`
--
ALTER TABLE `student_assessments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `student_units`
--
ALTER TABLE `student_units`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `types`
--
ALTER TABLE `types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `units`
--
ALTER TABLE `units`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `unit_assessments`
--
ALTER TABLE `unit_assessments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
