package com.mobiquity.test.pages

import com.mobiquity.test.Configuration
import org.openqa.selenium._
import com.mobiquity.test.utilities.WebDrivers.webDriver

object EmployeesNewPage {

  val employeesNewPageLink = Configuration.employeesNewUrl
  val firstNameOfNewUser = Configuration.firstName
  val lastNameOfNewUser = Configuration.lastName
  val startingDateOfNewUser = Configuration.startDate
  val eMailOfNewUser = Configuration.eMail

  def firstNameBox = webDriver.findElement(By.cssSelector("input[ng-model='selectedEmployee.firstName']"))

  def lastNameBox = webDriver.findElement(By.cssSelector("input[ng-model='selectedEmployee.lastName']"))

  def startDateBox = webDriver.findElement(By.cssSelector("input[ng-model='selectedEmployee.startDate']"))

  def eMailBox = webDriver.findElement(By.cssSelector("input[ng-model='selectedEmployee.email']"))

  def addButton = webDriver.findElements(By.cssSelector(".main-button")).get(2)

  def clickAddButton = addButton.click()
}
