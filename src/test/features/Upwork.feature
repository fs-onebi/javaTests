@run_UpWork
Feature: Upwork 

	Scenario:  SELENIUM
	
		Given Otworz strone https://www.upwork.com/
		Then Upwork: kliknij LOGIN
		Then Upwork: Zaloguj sie do upwork
		And Upwork: w pole SEARCH wprowadz wartosc Selenium
        And Upwork: kliknij SEARCH_BUTTON
      ##  And Upwork: odznacz ENTRY_LEVEL
        When Upwork: Dla listy SELENIUM_OFFERT znajdz nowe wartosci i zapisz raport do SELENIUM_OFFERT_LIST
	    Then Upwork : Przefiltruj liste SELENIUM_OFFERT_LIST i zapisz do bazy 
		
		
	Scenario: Upwork METEOR
	
		Given Otworz strone https://www.upwork.com/
		Then Upwork: kliknij LOGIN
		Then Upwork: Zaloguj sie do upwork
		And Upwork: w pole SEARCH wprowadz wartosc Meteor
        And Upwork: kliknij SEARCH_BUTTON
       ## And Upwork: odznacz ENTRY_LEVEL  
        When Upwork: Dla listy METEOR_OFFERT znajdz nowe wartosci i zapisz raport do METEOR_OFFERT_LIST
	    Then Upwork : Przefiltruj liste METEOR_OFFERT_LIST i zapisz do bazy 
		
		
    Scenario: Upwork PostgreSQL
	
		Given Otworz strone https://www.upwork.com/
		Then Upwork: kliknij LOGIN
		Then Upwork: Zaloguj sie do upwork
		Then Upwork: kliknij ADVANCED_SEARCH
		Then Poczekaj 2 sekund
		And Upwork: w pole TITLE_SEARCH wprowadz wartosc PostgreSQL
        And Upwork: kliknij ADVANCED_SEARCH_BUTTON
        ##And Upwork: odznacz ENTRY_LEVEL
        When Upwork: Dla listy POSTGRESQL_OFFERT znajdz nowe wartosci i zapisz raport do POSTGRESQL_OFFERT_LIST
	    Then Upwork : Przefiltruj liste POSTGRESQL_OFFERT_LIST i zapisz do bazy 
		