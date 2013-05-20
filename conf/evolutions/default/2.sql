# Sample data init

# --- !Ups

-- Create teams
insert into team(id, name, description) values (team_seq.nextval, 'B/E', 'The Back-end team');
insert into team(id, name, description) values (team_seq.nextval, 'F/E', 'The Front-end team');
insert into team(id, name, description) values (team_seq.nextval, 'QA', 'The Quality Assurance team');

-- Create categories
insert into category(id, name, duration_in_minutes, credits) values (category_seq.nextval, 'I Round', 30, 10);
insert into category(id, name, duration_in_minutes, credits) values (category_seq.nextval, 'II Round', 90, 30);

-- Create User
insert into user (id, external_identity, email, name, locale, picture) values (-1,'101491561765242970579','rajivrnair@gmail.com','Rajiv Nair','en_GB','https://lh6.googleusercontent.com/-gFZtm3h0sy4/AAAAAAAAAAI/AAAAAAAAD5s/-Lj2Sm0rF8k/photo.jpg');
insert into user (id, external_identity, email, name, locale, picture) values (-2,'101866479603323534663','srininara@gmail.com','Srinivas Narayanan','en','https://lh5.googleusercontent.com/-nUWeFiZbJdQ/AAAAAAAAAAI/AAAAAAAABNo/BsdlLR5h57M/photo.jpg');

# --- !Downs
delete * from team;
delete * from category;
delete * from task;
delete * from user;
