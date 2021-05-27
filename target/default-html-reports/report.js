$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/logout.feature");
formatter.feature({
  "name": "User should be able to Log out",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@logout"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "the user is on the dashboard page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.academiclibus.stepdefinitions.Logout.the_user_is_on_the_dashboard_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that the log out button is located under username dropdown",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@logout"
    }
  ]
});
formatter.step({
  "name": "user navigates to the top corner of the page",
  "keyword": "When "
});
formatter.match({
  "location": "com.academiclibus.stepdefinitions.Logout.user_navigates_to_the_top_corner_of_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on the user name item",
  "keyword": "And "
});
formatter.match({
  "location": "com.academiclibus.stepdefinitions.Logout.clicks_on_the_user_name_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the logout button should be clickable",
  "keyword": "And "
});
formatter.match({
  "location": "com.academiclibus.stepdefinitions.Logout.the_logout_button_should_be_clickable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks the button",
  "keyword": "And "
});
formatter.match({
  "location": "com.academiclibus.stepdefinitions.Logout.user_clicks_the_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be in the login page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.academiclibus.stepdefinitions.Logout.user_should_be_in_the_login_page()"
});
formatter.result({
  "status": "passed"
});
});