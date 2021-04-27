$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Elearning Application login",
  "description": "",
  "id": "elearning-application-login",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Learning registration page",
  "description": "",
  "id": "elearning-application-login;learning-registration-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is on Learning landing page \u003cURL\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User registration with following details firstname \u003cFirstname\u003e and lastname \u003clastname\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Emailid \u003cGmail\u003e and UserName \u003cusername\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Enter password \u003cpass1\u003e and Enter Confirm password \u003cpass2\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User successfully registered",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Validate mail id and Navigate to inbox page under user profile \u003cGmail\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User compose a mail with \u003cMailId SearchInput\u003e and \u003cMail Subject\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "User successfully sent a message \u003cConfirmation\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "elearning-application-login;learning-registration-page;",
  "rows": [
    {
      "cells": [
        "URL",
        "Firstname",
        "lastname",
        "Gmail",
        "username",
        "pass1",
        "pass2",
        "Confirmation",
        "MailId SearchInput",
        "Mail Subject"
      ],
      "line": 15,
      "id": "elearning-application-login;learning-registration-page;;1"
    },
    {
      "cells": [
        "http://elearningm1.upskills.in/",
        "Arpitha",
        "Gowda",
        "abcd@gmail.com",
        "Loginname4",
        "Password@1",
        "Password@1",
        "The message has been sent to virat kohli (virat)",
        "virat",
        "Testing confirmation"
      ],
      "line": 16,
      "id": "elearning-application-login;learning-registration-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3525376200,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Learning registration page",
  "description": "",
  "id": "elearning-application-login;learning-registration-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is on Learning landing page http://elearningm1.upskills.in/",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User registration with following details firstname Arpitha and lastname Gowda",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Emailid abcd@gmail.com and UserName Loginname4",
  "matchedColumns": [
    3,
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Enter password Password@1 and Enter Confirm password Password@1",
  "matchedColumns": [
    5,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User successfully registered",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Validate mail id and Navigate to inbox page under user profile abcd@gmail.com",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User compose a mail with virat and Testing confirmation",
  "matchedColumns": [
    8,
    9
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "User successfully sent a message The message has been sent to virat kohli (virat)",
  "matchedColumns": [
    7
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://elearningm1.upskills.in/",
      "offset": 33
    }
  ],
  "location": "StepDefinition.user_is_on_learning_landing_page(String)"
});
formatter.result({
  "duration": 9893815600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Arpitha",
      "offset": 51
    },
    {
      "val": "Gowda",
      "offset": 72
    }
  ],
  "location": "StepDefinition.user_registration_with_following_details_firstname_and_lastname(String,String)"
});
formatter.result({
  "duration": 394704900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abcd@gmail.com",
      "offset": 8
    },
    {
      "val": "Loginname4",
      "offset": 36
    }
  ],
  "location": "StepDefinition.emailid_and_username(String,String)"
});
formatter.result({
  "duration": 296609400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Password@1",
      "offset": 15
    },
    {
      "val": "Password@1",
      "offset": 53
    }
  ],
  "location": "StepDefinition.enter_password_and_enter_confirm_password(String,String)"
});
formatter.result({
  "duration": 3848338900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_successfully_registered()"
});
formatter.result({
  "duration": 203310200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "abcd@gmail.com",
      "offset": 63
    }
  ],
  "location": "StepDefinition.validate_mail_id_and_navigate_to_inbox_page_under_user_profile(String)"
});
formatter.result({
  "duration": 2575844000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "virat",
      "offset": 25
    },
    {
      "val": "Testing confirmation",
      "offset": 35
    }
  ],
  "location": "StepDefinition.user_compose_a_mail_with_and(String,String)"
});
formatter.result({
  "duration": 13052212700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "The message has been sent to virat kohli (virat)",
      "offset": 33
    }
  ],
  "location": "StepDefinition.user_successfully_sent_a_message(String)"
});
formatter.result({
  "duration": 48988000,
  "status": "passed"
});
formatter.after({
  "duration": 925315300,
  "status": "passed"
});
});