Create DATABASE VLSDB;
use VLSDB;
CREATE Table course(
    courseId INT PRIMARY KEY,
    courseName VARCHAR(250),
    authorName VARCHAR(250),
    durationInHours BIGINT,
    availability BOOLEAN
);
SELECT * FROM course;
drop table course;