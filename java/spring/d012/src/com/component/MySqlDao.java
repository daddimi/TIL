package com.component;

import com.frame.Dao;

public class MySqlDao implements Dao {

	@Override
	public void insert() {
		System.out.println("MySql inserted");

	}

	@Override
	public void delete() {
		System.out.println("MySql deleted");

	}

	@Override
	public void update() {
		System.out.println("MySql updated");

	}

}
