requestAwareLinkGenerator
====================

Grails app that overrides DefaultLinkGenerator.makeServerURL(), allowing the link's prefix to be based on the
incoming request rather than grails.serverURL.

Intro
-----

When generating absolute URLs, Grails prepends the value of the grails.serverURL property if it is not explicitly fed a
prefix. This works fine for a web app that serves all of its requests from a single protocol and domain, but breaks
down once an app needs to hop protocols(http <-> https), or serve more than a single domain (mysite.com/app,
theirsite.com/app, etc.).

If a GrailsWebRequest is present when generating absolute URLs, the code in this app overrides the Grails behavior,
prepending the baseUrl of the request rather than the value of grails.serverURL. The result being that methods which
return absolute URLs, such as controller.redirect(), grailsLinkGenerator.link(absolute: true), etc. will keep the
absolute URL within the context of the incoming request's protocol and domain.

Requirements
------------

###Software

Grails 2.2.4 - [http://www.grails.org/download](http://www.grails.org/download)

###Additional localhost entries

To test this locally, you'll need 127.0.0.1 to be able to resolve against more than just localhost. Make sure you have
at least 2 entries in */etc/hosts*

    127.0.0.1 localhost
    127.0.0.1 another.localhost

Running
--------

In this app the requestAwareLinkGenerator is enabled by default. Follow along to see how controller.redirect(),
grailsLinkGenerator.link(absolute: true), etc. behave in Grails when the requestAwareLinkGenerator is enabled vs.
when it's not.

###Run the app with requestAwareLinkGenerator enabled

Open a terminal, cd to the directory where this project is git cloned, and:

    > grails run-app

Point your browser at the *another.localhost* domain that you put into */etc/hosts* above:

    http://another.localhost:8080/requestAwareLinkGenerator/redirector

Click on the 3 links, with the expected results being:

* refresh - browser base url stays at http://another.localhost:8080
* redirect from controller - browser base url stays at http://another.localhost:8080
* redirect from service - browser base url stays at http://another.localhost:8080

###Run the app with requestAwareLinkGenerator disabled

Disable the requestAwareLinkGenerator by uncommenting this line in Config.groovy

    // requestAwareLinkGenerator.enable = false

Open a terminal, cd to the directory where this project is git cloned, and:

    > grails run-app

Point your browser at the *another.localhost* domain that you put into */etc/hosts* above:

    http://another.localhost:8080/requestAwareLinkGenerator/redirector

Click on the 3 links, with the expected results being:

* refresh - browser base url stays at http://another.localhost:8080
* redirect from controller - browser base url changes to http://localhost:8080
* redirect from service - browser base url changes to http://localhost:8080


Code
-----

The code that does the grailsLinkGenerator overriding is in resources.groovy, with the implementing classes being
RequestAwareDefaultLinkGenerator & RequestAwareCachingLinkGenerator, and with configuration overrides set up, but
commented out, in Config.groovy.

The code that illustrates how this works starts in RedirectorController.groovy, but also includes RedirectorService.groovy.

TODO
----
* Tests
* Turn this into a plugin


