/**
 * Manager of server handler based on this architecture
 */
package com.adreamzone.common.server.connection;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;

public class NettyServerChannelPipelineFactory implements
		ChannelPipelineFactory {

	public ChannelPipeline getPipeline() throws Exception {
		// TODO Auto-generated method stub
		return Channels.pipeline(
				new NettyServerChannelEncoder(),
				new NettyServerChannelDecoder(),
				new NettyServerClientHandler()
			);
	}

}
