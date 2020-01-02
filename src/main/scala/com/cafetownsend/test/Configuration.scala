package com.mobiquity.test

import com.typesafe.config.ConfigFactory

object Configuration {

  val config = ConfigFactory.load()

  val chromeDriver = config.getString("chromeDriver")
  val userName = config.getString("userName")
  val password = config.getString("password")
  val baseUrl = config.getString("baseUrl")
  val loginUrl = config.getString("loginUrl")
  val employeesUrl = config.getString("employeesUrl")
  val employeesNewUrl = config.getString("employeesNewUrl")
  val employeesEditUrlSuffix = config.getString("employeesEditUrlSuffix")

  val firstName = config.getString("employees1Name")
  val lastName = config.getString("employees1LastName")
  val startDate = config.getString("startDate")
  val eMail = config.getString("eMail")

}
