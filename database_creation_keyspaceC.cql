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

CREATE INDEX keyspaceC_city_country_memo ON city_country ( country_name );
CREATE INDEX keyspaceC_city_country_memo ON city_country ( population );

INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Los Angeles','USA',10000);
INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','New York','USA',20000);
INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Washington','USA',30000);
INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Moscow','RUSSIA',90000);
INSERT INTO city_country (pkey1,pkey2,name,country_name,population) VALUES ('a','b','Novosibirsk','RUSSIA',10000);

SELECT * FROM city_country;
