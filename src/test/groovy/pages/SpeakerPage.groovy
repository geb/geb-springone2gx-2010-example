package pages

class SpeakerPage extends MainPage {

	// If the title contains 'Biography', we are at a speaker page
	static at = { title.contains("Biography") }
	
	static content = {
		// Not strictly needed, but reads better in specs
		speakerName { pageName }
	}

}