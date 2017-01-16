@run_test
Feature: Meteor partners check

	Scenario: Meteor partners check and sending mail
		Given Otworz strone http://www.meteor.com/partners/meteorpartners
		When Partnerzy Meteora: Dla listy COMPANY znajdz nowe wartosci i zapisz raport do PARTNERZY_EMAIL
		And Wyslij email o temacie Nowi partnerzy meteora o zapamietanej tresci PARTNERZY_EMAIL do wojciech.marzec@gmail.com
		
		