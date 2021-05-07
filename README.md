# IoTBay
UTS Group Assignment, online web application.

# Notes

Create your own branch for the feature you're working on, derived from the master branch. Use this as your repository to push and pull your progress.

Create your DAO methods in srs/uts/isd/model/dao/DBManager.java, e.g. findUser, findProduct, etc.

When adding your controller/servlet classes, don't forget to declare them in the web.xml file in WEB-INF folder as well, otherwise they wont work.

Make sure to run the application through index.jsp, as that is the page that declares ConnServlet to allow for all controllers/servlets to work.

db: Contains sql file(s) for inserting tables/altering/updating columns. Important to comment out queries once they've been successfully executed once.
Note to self: make one final schema.sql file that inserts all tables (for creating the database at another computer)

# Creating a repository in Netbeans

Create your branch on the github site first

Check out this video on using GitHub directly within Netbeans: 
https://www.youtube.com/watch?v=rs3QSq5hNf4
