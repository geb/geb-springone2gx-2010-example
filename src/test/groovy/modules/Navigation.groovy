package modules

import geb.*
import pages.*

/**
 * Represents the navigation ul on the left hand side.
 * 
 * The sub items (i.e. children) have the class 'sub'.
 */
class Navigation extends Module {

	static content = {
		currentName { current.text() }
		current { allItems.find(".current") }
		allItems { $("li") }
		
		// Content objects have standard groovy collection methods
		// but returns a list of separate content objects
		// If you were only using CSS3 compliant browsers, you could use allItems.filter(":not(.sub)")
		topLevelItems { allItems.findAll { !it.hasClass('sub') } }
		
		itemLink { topLevel, subLevel = null -> item(topLevel, subLevel).find("a") }
		item { topLevel, subLevel = null -> 
			def top = topLevelItems.find { it.text() == topLevel }
			if (top == null || subLevel == null) {
				top
			} else {
				def next = top.next("li.sub")
				while (next != null) {
					if (next.text() == subLevel) {
						return next
					} else {
						next = next.next("li.sub") 
					}
				}
			}
		}
	
		sessions(to: AllSessionsPage) { itemLink("Sessions") }
		groovyGrailsSessions(to: GroovyGrailsSessionsPage) { itemLink("Sessions", "Groovy/Grails") }
		sponsors(to: SponsorsPage) { itemLink("Sponsors") }
	}

}