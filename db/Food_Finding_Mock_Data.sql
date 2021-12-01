USE `FreeFoodFinderDB` ;


describe dietary_restriction;
describe location;

-- dietary restriction table
INSERT INTO dietary_restriction
VALUES
	(0,1,1,0,1,0,0,0,1),
	(1,1,0,0,0,0,1,0,2),
    (0,0,0,0,0,1,0,0,3);
select * from dietary_restriction;
    
-- drop table dietary_restriction;
-- DELETE FROM dietary_restriction where restrictionID = 4;


-- event table
describe event;
INSERT INTO event 
VALUES
	(DEFAULT,"Free Cookies!", "2021-11-18 15:30:00", "Freshman Welcome!", "ECCE 188", 0, 1, 101),
	(DEFAULT,"Leftover Pizza + Soda", "2021-11-18 16:30:09", "Bold center event", "BOLD Center", 0 ,2, 76),
    (DEFAULT,"bagel", "2021-11-17 12:30:00", "this is a food description", NULL, 0, 3, 105);
select * from event;

