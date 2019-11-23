DROP TABLE IF EXISTS group_user;
DROP TABLE IF EXISTS module_promo;

CREATE TABLE module_promo(
	id INT AUTO_INCREMENT PRIMARY KEY, 
	module_name VARCHAR(100) NOT NULL
) ENGINE INNODB;

CREATE TABLE group_user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	module_order INT NOT NULL,
	module_promo_id INT NOT NULL,
	group_id INT,
	
	CONSTRAINT fk_module_promo
    FOREIGN KEY (module_promo_id) 
    REFERENCES module_promo(id)
) ENGINE INNODB;

INSERT INTO module_promo (module_name) 
VALUES('PromoCard'), ('CategoryCard'), ('FlashSaleCard'), 
('HistoryCard'), ('NewsCard');

INSERT INTO group_user(module_order, module_promo_id, group_id)
VALUES (1, 1, 1), (2, 2, 1), (3, 3, 1), (4, 4, 1), (5, 5, 1),
(1, 1, 2), (2, 5, 2), (3, 3, 2), (4, 2, 2), (5, 5, 2),
(1, 1, 3), (2, 3, 3), (3, 2, 3), (4, 5, 3), (5, 4, 3)