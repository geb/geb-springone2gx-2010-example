import geb.error.RequiredPageContentNotPresent

import pages.FrontPage
import pages.SpeakerPage

class FeaturedSpeakersSpec extends BaseSpec {
	def setup() {
		to FrontPage
	}
	
	def "Rod should be the first featured speaker"() {
		expect:
		springOneSpeakers.speakerAtPosition(0, 0).name == "Rod Johnson"
	}

	def "test some more speaker positions"() {
		when:
		def speakers = page."${group}Speakers"
		def speaker = speakers.speakerAtPosition(row, column)
		
		then:
		speaker.name == name
		
		where:
		name           | group       | row | column
		"Rod Johnson"  | "springOne" | 0   | 0  
		"Hans Dockter" | "twoGx"     | 1   | 1
		"Keith Donald" | "springOne" | 1   | 2
		"Jeff Brown"   | "twoGx"     | 0   | 2
	}
	
	def "each group of speakers should contain six"() {
		expect:
		springOneSpeakers.find("div.speaker").size() == 6

		and:
		twoGxSpeakers.find("div.speaker").size() == 6
	}
	
	def "speaker links should take you to the speaker page for that speaker"() {
		given:
		def speaker = "Juergen Hoeller"

		when:
		springOneSpeakers.speakerByName(speaker).nameLink.click()
		
		then:
		at SpeakerPage
		
		and:
		speakerName == speaker
	}
	
	def "the speaker image on the front page should be the same image that is used on their profile page"() {
		given:
		def speaker = twoGxSpeakers.speakerByName("Graeme")
		def frontPagePictureSrc = speaker.picture.@src // use attribute notation to get tag attributes

		when:
		speaker.picture.click() // get there via the picture
		
		then:
		at SpeakerPage
		
		and:
		frontPagePictureSrc == $("img.speaker").@src // can also use $() in tests for ad hoc
	}
	
	def "accessing content that doesn't exist throws an exception"() {
		when:
		twoGxSpeakers.speakerByName("Luke Daley").nameLink.click()
		
		then:
		thrown(RequiredPageContentNotPresent)
	}
}