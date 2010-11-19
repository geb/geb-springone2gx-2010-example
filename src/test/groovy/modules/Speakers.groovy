package modules

import geb.*
import pages.*

/**
 * A speakers module is a div containing Speaker modules in a grid layout
 */
class Speakers extends Module {

	static content = {
		
		// Obtain the speaker module for the given row and column index
		speakerAtPosition { rowIndex, columnIndex -> module(Speaker, row(rowIndex).find("div.speaker", columnIndex)) }
		
		// Obtain the the first speaker module where the name contains the given name
		speakerByName { name -> module(Speaker, speakerNameLink(name).parent("div.speaker")) }
		
		// Gets the first speaker name link that contains the given string, case insensitively
		speakerNameLink { name -> $("div.speaker").find("a", text: iContains(name)) }
		
		row { i = 0 -> $("div.row", i) }
	}

}