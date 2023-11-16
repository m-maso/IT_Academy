
-- Llista quants productes de categoria 'Begudes' s'han venut en una determinada localitat.
SELECT quantity AS 'Number of drinks sold in London'
FROM invoice_has_product
JOIN product ON invoice_has_product.product_product_id = product.product_id
JOIN invoice ON invoice_has_product.invoice_invoice_id = invoice.invoice_id
JOIN pizzeria ON invoice.fk_pizzeria_id = pizzeria.pizzeria_id
JOIN town_city ON pizzeria.fk_town_city_id = town_city.town_city_id
WHERE product_category = "drink"
AND town_city.town_city_id = 1;

-- Llista quantes comandes ha efectuat un determinat empleat/da.
SELECT COUNT(invoice.invoice_id) AS 'Number of orders taken by', employee.employee_id, employee.first_name, employee.last_name
FROM invoice
JOIN pizzeria ON invoice.fk_pizzeria_id = pizzeria.pizzeria_id
JOIN employee ON pizzeria.pizzeria_id = employee.fk_pizzeria_id
WHERE employee_id = 4;