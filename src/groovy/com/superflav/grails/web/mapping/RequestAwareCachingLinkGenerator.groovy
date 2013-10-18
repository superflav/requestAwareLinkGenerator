package com.superflav.grails.web.mapping

import org.codehaus.groovy.grails.web.mapping.CachingLinkGenerator
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest

class RequestAwareCachingLinkGenerator extends CachingLinkGenerator {

    RequestAwareCachingLinkGenerator(String serverBaseURL, String contextPath) {
        super(serverBaseURL, contextPath)
    }

    RequestAwareCachingLinkGenerator(String serverBaseURL) {
        super(serverBaseURL)
    }

    /**
     * @return serverURL based on the baseUrl of the incoming request.
     */
    String makeServerURL() {
        GrailsWebRequest webRequest = GrailsWebRequest.lookup()
        if (webRequest) {
            String baseUrl = webRequest.baseUrl
            return baseUrl
        } else {
            return super.makeServerURL()
        }
    }
}
