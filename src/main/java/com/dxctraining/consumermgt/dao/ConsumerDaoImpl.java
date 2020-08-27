package com.dxctraining.consumermgt.dao;

import com.dxctraining.consumermgt.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ConsumerDaoImpl implements ConsumerDao{

	    @PersistenceContext
	    private EntityManager em;

	    @Override
	    public Consumer findConsumerById(int id) {
	        Consumer consumer=em.find(Consumer.class,id);
	        
	        return consumer;
	    }

	    //DepartmentDto department = fetchFromDepartmentAppById(departmentId);
	    @Override
	    public Consumer addConsumer(Consumer consumer) {
	        em.persist(consumer);//insertion
	        return consumer;
	    }

	   

}
