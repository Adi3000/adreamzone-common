/**
 * Account which will interact with {@link DreamedElement} to be owner and author
 */
package com.adreamzone.common.database.data.model.users;


import java.sql.Timestamp;

import com.adreamzone.common.database.data.AbstractDataObject;
import com.adreamzone.common.database.data.model.creature.build.Creature;


public class User extends AbstractDataObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1345564181714215141L;
	public static final User ANONYMOUS_USER = new User();
	public static final String TABLE_AND_ENTITY_NAME = "USERS";
	
	private int id;
	private String login;
	private int token;
	private Timestamp lastDateLogin;
	private Creature mainCreature;
	private String password;
	private String mail;
	private String lastHostNameLogin;
	private String lastIpLogin;
	
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
	public void setToken(int token) {
		this.token = token;
	}
	/**
	 * @return the token
	 */
	public int getToken() {
		return token;
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
	/**
	 * @return the lastHostNameLogin
	 */
	public String getLastHostNameLogin() {
		return lastHostNameLogin;
	}
	/**
	 * @param lastHostNameLogin the lastHostNameLogin to set
	 */
	public void setLastHostNameLogin(String lastHostNameLogin) {
		this.lastHostNameLogin = lastHostNameLogin;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @return the lastDateLogin
	 */
	public Timestamp getLastDateLogin() {
		return lastDateLogin;
	}
	/**
	 * @param lastDateLogin the lastDateLogin to set
	 */
	public void setLastDateLogin(Timestamp lastDateLogin) {
		this.lastDateLogin = lastDateLogin;
	}
	/**
	 * @return the lastIpLogin
	 */
	public String getLastIpLogin() {
		return lastIpLogin;
	}
	/**
	 * @param lastIpLogin the lastIpLogin to set
	 */
	public void setLastIpLogin(String lastIpLogin) {
		this.lastIpLogin = lastIpLogin;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return TABLE_AND_ENTITY_NAME;
	}

	
	

}
