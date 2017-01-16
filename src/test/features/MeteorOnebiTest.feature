
Feature: Meteor Onebi test

	Scenario: Meteor Onebi scenario
		Given Otworz strone http://meteor.onebi.eu/
		When Meteor Onebi: adres strony zawiera meteor
		Then Meteor Onebi: kliknij TEAM
		Then Poczekaj 5 sekund 