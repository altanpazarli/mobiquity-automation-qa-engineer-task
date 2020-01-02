package com.mobiquity.test.tests

import com.mobiquity.test.pages.EmployeesPage._
import com.mobiquity.test.pages.EmployeesNewPage._
import com.mobiquity.test.pages.EmployeesEditPage._
import com.mobiquity.test.pages.LoginPage._
import com.mobiquity.test.utilities.WebDrivers._
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.concurrent.Eventually._
import org.scalatest.time.{Seconds, Span}


class UpdatingEmployeeDataTest extends FlatSpec with Matchers with WebBrowser {
  implicit val patienceConfig =
    PatienceConfig(timeout = scaled(Span(10, Seconds)), interval = scaled(Span(1, Seconds)))

  behavior of "Updating Employee Data"

  it should "able to update employee data" in {

    go to loginPageLink

    eventually(enterUserName)
    enterPassword
    clickLoginButton

    eventually(click on firstEmployeeOnList)

    val willBeEditedEmployee = fullNameOfFirstEmployee

    eventually(click on editButton)
    eventually(currentUrl should endWith(employeesEditPageLinkSuffix))

    val editingSuffix = "editing"
    eventually(lastNameBox.sendKeys(editingSuffix))
    clickUpdateButton

    val editedEmployeeName = willBeEditedEmployee + editingSuffix

    eventually(employeesList should contain(editedEmployeeName))

  }


}
