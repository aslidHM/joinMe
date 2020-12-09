INSERT INTO MEMBER (FULLNAME, EMAIL, PASSWORD) VALUES ('Fredrik Hagman', 'fredrik.hagman@hm.com', '123');
INSERT INTO MEMBER (FULLNAME, EMAIL, PASSWORD) VALUES ('Åsa Lindkvist', 'asa.lindkvist@hm.com', '123');
INSERT INTO MEMBER (FULLNAME, EMAIL, PASSWORD) VALUES ('Yusri Shakir', 'yusri.shakir@hm.com', '123');
INSERT INTO MEMBER (FULLNAME, EMAIL, PASSWORD) VALUES ('Robert Stigsson', 'robert.stigsson@hm.com', '123');

INSERT INTO CATEGORY (CATEGORYNAME) VALUES('Träna');
INSERT INTO CATEGORY (CATEGORYNAME) VALUES('Äta');


INSERT INTO ACTIVITY (MEMBERID, CATEGORYID, ACTIVITYNAME, MAXMEMBERS, DATE, TIME, LOCATION) VALUES
((SELECT MEMBERID FROM MEMBER WHERE FULLNAME ='Fredrik Hagman'), (SELECT CATEGORYID FROM CATEGORY WHERE CATEGORYID = 1), 'Springa på lunchen', '8', '2020-12-24', '12:00', 'Möts utanför stora ingången')

INSERT INTO ACTIVITY (MEMBERID, CATEGORYID, ACTIVITYNAME, MAXMEMBERS, DATE, TIME, LOCATION) VALUES
((SELECT MEMBERID FROM MEMBER WHERE FULLNAME ='Åsa Lindkvist'), (SELECT CATEGORYID FROM CATEGORY WHERE CATEGORYID = 1), 'Promenera på lunchen', '4', '2020-12-13', '11:00', 'Möts utanför m28a')

INSERT INTO ACTIVITY (MEMBERID, CATEGORYID, ACTIVITYNAME, MAXMEMBERS, DATE, TIME, LOCATION) VALUES
((SELECT MEMBERID FROM MEMBER WHERE FULLNAME ='Yusri Shakir'), (SELECT CATEGORYID FROM CATEGORY WHERE CATEGORYID = 2), 'Äta på Nida', '4', '2020-12-12', '12:00', 'Möts vid spärrarna')

INSERT INTO ACTIVITY (MEMBERID, CATEGORYID, ACTIVITYNAME, MAXMEMBERS, DATE, TIME, LOCATION) VALUES
((SELECT MEMBERID FROM MEMBER WHERE FULLNAME ='Robert Stigsson'), (SELECT CATEGORYID FROM CATEGORY WHERE CATEGORYID = 2), 'Äta ute: Indiskt', '4', '2020-12-11', '11:00', 'Möts vid kajen')


INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES ((SELECT MEMBERID FROM MEMBER WHERE FULLNAME ='Fredrik Hagman'), (SELECT ACTIVITYID FROM ACTIVITY WHERE ACTIVITYID = '1'), '1')
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES ((SELECT MEMBERID FROM MEMBER WHERE FULLNAME ='Åsa Lindkvist'), (SELECT ACTIVITYID FROM ACTIVITY WHERE ACTIVITYID = '2'), '1')
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES ((SELECT MEMBERID FROM MEMBER WHERE FULLNAME ='Yusri Shakir'), (SELECT ACTIVITYID FROM ACTIVITY WHERE ACTIVITYID = '3'), '1')
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES ((SELECT MEMBERID FROM MEMBER WHERE FULLNAME ='Robert Stigsson'), (SELECT ACTIVITYID FROM ACTIVITY WHERE ACTIVITYID = '4'), '1')