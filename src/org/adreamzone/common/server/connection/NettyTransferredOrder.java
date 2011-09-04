/**
 * Implementation of Order to improve redirecting replies and quick operation
 * on user concerned.
 */
package org.adreamzone.common.server.connection;

import java.io.Serializable;

import org.adreamzone.common.Order;
import org.adreamzone.common.OrderType;


public class NettyTransferredOrder extends Order {
	/**
	 * from who come instruction and where to put answer
	 */
	private UserChannel from;
	
	public NettyTransferredOrder(OrderType orderType, Serializable instruction) {
		super(orderType, instruction);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param from set the {@link UserChannel} from who come instruction and where to put
	 */
	public void setFrom(UserChannel from) {
		this.from = from;
	}
	/**
	 * @return the {@link UserChannel}
	 */
	public UserChannel getFrom() {
		return from;
	}

}
