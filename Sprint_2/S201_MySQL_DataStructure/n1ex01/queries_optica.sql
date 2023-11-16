--  1 Llista el total de factures d'un client/a en un període determinat.
SELECT COUNT(invoice_id) AS 'Total number of invoices from client', customer.first_name AS 'First Name', customer.last_name AS 'Last Name' FROM invoice JOIN customer ON invoice.fk_cust_id = customer.cust_id WHERE cust_id = 1 AND date BETWEEN '2023-10-01' AND '2023-12-01';

-- 2 Llista els diferents models d'ulleres que ha venut un empleat/da durant un any.
SELECT lenses.lenses_id AS 'Lenses models', invoice.date, invoice.fk_employee_id, employee.first_name, employee.last_name FROM lenses JOIN invoice ON lenses.lenses_id = invoice.fk_lenses_id JOIN employee ON invoice.fk_employee_id = employee.employee_id WHERE employee_id = 2 AND YEAR(invoice.date) = 2023;

-- 3 Llista els diferents proveïdors que han subministrat ulleres venudes amb èxit per l'òptica.
SELECT supplier.supplier_id, supplier.first_name, supplier.last_name, lenses.fk_brand_id AS 'Lenses Brand Id', invoice.fk_lenses_id AS 'Sold Lenses Id' FROM supplier JOIN lenses ON supplier.supplier_id = lenses.fk_supplier_id JOIN invoice ON lenses.lenses_id = invoice.fk_lenses_id ORDER BY invoice.fk_lenses_id DESC;