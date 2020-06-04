# Create a Assessment View
Version: 1.1 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 11/01/18 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── CreateNewAssessmentView.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── org
│       │       └── graphwalker
│       │           ├── Config.java
│       │           ├── CreateNewAssessmentViewTest.java
│       │           └── Helper.java
│       └── resources
│           └── org
│               └── graphwalker
│                   └── CreateNewAssessmentView.graphml
└── target
    ├── classes
    │   └── org
    │       └── graphwalker
    │           ├── Config.class
    │           ├── CreateNewAssessmentView.class
    │           ├── CreateNewAssessmentView.graphml
    │           ├── CreateNewAssessmentViewTest.class
    │           └── Helper.class
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── org
    │           └── graphwalker
    │               └── CreateNewAssessmentView.java
    ├── generated-test-sources
    │   └── graphwalker
    │       └── cache.json
    ├── graphwalker-reports
    └── maven-status
        └── maven-compiler-plugin
            ├── compile
            │   └── default-compile
            │       ├── createdFiles.lst
            │       └── inputFiles.lst
            └── testCompile
                └── default-testCompile
                    └── inputFiles.lst
```