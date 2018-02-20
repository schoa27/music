create table am_albums
(
	am_id integer not null
		constraint pk_am_id
			primary key,
	am_collection boolean not null,
	am_songs integer,
	am_type char(10),
	am_title char(30),
	am_group integer,
	am_artist integer,
	am_image char(255),
	am_releaseyear char(4),
	am_genre char(20)
)
;

create table sg_songs
(
	sg_id integer not null
		constraint pk_sg_id
			primary key,
	sg_title char(50) not null,
	sg_duration char(10),
	sg_albums integer
		constraint fk_sg_albums
			references am_albums
)
;

alter table am_albums
	add constraint fk_am_songs
		foreign key (am_songs) references sg_songs
;

create table gp_groups
(
	gp_id integer not null
		constraint gp_group_pkey
			primary key,
	gp_name char(30),
	gp_albums integer
		constraint fk_gp_albums
			references am_albums,
	gp_image char
)
;

alter table am_albums
	add constraint fk_am_group
		foreign key (am_group) references gp_groups
;

create table at_artists
(
	at_id integer not null
		constraint at_atrists_pkey
			primary key,
	at_name char(50),
	at_albums integer
		constraint fk_at_albums
			references am_albums,
	at_image char
)
;

alter table am_albums
	add constraint fk_am_artist
		foreign key (am_artist) references at_artists
;

create table am_sg
(
	am_id integer,
	sg_id integer
)
;

create table at_sg
(
	at_id integer,
	sg_id integer
)
;

create table gp_sg
(
	gp_id integer,
	sg_id integer
)
;

create table gp_at
(
	gp_id integer,
	at_id integer
)
;

