-- Create Sequence Objects and set owner

-- Sequence for album id
CREATE SEQUENCE music.seq_am
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE music.seq_am
    OWNER TO music;

-- Sequence for artist id
CREATE SEQUENCE music.seq_at
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE music.seq_at
    OWNER TO music;	
	
-- Sequence for group id
CREATE SEQUENCE music.seq_gp
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE music.seq_gp
    OWNER TO music;

-- Sequence for song id
CREATE SEQUENCE music.seq_sg
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE music.seq_sg
    OWNER TO music;
