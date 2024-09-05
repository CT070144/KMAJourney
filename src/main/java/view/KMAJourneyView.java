package view;



import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import control.KMAJourneyControl;
import model.HocPhan;
import model.SinhVien;
import net.bytebuddy.asm.Advice.This;
import util.HibernateUtil;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.SwingConstants;



public class KMAJourneyView extends JFrame {
    private SinhVien sinhVienModel = null;
    private List<HocPhan> hocPhanModel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Container menuBar;
	private JTextField masinhvienfetch;
	private JTable table;
	private JTextField masinhvien;
	private JTextField khoa;
	private JTextField lop;
	private JTextField hovaten;
	private JTextField trangthai;
	private JComboBox comboBox;
	private JTextField gpa;
	private JTextField top;

	public KMAJourneyView() {
		
		sinhVienModel = new SinhVien();
		hocPhanModel = new ArrayList<HocPhan>();
		this.setTitle("KMA Journey");
		URL url = KMAJourneyView.class.getResource("Image.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(img);
		
	KMAJourneyControl actionListener = new KMAJourneyControl(this);	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1050, 711);
	this.setLocationRelativeTo(null);
	
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	
   // QLSVController actionListener = new QLSVController(this);
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(20, 0, 76, 21);
	contentPane.add(menuBar);
	
	JMenu mnNewMenu = new JMenu("File");
	mnNewMenu.setFont(new Font("Arial", Font.BOLD, 12));
	menuBar.add(mnNewMenu);
	
	JMenuItem mntmNewMenuItem = new JMenuItem("Open");
    //mntmNewMenuItem.addActionListener(actionListener);
	mnNewMenu.add(mntmNewMenuItem);
	
	JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save as");
	//mntmNewMenuItem_1.addActionListener(actionListener);
	mnNewMenu.add(mntmNewMenuItem_1);
	
	JSeparator separator = new JSeparator();
	mnNewMenu.add(separator);
	
	JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
	mntmNewMenuItem_2.addActionListener(actionListener);
	mnNewMenu.add(mntmNewMenuItem_2);
	
	JMenu mnNewMenu_1 = new JMenu("About");

	mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 12));
	menuBar.add(mnNewMenu_1);
	
	JMenuItem mntmNewMenuItem_3 = new JMenuItem("Được phát triển bởi NguyenVanPhuc");
	mntmNewMenuItem_3.addActionListener(actionListener);
	mntmNewMenuItem_3.setFont(new Font("Cambria", Font.ITALIC, 12));
	mnNewMenu_1.add(mntmNewMenuItem_3);
	
	JLabel lblNewLabel = new JLabel("KMA Journey");
	lblNewLabel.setFont(new Font("Dubai Medium", Font.BOLD, 30));
	lblNewLabel.setBounds(802, 46, 179, 60);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setIcon(new ImageIcon(KMAJourneyView.class.getResource("/view/Seanau-Kungfu-Panda-Squirrel.64.png")));
	lblNewLabel_1.setBounds(0, 612, 60, 60);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Mã sinh viên");
	lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
	lblNewLabel_2.setBounds(56, 67, 108, 27);
	contentPane.add(lblNewLabel_2);
	
	masinhvienfetch = new JTextField();
	masinhvienfetch.setFont(new Font("Arial", Font.PLAIN, 16));
	masinhvienfetch.setBounds(166, 61, 222, 33);
	contentPane.add(masinhvienfetch);
	masinhvienfetch.setColumns(10);
	
	JButton btnNewButton = new JButton(" Fetch");
	
	btnNewButton.addActionListener(actionListener);
	btnNewButton.setBackground(new Color(255, 255, 255));
	btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
	
	btnNewButton.setBounds(409, 61, 114, 33);
	contentPane.add(btnNewButton);
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(new Color(0, 0, 0));
	separator_1.setBackground(new Color(255, 255, 255));
	separator_1.setBounds(-16, 128, 1040, 2);
	contentPane.add(separator_1);
	
	
	table = new JTable();
	table.setRowHeight(20);
	table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"STT", "T\u00CAN M\u00D4N H\u1ECCC", "\u0110i\u1EC3m TP1", "\u0110i\u1EC3m TP2", "\u0110I\u1EC2M THI", "\u0110I\u1EC2M T\u1ED4NG K\u1EBET", "\u0110I\u1EC2M CH\u1EEE"
		}
	));
	table.getColumnModel().getColumn(0).setPreferredWidth(39);
	table.getColumnModel().getColumn(0).setMaxWidth(39);
	table.getColumnModel().getColumn(1).setPreferredWidth(310);
	table.getColumnModel().getColumn(1).setMinWidth(310);
	table.setBackground(new Color(255, 255, 255));
	table.setFont(new Font("Arial", Font.PLAIN, 14));
	
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBackground(new Color(255, 255, 255));
	scrollPane.setBounds(20, 180, 991, 334);
	
	table.setBounds(20, 180, 991, 334);
	contentPane.add(scrollPane);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setForeground(new Color(0, 0, 0));
	separator_2.setBounds(10, 525, 1001, 2);
	contentPane.add(separator_2);
	
	
	JLabel lblNewLabel_3 = new JLabel("BẢNG ĐIỂM CHI TIẾT");
	lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
	lblNewLabel_3.setBounds(20, 141, 179, 28);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_2_1 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1.setBounds(209, 537, 102, 29);
	contentPane.add(lblNewLabel_2_1);
	
	masinhvien = new JTextField();
	masinhvien.setFont(new Font("Arial", Font.PLAIN, 16));
	masinhvien.setBounds(311, 538, 222, 24);
	contentPane.add(masinhvien);
	masinhvien.setColumns(10);
	
	JLabel lblNewLabel_2_1_1 = new JLabel("Khóa : ");
	lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1.setBounds(209, 575, 92, 22);
	contentPane.add(lblNewLabel_2_1_1);
	
	khoa = new JTextField();
	khoa.setFont(new Font("Arial", Font.PLAIN, 16));
	khoa.setColumns(10);
	khoa.setBounds(311, 573, 222, 24);
	contentPane.add(khoa);
	
	JLabel lblNewLabel_2_1_1_1 = new JLabel("Lớp :");
	lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_1.setBounds(209, 606, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_1);
	
	JLabel lblNewLabel_2_1_1_2 = new JLabel("Họ và tên : ");
	lblNewLabel_2_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2.setBounds(559, 538, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2);
	
	JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Trạng thái : ");
	lblNewLabel_2_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2_1.setBounds(559, 573, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2_1);
	
	JLabel lblNewLabel_2_1_1_2_2 = new JLabel("Lọc theo : ");
	lblNewLabel_2_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2_2.setBounds(559, 608, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2_2);
	
	lop = new JTextField();
	lop.setFont(new Font("Arial", Font.PLAIN, 16));
	lop.setColumns(10);
	lop.setBounds(311, 608, 222, 24);
	contentPane.add(lop);
	
	hovaten = new JTextField();
	hovaten.setFont(new Font("Arial", Font.PLAIN, 16));
	hovaten.setColumns(10);
	hovaten.setBounds(647, 538, 202, 24);
	contentPane.add(hovaten);
	
	trangthai = new JTextField();
	trangthai.setFont(new Font("Arial", Font.PLAIN, 16));
	trangthai.setColumns(10);
	trangthai.setBounds(647, 573, 202, 24);
	contentPane.add(trangthai);
	
	 comboBox = new JComboBox();
	comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
	comboBox.setBackground(new Color(255, 255, 255));
	comboBox.setBounds(647, 612, 202, 22);
	 comboBox.addItem("Tất cả các môn");
     comboBox.addItem("Lọc môn ĐẠT");
     comboBox.addItem("Lọc môn TRƯỢT");
     comboBox.addItem("Lọc theo kì gần nhất");
     comboBox.addItem("Xếp hạng theo lớp");
     
     
	contentPane.add(comboBox);
	
	JButton btnNewButton_1 = new JButton("Lọc");
	btnNewButton_1.addActionListener(actionListener);
	btnNewButton_1.setBackground(new Color(255, 255, 255));
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnNewButton_1.setBounds(876, 612, 68, 23);
	contentPane.add(btnNewButton_1);
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setIcon(new ImageIcon(KMAJourneyView.class.getResource("/view/Logo Học Viện Kỹ Thuật Mật Mã - ACTVN (1).jpg")));
	lblNewLabel_4.setBounds(722, 36, 70, 70);
	contentPane.add(lblNewLabel_4);
	
	JLabel lblNewLabel_3_1 = new JLabel("THÔNG TIN SINH VIÊN");
	lblNewLabel_3_1.setForeground(new Color(0, 0, 0));
	lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
	lblNewLabel_3_1.setBounds(20, 538, 179, 28);
	contentPane.add(lblNewLabel_3_1);
	
	JSeparator separator_3 = new JSeparator();
	separator_3.setForeground(new Color(0, 0, 0));
	separator_3.setBounds(20, 561, 167, 2);
	contentPane.add(separator_3);
	
	JSeparator separator_3_1 = new JSeparator();
	separator_3_1.setForeground(Color.BLACK);
	separator_3_1.setBounds(20, 164, 167, 2);
	contentPane.add(separator_3_1);
	
	JLabel lblNewLabel_5 = new JLabel("GPA :");
	lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_5.setBounds(876, 541, 37, 21);
	contentPane.add(lblNewLabel_5);
	
	JLabel lblNewLabel_5_1 = new JLabel("TOP :");
	lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_5_1.setBounds(876, 576, 37, 21);
	contentPane.add(lblNewLabel_5_1);
	
	gpa = new JTextField();
	gpa.setHorizontalAlignment(SwingConstants.CENTER);
	gpa.setFont(new Font("Arial", Font.BOLD, 16));
	gpa.setColumns(10);
	gpa.setBounds(923, 538, 47, 24);
	contentPane.add(gpa);
	
	top = new JTextField();
	top.setHorizontalAlignment(SwingConstants.CENTER);
	top.setFont(new Font("Arial", Font.BOLD, 16));
	top.setColumns(10);
	top.setBounds(923, 573, 47, 24);
	contentPane.add(top);

	
	
   this.setVisible(true);	
  

	}
	
	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "--KMA Journey--- \n Nguyễn Văn Phúc đz😊");
	}

	public void thongTinSinhVien() {
		this.masinhvien.setText(this.sinhVienModel.getMaSinhVien());	
		this.hovaten.setText(this.sinhVienModel.getTenSinhvien());
		this.lop.setText(this.sinhVienModel.getLop());	
		this.khoa.setText(this.sinhVienModel.getKhoa());
		this.trangthai.setText(this.sinhVienModel.getTrangThai());
		this.gpa.setText(this.sinhVienModel.getGpa()+"");
	}
	public void getSession(String masv){
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
		
			    this.sinhVienModel = session.get(SinhVien.class,masv);
			    //nếu chỉ getHocPhan thì chỉ trả về con trỏ của list<HocPhan> mà chưa có dữ liệu phải thực sự truy cập đến các học phần thì dữ liệu mới được tải
			    // trong phuong thức getHocPhan phai gọi tới từng học phần một để lấy dữ liệu
			    // hoặc sử dựng FetchType.EAGER đào lấy hết dữ liệu của sinhvien
			    if(this.sinhVienModel != null) {
			    this.hocPhanModel =  this.sinhVienModel.getHocPhan();}
			    
			   if(this.sinhVienModel.getGpa() == 0) 
			   {
			   double gpaValue = this.tinhGPA();
		       BigDecimal bd = new BigDecimal(gpaValue);
		       gpaValue = (bd.setScale(2, RoundingMode.HALF_UP)).doubleValue();
			   String masv2 = this.sinhVienModel.getMaSinhVien();
			   this.sinhVienModel.setGpa(gpaValue);
			    
			    String hql = "UPDATE SinhVien SET gpa = :a WHERE maSinhVien = :masv";
			    Query query = session.createQuery(hql);
			    query.setParameter("a", gpaValue);  // gpaValue là giá trị GPA mới mà bạn muốn cập nhật
			    query.setParameter("masv", masv2);
			    int result = query.executeUpdate();
			

			    int res = query.executeUpdate();
		   }
			    
		
				tr.commit();
				session.close();}
			
	}
    
	public void fetch() {
		
		this.xoaBang();
		String masv = this.masinhvienfetch.getText()+"";
		masv = masv.toUpperCase();
	
		//Truy vấn thông tin từ database
	   this.getSession(masv);
	 
	   // Đẩy thông tin vào view
	    this.thongTinSinhVien();
	   
	    int stt=1;
	   for(HocPhan x: this.hocPhanModel) {
		   this.taoBangDiemChiTiet(x,stt);
		   stt++;
	   }
	//   System.out.println(this.sinhVienModel.toString());
	   this.top.setText("");
	}
	
	    
	    public void taoBangDiemChiTiet(HocPhan hp,int stt) {
	        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	        
	        model_table.addRow(new Object[] {
	            String.valueOf(stt), // Convert int to String
	            hp.getTenHocPhan(),
	            String.valueOf(hp.getDiemThanhPhan1()), // Convert int to String
	            String.valueOf(hp.getDiemThanhPhan2()), // Convert int to String
	            String.valueOf(hp.getDiemThi()), // Convert int to String
	            String.valueOf(hp.getDiemTongKet()), // Convert int to String
	            hp.getDiemChu()
	        });
	    }
	    private double tinhGPA() {
			double sum=0;
			double count=0;
			   for(HocPhan x: this.sinhVienModel.getHocPhan()) {
				   if(x.getTenHocPhan().contains("Giáo dục thể chất")) 
					   continue;
				    sum += (x.getDiemTongKet()*x.getSoTinchi());
				    count+= x.getSoTinchi();
				    }
		
			   sum /= count;
		       sum = sum/10*4;
			   return sum;
			   }
	    private double tinhGPAtheoki(List<HocPhan> list) {
			double sum=0;
			double count=0;
			   for(HocPhan x: list) {
				   if(x.getTenHocPhan().contains("Giáo dục thể chất")) 
					   continue;
				    sum += (x.getDiemTongKet()*x.getSoTinchi());
				    count+= x.getSoTinchi();
				    }
		
			   sum /= count;
		       sum = sum/10*4;
			   return sum;
			   }

		public void locBang() {
			if(this.comboBox.getSelectedItem().equals("Lọc môn ĐẠT")) {
				
				this.locHocPhanDat();
			}
			else if (this.comboBox.getSelectedItem().equals("Lọc môn TRƯỢT")){
				this.locHocPhanTruot();
			}
			else if(this.comboBox.getSelectedItem().equals("Tất cả các môn")){
			}
			else if(this.comboBox.getSelectedItem().equals("Lọc theo kì gần nhất")) {
				this.top.setText("");
				this.xoaBang();
				int hocki = this.getHocKy();
				this.locTheoHocKiGanNhat(hocki);
			}
			else if(this.comboBox.getSelectedItem().equals("Xếp hạng theo lớp")){
				this.xepHangLop(this.lop.getText());
			}
			
		}
		public int getHocKy(){
			 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				if (sessionFactory != null) {
					Session session = sessionFactory.openSession();
					Transaction tr = session.beginTransaction();
			
				  String hql = "Select max(hocKi) from HocPhan";
				  Query query = session.createQuery(hql);
				  Object result = query.uniqueResult();
				 
				 
			
					tr.commit();
					session.close();
					return (int)result ;
					}
				return -1;
				
		}
		public void locTheoHocKiGanNhat(int hocki){
			String masv = this.masinhvienfetch.getText()+"";
			masv = masv.toUpperCase();
			List<HocPhan> list = null;
			 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				if (sessionFactory != null) {
					Session session = sessionFactory.openSession();
					Transaction tr = session.beginTransaction();
			
				  String hql = "from HocPhan  where sinhvien_id =: a and hocKi =: x";
				  Query query = session.createQuery(hql);
				  query.setParameter("a", masv);
				  query.setParameter("x", hocki);
			
				   list = query.list();
				  
			
					tr.commit();
					session.close();
					
					}
				int stt = 1;
				  for(HocPhan x: list) {
					   this.taoBangDiemChiTiet(x,stt);
					   stt++;
				   }
				  double gpaValue = this.tinhGPAtheoki(list);
			       BigDecimal bd = new BigDecimal(gpaValue);
			       gpaValue = (bd.setScale(2, RoundingMode.HALF_UP)).doubleValue();
				  this.gpa.setText(gpaValue+"");
				
				
				
		}
		
		
		public void exit() {
			int luaChon = JOptionPane.showConfirmDialog(
				    this,
				    "Xác nhận thoát khỏi chương trình",
				    "Exit",
				    JOptionPane.YES_NO_OPTION);
			if (luaChon == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		public void xoaBang() {
			
			while (table.getRowCount() > 0) {
			                    ((DefaultTableModel) table.getModel()).removeRow(0);
			                }
		
		}
		public void locHocPhanDat() {
			this.xoaBang();
			List<HocPhan> list = new ArrayList<HocPhan>();
			for(HocPhan x: this.hocPhanModel) {
				if(x.getDiemThi() > 4 || x.getDiemTongKet() > 4) {
					list.add(x);
				}
			}
			this.taoBangLoc(list);
			
		}
		public void locHocPhanTruot() {
			this.xoaBang();
			List<HocPhan> list = new ArrayList<HocPhan>();
			for(HocPhan x: this.hocPhanModel) {
				if(x.getDiemThi() < 4 || x.getDiemTongKet()  < 4) {
					list.add(x);
				}
			}
			this.taoBangLoc(list);
			
		}
		public void taoBangLoc(List<HocPhan> arr) {
			int i=1;
			for(HocPhan a: arr) {
				this.taoBangDiemChiTiet(a,i);
				i++;
			}
		}
		
		public void xepHangLop(String lop) {
			 List<Double> resultlist=new ArrayList<Double>();
			
			 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				if (sessionFactory != null) {
					Session session = sessionFactory.openSession();
					Transaction tr = session.beginTransaction();
			
				  String hql = "SELECT gpa from SinhVien where lop =: aa";
				  Query query = session.createQuery(hql);
				  query.setParameter("aa", lop);
			
			     resultlist = query.list();
			  
				  
					tr.commit();
					session.close();
					
				}
				 Collections.sort(resultlist, new Comparator<Double>() {
			            @Override
			            public int compare(Double o1, Double o2) {
			                return o2.compareTo(o1); //
			            }
			        });
			
				Double find = this.sinhVienModel.getGpa();
				
				int result = resultlist.indexOf(find)+1;
				System.out.println(result);
				this.top.setText(result+"");
				
			
		}
		
		
	}
	   
	   


		
		
	
    
	

