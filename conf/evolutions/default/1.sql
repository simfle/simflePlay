# --- !Ups   <<-- 업그레이드 시 실행되는 부분
CREATE TABLE USER (
  id IDENTITY NOT NULL PRIMARY KEY,
  first_name varchar(255),
  last_name varchar(255),
  email varchar(255)
);

CREATE TABLE session (
  id long NOT NULL,
  title varchar(255) NOT NULL,
  speaker_id long NOT NULL,
  conference_id long NOT NULL
);

# --- !Downs   <<- 다운그레이드 시 실행되는 부분
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS session