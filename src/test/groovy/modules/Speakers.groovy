package modules

import geb.*
import pages.*

/**
 * A speakers module is a list containing speakers as items
 */
class Speakers extends Module {

	static content = {
		
		// Obtain the speaker module for the given row and column index
		speakerAtIndex { index -> module(Speaker, $("li", index)) }
		
		// Obtain the the first speaker module where the name contains the given name
		speakerByName { name -> module(Speaker, speakerNameLink(name).parent("li")) }
		
		// Gets the first speaker name link that contains the given string, case insensitively
		speakerNameLink { name -> $("a", text: iContains(name)) }
	}

}