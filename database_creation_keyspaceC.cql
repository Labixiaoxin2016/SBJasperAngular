CREATE KEYSPACE IF NOT EXISTS keyspaceC WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;
USE keyspaceC;
DROP TABLE IF EXISTS keyspaceC.memobox;
CREATE TABLE IF NOT EXISTS keyspaceC.memobox (
    pkey1 text,
    pkey2 text,
    id timeuuid,
    name text,
    memo text,
    date timestamp,
    PRIMARY KEY ((pkey1, pkey2),id,name)
) WITH CLUSTERING ORDER BY (id DESC,name DESC);

CREATE INDEX keyspaceC_memobox_memo ON memobox ( memo );

INSERT INTO memobox (pkey1,pkey2,id,name,memo,date) VALUES ('a','b',now(),'tanaka','greet message1','2016-12-13');
INSERT INTO memobox (pkey1,pkey2,id,name,memo,date) VALUES ('a','b',now(),'yamamoto','greet message2','2016-12-13');

SELECT * FROM memobox where pkey1='a' and pkey2='b' ORDER BY id;

SELECT * FROM memobox where pkey1='a' and pkey2='b' ORDER BY id,name;

DROP TABLE IF EXISTS keyspaceC.person;
CREATE TABLE IF NOT EXISTS keyspaceC.person (
    id text,
    firstname text,
    lastname text,
    PRIMARY KEY (id)
) ;

CREATE INDEX keyspaceC_person_memo ON person ( firstname );
CREATE INDEX keyspaceC_person_memo ON person ( lastname );

INSERT INTO person (id,firstname,lastname) VALUES ('1','tanaka','tarou');
INSERT INTO person (id,firstname,lastname) VALUES ('2','tanaka','jirou');

SELECT * FROM person;

DROP TABLE IF EXISTS keyspaceC.city_country;
CREATE TABLE IF NOT EXISTS keyspaceC.city_country (
    pkey1 text,
    pkey2 text,
    name text,
    country_name text,
    population int,
    PRIMARY KEY ((pkey1, pkey2),name)
) WITH CLUSTERING ORDER BY (name DESC);

CREATE INDEX keyspaceC_city_country_name ON city_country ( country_name );
CREATE INDEX keyspaceC_city_country_population ON city_country ( population );

INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Los Angeles','USA',10000);
INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','New York','USA',20000);
INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Washington','USA',30000);
INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Moscow','RUSSIA',90000);
INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Novosibirsk','RUSSIA',10000);

SELECT * FROM city_country;

DROP TABLE IF EXISTS keyspaceC.city;
CREATE TABLE IF NOT EXISTS keyspaceC.city (
    pkey1 text,
    pkey2 text,
    name text,
    country_id text,
    population int,
    PRIMARY KEY ((pkey1, pkey2),name)
) WITH CLUSTERING ORDER BY (name DESC);

CREATE INDEX keyspaceC_city_country_id ON city ( country_id );
CREATE INDEX keyspaceC_city_population ON city ( population );

INSERT INTO city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','Los Angeles','1',10000);
INSERT INTO city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','New York','1',20000);
INSERT INTO city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','Washington','1',30000);
INSERT INTO city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','Moscow','2',90000);
INSERT INTO city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','Novosibirsk','2',10000);

SELECT * FROM city;


DROP TABLE IF EXISTS keyspaceC.country;
CREATE TABLE IF NOT EXISTS keyspaceC.country (
    pkey1 text,
    pkey2 text,
    id text,
    name text,
    PRIMARY KEY ((pkey1, pkey2),id)
) WITH CLUSTERING ORDER BY (id DESC);

CREATE INDEX keyspaceC_country_name ON country ( name );

INSERT INTO country (pkey1,pkey2,id,name) VALUES ('a','b','1','USA');
INSERT INTO country (pkey1,pkey2,id,name) VALUES ('a','b','2','RUSSIA');

SELECT * FROM country;

DROP TABLE IF EXISTS keyspaceC.cassandra_city;
CREATE TABLE IF NOT EXISTS keyspaceC.cassandra_city (
    pkey1 text,
    pkey2 text,
    name text,
    country_id text,
    population int,
    PRIMARY KEY ((pkey1, pkey2),name)
) WITH CLUSTERING ORDER BY (name DESC);

CREATE INDEX keyspaceC_cassandra_city_country_id ON cassandra_city ( country_id );
CREATE INDEX keyspaceC_cassandra_city_population ON cassandra_city ( population );

INSERT INTO cassandra_city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','Los Angeles','1',10000);
INSERT INTO cassandra_city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','New York','1',20000);
INSERT INTO cassandra_city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','Washington','1',30000);
INSERT INTO cassandra_city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','Moscow','2',90000);
INSERT INTO cassandra_city (pkey1,pkey2,name,country_id,population) VALUES ('a','b','Novosibirsk','2',10000);

SELECT * FROM cassandra_city;

DROP TABLE IF EXISTS keyspaceC.cassandra_country;
CREATE TABLE IF NOT EXISTS keyspaceC.cassandra_country (
    pkey1 text,
    pkey2 text,
    id text,
    name text,
    PRIMARY KEY ((pkey1, pkey2),id)
) WITH CLUSTERING ORDER BY (id DESC);

CREATE INDEX keyspaceC_cassandra_country_name ON cassandra_country ( name );

INSERT INTO cassandra_country (pkey1,pkey2,id,name) VALUES ('a','b','1','USA');
INSERT INTO cassandra_country (pkey1,pkey2,id,name) VALUES ('a','b','2','RUSSIA');

SELECT * FROM cassandra_country;

DROP TABLE IF EXISTS keyspaceC.cassandra_city_country;
CREATE TABLE IF NOT EXISTS keyspaceC.cassandra_city_country (
    pkey1 text,
    pkey2 text,
    name text,
    country_name text,
    population int,
    PRIMARY KEY ((pkey1, pkey2),name)
) WITH CLUSTERING ORDER BY (name DESC);

CREATE INDEX keyspaceC_cassandra_city_country_name ON cassandra_city_country ( country_name );
CREATE INDEX keyspaceC_cassandra_city_country_population ON cassandra_city_country ( population );

INSERT INTO cassandra_city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Los Angeles','USA',10000);
INSERT INTO cassandra_city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','New York','USA',20000);
INSERT INTO cassandra_city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Washington','USA',30000);
INSERT INTO cassandra_city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Moscow','RUSSIA',90000);
INSERT INTO cassandra_city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Novosibirsk','RUSSIA',10000);

SELECT * FROM cassandra_city_country;
