# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  id                        bigint not null,
  name                      varchar(255),
  duration_in_minutes       integer,
  credits                   integer,
  constraint pk_category primary key (id))
;

create table task (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  start_date                varchar(255),
  start_hour                varchar(255),
  start_minute              varchar(255),
  scheduled_start           timestamp,
  category_id               bigint,
  status                    varchar(11),
  constraint ck_task_status check (status in ('NOT_STARTED','REJECTED','COMPLETE','RESCHEDULED','MISSED')),
  constraint pk_task primary key (id))
;

create table team (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_team primary key (id))
;

create sequence category_seq;

create sequence task_seq;

create sequence team_seq;

alter table task add constraint fk_task_category_1 foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_task_category_1 on task (category_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists category;

drop table if exists task;

drop table if exists team;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists category_seq;

drop sequence if exists task_seq;

drop sequence if exists team_seq;

