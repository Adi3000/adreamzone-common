package org.adreamzone.common.engine;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

import model.creature.build.Creature;
import model.creature.build.Statistics;
import model.users.User;
import engine.common.Order;
import engine.common.OrderType;
import engine.security.Security;
import engine.server.connection.NettyServerChannelControl;

public class ServerEngine extends Engine {
	
	//TODO Manage multiple thread for each different treatment or decrease overload treatment
	public static final ServerEngine test = new ServerEngine();  
	public static final SortedMap<Integer,User> CONNECTED_USERS = new TreeMap<Integer, User>();
	
	
	public Order answerFor(Order o)
	{
		EngineLog.SERVER.fine("About to compute :" + o);
		return super.answerFor(o);
	}
	
	@Override
	protected Order createSession(int clientHashCode,SocketAddress from)
	{
		int sessionId = Security.generateSessionID(clientHashCode,from);
		
		if(sessionId != Security.ERROR){
			CONNECTED_USERS.put(sessionId,User.ANONYMOUS_USER);
			return new Order(OrderType.CONNECT, sessionId);
		}else{
			//Throw an error order if user can't be authenticated by hashCode
			return new Order(OrderType.ERROR, "Not a valid user : " + sessionId);
		}
		//TODO In future case, throw an non-implemented error if something get wrong 
		//return null;
	}

	@Override
	protected Order process(Order o) {
		// //TODO finalize multiple treatment for each OrderType
		Order response = null;
		if(o != null){
			switch(o.getOrderType())
			{
				case AUTH : 
					EngineLog.SERVER.info(
							"Recived an Auth permission from "+ 
							o.getParentOrder().getSocketAddress() +
							Arrays.toString(((String[])o.getInstruction())));
					response = Order.ACK;
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
				case ERROR :
					if(o.getInstruction() != null)
						EngineLog.SERVER.info("Server return error : "+o.getInstruction() );
				default:
					response =  new Order(OrderType.ERROR , null);
			}
		}else{
		//if no order submitted, o is null, response is null
			response = o;
		}
		return response;
	}
	
	
	
}
