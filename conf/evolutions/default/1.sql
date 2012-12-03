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

create table interview (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  start_date                varchar(255),
  start_hour                varchar(255),
  start_minute              varchar(255),
  category_id               bigint,
  status                    varchar(11),
  outcome                   varchar(4),
  constraint ck_interview_status check (status in ('NOT_STARTED','REJECTED','COMPLETE','RESCHEDULED','MISSED')),
  constraint ck_interview_outcome check (outcome in ('PASS','FAIL')),
  constraint pk_interview primary key (id))
;

create table team (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_team primary key (id))
;

create sequence category_seq;

create sequence interview_seq;

create sequence team_seq;

alter table interview add constraint fk_interview_category_1 foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_interview_category_1 on interview (category_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists category;

drop table if exists interview;

drop table if exists team;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists category_seq;

drop sequence if exists interview_seq;

drop sequence if exists team_seq;

