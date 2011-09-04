package org.adreamzone.common.engine;

import java.io.Serializable;
import java.net.SocketAddress;

import org.adreamzone.common.Order;
import org.adreamzone.common.OrderType;
import org.adreamzone.common.model.creature.build.Creature;
import org.adreamzone.common.model.creature.build.Statistics;

//TODO invert Inherit or make a specific class of Engine for server
public abstract class Engine {

	public static final boolean DEBUG_MODE = true;

	public Order answerFor(Order o){
		//TODO finalize multiple treatment for each OrderType
		Order response = null;
		if(o != null){
			switch(o.getOrderType())
			{
				case UPDATE : 
					if(o.getInstruction().getClass().isAssignableFrom(Order.class))
					{
						((Order)(o.getInstruction())).setParentOrder(o);
					}
					response = this.process((Order)o.getInstruction());
					break;
				case ACK :
					//Response stay null
					break;
				case ECHO : 
					response = new Order(OrderType.INFO, o.getInstruction());
					break;
				case INFO:
					response = Order.ACK;
					break;
				case CONNECT:
					response = this.createSession((Integer)(o.getInstruction()),o.getSocketAddress());
					break;
				case ERROR :
					if(o.getInstruction() != null)
						EngineLog.SERVER.severe("Server return error : "+o.getInstruction() );
					break;
				default:
					response =  new Order(OrderType.ERROR , null);
					break;
			}
			response.setSessionIdFrom(o);
			if(o.hasOrderSequence())
			{
				response.setOrderSequence(o.getOrderSequence());
			}
		}else{
		//if no order submitted, o is null, response is null
			response = o;
		}
		return response;
	}

	protected abstract Order process(Order instruction);

	public boolean receive(String readLine) {
		EngineLog.SERVER.info("Recieve an answer "+readLine );
		return true;
	}
	
	/**
	 * Must be implemented for server mode. Client can't create session
	 * For client, its receipt the sessionId in hashCode of the user successfully connected 
	 * @param socketAddress 
	 * @param hashCode
	 * @return null if session can't be created
	 */
	protected abstract Order createSession(int hashCode, SocketAddress socketAddress);
}
