package com.mobiquity.test.pages

import com.mobiquity.test.Configuration
import org.openqa.selenium._
import com.mobiquity.test.utilities.WebDrivers.webDriver

object LoginPage {

  val loginPageLink = Configuration.loginUrl

  def userNameBox = webDriver.findElement(By.cssSelector("input[ng-model='user.name']"))

  def enterUserName = userNameBox.sendKeys(Configuration.userName)

  def passwordBox = webDriver.findElement(By.cssSelector("input[ng-model='user.password']"))

  def enterPassword = passwordBox.sendKeys(Configuration.password)

  def clickLoginButton = webDriver.findElement(By.cssSelector("button[type='submit']")).click()

}
