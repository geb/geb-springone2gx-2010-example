import pages.FrontPage
import pages.AllSessionsPage
import pages.SponsorsPage
import pages.GroovyGrailsSessionsPage

class NavigationSpec extends BaseSpec {
	def "navigation menu indicates the current page"() {
		when:
		to FrontPage

		then:
		at FrontPage

		and:
		navigation.currentName == "Event Home"
	} 
	
	def "count the navigation items"() {
		given:
		to FrontPage
		
		expect:
		navigation.allItems.size() == 12
		
		and:
		navigation.topLevelItems.size() == 6
	}

	def "exercise the nav menu"() {
		given:
		to FrontPage
		
		when:
		navigation.itemLink(topLevel, subLevel).click(expectedPage)
		
		then:
		at expectedPage
		
		where:
		topLevel   | subLevel            | expectedPage
		"Sponsors" | null                | SponsorsPage
		"Sessions" | null                | AllSessionsPage
		"Sessions" | "Groovy/Grails"     | GroovyGrailsSessionsPage
		
	}
	
	def "navigate between pages"() {
		given:
		to FrontPage
		expect:
		at FrontPage
		
		when:
		navigation.sessions.click()
		then:
		at AllSessionsPage
		
		when:
		navigation.sponsors.click()
		then:
		at SponsorsPage
		
		when:
		navigation.groovyGrailsSessions.click()
		then:
		at GroovyGrailsSessionsPage
	}
}