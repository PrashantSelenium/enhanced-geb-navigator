enhanced-geb-navigator
======================
This utility allows users of Geb autoamtion framework to use different locator types supported by the _**By**_ class of Selenium to be used while using Geb.

##Download

The jar can be download for the relase url:

https://github.com/menonvarun/mvn-repo/tree/master/releases/com/menonvarun/geb/enhanced-geb-navigator

##Using Gradle

- Add the following to your list of repositories: 

_mavenRepo urls: "https://github.com/menonvarun/mvn-repo/raw/master/releases"_

- Add the dependency as mentioned below to your list of dependency:
 
_testCompile "com.menonvarun.geb:enhanced-geb-navigator:0.1"_


##Configuration


Import the EnhancedNavigatorFactory class into your _**GebConfig.groovy**_ file

_**import com.menonvarun.geb.navigator.***_

Add the following configuration to your _**GebConfig.groovy**_ file

_**innerNavigatorFactory  = new EnhancedNavigatorFactory()**_

##Supported Methods

After doing the above configuration you will be able to use the following methods in your module, page and test classes.

- find(By by)
- find(Map<String, Object> predicates, By by, int index)
- find(By by, Range<Integer> range)
- find(Map<String, Object> predicates, By by, Range<Integer> range)
- find(Map<String, Object> predicates, By by, Integer index)
- find(By by, int index)
- find(Map<String, Object> predicates, By by)
 
##How to Use

To use the said utility in your modules, pages and test-classes. Use _**$().find(By)**_ or simply _**find(By)**_.

##Sample tests
Sample tests are available in the following file.

https://github.com/menonvarun/enhanced-geb-navigator/blob/master/src/test/groovy/com/menonvarun/geb/navigator/EnhancedNavigatorSpec.groovy

**Note:** These methods will not be auto suggested in any IDE. These methods are identified at runtime and then executed.

