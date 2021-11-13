USE `mydb` ;


describe dietaryrestriction;
describe location;

#distary restriction table
INSERT INTO dietaryrestriction 
VALUES
	(0,1,1,0,1,0,0,0,1),
	(1,1,0,0,0,0,1,0,2),
    (0,0,0,0,0,1,0,0,3);
select * from dietaryrestriction;
    
#drop table dietaryrestriction;
#DELETE FROM dietaryrestriction where restrictionID = 4;

#location table
INSERT INTO location 
VALUES
	(1,"Engineering Center",20.5,30.2,0),
	(2,"Math Building",19.3,30.2,0),
    (3,"Outside of Math Building",20,30,1);
select * from location;


#event table
describe event;
INSERT INTO event 
VALUES
	(1,"cookies", "2021-11-18 15:30:00", "Freshman Welcome!", "ECCE 188", 1, 1),
	(2,"pizza", "2021-11-18 16:30:09", "Bold center event", "BOLD Center" ,2, 2),
    (3,"bagel", "2021-11-17 12:30:00", "this is a food description", NULL, 3, 3);
select * from event;

