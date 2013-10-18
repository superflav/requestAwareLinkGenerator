package com.superflav.grails.web.mapping

import org.codehaus.groovy.grails.web.mapping.DefaultLinkGenerator
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest

class RequestAwareDefaultLinkGenerator extends DefaultLinkGenerator {

    RequestAwareDefaultLinkGenerator(String serverBaseURL, String contextPath) {
        super(serverBaseURL, contextPath)
    }

    RequestAwareDefaultLinkGenerator(String serverBaseURL) {
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