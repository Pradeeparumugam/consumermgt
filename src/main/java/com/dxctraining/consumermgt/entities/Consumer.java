package com.dxctraining.consumermgt.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Consumer {
	@Id
	private int cid;
	private String name;
	public Consumer(int cid,String name) {
		this.cid=cid;
		this.name=name;
	}
	public Consumer(){
		
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
