package modules

import geb.*
import pages.*

/**
 * A speaker module is a div containing the speakers name and pic.
 */
class Speaker extends Module {

	static content = {
		nameLink(to: SpeakerPage) { $("a", 0) }
		picture(to: SpeakerPage) { $("img") }
		name { nameLink.text() }
	}

}