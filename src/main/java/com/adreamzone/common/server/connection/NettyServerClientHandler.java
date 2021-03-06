package com.adreamzone.common.server.connection;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

import com.adreamzone.common.Order;
import com.adreamzone.common.engine.EngineLog;
import com.adreamzone.common.engine.ServerEngine;



public class NettyServerClientHandler extends SimpleChannelUpstreamHandler {
	
	//TODO Must set multiple thread to compute answer
	private static ServerEngine engine =  ServerEngine.test;
	
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		// Echo back the received object to the client.
		Order m = (Order)e.getMessage();
		m.setSocketAddress(e.getRemoteAddress());
		if(!m.isAsynchronous()){
			EngineLog.SERVER.fine("["+m.getSessionId()+"]\tAbout to compute : " + m);
			Order response = engine.answerFor(m);
			EngineLog.SERVER.fine("["+m.getSessionId()+"]\tResponse computed : " + response);
			if(response != null)
				e.getChannel().write(response);
		}
		else{
			//TODO not implemented yet
			EngineLog.SERVER.warning("Async message : " + m);
		}
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
	{
		EngineLog.SERVER.severe("ClientHandler broken : " + e.getCause().getMessage() + "\n" );
		e.getCause().printStackTrace();
		
	}

}
