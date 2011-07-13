package org.jbs2011.jsoued;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;


public class Questions20 extends Activity {

	TextView tview;
	EditText etext;
	String user;
	boolean repeat = true;
	Node main;
	Node newA;
	Node newQ;
	Node next;


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tview = (TextView) this.findViewById(R.id.regulartext);
        
        main = new Question("Does it have stripes?");
        main.addYes(new Animal("zebra"));
        main.addNo(new Animal("kangaroo"));
		
        next = main;

		tview.setText(main.getQuestion());
		
		etext = (EditText) findViewById(R.id.textbox);
		etext.setOnKeyListener(new OnKeyListener() {
            
			public boolean onKey(View v, int keyCode, KeyEvent event) {
                
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                	user = etext.getText().toString().toLowerCase();
                  
                	etext.setText(null); 
                	tview.setText(getOutput()); 
                	
                	return true;
                }
                
                return false;
            }
        });   
    }
    
    public String getOutput(){

    	if(user.toLowerCase().equals("yes")){
    		
    		if (main.isYes()) {
    			
				main = main.getYes();
				
				return main.getQuestion();
			
    		} else {
    			
    			return ("Computer wins! Wanna play again? (p to play, x to exit)");
    		}
    	
    	} else if (user.toLowerCase().equals("no")){
    		
    		if(main.isNo()){
    			
    			main = main.getNo();
    			
    			return main.getQuestion();
    		
    		} else {
    			
    			if(main instanceof Animal){
    				
    				Animal anim = (Animal) main;
    				
    				return ("Please write a question that would be true for your animal and false for a " + anim.getAnimal());
    			
    			} else {
    				
    				return null;
    			}
    		}
    		
    	} else if (user.contains("?")){
    		
    		newQ = new Question(user);
    		
    		return ("What was your animal?");
    		
    	} else if(user.equals("p")){
    		
    		main = next;
    		
    		return main.getQuestion();
    		
    	} else if(user.equals("x")){
    		
    		finish();
    		
    		return null;
    		
    	} else {
    		
    		newA= new Animal(user);
    		
    		build();
    		
    		return("Wanna play again? (p to play, x to exit)");
    	}
    }
    
    
	public void build(){
		
		Node previous = main.getPrevious();

		if(previous.getNo().equals(main)){
			
			previous.addNo(newQ);
			
		} else {
			
			previous.addYes(newQ);
		}

		newQ.addNo(main);
		newQ.addYes(newA);
	} 
}