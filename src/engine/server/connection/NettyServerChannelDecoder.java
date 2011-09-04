/**
 * Decoder of incoming object message/{@link NettyTransferredOrder}
 */
package engine.server.connection;

import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

public class NettyServerChannelDecoder extends ObjectDecoder {

	public static final int MAX_FRAME_LENGTH = 512;
	
	public NettyServerChannelDecoder(int maxFrameLength) {
		super(maxFrameLength);
		// TODO Auto-generated constructor stub
	}
	
	public NettyServerChannelDecoder() {
		super(MAX_FRAME_LENGTH);
		// TODO Auto-generated constructor stub
	}	

}
