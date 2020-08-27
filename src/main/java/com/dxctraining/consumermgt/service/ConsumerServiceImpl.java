package com.dxctraining.consumermgt.service;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.consumermgt.dao.ConsumerDao;
import com.dxctraining.consumermgt.entities.Consumer;
import com.dxctraining.consumermgt.exception.*;


@Transactional
@Service
public class ConsumerServiceImpl implements ConsumerService{
	@Autowired
	private ConsumerDao dao;
	
	public Consumer addConsumer(Consumer c1) {
		verify(c1);
		 c1=dao.addConsumer(c1);
		return c1;
	}
	public Consumer findConsumerById(int id) {
		verify(id);
		Consumer c1=dao.findConsumerById(id);
		return c1;
	}
	public void verify(Object ob) {
		if(ob==null) {
			throw new NotValidException("Not Valid");
			}
		}

}
