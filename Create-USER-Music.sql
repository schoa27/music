-- Creat User: music

CREATE USER music WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION;

-- Set password User
ALTER USER music
	PASSWORD 'xxxxxx';