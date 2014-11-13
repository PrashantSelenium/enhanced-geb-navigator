package com.menonvarun.geb.navigator

import geb.Browser
import geb.navigator.Navigator
import geb.navigator.NonEmptyNavigator
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

/**
 * Created by varunm on 10-09-2014.
 */
class EnhancedNavigator extends NonEmptyNavigator {

    public EnhancedNavigator(Browser browser, List<WebElement> webElements){
        super(browser,webElements)
    }


    public Navigator find(By by){
        List<WebElement> list = []
        for (contextElement in contextElements) {
            list.addAll contextElement.findElements(by)
        }
        navigatorFor list
    }

    Navigator find(Map<String, Object> predicates, By by, int index) {
        find(predicates, by, index..index)
    }

    Navigator find(By by, Range<Integer> range) {
        find(by)[range]
    }

    Navigator find(Map<String, Object> predicates, By by, Range<Integer> range) {
        find(predicates, by)[range]
    }

    Navigator find(Map<String, Object> predicates, By by, Integer index) {
        find(predicates, by, index..index)
    }

    Navigator find(By by, int index) {
        find(by)[index]
    }

    Navigator find(Map<String, Object> predicates, By by) {
        find(by).filter(predicates)
    }

    Navigator filter(By by) {
        throw new Exception("Not implemented")
    }
    Navigator filter(Map<String, Object> predicates, By by) {
        filter(by).filter(predicates)
    }

}
