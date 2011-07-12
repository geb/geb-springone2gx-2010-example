package modules

import geb.*
import pages.*

class Footer extends Module {

	static content = {
		auxillaryPageLinks { $("ul", 0) }
		auxillaryPageLink { auxillaryPageLinks.find(text: iContains(it)) }
		contactUsLink(to: ContactUsPage) { auxillaryPageLink("contact us") }
	}

}