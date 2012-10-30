# Sample data init

# --- !Ups

-- Create teams
insert into team(id, name, description) values (1, 'B/E', 'The Back-end team');
insert into team(id, name, description) values (2, 'F/E', 'The Front-end team');
insert into team(id, name, description) values (3, 'QA', 'The Quality Assurance team');

-- Create categories
insert into category(id, name, duration_in_minutes, credits) values (1, 'I Round', 30, 10);
insert into category(id, name, duration_in_minutes, credits) values (2, 'II Round', 90, 30);

# --- !Downs
delete * from team;
delete * from category;
delete * from task;  