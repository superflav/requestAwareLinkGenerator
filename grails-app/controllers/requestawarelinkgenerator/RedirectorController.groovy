package requestawarelinkgenerator

class RedirectorController {

    def redirectorService

    def index() {}

    def redirectBackToIndex() {
        flash.message = "redirectBackToIndex redirected you here."
        redirect(action: "index")
    }

    def redirectBackToIndexFromService() {
        flash.message = "redirectBackToIndexFromService redirected you here."
        redirect(uri: redirectorService.redirectBackToIndex())
    }

}
