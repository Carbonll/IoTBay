# IoTBay
UTS Group Assignment, online web application.

# STATUS: 01 Completed. Can safely create branches from master branch!

# Notes

Create your own branch for the feature you're working on, derived from the master branch. Use this as your repository to push and pull your progress.

## Initializing the database/tables:

Make sure the database credentials are the same as the ones found in uts/isd/model/dao/DB.java

SQL statements for table creation/insertion can be found/should be done in db/tables.sql and db/inserts.sql respectively. Reserve these files for those actions only. Important to comment out queries once they've been successfully executed once.

## Other

Create your DAO methods in srs/uts/isd/model/dao/DBManager.java, e.g. findUser, findProduct, etc.

When adding your servlet classes, don't forget to declare them in the web.xml file in WEB-INF folder as well, otherwise they wont work.

Make sure to run the application through index.jsp, as that is the page that declares ConnServlet to allow for all controllers/servlets to work.

# Creating a repository in Netbeans

Create your branch on the github site first

Check out this video on using GitHub directly within Netbeans: 
https://www.youtube.com/watch?v=rs3QSq5hNf4
