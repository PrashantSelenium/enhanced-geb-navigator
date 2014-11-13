package com.menonvarun.geb.navigator

import geb.Browser
import geb.navigator.Navigator
import org.openqa.selenium.By
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by varunm on 21-10-2014.
 */
class EnhancedNavigatorSpec extends Specification{
    @Shared Browser browser
    @Shared Navigator onPage

    def setupSpec() {
        browser = new Browser()
        browser.go(getClass().getResource("/test.html") as String)
        onPage = browser.navigatorFactory.base
    }

    @Unroll
    def "Can use By #type object with Navigator to find element"() {
        expect: navigator.size() > 0
        where:
        type                |navigator
        "Tagname"           |onPage.find(By.tagName("div"))
        "Classname"         |onPage.find(By.className("article"))
        "Id"                |onPage.find(By.id("header"))
        "Xpath"             |onPage.find(By.xpath("//div[@class='article']"))
        "PartialLinkText"   |onPage.find(By.partialLinkText("Article"))
        "LinkText"          |onPage.find(By.linkText("Contact"))
        "CssSelector"       |onPage.find(By.cssSelector("#content .content"))
    }

    @Unroll
    def "Can use method which take #arguments arguments to find element"() {
        expect: navigator.size() == size
        where:
        arguments                           |navigator                                              |size
        "Predicates and By object"          |onPage.find(By.tagName("a"),text:"Home")               |1
        "Predicates, By and index object"   |onPage.find(By.className("article"),id:"article-1",0)  |1
        "By and range object"               |onPage.find(By.className("article"),0..1)              |2
        "By and index object"               |onPage.find(By.className("article"),1)                 |1
        "Predicates, By and range object"   |onPage.find(By.tagName("input"),type:"checkbox",0..1)  |2
    }
}
