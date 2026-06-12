package com.itbulls.rahman.entity;

import java.io.Serializable;
import java.util.Map;


public class Employee implements Serializable, Cloneable{

	private static final long SerialVersionUID = 1L;
	
	private int id;
	private String name;
	private Map<String, String> props;
	

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public void setProps(Map<String, String> p) {
		this.props = p;
	}
	
	public Map<String, String> getProps()
	{
		return this.props;
	}
	
	@Override
	public String toString() {
		return id + ", " + name + ", " + props;
		
	}
	
	
	
}
