import geb.error.RequiredPageContentNotPresent
import geb.spock.GebReportingSpec
import pages.FrontPage
import pages.SpeakerPage

class FeaturedSpeakersSpec extends GebReportingSpec {
	def setup() {
		to FrontPage
	}
	
	def "Rod should be the first featured speaker"() {
		expect:
		springOneSpeakers.speakerAtIndex(0).name == "Rod Johnson"
	}

	def "test some more speaker positions"() {
		when:
		def speakers = page."${group}Speakers"
		def speaker = speakers.speakerAtIndex(index)
		
		then:
		speaker.name == name
		
		where:
		name           | group       | index
		"Rod Johnson"  | "springOne" | 0
		"Hans Dockter" | "twoGx"     | 3
		"Keith Donald" | "springOne" | 4
		"Jeff Brown"   | "twoGx"     | 2
	}
	
	def "count the speakers"() {
		expect:
		springOneSpeakers.find("li").size() == 5

		and:
		twoGxSpeakers.find("li").size() == 5
	}
	
	def "speaker links should take you to the speaker page for that speaker"() {
		given:
		def speaker = "JUERGEN HOELLER"

		when:
		springOneSpeakers.speakerByName(speaker).nameLink.click()
		
		then:
		at SpeakerPage
		
		and:
		speakerName == speaker
	}
	
	def "the speaker image should be fore the speaker"() {
		given:
		def speaker = twoGxSpeakers.speakerByName("Graeme")
		
		expect:
		speaker.picture.@src.contains("5144_Rocher") // use attribute notation to get tag attributes

		when:
		speaker.picture.click() // get there via the picture
		
		then:
		at SpeakerPage
		
		and:
		$("img.speaker").@src.contains("5144_Rocher") // can also use $() in tests for ad hoc
	}
	
	def "accessing content that doesn't exist throws an exception"() {
		when:
		twoGxSpeakers.speakerByName("Luke Daley").nameLink.click()
		
		then:
		thrown(RequiredPageContentNotPresent)
	}
}