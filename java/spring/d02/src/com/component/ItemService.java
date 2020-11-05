package com.component;

import java.util.ArrayList;

import javax.annotation.Resource;

import com.frame.Dao;
import com.frame.Search;
import com.frame.Service;
import com.vo.Item;
@org.springframework.stereotype.Service("itemservice")
public class ItemService implements Service<String, Item>, Search<Integer, Integer, Item> {
	
	@Resource(name="itemdao")
	Dao dao;
	
	@Resource(name="itemdao")
	Search search;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public void register(Item v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(Item v) throws Exception {
		dao.update(v);
	}

	@Override
	public Item get(String k) throws Exception {
		return (Item) dao.select(k);
	}

	@Override
	public ArrayList<Item> get() throws Exception {
		return dao.select();
	}

	@Override
	public ArrayList<Item> search(Integer k) throws Exception {
		return search.search(k);
	}

	@Override
	public ArrayList<Item> search(Integer k1, Integer k2) throws Exception {
		return search.search(k1,k2);
	}

}
