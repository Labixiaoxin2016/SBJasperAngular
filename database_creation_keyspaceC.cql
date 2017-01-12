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