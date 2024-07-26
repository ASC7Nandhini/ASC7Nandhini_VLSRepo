create DATABASE LoginPage;
use LoginPage;
create table credentials(
    username VARCHAR(250),
    password VARCHAR(250)
);
SELECT * from credentials;
INSERT INTO credentials VALUES('admin','password');