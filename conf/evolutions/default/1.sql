# --- !Ups   <<-- 업그레이드 시 실행되는 부분
CREATE TABLE USER (
  id IDENTITY NOT NULL PRIMARY KEY,
  first_name varchar(255),
  last_name varchar(255),
  email varchar(255)
);

CREATE TABLE SERVER (
  id IDENTITY NOT NULL PRIMARY KEY,
  name varchar(255),
  public_host varchar(255),
  private_host varchar(255),
  public_port INT,
  private_port INT
);

CREATE TABLE SERVERSTATUS (
  id IDENTITY NOT NULL PRIMARY KEY,
  amount_used BIGINT,
  max_amount BIGINT,
  interval_second BIGINT,
  server_id BIGINT
);


# --- !Downs   <<- 다운그레이드 시 실행되는 부분
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS SERVER;
DROP TABLE IF EXISTS SERVERSTATUS;
