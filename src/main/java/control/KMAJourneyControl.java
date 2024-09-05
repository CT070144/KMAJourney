package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.KMAJourneyView;

public class KMAJourneyControl implements ActionListener {
        KMAJourneyView view ;
        public KMAJourneyControl(KMAJourneyView view) {
        	this.view = view;
        }
	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		
		switch(ac) {
		case " Fetch":{
		
			this.view.fetch();
			break; 		
		}
		case "Được phát triển bởi NguyenVanPhuc":{
			
			this.view.hienThiAbout();
			break;
		}
		case "Lọc":{
			this.view.fetch();
			this.view.locBang();
			break;
		}
		case "Exit":{
			this.view.exit();
			break;
		}
		
		
		}
		
	}

}
