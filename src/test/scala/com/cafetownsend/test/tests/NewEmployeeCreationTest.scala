package com.mobiquity.test.tests

import com.mobiquity.test.pages.EmployeesPage._
import com.mobiquity.test.pages.EmployeesNewPage._
import com.mobiquity.test.pages.LoginPage._
import com.mobiquity.test.utilities.WebDrivers._
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.concurrent.Eventually._
import org.scalatest.time.{Seconds, Span}

class NewEmployeeCreationTest extends FlatSpec with Matchers with WebBrowser {
  implicit val patienceConfig =
    PatienceConfig(timeout = scaled(Span(10, Seconds)), interval = scaled(Span(1, Seconds)))

  behavior of "New Employee Creation"

  it should "create a new employee" in {

    go to loginPageLink

    eventually(enterUserName)
    enterPassword
    clickLoginButton

    eventually(clickCreateButton)
    eventually(firstNameBox.sendKeys(firstNameOfNewUser))
    lastNameBox.sendKeys(lastNameOfNewUser)
    startDateBox.sendKeys(startingDateOfNewUser)
    eMailBox.sendKeys(eMailOfNewUser)
    clickAddButton

    eventually(currentUrl shouldEqual employeesPageLink)

    val fullNameOfNewUser = firstNameOfNewUser + " " + lastNameOfNewUser
    eventually(employeesList should contain(fullNameOfNewUser))
    eventually(currentUrl shouldEqual employeesPageLink)

  }


}
