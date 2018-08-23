DROP TABLE if exists BLOG_POST;
DROP TABLE if exists BLOG;

CREATE TABLE BLOG (
  BLOG_ID         INT AUTO_INCREMENT PRIMARY KEY,
  BLOG_VERSION    INT NOT NULL DEFAULT 0,
  BLOG_AUTHOR     VARCHAR(255) NOT NULL,
  BLOG_NAME       VARCHAR(255) NOT NULL
);

CREATE TABLE BLOG_POST (
  POST_ID         INT AUTO_INCREMENT PRIMARY KEY,
  POST_VERSION    INT NOT NULL DEFAULT 0,
  POST_DATE       DATETIME NOT NULL,
  POST_TITLE      VARCHAR(255) NOT NULL,
  POST_TEXT       LONGTEXT DEFAULT NULL,
  BLOG_ID         INT NULL
);

ALTER TABLE BLOG_POST ADD CONSTRAINT POST_TO_BLOG_FK FOREIGN KEY (BLOG_ID) REFERENCES BLOG(BLOG_ID);

INSERT INTO BLOG(BLOG_AUTHOR, BLOG_NAME) VALUES('Lars Vogel', 'Blog of Lars Vogel');

INSERT INTO BLOG_POST(BLOG_ID, POST_DATE, POST_TITLE, POST_TEXT) VALUES(
  1,
  '2013-07-19 00:00:00',
  'Inject your JPA EntityManager into an Eclipse RCP application - Guest post by Nepomuk Seiler',
  'The Gemini JPA project provides an OSGi service implementation for EntityManagers and EntityManagerFactories. A set of database connectors are provided through the Gemini DBAccess project. In order to use these services smoothly with annotations the Gemini Ext Di project was created.');

INSERT INTO BLOG_POST(BLOG_ID, POST_DATE, POST_TITLE, POST_TEXT) VALUES(
  1,
  '2011-01-10 00:00:00',
  'Google App Engine and JPA',
  'Using JPA on the Google AppEngine is straight forward. For some reason the documentation on the official Google App Engine side is not very easy to read therefore a little example here.');

INSERT INTO BLOG_POST(BLOG_ID, POST_DATE, POST_TITLE, POST_TEXT) VALUES(
  1,
  '2010-01-18 00:00:00',
  'Google App Engine - Low level API for storing objects',
  'Google App Engine for Java permits three ways of storing your data: JDO, JPA and the low-level API. All data is ultimately stored in Bigtable. This blog post will give a little example how you can store data via the low-level API.');
