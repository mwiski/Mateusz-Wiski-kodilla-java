DROP FUNCTION IF EXISTS findReadersByID;

DELIMITER $$

CREATE FUNCTION findReadersByID(readerID INT) RETURNS VARCHAR(255) DETERMINISTIC
BEGIN
    DECLARE foundReaders VARCHAR(255) DEFAULT 'There is no reader with given ID in database';
    IF readerID <= 0 THEN
        RETURN 'Wrong ID';
    END IF;
    SELECT concat(FIRSTNAME, ' ', LASTNAME, ', PESEL ', PESELID) INTO foundReaders FROM readers WHERE READER_ID = readerID;
    RETURN foundReaders;
END $$

DELIMITER ;

SELECT findReadersByID(20) AS Readers;