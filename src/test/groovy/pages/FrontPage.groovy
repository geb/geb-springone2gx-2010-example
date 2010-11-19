package pages

import modules.*

class FrontPage extends MainPage {

	static content = {
		
		// Define our two lots of speakers
		springOneSpeakers { speakersAfterHeading("SpringOne Featured Speakers") }
		twoGxSpeakers { speakersAfterHeading("2GX Featured Speakers") }
		
		speakersAfterHeading { module(Speakers, $("h3", text: it).next()) }
	}

}