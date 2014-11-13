package com.menonvarun.geb.navigator

import geb.Browser
import geb.navigator.EmptyNavigator
import geb.navigator.Navigator
import geb.navigator.factory.InnerNavigatorFactory
import org.openqa.selenium.WebElement

/**
 * Created by varunm on 10-09-2014.
 */
class EnhancedNavigatorFactory implements InnerNavigatorFactory{

    @Override
    Navigator createNavigator(Browser browser, List<WebElement> elements) {
        elements ? new EnhancedNavigator(browser,elements) : new EmptyNavigator(browser)
    }
}
