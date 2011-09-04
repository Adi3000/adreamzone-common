package engine.security;

import java.net.SocketAddress;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import engine.EngineLog;
import engine.common.utils.optimizer.CommonValues;

import model.users.User;

/**
 * Utilities of static methods to provide encrypt and decrypt procedures.
 * @author adi
 *
 */
public class Security {
	
	public static final int ERROR = CommonValues.ERROR_OR_INFINITE;  
	
	private static Set<Integer> ANONYMOUS_SESSION_ID = new TreeSet<Integer>();

	public static int generateSessionID(int clientHashCode,SocketAddress client) {
		// TODO Auto-generated method stub
		EngineLog.SERVER.info("Anonymous UUID Session asked from " + client.toString());
		UUID uuid = UUID.randomUUID(); 
		int uuidHash = uuid.hashCode();
		EngineLog.SERVER.finer("UUID computed : " + uuid);
		if (ANONYMOUS_SESSION_ID.add(uuidHash) )
		{
			return uuidHash;
		}
		return ERROR;
	}

}
