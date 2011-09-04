package org.adreamzone.common.server.connection;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.adreamzone.common.engine.EngineLog;
import org.jboss.netty.bootstrap.ServerBootstrap;
/**
 * Connection manager. Open a binding port to listen and "may" receipt client
 * connection (not sure because of my few understanding of Netty Framework) 
 */
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;


public class NettyServerChannelControl {
	
	private ServerBootstrap bootstrap;
	public static final int PORT = 7777;
	
	public void init(){
		//Using Executors to manage Threads
		bootstrap = new ServerBootstrap(
                  new NioServerSocketChannelFactory(
                          Executors.newCachedThreadPool(),
                          Executors.newCachedThreadPool()));
		//NettyServerChannelPipelineFactory contains NettyServerChannelHandler based Pipeline
		bootstrap.setPipelineFactory(new NettyServerChannelPipelineFactory());
		// Bind and start to accept incoming connections.
		bootstrap.bind(new InetSocketAddress(PORT));
		EngineLog.SERVER.info("Connection Manager Started, binding on "+PORT);
	}
	
	public void finish(){
		EngineLog.SERVER.info("Is about to end binding on "+PORT);
		bootstrap.releaseExternalResources();
	}
}
