CREATE TABLE JDBC_DIMAS.dbo.Kategori
(
    ID int PRIMARY KEY NOT NULL IDENTITY,
    NAMA_KATEGORI varchar(50) NOT NULL
)
CREATE UNIQUE INDEX Kategori_NAMA_KATEGORI_uindex ON JDBC_DIMAS.dbo.Kategori (NAMA_KATEGORI)