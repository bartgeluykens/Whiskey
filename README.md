# Whiskey #

## About ##

    The aim of the Whiskey appllication is to create a web based java application that:

    1. Can be written very fast
    2. Showcases good oo practice
    3. Write as little code as possible


## This application ##

    This is a simple progam to organise a whiskey collection.

## Technologie Stack ##

    * Spring MVC
    * Apache Wicket
    * Hibenate

# Installing the Application #

## Database ##

    Out of the box we use hsqldb.

    Database scripts can be found under src/main/db

## Building the application ##

### Prerequisites ###

    You neet to have maven installed

### Building ###

    Go to the main page and type:

        mvn clean install

## deploying the application ##

### Deploy on Linux ###

    Under the unix directory you'll find some scipts to deploy on tomcat 7.

    Start the script with the following command:

        source unix/tomcat_deploy.sh

    (You will have to do some manual replacements in the script to specify your settings)

    This will define some additional command line options like:

        tomcat_deploy: deploys on tomcat
        tomcat_shutdown: shutdowns tomcat
        tomcat_startup: startup tomcat
        start_hsqldb: starts hsqldb using the war-files from the maven repository
        stop_hsqldb: stops the hsqldb
        start_hsqldb_viewer: starts the hsql viewer

### Deploy on windows ###

    Should be possible, but didn't try it.


# We value you input!!! #

    The whole point of making this application is because we value your input.

    I would love to hear all improvements that could be made to this application

