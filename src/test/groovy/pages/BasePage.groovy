package pages

import geb.*
import modules.*

class BasePage extends Page {

	static content = {
		// ditto
		pageName { $("h1").text() }
		footer { module(Footer, $("div#footer")) }
	}

}