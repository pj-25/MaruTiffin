-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 21, 2021 at 05:13 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `marutiffin`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `latitude` decimal(10,0) NOT NULL,
  `longitude` decimal(10,0) NOT NULL,
  `locality` varchar(50) NOT NULL,
  `city` varchar(25) NOT NULL,
  `district` varchar(25) NOT NULL,
  `state` varchar(25) NOT NULL,
  `country` varchar(25) NOT NULL,
  `address_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` varchar(30) NOT NULL,
  `role` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cart_id` int(11) NOT NULL,
  `customer_id` varchar(30) NOT NULL,
  `total_amount` float NOT NULL,
  `cook_instruction` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cart_item`
--

CREATE TABLE `cart_item` (
  `cart_item_id` int(11) NOT NULL,
  `food_item_id` int(11) NOT NULL,
  `quantity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cart_item_list`
--

CREATE TABLE `cart_item_list` (
  `cart_id` int(11) NOT NULL,
  `cart_item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` varchar(30) NOT NULL,
  `pending_cart_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `delivery_person`
--

CREATE TABLE `delivery_person` (
  `delivery_person_id` varchar(30) NOT NULL,
  `address_id` int(11) NOT NULL,
  `status` char(1) NOT NULL,
  `current_order_id` int(11) DEFAULT NULL,
  `weekly_payout` float NOT NULL DEFAULT 0,
  `order_count` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `food_item`
--

CREATE TABLE `food_item` (
  `food_item_id` int(11) NOT NULL,
  `menu_item_id` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `quantity` varchar(10) NOT NULL,
  `price` float NOT NULL,
  `status` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `avg_prep_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `kitchen`
--

CREATE TABLE `kitchen` (
  `kitchen_id` int(11) NOT NULL,
  `kitchen_name` varchar(30) NOT NULL,
  `description` varchar(100) NOT NULL,
  `type` char(1) NOT NULL,
  `opening_time` time NOT NULL,
  `closing_time` time NOT NULL,
  `status` char(1) NOT NULL,
  `address_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `kitchen_holder`
--

CREATE TABLE `kitchen_holder` (
  `kitchen_holder_id` varchar(30) NOT NULL,
  `kitchen_id` int(11) NOT NULL,
  `fssai_reg_number` char(14) NOT NULL,
  `food_license_valid_till` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `kitchen_review`
--

CREATE TABLE `kitchen_review` (
  `review_id` int(11) NOT NULL,
  `review` varchar(100) NOT NULL,
  `kitchen_id` int(11) NOT NULL,
  `customer_id` varchar(30) NOT NULL,
  `ratings` int(2) NOT NULL,
  `reviewed_on` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL,
  `kitchen_id` int(11) NOT NULL,
  `menu_type` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `menu_item`
--

CREATE TABLE `menu_item` (
  `menu_item_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `item_type` int(11) NOT NULL,
  `description` varchar(100) NOT NULL,
  `status` char(1) NOT NULL,
  `total_cost` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `offer`
--

CREATE TABLE `offer` (
  `offer_code` varchar(10) NOT NULL,
  `description` varchar(100) NOT NULL,
  `offer_type` int(2) NOT NULL,
  `valid_till` date NOT NULL,
  `discount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_info`
--

CREATE TABLE `order_info` (
  `order_id` int(11) NOT NULL,
  `delivery_person_id` varchar(30) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `ordered_on` datetime NOT NULL DEFAULT current_timestamp(),
  `delivery_address_id` int(11) NOT NULL,
  `esti_prep_time` time NOT NULL,
  `esti_delivery_time` time NOT NULL,
  `status` char(1) NOT NULL,
  `feedback` varchar(50) DEFAULT NULL,
  `delivered_on` datetime NOT NULL,
  `offer_code` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_issue`
--

CREATE TABLE `order_issue` (
  `order_issue_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `applied_on` time NOT NULL DEFAULT current_timestamp(),
  `description` varchar(500) NOT NULL,
  `status` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `payment_method` int(2) NOT NULL,
  `transaction_id` char(12) NOT NULL,
  `order_id` int(11) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `saved_address`
--

CREATE TABLE `saved_address` (
  `address_id` int(11) NOT NULL,
  `customer_id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `scheduled_order`
--

CREATE TABLE `scheduled_order` (
  `scheduled_order_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `customer_id` varchar(30) NOT NULL,
  `status` char(1) NOT NULL,
  `scheduled_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  `gender` char(1) NOT NULL,
  `birthdate` date NOT NULL,
  `registered_on` date NOT NULL DEFAULT current_timestamp(),
  `phone_number` char(10) NOT NULL,
  `email_id` varchar(40) NOT NULL,
  `user_type` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD PRIMARY KEY (`cart_item_id`),
  ADD KEY `food_item_id` (`food_item_id`);

--
-- Indexes for table `cart_item_list`
--
ALTER TABLE `cart_item_list`
  ADD PRIMARY KEY (`cart_id`,`cart_item_id`),
  ADD KEY `cart_item_id` (`cart_item_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `delivery_person`
--
ALTER TABLE `delivery_person`
  ADD PRIMARY KEY (`delivery_person_id`),
  ADD KEY `address_id` (`address_id`);

--
-- Indexes for table `food_item`
--
ALTER TABLE `food_item`
  ADD PRIMARY KEY (`food_item_id`),
  ADD KEY `menu_item_id` (`menu_item_id`);

--
-- Indexes for table `kitchen`
--
ALTER TABLE `kitchen`
  ADD PRIMARY KEY (`kitchen_id`),
  ADD KEY `address_id` (`address_id`);

--
-- Indexes for table `kitchen_holder`
--
ALTER TABLE `kitchen_holder`
  ADD PRIMARY KEY (`kitchen_holder_id`);

--
-- Indexes for table `kitchen_review`
--
ALTER TABLE `kitchen_review`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `kitchen_id` (`kitchen_id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`menu_id`),
  ADD KEY `kitchen_id` (`kitchen_id`);

--
-- Indexes for table `menu_item`
--
ALTER TABLE `menu_item`
  ADD PRIMARY KEY (`menu_item_id`),
  ADD KEY `menu_id` (`menu_id`);

--
-- Indexes for table `offer`
--
ALTER TABLE `offer`
  ADD PRIMARY KEY (`offer_code`);

--
-- Indexes for table `order_info`
--
ALTER TABLE `order_info`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `cart_id` (`cart_id`),
  ADD KEY `offer_code` (`offer_code`),
  ADD KEY `delivery_address_id` (`delivery_address_id`);

--
-- Indexes for table `order_issue`
--
ALTER TABLE `order_issue`
  ADD PRIMARY KEY (`order_issue_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `saved_address`
--
ALTER TABLE `saved_address`
  ADD PRIMARY KEY (`address_id`,`customer_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `scheduled_order`
--
ALTER TABLE `scheduled_order`
  ADD PRIMARY KEY (`scheduled_order_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cart_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cart_item`
--
ALTER TABLE `cart_item`
  MODIFY `cart_item_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `food_item`
--
ALTER TABLE `food_item`
  MODIFY `food_item_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kitchen`
--
ALTER TABLE `kitchen`
  MODIFY `kitchen_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kitchen_review`
--
ALTER TABLE `kitchen_review`
  MODIFY `review_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `menu_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menu_item`
--
ALTER TABLE `menu_item`
  MODIFY `menu_item_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_info`
--
ALTER TABLE `order_info`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_issue`
--
ALTER TABLE `order_issue`
  MODIFY `order_issue_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `scheduled_order`
--
ALTER TABLE `scheduled_order`
  MODIFY `scheduled_order_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- Constraints for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD CONSTRAINT `cart_item_ibfk_1` FOREIGN KEY (`food_item_id`) REFERENCES `food_item` (`food_item_id`);

--
-- Constraints for table `cart_item_list`
--
ALTER TABLE `cart_item_list`
  ADD CONSTRAINT `cart_item_list_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`),
  ADD CONSTRAINT `cart_item_list_ibfk_2` FOREIGN KEY (`cart_item_id`) REFERENCES `cart_item` (`cart_item_id`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `delivery_person`
--
ALTER TABLE `delivery_person`
  ADD CONSTRAINT `delivery_person_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  ADD CONSTRAINT `delivery_person_ibfk_2` FOREIGN KEY (`delivery_person_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `food_item`
--
ALTER TABLE `food_item`
  ADD CONSTRAINT `food_item_ibfk_1` FOREIGN KEY (`menu_item_id`) REFERENCES `menu_item` (`menu_item_id`);

--
-- Constraints for table `kitchen`
--
ALTER TABLE `kitchen`
  ADD CONSTRAINT `kitchen_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`);

--
-- Constraints for table `kitchen_holder`
--
ALTER TABLE `kitchen_holder`
  ADD CONSTRAINT `kitchen_holder_ibfk_1` FOREIGN KEY (`kitchen_holder_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `kitchen_review`
--
ALTER TABLE `kitchen_review`
  ADD CONSTRAINT `kitchen_review_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  ADD CONSTRAINT `kitchen_review_ibfk_2` FOREIGN KEY (`kitchen_id`) REFERENCES `kitchen` (`kitchen_id`);

--
-- Constraints for table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`kitchen_id`) REFERENCES `kitchen` (`kitchen_id`);

--
-- Constraints for table `menu_item`
--
ALTER TABLE `menu_item`
  ADD CONSTRAINT `menu_item_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`);

--
-- Constraints for table `order_info`
--
ALTER TABLE `order_info`
  ADD CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`),
  ADD CONSTRAINT `order_info_ibfk_2` FOREIGN KEY (`offer_code`) REFERENCES `offer` (`offer_code`),
  ADD CONSTRAINT `order_info_ibfk_3` FOREIGN KEY (`delivery_address_id`) REFERENCES `saved_address` (`address_id`);

--
-- Constraints for table `order_issue`
--
ALTER TABLE `order_issue`
  ADD CONSTRAINT `order_issue_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`order_id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`order_id`);

--
-- Constraints for table `saved_address`
--
ALTER TABLE `saved_address`
  ADD CONSTRAINT `saved_address_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  ADD CONSTRAINT `saved_address_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- Constraints for table `scheduled_order`
--
ALTER TABLE `scheduled_order`
  ADD CONSTRAINT `scheduled_order_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_info` (`order_id`),
  ADD CONSTRAINT `scheduled_order_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
