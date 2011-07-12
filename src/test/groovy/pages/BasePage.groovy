package pages

import geb.*
import modules.*

class BasePage extends Page {

	static content = {
		container { $("div#container") }
		pageName { container.find("h1").text() }
		footer { module(Footer, $("div#ftr")) }
	}

}