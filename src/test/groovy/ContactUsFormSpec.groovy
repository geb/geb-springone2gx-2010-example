import spock.lang.Stepwise
import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

import pages.FrontPage
import pages.ContactUsPage

@Stepwise
class ContactUsFormSpec extends GebReportingSpec {
	def "at the front page"() {
		when:
		to FrontPage

		then:
		at FrontPage
	}

	def "click the contact us link"() {
		when:
		// footer.contactUsLink.click() // doesn't work on chrome (chrome driver bug selenium 2.0rc3)
		$("a[title=Contact]").click(ContactUsPage)

		then:
		at ContactUsPage
	}
	
	def "fill in the form except for a message"() {
		when:
		name = "Peter Niederwieser"
		email = "pniederw@gmail.com"
		sendButton.click()

		then:
		at ContactUsPage
		errorMessage == "message is required"
	}
	
	def "refreshing the page does not get rid of the error message"() {
		when:
		driver.navigate().refresh() // dip into the webdriver API

		then:
		at ContactUsPage
		
		and:
		errorMessage == "message is required"
	}
	
	def "going back gets rid of the error message"() {
		when:
		driver.navigate().back()

		then:
		at ContactUsPage
		
		and:
		errorMessage == null
	}
	
	def "fill in the form"() {
		when: "I try to do some self-promotion"
		name = "Peter Niederwieser"
		email = "pniederw@gmail.com"
		feedbackMessage = "I loved the Spock and Geb sessions!"
		sendButton.click()

		then: "I can't get past the captcha"
		at ContactUsPage
		errorMessage == "Verification failed" 
	}
	
	def "demo the keyboard event api"() {
		when:
		// Can send characters to elements
		feedbackMessage = "123"
		feedbackMessage() << "4" << "5"
		
		then:
		// Can read form elements values by name
		// feedbackMessage == "12345" -- broken in selenium 2.0rc3
		true 
		
		when:
		feedbackMessage() << Keys.BACK_SPACE << Keys.BACK_SPACE // can use webdriver API for sending "exotic" keys
		
		then:
		// feedbackMessage == "123" -- broken in selenium 2.0rc3
		true
	}   
}