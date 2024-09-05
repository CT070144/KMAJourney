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
//		    HocPhan hp = new HocPhan("Tin học đại cương", 8.5, 10, 7.2, 7.7, 'B', 'CT070144');
//		    hp.
//		    
//		    SinhVien a = new SinhVien();
//		    a.setMaSinhVien("CT070144");
//		    a.setTenSinhvien("Nguyễn Văn Phúc");
//		    a.setKhoa("Công nghệ thông tin");
//		    a.setLop("CT7A");
//		    session.save(a);
//			tr.commit();
//			session.close();}
	//KMAJourneyView ex = new KMAJourneyView();
   LoginView ex  = new LoginView();
			
}
}






















