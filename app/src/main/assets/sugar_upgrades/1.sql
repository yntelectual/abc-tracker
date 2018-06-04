CREATE TABLE CHILD (
 id integer PRIMARY KEY,
 name text NOT NULL,
 surname text,
 age integer
);

CREATE TABLE ABCMASTERDATA (
 id integer PRIMARY KEY,
 name text NOT NULL,
 description text,
 type text
);

CREATE TABLE ABCFORM (
 id integer PRIMARY KEY,
 childId integer NOT NULL,
 abcId integer NOT NULL
);

CREATE TABLE ABCFORMDATA (
 id integer PRIMARY KEY,
 childId integer NOT NULL,
 aId integer NOT NULL,
 bId integer NOT NULL,
 cId integer NOT NULL,
 creationDate text,
 comment String
);

CREATE TABLE BEHAVIORFORM (
 id integer PRIMARY KEY,
 childId integer NOT NULL,
 behaviorId integer NOT NULL
);

CREATE TABLE BEHAVIORFORMDATA (
 id integer PRIMARY KEY,
 childId integer NOT NULL,
 behaviorId integer NOT NULL,
 startDate text,
 endDate text,
 duration real
);

CREATE TABLE BEHAVIORSTRATEGY (
 id integer PRIMARY KEY,
 childId integer NOT NULL,
 behaviorId integer NOT NULL,
 creationDate text,
 type text,
 description text
);