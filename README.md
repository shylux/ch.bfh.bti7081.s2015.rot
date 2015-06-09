# ch.bfh.bti7081.s2015.rot

**Wir benutzen git als Versionierungssystem.**

[Diary](doc/diary.md)


Installation
============

Database Configuration
----------------------
We use MongoDB as our database. You need a database server to run our app.
Create a `db.properties` file in the project root.
```
server=<domain/ip and if not standard the port of database server>
user=<db username>
pass=<db password>
db=<database name on server>
```


Building
--------

We use maven to build the project. This should pull all dependencies like vaadin and jetty automatically.

```
maven build
maven install
maven run:jetty
```
The app runs on port `8080`.


Java Doc
--------
[Java Doc](https://github.com/shylux/ch.bfh.bti7081.s2015.rot/tree/master/doc/javadoc)
