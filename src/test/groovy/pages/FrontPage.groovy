package pages

import modules.*

class FrontPage extends BasePage {

	static content = {
		
		// Define our two lots of speakers
		springOneSpeakers { speakersAfterHeading("SPRINGONE FEATURED SPEAKERS") }
		twoGxSpeakers { speakersAfterHeading("2GX FEATURED SPEAKERS") }
		speakers { $("div#home-speakers") }
		speakersHeading { speakers.find("h3", text: it) }
		speakersAfterHeading { module(Speakers, speakersHeading(it).next()) }
	}

}