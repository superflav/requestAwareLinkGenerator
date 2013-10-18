import com.superflav.grails.web.mapping.RequestAwareCachingLinkGenerator
import com.superflav.grails.web.mapping.RequestAwareDefaultLinkGenerator

beans = {

    // requestAwareLinkGenerator is enabled by default
    boolean requestAwareLinkGeneratorEnabled = (application.config.requestAwareLinkGenerator?.enable == false) ? false : true

    // requestAwareLinkGenerator uses RequestAwareCachingLinkGenerator by default
    Class requestAwareLinkGeneratorClass = (application.config.requestAwareLinkGenerator?.useCachingLinkGenerator == false) ? RequestAwareDefaultLinkGenerator : RequestAwareCachingLinkGenerator

    if (requestAwareLinkGeneratorEnabled) {
        println "requestAwareLinkGenerator is enabled and using implementation from ${requestAwareLinkGeneratorClass}"

        if (application.config.grails.app.context) {
            println "grails.app.context has been set, calling ${requestAwareLinkGeneratorClass} constructor with contextPath"
            grailsLinkGenerator(requestAwareLinkGeneratorClass, "${application.config.grails.serverURL}", "${application.config.grails.app.context}") {}
        } else {
            println "grails.app.context has not been set, calling ${requestAwareLinkGeneratorClass} constructor without contextPath"
            grailsLinkGenerator(requestAwareLinkGeneratorClass, "${application.config.grails.serverURL}") {}
        }
    } else {
        println "requestAwareLinkGenerator is disabled"
    }

}
