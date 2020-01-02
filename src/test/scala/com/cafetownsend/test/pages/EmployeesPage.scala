package com.mobiquity.test.pages

import com.mobiquity.test.Configuration
import org.openqa.selenium._
import com.mobiquity.test.utilities.WebDrivers.webDriver
import scala.collection.convert.ImplicitConversions._

object EmployeesPage {

  val employeesPageLink = Configuration.employeesUrl

  def greetingsMessage = webDriver.findElement(By.cssSelector("p[id='greetings']")).getText

  def employeesListSelector = webDriver.findElements(By.cssSelector(".ng-scope.ng-binding"))

  def employeesList = employeesListSelector.map(_.getText)

  def firstEmployeeOnList = employeesListSelector.get(0)

  def fullNameOfFirstEmployee = firstEmployeeOnList.getText

  def createButton = webDriver.findElement(By.cssSelector("#bAdd"))

  def clickCreateButton = createButton.click()

  def editButton = webDriver.findElement(By.cssSelector("#bEdit"))

  def clickEditButton = editButton.click()

  def deleteButton = webDriver.findElement(By.cssSelector("#bDelete"))

  def clickDeleteButton = deleteButton.click()


}
