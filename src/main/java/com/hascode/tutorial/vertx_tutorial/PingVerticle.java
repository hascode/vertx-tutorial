package com.hascode.tutorial.vertx_tutorial;

import org.vertx.java.core.Handler;
import org.vertx.java.core.net.NetSocket;
import org.vertx.java.core.streams.Pump;
import org.vertx.java.platform.Verticle;

public class PingVerticle extends Verticle {

	@Override
	public void start() {
		vertx.createNetServer().connectHandler(new Handler<NetSocket>() {
			@Override
			public void handle(final NetSocket socket) {
				Pump.createPump(socket, socket).start();
			}
		}).listen(1234);
	}
}
