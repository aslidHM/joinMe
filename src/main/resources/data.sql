INSERT INTO MEMBER (FULLNAME, EMAIL, PASSWORD) VALUES ('Fredrik Hagman', 'fredrik.hagman@hm.com', '123');
INSERT INTO MEMBER (FULLNAME, EMAIL, PASSWORD) VALUES ('Åsa Lindkvist', 'asa.lindkvist@hm.com', '123');
INSERT INTO MEMBER (FULLNAME, EMAIL, PASSWORD) VALUES ('Yusri Shakir', 'yusri.shakir@hm.com', '123');
INSERT INTO MEMBER (FULLNAME, EMAIL, PASSWORD) VALUES ('Robert Stigsson', 'robert.stigsson@hm.com', '123');

INSERT INTO CATEGORY (CATEGORYNAME) VALUES('lunch');
INSERT INTO CATEGORY (CATEGORYNAME) VALUES('exercise');
INSERT INTO CATEGORY (CATEGORYNAME) VALUES('run');
INSERT INTO CATEGORY (CATEGORYNAME) VALUES('fika');
INSERT INTO CATEGORY (CATEGORYNAME) VALUES('meet');


INSERT INTO ACTIVITY (CATEGORYID, ACTIVITYNAME, MAXMEMBERS, ACTIVITYDATE, LOCATION) VALUES
(3, 'Springa på lunchen', 8, {ts '2020-12-24 12:00:00.0'}, 'Utanför ingången');

INSERT INTO ACTIVITY (CATEGORYID, ACTIVITYNAME, MAXMEMBERS, ACTIVITYDATE , LOCATION) VALUES
(2, 'Promenera på lunchen', 4, {ts '2020-12-16 11:00:00.0'}, 'Möts utanför m28a');

INSERT INTO ACTIVITY (CATEGORYID, ACTIVITYNAME, MAXMEMBERS, ACTIVITYDATE , LOCATION) VALUES
(1, 'Äta på Nida', 4, {ts '2020-12-20 12:00:00.0'}, 'Möts vid spärrarna');

INSERT INTO ACTIVITY (CATEGORYID, ACTIVITYNAME, MAXMEMBERS, ACTIVITYDATE , LOCATION) VALUES
(1, 'Äta ute: Indiskt', 4, {ts '2020-12-15 11:00:00.0'}, 'Möts vid kajen');



INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES (1, 1, 1);
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES (2, 1, 0);
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES (3, 1, 0);
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES (1, 2, 0);
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES (1, 3, 0);
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES (2, 2, 1);
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES (3, 3, 1);
INSERT INTO MEMBERACTIVITY (MEMBERID, ACTIVITYID, ISOWNER) VALUES (4, 4, 1);