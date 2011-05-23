package redis.voice

import redis.clients.jedis.JedisPubSub;

abstract class JedisPubSubAdapter extends JedisPubSub {

	@Override
	public void onMessage(String arg0, String arg1) {
		println "Publishing to channel 1"
		
	}

	@Override
	public void onPMessage(String arg0, String arg1, String arg2) {
		println "Publishing to channel 2"
		
	}

	@Override
	public void onPSubscribe(String arg0, int arg1) {
		println "Publishing to channel 3"
		
	}

	@Override
	public void onPUnsubscribe(String arg0, int arg1) {
		println "Publishing to channel 4"
		
	}

	@Override
	public void onSubscribe(String arg0, int arg1) {
		println "Publishing to channel 5"
		
	}

	@Override
	public void onUnsubscribe(String arg0, int arg1) {
		println "Publishing to channel 6"
		
	}

}
