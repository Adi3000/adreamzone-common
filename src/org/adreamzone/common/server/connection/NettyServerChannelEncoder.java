/**
 * Encoder of outgoing object message/{@link NettyTransferredOrder}
 */
package org.adreamzone.common.server.connection;

import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

public class NettyServerChannelEncoder extends ObjectEncoder {

	public static final int ESTIMATED_LENGTH = 512;
	
	public NettyServerChannelEncoder(int estimatedLength) {
		super(estimatedLength);
		// TODO Auto-generated constructor stub
	}
	public NettyServerChannelEncoder() {
		super(ESTIMATED_LENGTH);
		// TODO Auto-generated constructor stub
	}
	
}
