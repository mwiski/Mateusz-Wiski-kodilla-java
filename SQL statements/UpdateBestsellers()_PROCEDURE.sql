ALTER TABLE BOOKS ADD BESTSELLER BOOLEAN;

DROP FUNCTION IF EXISTS isBestSeller;

DELIMITER $$

CREATE FUNCTION isBestSeller(avgbookrents DECIMAL(5,2)) RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE bestseller BOOLEAN;
    IF avgbookrents > 2 THEN
        SET bestseller = true;
    ELSE
        SET bestseller = false;
    END IF;
    RETURN bestseller;
END $$

DELIMITER ;

DROP PROCEDURE IF EXISTS UpdateBestsellers;

DELIMITER $$

CREATE PROCEDURE UpdateBestsellers()
BEGIN
    DECLARE BOOKRENTS, DAYS, THIS_BOOK_ID INT;
    DECLARE RENTSPERMONTH DECIMAL(5,2);
    DECLARE FINISHED INT DEFAULT 0;
    DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM BOOKS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;
    OPEN ALL_BOOKS;
    WHILE (FINISHED = 0) DO
            FETCH ALL_BOOKS INTO THIS_BOOK_ID;
            IF (FINISHED = 0) THEN
                SELECT COUNT(*) FROM RENTS
                    WHERE BOOK_ID = THIS_BOOK_ID
                    INTO BOOKRENTS;
                SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1 FROM RENTS
                    WHERE BOOK_ID = THIS_BOOK_ID
                    INTO DAYS;
                IF DAYS < 30 THEN
                    SET RENTSPERMONTH = BOOKRENTS;
                ELSE
                    SET RENTSPERMONTH = BOOKRENTS / DAYS * 30;
                END IF;
                UPDATE BOOKS SET BESTSELLER = BestSeller(RENTSPERMONTH)
                    WHERE BOOK_ID = THIS_BOOK_ID;
                COMMIT;
            END IF;
        END WHILE;
    CLOSE ALL_BOOKS;
END $$

DELIMITER ;

CALL UpdateBestsellers();