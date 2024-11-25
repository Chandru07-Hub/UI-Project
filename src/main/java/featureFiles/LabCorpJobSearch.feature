Feature: LabCorp Job Search and Application

	@test1
  Scenario: Browse and apply for a job
    Given the user navigates to the LabCorp website
    When the user clicks on the Careers link
    And the user searches for a job titled "QA Test Automation Developer"
    And the user selects the first job listing
    Then the job title should be "Developer"
    And the job location should be "Bangalore"
    And the job ID should be "2430741"    
    And the job description should contain the following texts: 
   
  | Automation                                |
  | Javascript                                |
  | Excellent written and oral communication skills |
    
    When the user clicks Apply Now

