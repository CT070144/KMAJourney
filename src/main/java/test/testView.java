package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




import model.HocPhan;
import model.SinhVien;
import util.HibernateUtil;
import view.KMAJourneyView;
import view.LoginView;

public class testView {
 public static void main(String[] args) {
//	 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		if (sessionFactory != null) {
//			Session session = sessionFactory.openSession();
//			Transaction tr = session.beginTransaction();
//	
//		  
//		    
//		    SinhVien res = session.get(SinhVien.class, "CT070144");
//		    
//		    System.out.println(res.toString());
//		    List<HocPhan> hp = res.getHocPhan();
//		    for(HocPhan x: hp) {
//		    	System.out.println(x.toString());
//		    }
//			
//			
//			tr.commit();
//			session.close();}
//	KMAJourneyView ex = new KMAJourneyView();
	LoginView ex  = new LoginView();
			
}
}
 






















