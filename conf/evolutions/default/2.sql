# Sample data init

# --- !Ups

-- Create teams
insert into team(id, name, description) values (team_seq.nextval, 'B/E', 'The Back-end team');
insert into team(id, name, description) values (team_seq.nextval, 'F/E', 'The Front-end team');
insert into team(id, name, description) values (team_seq.nextval, 'QA', 'The Quality Assurance team');

-- Create categories
insert into category(id, name, duration_in_minutes, credits) values (category_seq.nextval, 'I Round', 30, 10);
insert into category(id, name, duration_in_minutes, credits) values (category_seq.nextval, 'II Round', 90, 30);

# --- !Downs
delete * from team;
delete * from category;
delete * from task;  