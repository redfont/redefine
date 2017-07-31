package com.redefine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redefine.dao.ItemDao;
import com.redefine.model.Item;
import com.redefine.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public void add(Item item) throws Exception {
		itemDao.add(item);
	}

	@Override
	public List<Item> getList() throws Exception {
		return itemDao.getList();
	}

	@Override
	public Item getItem(int id) throws Exception {	
		return itemDao.getItem(id);
	}

	@Override
	public void update(Item item) throws Exception {
		itemDao.update(item);
	}
}
