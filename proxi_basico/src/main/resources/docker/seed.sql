USE empleados_dam;

-- Empleados
INSERT INTO employees (first_name, last_name, email, salary) VALUES
('Ana',  'López',     'ana@empresa.com',  45000.00),
('Luis', 'Martínez',  'luis@empresa.com', 52000.00),
('Mara', 'García',    'mara@empresa.com', 48000.00);

-- Clientes
INSERT INTO customers (name, email) VALUES
('Acme Corp',  'contact@acme.com'),
('Globex S.A.', 'info@globex.com'),
('Initech',    'hello@initech.com');

-- Ventas
INSERT INTO sales (customer_id, employee_id, total) VALUES
(1, 1, 199.99),
(2, 2, 550.00),
(3, 3, 1299.95);
