DROP TABLE IF EXISTS trx_data;

CREATE TABLE trx_data (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  account_number VARCHAR(10) NOT NULL,
  trx_amount DECIMAL(20,2) NOT NULL,
  description VARCHAR(150) NOT NULL,
  trx_date DATE NOT NULL,
  trx_time TIME NOT NULL,
  customer_id INT
);
