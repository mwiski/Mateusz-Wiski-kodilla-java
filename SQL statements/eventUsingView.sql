CREATE TABLE STATS (
                       STAT_ID INT(11) AUTO_INCREMENT PRIMARY KEY,
                       STAT_DATE DATETIME NOT NULL,
                       STAT VARCHAR(20) NOT NULL,
                       VALUE INT(11) NOT NULL
);

CREATE VIEW BESTSELLERS_COUNT AS
SELECT COUNT(*) AS BESTSELLERS_COUNT FROM BOOKS WHERE BESTSELLER = 1;


DROP EVENT IF EXISTS UPDATE_BESTSELLERS;

DELIMITER $$

CREATE EVENT UPDATE_BESTSELLERS
    ON SCHEDULE EVERY 1 MINUTE
    DO
    BEGIN
        CALL UpdateBestsellers();
        INSERT INTO STATS(STAT_DATE, STAT, VALUE) VALUES(NOW(), "BESTSELLER", (SELECT BESTSELLERS_COUNT FROM BESTSELLERS_COUNT));
    END $$

DELIMITER ;
