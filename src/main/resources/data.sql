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

CREATE INDEX IF NOT EXISTS account_number_idx ON trx_data(account_number);

CREATE INDEX IF NOT EXISTS description_idx ON trx_data(description);

CREATE INDEX IF NOT EXISTS customer_id_idx ON trx_data(customer_id);