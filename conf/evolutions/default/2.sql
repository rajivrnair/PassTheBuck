# Sample data init

# --- !Ups

-- Create teams
insert into team(id, name, description) values (1, 'B/E', 'The Back-end team');
insert into team(id, name, description) values (2, 'F/E', 'The Front-end team');
insert into team(id, name, description) values (3, 'QA', 'The Quality Assurance team');

-- Create categories
insert into category(id, name, duration_in_minutes, credits) values (1, 'I Round', 30, 10);
insert into category(id, name, duration_in_minutes, credits) values (2, 'II Round', 90, 30);

-- Create tasks
insert into task(id, name, description, start_date, start_hour,start_minute, status) 
  values (10000, 'Mister Purushan (9945668710)', '1st round f2f', '2012-10-30', '11', '00', 0);

insert into task(id, name, description, start_date, start_hour,start_minute, status) 
  values (20000, 'Miss Pombalai (9922558887)', '1st round f2f', '2012-10-30', '11', '00', 0);


# --- !Downs
delete * from team;
delete * from category;
delete * from task;  