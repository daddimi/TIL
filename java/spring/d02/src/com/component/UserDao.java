package com.component;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.UserMapper;
import com.vo.User;
@Repository("userdao")
public class UserDao implements Dao<String, User> {
	@Autowired
	UserMapper um;
	@Override
	public void insert(User v)  throws Exception{
		System.out.println("Inserted:"+v);
		um.insert(v);
	}

	@Override
	public void delete(String k)  throws Exception{
		System.out.println("Deleted:"+k);
		um.delete(k);
	}

	@Override
	public void update(User v)  throws Exception{
		System.out.println("Updated:"+v);
		um.update(v);
	}

	@Override
	public User select(String k)  throws Exception{
		User user = um.select(k);
		return user;
	}

	@Override
	public ArrayList<User> select()  throws Exception{
		ArrayList<User> list = um.selectall();
		return list;
	}


}




