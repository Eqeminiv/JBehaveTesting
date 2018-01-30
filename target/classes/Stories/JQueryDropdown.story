
Scenario: JQueryDropdown
Given a page is JQuery dropdown search demo
When the single search is given a country fragment
Then it's tested whether the response is proper
When in the multiple select state is clicked
Then it's tested whether the response is valid
When the dropdown with disabled values is checked
Then it's tested whether the chosen option is returned