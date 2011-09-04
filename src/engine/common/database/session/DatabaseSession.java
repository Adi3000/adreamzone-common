package engine.common.database.session;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.loader.custom.sql.SQLCustomQuery;

import engine.EngineLog;
import engine.common.database.IDatabaseConstants;
import engine.common.database.data.AbstractDataObject;

public class DatabaseSession {

	private Session session;

	/**
	 * Return true if a persist is engaged on this session. (It means 
	 * that a transaction has began and has not finished yet)
	 * @return
	 */
	public boolean isSetForCommitting() {
		// TODO Auto-generated method stub
		return session != null || session.getTransaction().isActive();
	}

	/**
	 * Initialize session for a modification request
	 */
	private void initSession() {
		// TODO Auto-generated method stub
		openSession();		
		this.session.beginTransaction();
	}
	
	public void persist(ArrayList<AbstractDataObject> toCommitList){
		initSession();
		for(AbstractDataObject modelData : toCommitList)
		{
			//TODO Set case for update, delete or insert
			switch(modelData.getDatabaseOperation())
			{
				case IDatabaseConstants.DELETE :
					EngineLog.SERVER.fine("Will delete "+modelData +" on table " + modelData.getTableName());
					session.delete(modelData);
				case IDatabaseConstants.INSERT :
					EngineLog.SERVER.fine("Will insert "+modelData +" on table" + modelData.getTableName());
					session.save(modelData);
				case IDatabaseConstants.INSERT_OR_UPDATE :
					EngineLog.SERVER.fine("Will insert or update "+modelData +" on table " + modelData.getTableName());
					session.saveOrUpdate(modelData);
				default :
					EngineLog.SERVER.severe("Will insert or update "+modelData +" on table " + modelData.getTableName());
					
			}
		}
	}
	
	public boolean commit(){
		if(isSetForCommitting()){
			session.getTransaction().commit();
			return true;
		}
		return false;		
	}
	
	@SuppressWarnings("unchecked")
	public List<AbstractDataObject> getListOfSqlRequest(String sqlRequest)
	{
		openSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlRequest);
		List<AbstractDataObject> list =  sqlQuery.list();
		return list;
	}
	
	private void openSession()
	{
		if(session == null)
			session = HibernateUtils.getSessionFactory().openSession();
	}

	public AbstractDataObject getDataObject(AbstractDataObject model)
	{
		openSession();
		AbstractDataObject toReturn = (AbstractDataObject)session.get(model.getClass(), model.getId());
		
		return toReturn;
	}
}
