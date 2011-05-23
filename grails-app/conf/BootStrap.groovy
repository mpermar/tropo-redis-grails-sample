class BootStrap {

	def bayeuxService
	
    def init = { servletContext ->
		
		bayeuxService.init()
    }
    def destroy = {
    }
}
