package test;

import java.sql.Timestamp;

import org.hibernate.Session;

import com.adreamzone.common.database.data.model.creature.build.Creature;
import com.adreamzone.common.database.data.model.creature.build.Statistics;
import com.adreamzone.common.database.data.model.users.User;
import com.adreamzone.common.database.session.HibernateUtils;
import com.adreamzone.common.engine.EngineLog;
import com.adreamzone.common.server.connection.NettyServerChannelControl;

public class ServerTest {

	public static final String JDBC_DRIVER = "org.postgresql.Driver";
	/**
	 * @param args
	 */
	public static void main(String[] args){
		int[] bonusStart= Statistics.createBonusStart(150, 150, 60, 30, 20, 20);
		Statistics stats = new Statistics(bonusStart);
		Creature c = new Creature("Test","1",stats);
		System.out.println(c.getStats());
		for(int i=0; i < 10 ; i++){
			c.progress(1);
		}
		
		//ClientConnectionManager connManager = new ClientConnectionManager();
		//connManager.start();
		NettyServerChannelControl connManager = new NettyServerChannelControl();
		connManager.init();
		try {
			Class.forName(JDBC_DRIVER);
			EngineLog.SERVER.fine("Driver " + JDBC_DRIVER + " found");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = new User();
        user.setLogin("Test");
        user.setLastDateLogin(new Timestamp(new java.util.Date().getTime()));
        EngineLog.SERVER.info("Ready to save user");
        
        session.save(user);
        EngineLog.SERVER.info("Commiting changes");
        session.getTransaction().commit();
		/*String database = "ADreamZone_dev";
		String host = "192.168.26.1";
		String port = "5432";
		String prefix = "jdbc:postgresql://";
		
		String url = prefix + host + ":" + port +"/" + database;
		Properties props = new Properties();
		props.setProperty("user","a-dream-zone");
		props.setProperty("password","a-dream-zone");
		try {
			Connection conn = DriverManager.getConnection(url, props);
			EngineLog.SERVER.info("Connected to database "+ url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			props.remove("password");
			EngineLog.SERVER.severe("Failed to connect to "+ url + " with "+props + "\n"+e.getMessage());
		}
		System.exit(0);*/
	}

}
