# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  start_date                date,
  start_time                time,
  status                    integer,
  constraint ck_task_status check (status in (0,1,2,3,4)),
  constraint pk_task primary key (id))
;

create table team (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_team primary key (id))
;

create sequence task_seq;

create sequence team_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists task;

drop table if exists team;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists task_seq;

drop sequence if exists team_seq;

