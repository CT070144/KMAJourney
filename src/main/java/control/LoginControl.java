package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.LoginView;


public class LoginControl implements ActionListener {
        private LoginView view;
        public LoginControl(LoginView view) {
    		this.view = view;
    	}
        
		@Override
		public void actionPerformed(ActionEvent e) {
			String sc = e.getActionCommand();
			try {
			if(sc.equals("Login")) 
			{
				
			      this.view.check2();
		     
			}
			}
			catch(Exception a){
				a.printStackTrace();
			}}

		
		
			}
			
		
        

