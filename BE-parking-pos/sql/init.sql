-- parking_db.`member` definition

CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plate_number` varchar(50) NOT NULL,
  `expired_date` timestamp NULL DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- parking_db.tickets definition

CREATE TABLE `tickets` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plate_number` varchar(50) NOT NULL,
  `check_in_time` timestamp NOT NULL,
  `check_out_time` timestamp NULL DEFAULT NULL,
  `total_price` int(11) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  `is_member` tinyint(1) DEFAULT 0,
  `type` varchar(10) DEFAULT NULL,
  `id_member` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_plate_status` (`plate_number`,`status`),
  KEY `idx_status` (`status`),
  KEY `fk_ticket_member` (`id_member`),
  CONSTRAINT `fk_ticket_member` FOREIGN KEY (`id_member`) REFERENCES `member` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO parking_db.`member` (plate_number,expired_date,name,created_at,updated_at, type) VALUES
	 ("B 1111 AAA","2025-12-31 23:59:59.000","Anto",CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), "Mobil"),
	 ("B 2222 BBB","2026-12-31 23:59:59.000","Beta",CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), "Motor"),
	 ("B 3333 CCC","2025-10-31 23:59:59.000","Cico",CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), "Motor"),
	 ("B 4444 DDD","2026-01-31 23:59:59.000","Dede",CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), "Mobil"),
	 ("B 5555 EEE","2025-07-31 23:59:59.000","Eko",CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP(), "Mobil");