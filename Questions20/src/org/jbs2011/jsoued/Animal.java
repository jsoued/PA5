package org.jbs2011.jsoued;

public class Animal extends Node{

	//protected Node previous;
	//protected Node yes;
	//protected Node no;
	private String name;

	
	public Animal(String name){
		
		this.previous = null;
		this.yes = null;
		this.no = null;
		this.name = name;
	}


	public Animal(String name, Node previous){
		
		this.previous = previous;
		this.yes = null;
		this.no = null;
		this.name = name;
	}

	@Override
	public Node getYes() {
		
		return this.yes;
	}

	@Override
	public Node getNo() {
		
		return this.no;
	}
	
	@Override
	public boolean isYes() {
		
		if(this.yes == null){
			
			return false;
		}
		
		return true;
	}

	@Override
	public boolean isNo() {
		
		if(this.no == null){
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public void addYes(Node nodeyes) {
		
		this.yes = nodeyes;
		nodeyes.previous = this;
	}

	@Override
	public void addNo(Node nodeno) {
		
		this.no = nodeno;
		nodeno.previous = this;
	}

	@Override
	public String getAnimal() {
		
		return name;
	}
	
	@Override
	public String getQuestion() {
		
		return "Is your animal a " + name + "?";
	}

	@Override
	public Node getPrevious() {
		
		return this.previous;
	}

}
