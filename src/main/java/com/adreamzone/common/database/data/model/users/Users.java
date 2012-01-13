package com.adreamzone.common.database.data.model.users;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.adreamzone.common.database.session.DatabaseSession;

public class Users extends DatabaseSession{
	
	public User getUserByLogin(String login){
		Criteria req = this.session.createCriteria(User.class)
				.setMaxResults(1)
				.add(Restrictions.eq("login", login)) ;
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>)req.list();
		
		return users.isEmpty() ?  null : users.get(0);
	}

	
}
