package redis.voice

import com.tropo.grails.TropoBuilder
import grails.converters.JSON

class TropoController {

	def redisService
	
    def index = { 
		
		def color
		def tropoPost = request.JSON
		def tropo = new TropoBuilder()
		
		if (tropoPost.session) {
			// First call		
			tropo.say("Welcome to the Redis and socket I O test.")
		}
		if (tropoPost.result) {
			color = tropoPost?.result?.actions?.concept
		}
		
		if (color == 'stop') {
			tropo.hangup()
		} else {
			if (color) {
				redisService.sendColor(color)
			}				
			tropo.ask(name:'redis', timeout: 20) {
				say("Say the color you want to see. When done, say stop.")
				choices(value: 'white, blue, green, yellow, red, stop')
			}
			tropo.on(event:'continue', next:'index')
		}
		tropo.render(response)		
	}
}
