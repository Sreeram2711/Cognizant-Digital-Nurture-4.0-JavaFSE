CREATE TABLE Accounts (account_id INT PRIMARY KEY,account_type VARCHAR(20), balance DECIMAL(12,2)); 
CREATE TABLE Employees (emp_id INT PRIMARY KEY,name VARCHAR(100),department VARCHAR(50),salary DECIMAL(10,2)); 
INSERT INTO Accounts VALUES (101, 'savings', 10000.00), (102, 'current', 5000.00), (103, 'savings', 20000.00), (202, 'savings', 3000.00); 
INSERT INTO Employees VALUES (1, 'sreeram', 'Finance', 60000.00), (2, 'hari', 'IT', 50000.00), (3, 'gogulan', 'Finance', 54000.00); 
DELIMITER $$

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'savings';
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_name VARCHAR(50),
    IN bonus_percent DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET salary = salary + (salary * (bonus_percent / 100))
    WHERE department = dept_name;
END$$

DELIMITER ;



DELIMITER $$

CREATE PROCEDURE TransferFunds(
    IN from_account_id INT,
    IN to_account_id INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE from_balance DECIMAL(10,2);

    
    SELECT balance INTO from_balance
    FROM accounts
    WHERE account_id = from_account_id;

    IF from_balance >= amount THEN
        
        UPDATE accounts
        SET balance = balance - amount
        WHERE account_id = from_account_id;

      
        UPDATE accounts
        SET balance = balance + amount
        WHERE account_id = to_account_id;

        
        SELECT CONCAT('₹', amount, ' transferred from Account ', from_account_id, ' to Account ', to_account_id) AS message;

    ELSE
        
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient balance for transfer.';
    END IF;
END$$

DELIMITER ;
SELECT account_id, balance FROM Accounts WHERE account_id IN (101, 103);
UPDATE Accounts
SET balance = 5000.00
WHERE account_id = 101;
CALL TransferFunds(101, 103, 2000.00);



