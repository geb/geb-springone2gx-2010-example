Geb Example Project
===================

This is the Geb example project as demonstrated at SpringOne 2GX 2010.
              
Running Tests with Gradle
------------------------

To run tests with Gradle, type:

> ./gradlew clean test (Windows: gradlew.bat clean test)

All dependencies (including Gradle) will be downloaded automatically. By default, the build will use Firefox to drive the tests. If you don't have Firefox installed, you can run the tests with HTMLUnit:

> ./gradlew clean test -Pdriver=htmlunit

Note that a few of the tests will fail when using HTMLUnit. This is expected.    

To view the generated JUnit reports, open build/reports/tests/index.html. Additionally, Geb saves HTML and screenshots for all visited pages to build/geb-reports.

Running Tests with IDEA 9/10
---------------------------- 

> ./gradlew cleanIdea idea (Windows: gradlew.bat cleanIdea idea)

Open the generated IDEA project (geb_s2gx.ipr)

Open Project Settings and make sure the correct JDK is selected

Run src/test/groovy/ContactUsFormSpec.groovy as you would run a JUnit test

By default, tests will be run with HTMLUnit. Note that a few tests will fail when using HTMLUnit. This is expected. To use Firefox instead of HTMLUnit, open the test's Run Configuration and add the following VM parameter: -Dgeb.driver=firefox

Running Tests with Eclipse 3.5/3.6
----------------------------------

Please make sure you are using the latest version of the Groovy Eclipse plugin.

> ./gradlew cleanEclipse eclipse (Windows: gradlew.bat cleanEclipse eclipse)

Open the generated Eclipse project

Open Preferences and add a classpath variable GRADLE_CACHE with value "<user_home>/.gradle/cache". (If you already are a Gradle user and have an environment variable GRADLE_USER_HOME set, the cache location might differ.) 

Run src/test/groovy/ContactUsFormSpec.groovy as you would run a JUnit test

By default, tests will be run with HTMLUnit. Note that a few tests will fail when using HTMLUnit. This is expected. To use Firefox instead of HTMLUnit, open the test's Run Configuration, switch to the "Arguments" tab, and add the following VM argument: -Dgeb.driver=firefox

If you have problems running the tests, open the "Error Log" view (Window->Show View->Error Log) and check if there are any problems reported for the Groovy Eclipse plugin.

Further Help
------------

If you have any problems or questions, please contact one the following mailing lists. We'd love to hear from you!

Geb http://xircles.codehaus.org/projects/geb/lists
Spock http://forum.spockframework.org
Groovy Eclipse plugin http://groovy-eclipse-plugin.42567.n3.nabble.com/
