package com.mobiquity.test.pages

import com.mobiquity.test.Configuration
import org.openqa.selenium._
import com.mobiquity.test.utilities.WebDrivers.webDriver

object EmployeesEditPage {

  val employeesEditPageLinkSuffix = Configuration.employeesEditUrlSuffix

  def updateButton = webDriver.findElements(By.cssSelector(".main-button")).get(1)

  def clickUpdateButton = updateButton.click()

}
