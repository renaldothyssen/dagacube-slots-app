DROP TABLE IF EXISTS TBL_PLAYERS;
DROP TABLE IF EXISTS TBL_PLAYERS_LOG;
CREATE TABLE TBL_PLAYERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) DEFAULT NULL,
  last_name VARCHAR(250) DEFAULT NULL,
  user_name VARCHAR(50) DEFAULT NOT NULL,
  current_balance DECIMAL(19,2) DEFAULT 0,
  create_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
  modified_dt DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE TBL_PLAYERS_LOG (
   id INT AUTO_INCREMENT  PRIMARY KEY,
  `transaction_id` varchar(500) DEFAULT NULL,
  `player_id` int(11) DEFAULT NULL,
  `transaction_type` varchar(45) DEFAULT NULL,
  `api_request_message` mediumtext,
  `api_response_message` mediumtext,
  `http_method` varchar(15) DEFAULT NULL,
  `create_dt` timestamp DEFAULT CURRENT_TIMESTAMP,
  `modified_dt` datetime DEFAULT CURRENT_TIMESTAMP
);