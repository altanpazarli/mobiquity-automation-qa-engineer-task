package com.mobiquity.test.tests

import com.mobiquity.test.Configuration
import com.mobiquity.test.pages.HomePage._
import com.mobiquity.test.pages.LoginPage._
import com.mobiquity.test.pages.EmployeesPage._
import com.mobiquity.test.utilities.WebDrivers._
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.concurrent.Eventually._
import org.scalatest.time.{Seconds, Span}

class LoginTest extends FlatSpec with Matchers with WebBrowser {
  implicit val patienceConfig =
    PatienceConfig(timeout = scaled(Span(10, Seconds)), interval = scaled(Span(1, Seconds)))

  behavior of "User Log in"

  it should "be able to login" in {

    go to homePageLink

    //homepage will redirect user to login page

    currentUrl shouldEqual loginPageLink
    eventually(enterUserName)
    enterPassword
    clickLoginButton

    // User should see
    //  employees page
    //  changing link loginLink to employeesLink
    //  greetings message "Hello Luke"

    eventually(currentUrl shouldEqual employeesPageLink)
    eventually(greetingsMessage should include("Hello " + Configuration.userName))

  }
}
