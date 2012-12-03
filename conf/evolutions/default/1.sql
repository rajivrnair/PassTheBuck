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

create table credit (
  id                        bigint not null,
  value                     integer,
  source                    integer,
  source_id                 bigint,
  awarded_date              date,
  awarded_time              time,
  constraint ck_credit_source check (source in (0,1)),
  constraint pk_credit primary key (id))
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

create table user (
  id                        bigint not null,
  external_identity         varchar(255),
  email                     varchar(255),
  name                      varchar(255),
  locale                    varchar(20),
  picture                   varchar(255),
  constraint pk_user primary key (id))
;

create sequence category_seq;

create sequence credit_seq;

create sequence interview_seq;

create sequence team_seq;

create sequence user_seq;

alter table interview add constraint fk_interview_category_1 foreign key (category_id) references category (id) on delete restrict on update restrict;
create index ix_interview_category_1 on interview (category_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists category;

drop table if exists credit;

drop table if exists interview;

drop table if exists team;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists category_seq;

drop sequence if exists credit_seq;

drop sequence if exists interview_seq;

drop sequence if exists team_seq;

drop sequence if exists user_seq;

