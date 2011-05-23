package redis.voice

import redis.clients.jedis.Jedis;

class RedisService {

    static transactional = true

    def sendColor(color) {

		def jedis = new Jedis("bass.redistogo.com",9236)
		jedis.connect()
		jedis.auth "e9e049d4b35d1021c3a8c77c69ee9db6"
		
		println "publishing color 2 ${color}"
		jedis.publish "tropo.color", color
    }
}
