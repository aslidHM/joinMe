CREATE TABLE Member(
  MemberId BIGINT AUTO_INCREMENT PRIMARY KEY,
  FullName VARCHAR(255) NOT NULL,
  Email VARCHAR(64) NOT NULL,
  Password VARCHAR(64) NOT NULL
);

CREATE TABLE Category(
  CategoryId BIGINT AUTO_INCREMENT PRIMARY KEY,
  CategoryName VARCHAR(64) NOT NULL
);

CREATE TABLE MemberActivity(
  MemberId BIGINT,
  ActivityId BIGINT,
  IsOwner BIT
);
CREATE TABLE Activity(
  ActivityId BIGINT AUTO_INCREMENT PRIMARY KEY,
  ActivityName VARCHAR(64) NOT NULL,
  memberId BIGINT,
  MaxMembers BIGINT,
  ActivityTime TIME NOT NULL,
  ActivityDate DATE NOT NULL,
  Location VARCHAR(64) NOT NULL,
  CategoryId BIGINT NOT NULL
);


ALTER TABLE MemberActivity ADD FOREIGN KEY (MemberId) REFERENCES Member(MemberId);
ALTER TABLE MemberActivity ADD FOREIGN KEY (ActivityId) REFERENCES Activity(ActivityId);
ALTER TABLE Activity ADD FOREIGN KEY (MemberId) REFERENCES Member(MemberId);
ALTER TABLE Activity ADD FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId);

