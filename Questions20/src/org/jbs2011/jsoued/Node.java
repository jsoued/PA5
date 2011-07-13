package org.jbs2011.jsoued;

public abstract class Node {
	
	protected Node previous;
	protected Node yes;
	protected Node no;
	
	public abstract void addYes(Node nodeyes);
	public abstract void addNo(Node nodeno);
	public abstract String getQuestion();
	public abstract String getAnimal();
	public abstract Node getYes();
	public abstract Node getNo();
	public abstract boolean isYes();
	public abstract boolean isNo();
	public abstract Node getPrevious();
}
