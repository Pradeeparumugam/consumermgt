package com.dxctraining.consumermgt.dao;

import com.dxctraining.consumermgt.entities.Consumer;

public interface ConsumerDao {
	public Consumer addConsumer(Consumer consumer);
	public Consumer findConsumerById(int id);

}
