package com.redefine.service;

import java.util.List;

import com.redefine.model.Item;

public interface ItemService {
	public void add(Item item) throws Exception;
	public List<Item> getList() throws Exception;
	public Item getItem(int id) throws Exception;
	public void update(Item item) throws Exception;
}
