CREATE TABLE IF NOT EXISTS employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(80) NOT NULL,
  last_name  VARCHAR(80) NOT NULL,
  email      VARCHAR(120) NOT NULL UNIQUE,
  salary     DECIMAL(12,2) NOT NULL DEFAULT 0
);

INSERT INTO employees(first_name,last_name,email,salary) VALUES
('Ada','Lovelace','ada@demo.com',75000.00),
('Alan','Turing','alan@demo.com',82000.00);
