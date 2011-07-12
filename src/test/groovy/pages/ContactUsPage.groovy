package pages

import geb.*

class ContactUsPage extends BasePage {

	static at = { assert pageName == "CONTACT US"; true }

	static content = {
		// Not required because there may not be an error message
		errorMessage(required: false) { $("span.errorMessage").text() }
		
		sendButton(to: [ContactUsPage, FrontPage]) { $("input#FeedbackAdd_0") }
	}
}