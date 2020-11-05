package com.component;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.frame.Search;
import com.mapper.ItemMapper;
import com.vo.Item;
@Repository("itemdao")
public class ItemDao implements Dao<String, Item> , Search<Integer, Integer, Item>{
	@Autowired
	ItemMapper im;
	@Override
	public void insert(Item v) throws Exception  {
		System.out.println("Inserted:"+v);		
		im.insert(v);
	}

	@Override
	public void delete(String k) throws Exception {
		System.out.println("Deleted:"+k);
		im.delete(k);
	}

	@Override
	public void update(Item v) throws Exception {
		System.out.println("Updated:"+v);
		im.update(v);
	}

	@Override
	public Item select(String k) throws Exception {
		Item item = im.select(k);
		return item;
	}

	@Override
	public ArrayList<Item> select() throws Exception {
		ArrayList<Item> list = im.selectall();
		return list;
	}

	@Override
	public ArrayList<Item> search(Integer k) throws Exception {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("it01","pants",10000,new Date()));
		list.add(new Item("it02","pants",20000,new Date()));
		return list;
	}

	@Override
	public ArrayList<Item> search(Integer k1, Integer k2) {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item("it01","pants",10000,new Date()));
		list.add(new Item("it02","pants",20000,new Date()));
		list.add(new Item("it03","pants",30000,new Date()));
		return list;

	}
	

}
