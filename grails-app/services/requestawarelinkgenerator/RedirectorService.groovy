package requestawarelinkgenerator

import org.codehaus.groovy.grails.web.mapping.LinkGenerator

class RedirectorService {

    LinkGenerator grailsLinkGenerator

    /**
     * @return an absolute URL that can be used to redirect from a controller action
     */
    String redirectBackToIndex() {
        return grailsLinkGenerator.link(controller: "redirector", action: "index", absolute: true)
    }
}
