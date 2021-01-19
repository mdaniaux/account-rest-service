DROP TABLE IF EXISTS book;

--accountNumber": "abc", "transactionTs": "2020-01-03T01:02:03.8Z", "type": "DEPOSIT", "amount": 89.1

CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  accountNumber VARCHAR(10) NOT NULL,
  transactionTs TIMESTAMP WITH TIME ZONE NOT NULL,
  deposit DECIMAL(20,2) DEFAULT NULL,
  withdraw DECIMAL(20,2) DEFAULT NULL,
  balance DECIMAL(20,2) DEFAULT NULL
);

INSERT INTO book (accountNumber, transactionTs, deposit, withdraw, balance) VALUES
  ('abc', '2020-01-03T01:02:03.000+08:00', 10000,0, 10000),
  ('abc', '2020-01-04T02:03:04.000+08:00', 0, 200, 9800),
  ('abc', '2020-01-04T02:06:04.000+08:00', 0, 300, 9500),
  ('abc', '2020-01-10T02:03:04.000+08:00', 0, 100.99, 9399.01),
  ('abc', '2020-02-04T06:03:04.000+08:00', 150.99, 0, 9550),
  ('abc', '2020-02-04T04:03:04.000+08:00', 0, 1200, 8600),
  ('abc', '2020-03-04T09:03:04.000+08:00', 0, 230, 8370),
  ('abc', '2020-04-03T07:02:03.000+08:00', 0, 770, 7600),
  ('abc', '2020-12-18T09:03:04.000+08:00', 0, 400, 7200),
  ('abc', '2020-12-20T07:02:03.000+08:00', 400, 0, 7600),
  ('abc', '2021-01-15T09:03:04.000+08:00', 0, 250, 7350),
  ('abc', '2021-01-15T07:02:03.000+08:00', 150, 0, 7500),
  ('abc', '2021-01-16T08:02:03.000+08:00', 0, 350, 7150),
  ('abc', '2021-01-16T09:04:03.000+08:00', 130, 0, 7280),
  ('abc', '2021-01-17T18:02:03.000+08:00', 0, 140, 7140),
  ('abc', '2021-01-17T19:04:03.000+08:00', 120, 0, 7260);
