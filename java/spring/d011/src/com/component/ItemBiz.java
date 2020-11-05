package com.component;

import com.biz.Biz;

public class ItemBiz implements Biz {
	public ItemBiz() {
		System.out.println("Item Biz Constructor ....");
	}
	@Override
	public void register() {
		System.out.println("Item Register");

	}

	@Override
	public void remove() {
		System.out.println("Item Remove");

	}

	@Override
	public void modify() {
		System.out.println("Item Modify");

	}

}
