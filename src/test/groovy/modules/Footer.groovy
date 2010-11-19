package modules

import geb.*
import pages.*

class Footer extends Module {

	static content = {
		auxillaryPageLinks { $("ul.links") }
		auxillaryPageLink { 
			auxillaryPageLinks.each {
				println it.text()
			}
			auxillaryPageLinks.find(text: iContains(it)) 
		}
		contactUsLink(to: ContactUsPage) { auxillaryPageLink("contact us") }
	}

}