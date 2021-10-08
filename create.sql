create sequence hibernate_sequence start with 1 increment by 1
create table activity (id bigint not null, activity_time timestamp, created_at timestamp, description varchar(255), user_bucket_id bigint not null, primary key (id))
create table user (id bigint not null, email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table user_bucket (id bigint not null, active boolean, cost integer, name varchar(255), size integer, user_id bigint not null, primary key (id))
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table activity add constraint FKnn72yg7x0l941vua69s6f9cq8 foreign key (user_bucket_id) references user_bucket
alter table user_bucket add constraint FKa683hles4n8797hvcfhcj0c9t foreign key (user_id) references user
create sequence hibernate_sequence start with 1 increment by 1
create table activity (id bigint not null, activity_time timestamp, created_at timestamp, description varchar(255), user_bucket_id bigint not null, primary key (id))
create table user (id bigint not null, email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table user_bucket (id bigint not null, active boolean, cost integer, name varchar(255), size integer, user_id bigint not null, primary key (id))
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table activity add constraint FKnn72yg7x0l941vua69s6f9cq8 foreign key (user_bucket_id) references user_bucket
alter table user_bucket add constraint FKa683hles4n8797hvcfhcj0c9t foreign key (user_id) references user
create sequence hibernate_sequence start with 1 increment by 1
create table activity (id bigint not null, activity_time timestamp, created_at timestamp, description varchar(255), user_bucket_id bigint not null, primary key (id))
create table user (id bigint not null, email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table user_bucket (id bigint not null, active boolean, cost integer, name varchar(255), size integer, user_id bigint not null, primary key (id))
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table activity add constraint FKnn72yg7x0l941vua69s6f9cq8 foreign key (user_bucket_id) references user_bucket
alter table user_bucket add constraint FKa683hles4n8797hvcfhcj0c9t foreign key (user_id) references user
create sequence hibernate_sequence start with 1 increment by 1
create table activity (id bigint not null, activity_time timestamp, created_at timestamp, description varchar(255), user_bucket_id bigint not null, primary key (id))
create table user (id bigint not null, email varchar(255), name varchar(255), password varchar(255), primary key (id))
create table user_bucket (id bigint not null, active boolean, cost integer, name varchar(255), size integer, user_id bigint not null, primary key (id))
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table activity add constraint FKnn72yg7x0l941vua69s6f9cq8 foreign key (user_bucket_id) references user_bucket
alter table user_bucket add constraint FKa683hles4n8797hvcfhcj0c9t foreign key (user_id) references user
select * from user_bucket
