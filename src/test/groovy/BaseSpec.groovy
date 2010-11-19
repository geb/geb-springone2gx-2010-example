import org.junit.runner.RunWith

import org.spockframework.runtime.Sputnik

import geb.spock.GebReportingSpec

@RunWith(Sputnik) // workaround for Eclipse 3.5 bug; no longer necessary once geb-spock sources are available from Maven repo
abstract class BaseSpec extends GebReportingSpec {

	/**
	 * All relative urls will be interpreted against this.
	 */
	String getBaseUrl() {
		"http://www.springone2gx.com/conference/chicago/2010/10/home"
	}

	/**
	 * Write out responses and screenshots here.
	 */
	File getReportDir() {
		new File("build/geb-reports")
	}
	
}