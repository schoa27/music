-- Create Tables, foreignkeys and set owner

-- Table: music.am_sg
CREATE TABLE music.am_sg
(
    am_id integer,
    sg_id integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-- Table: music.at_sg
CREATE TABLE music.at_sg
(
    at_id integer,
    sg_id integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-- Table: music.gp_at
CREATE TABLE music.gp_at
(
    gp_id integer,
    at_id integer,
    at_startdate character(4) COLLATE pg_catalog."default",
    at_enddate character(4) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-- Table: music.gp_sg;
CREATE TABLE music.gp_sg
(
    gp_id integer,
    sg_id integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;


-- Table: music.am_albums
CREATE TABLE music.am_albums
(
    am_id integer NOT NULL,
    am_collection boolean NOT NULL,
    am_songs integer,
    am_type character(10) COLLATE pg_catalog."default",
    am_title character(30) COLLATE pg_catalog."default",
    am_group integer,
    am_artist integer,
    am_image character(255) COLLATE pg_catalog."default",
    am_releaseyear character(4) COLLATE pg_catalog."default",
    am_genre character(20) COLLATE pg_catalog."default",
    CONSTRAINT pk_am_id PRIMARY KEY (am_id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

-- Table: music.sg_songs
CREATE TABLE music.sg_songs
(
    sg_id integer NOT NULL,
    sg_title character(50) COLLATE pg_catalog."default" NOT NULL,
    sg_duration character(10) COLLATE pg_catalog."default",
    sg_albums integer,
    sg_disc integer NOT NULL,
    CONSTRAINT pk_sg_id PRIMARY KEY (sg_id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

-- Table: music.gp_groups
CREATE TABLE music.gp_groups
(
    gp_id integer NOT NULL,
    gp_name character(50) COLLATE pg_catalog."default",
    gp_albums integer,
    gp_image character varying COLLATE pg_catalog."default",
    CONSTRAINT gp_group_pkey PRIMARY KEY (gp_id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

-- Table: music.at_artists
CREATE TABLE music.at_artists
(
    at_id integer NOT NULL,
    at_name character(50) COLLATE pg_catalog."default",
    at_albums integer,
    at_image character varying COLLATE pg_catalog."default",
    CONSTRAINT at_atrists_pkey PRIMARY KEY (at_id)
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

-- add foreignkeys

-- foreignkeys on music.am_albums
ALTER TABLE music.am_albums
    ADD CONSTRAINT fk_am_artist FOREIGN KEY (am_artist)
    REFERENCES music.at_artists (at_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    ADD CONSTRAINT fk_am_group FOREIGN KEY (am_group)
    REFERENCES music.gp_groups (gp_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    ADD CONSTRAINT fk_am_songs FOREIGN KEY (am_songs)
    REFERENCES music.sg_songs (sg_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;

-- foreignkeys music.sg_songs
ALTER TABLE music.sg_songs
    ADD CONSTRAINT fk_sg_albums FOREIGN KEY (sg_albums)
    REFERENCES music.am_albums (am_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;

-- foreignkeys music.gp_groups
ALTER TABLE music.gp_groups
    ADD CONSTRAINT fk_gp_albums FOREIGN KEY (gp_albums)
    REFERENCES music.am_albums (am_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;

-- foreignkeys music.at_artists
ALTER TABLE music.at_artists
    ADD CONSTRAINT fk_at_albums FOREIGN KEY (at_albums)
    REFERENCES music.am_albums (am_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;

-- set owner

-- set owner to music.am_albums
ALTER TABLE music.am_albums
    OWNER to music;

-- set owner to music.sg_songs
ALTER TABLE music.sg_songs
    OWNER to music;

-- set owner to music.gp_groups
ALTER TABLE music.gp_groups
    OWNER to music;

-- set owner to music.at_artists
ALTER TABLE music.at_artists
    OWNER to music;

-- set owner music.am_sg
ALTER TABLE music.am_sg
    OWNER to music;

-- set owner music.gp_sg
ALTER TABLE music.gp_sg
    OWNER to music;

-- set owner music.at_sg
ALTER TABLE music.at_sg
    OWNER to music;

-- set owner music.gp_at
ALTER TABLE music.gp_at
    OWNER to music;
