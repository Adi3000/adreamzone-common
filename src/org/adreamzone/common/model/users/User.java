/**
 * Account which will interact with {@link DreamedElement} to be owner and author
 */
package org.adreamzone.common.model.users;


import java.sql.Date;

import org.adreamzone.common.database.data.AbstractDataObject;
import org.adreamzone.common.model.creature.build.Creature;



public class User extends AbstractDataObject{
	
	public static final User ANONYMOUS_USER = new User();
	public static final String TABLE_AND_ENTITY_NAME = "USERS";
	
	private int id;
	private String login;
	private String token;
	private Date lastConnection;
	private Creature mainCreature;
	private String password;
	
	public Integer getId()
	{
		return id;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param lastConnection the lastConnection to set
	 */
	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}
	/**
	 * @return the lastConnection
	 */
	public Date getLastConnection() {
		return lastConnection;
	}
	/**
	 * @param mainCreature the mainCreature to set
	 */
	public void setMainCreature(Creature mainCreature) {
		this.mainCreature = mainCreature;
	}
	/**
	 * @return the mainCreature
	 */
	public Creature getMainCreature() {
		return mainCreature;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return TABLE_AND_ENTITY_NAME;
	}
	
	

}
