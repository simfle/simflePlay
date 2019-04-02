# --- !Ups   <<-- 업그레이드 시 실행되는 부분

CREATE TABLE conference (
  id long NOT NULL,
  name varchar(255) NOT NULL,
  attendees long NOT NULL,
  date DATE NOT NULL
);

CREATE TABLE session (
  id long NOT NULL,
  title varchar(255) NOT NULL,
  speaker_id long NOT NULL,
  conference_id long NOT NULL
);

# --- !Downs   <<- 다운그레이드 시 실행되는 부분
DROP TABLE IF EXISTS conference;
DROP TABLE IF EXISTS session;