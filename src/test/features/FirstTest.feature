
Feature: First test

	Scenario: First scenario
		Given Otworz strone http://www.onebi.eu/
		When Strona glowna: adres strony zawiera onebi.eu
		Then Strona glowna: kliknij OUR_APPROACH
		Then Poczekaj 5 sekund
		Then Strona glowna: kliknij SERVICES
		Then Poczekaj 5 sekund