package redis.voice

import org.springframework.beans.factory.InitializingBean;
import org.cometd.bayeux.Bayeux;
import org.cometd.bayeux.Channel;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

class BayeuxService {

	def bayeux
	def bayeuxSession
	def bitacoraService
	def authService
	def timer
	def channel
	
	static transactional = true
	
	public void init() throws Exception {

		bayeuxSession = bayeux.newLocalSession()
		bayeuxSession.handshake()
		channel = bayeuxSession.getChannel('/redis')

		def jedis = new Jedis("bass.redistogo.com",9236)
		jedis.connect()
		jedis.auth "e9e049d4b35d1021c3a8c77c69ee9db6"
		def listener = new JedisPubSubAdapter() {
			public void onMessage(String key, String value) {
				if (key.equals('tropo.color')) {
					println "Publishing to channel"
					channel.publish(value)
				}
			}	
		}
		Thread.start {
			// jedis subscribe is a blocking operation that polls the redis service for changes
			jedis.subscribe listener, 'tropo.color'
		}
	}
}
