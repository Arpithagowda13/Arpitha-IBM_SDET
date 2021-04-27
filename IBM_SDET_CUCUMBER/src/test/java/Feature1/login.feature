Feature: Elearning Application login

  @smokeTest
  Scenario Outline: Learning registration page
    Given User is on Learning landing page <URL>
    When User registration with following details firstname <Firstname> and lastname <lastname>
    And Emailid <Gmail> and UserName <username>
    And Enter password <pass1> and Enter Confirm password <pass2>
    Then User successfully registered
    And Validate mail id and Navigate to inbox page under user profile <Gmail>
    When User compose a mail with <MailId SearchInput> and <Mail Subject>
    Then User successfully sent a message <Confirmation>

    Examples: 
      | URL                             | Firstname | lastname | Gmail          | username   | pass1      | pass2      | Confirmation                                     | MailId SearchInput | Mail Subject         |
      | http://elearningm1.upskills.in/ | Arpitha   | Gowda    | abcd@gmail.com | Loginname4 | Password@1 | Password@1 | The message has been sent to virat kohli (virat) | virat              | Testing confirmation |
