DROP TABLE IF EXISTS bot;
DROP TABLE IF EXISTS conversation;
DROP TABLE IF EXISTS message;
 
CREATE TABLE bot (
  id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE conversation (
  id VARCHAR(255) PRIMARY KEY,
  creation_date TIMESTAMP NOT NULL
);

CREATE TABLE message (
  id VARCHAR(255) PRIMARY KEY,
  message VARCHAR(4000) NOT NULL,
  id_from VARCHAR(255) NOT NULL,
  id_to VARCHAR(255) NOT NULL,
  id_conversation VARCHAR(255) NOT NULL,
  creation_date TIMESTAMP NOT NULL,
  foreign key (id_from) references bot(id),
  foreign key (id_to) references bot(id),
  foreign key (id_conversation) references conversation(id)
);


