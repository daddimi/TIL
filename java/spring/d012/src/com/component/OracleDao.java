package com.component;

import com.frame.Dao;

public class OracleDao implements Dao {

	@Override
	public void insert() {
		System.out.println("Oracle inserted");
	}

	@Override
	public void delete() {
		System.out.println("Oracle deleted");

	}

	@Override
	public void update() {
		System.out.println("Oracle updated");

	}

}
