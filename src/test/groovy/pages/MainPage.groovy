
package pages

import geb.*
import modules.*

/**
 * A main page is any of the pages with the nav menu and full footer
 */
class MainPage extends BasePage {

	static content = {
		// All pages have the navigation menu, this will be inherited
		navigation { module(Navigation, $("ul#showNavButtons")) }
	}

}