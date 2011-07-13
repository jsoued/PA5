package org.jbs2011.jsoued;

public class Question extends Node{

	//protected Node previous;
	//protected Node yes;
	//protected Node no;
	private String question;

	
	public Question(String question){
		
		this.previous = null;
		this.yes = null;
		this.no = null;
		this.question = question;
	}


	public Question(String question, Node previous){
		
		this.previous = previous;
		this.yes = null;
		this.no = null;
		this.question = question;
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
	public Node getPrevious() {
		
		return this.previous;
	}

	@Override
	public String getQuestion() {
		
		return question;
	}

	public String getAnimal() {
		// TODO Auto-generated method stub
		return null;
	}
}