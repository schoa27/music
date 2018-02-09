create table "AM_ALBUM"
(
	"AM_ID" integer not null
		constraint "PK_AM_ID"
		primary key,
	"AM_TITLE" char(30) not null,
	"AM_RELEASE" date,
	"AM_TYPE" char(10) not null,
	"AM_COLLECTION" boolean not null,
	"AM_SONG" integer not null,
	"AM_ARTIST" integer,
	"AM_GROUP" integer
)
;

create table "SG_SONGS"
(
	"SG_ID" integer not null
		constraint "PK_SG_ID"
		primary key,
	"SG_TITLE" char(50) not null,
	"SG_DURATION" char(10),
	"SG_ALBUM" integer
		constraint "FK_SG_AM"
		references "AM_ALBUM",
	"SG_ARTIST" integer,
	"SG_GROUP" integer
)
;

alter table "AM_ALBUM"
	add constraint "FK_AM_SG"
foreign key ("AM_SONG") references "SG_SONGS"
;

create table "AT_ARTISTS"
(
	"AT_ID" integer not null
		constraint "PK_AT_ID"
		primary key,
	"AT_NAME" char(30) not null,
	"AT_ALBUM" integer
		constraint "FK_AT_AM"
		references "AM_ALBUM",
	"AT_SONG" integer
		constraint "FK_AT_SG"
		references "SG_SONGS",
	"AT_GROUP" integer
)
;

alter table "AM_ALBUM"
	add constraint "FK_AM_AT"
foreign key ("AM_ARTIST") references "AT_ARTISTS"
;

alter table "SG_SONGS"
	add constraint "FK_SG_AT"
foreign key ("SG_ARTIST") references "AT_ARTISTS"
;

create table "GP_GROUPS"
(
	"GP_ID" integer not null
		constraint "PK_GP_ID"
		primary key,
	"GP_NAME" char not null,
	"GP_ALBUM" integer
		constraint "FK_GP_AM"
		references "AM_ALBUM",
	"GP_SONG" integer
		constraint "FK_GP_SG"
		references "SG_SONGS",
	"GP_ARTIST" integer not null
		constraint "FK_GP_AT"
		references "AT_ARTISTS"
)
;

alter table "AM_ALBUM"
	add constraint "FK_AM_GP"
foreign key ("AM_GROUP") references "GP_GROUPS"
;

alter table "SG_SONGS"
	add constraint "FK_SG_GP"
foreign key ("SG_GROUP") references "GP_GROUPS"
;

alter table "AT_ARTISTS"
	add constraint "FK_AT_GP"
foreign key ("AT_GROUP") references "GP_GROUPS"
;

