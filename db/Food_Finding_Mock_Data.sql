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
	(1,"cookies", "2021-11-18 15:30:00", "Freshman Welcome!", "ECCE 188", 1, 1),
	(2,"pizza", "2021-11-18 16:30:09", "Bold center event", "BOLD Center" ,2, 2),
    (3,"bagel", "2021-11-17 12:30:00", "this is a food description", NULL, 3, 3);
select * from event;

