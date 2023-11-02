CREATE TABLE books (
  id UUID NOT NULL,
   title VARCHAR(255) NOT NULL,
   author VARCHAR(255) NOT NULL,
   publisher VARCHAR(255) NOT NULL,
   publication_year INTEGER NOT NULL,
   category SMALLINT NOT NULL,
   reading_status SMALLINT NOT NULL,
   CONSTRAINT pk_books PRIMARY KEY (id)
);