# IoTBay
UTS Group Assignment, online web application.

# STATUS: 01 Completed. Can safely create branches from master branch!

# Notes

Create your own branch for the feature you're working on, derived from the master branch. Use this as your repository to push and pull your progress. (see video link below on how)

## Initializing the database/tables:

Make sure the database credentials are the same as the ones found in uts/isd/model/dao/DB.java

SQL statements for table creation/insertion can be found/should be done in db/tables.sql and db/inserts.sql respectively. Please rserve these files for those actions only. Important to comment out queries once they've been successfully executed once.

## Other

Create your DAO methods in srs/uts/isd/model/dao/DBManager.java, e.g. findUser, findProduct, etc. Add Servlet classes in srs/uts/isd/controller, e.g. loginServlet, registerServlet, etc.

When adding your servlet classes, don't forget to declare them in the web.xml file in WEB-INF folder as well, otherwise they wont work.

Make sure to run the application through index.jsp, as that is the page that declares ConnServlet to allow for all the controllers/servlets to work.

# Creating a local repository in Netbeans

Create your branch on the github site first

Check out this video on using GitHub directly within Netbeans: 
https://www.youtube.com/watch?v=rs3QSq5hNf4

## Github in a nutshell:

Local repository: in this case, your netbeans project folder (see video above).
Remote repository: this place you're looking at

You push and pull your progress to and from your branch

Pull: downloads any new files from a selected branch to your local repository
Push: uploads any new files not yet in the selected branch from your local repository
