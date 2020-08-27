package com.dxctraining.consumermgt.service;


import com.dxctraining.consumermgt.entities.Consumer;


public interface ConsumerService {
	public Consumer addConsumer(Consumer c1);
	public Consumer findById(int id);
}
