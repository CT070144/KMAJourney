package view;



import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

import control.KMAJourneyControl;
import model.HocPhan;
import model.SinhVien;
import net.bytebuddy.asm.Advice.This;
import util.HibernateUtil;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JList;
import java.awt.Color;



public class KMAJourneyView extends JFrame {
    private SinhVien sinhVienModel;
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
	private JTextField gpa;

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
	//mntmNewMenuItem_2.addActionListener(actionListener);
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
	lblNewLabel.setBounds(792, 44, 179, 60);
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
	lblNewLabel_2_1.setBounds(209, 540, 102, 29);
	contentPane.add(lblNewLabel_2_1);
	
	masinhvien = new JTextField();
	masinhvien.setFont(new Font("Arial", Font.PLAIN, 14));
	masinhvien.setBounds(311, 538, 222, 24);
	contentPane.add(masinhvien);
	masinhvien.setColumns(10);
	
	JLabel lblNewLabel_2_1_1 = new JLabel("Khóa : ");
	lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1.setBounds(209, 573, 92, 22);
	contentPane.add(lblNewLabel_2_1_1);
	
	khoa = new JTextField();
	khoa.setFont(new Font("Arial", Font.PLAIN, 14));
	khoa.setColumns(10);
	khoa.setBounds(311, 573, 222, 24);
	contentPane.add(khoa);
	
	JLabel lblNewLabel_2_1_1_1 = new JLabel("Lớp :");
	lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_1.setBounds(209, 606, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_1);
	
	JLabel lblNewLabel_2_1_1_2 = new JLabel("Họ và tên : ");
	lblNewLabel_2_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2.setBounds(559, 541, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2);
	
	JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Trạng thái : ");
	lblNewLabel_2_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2_1.setBounds(559, 571, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2_1);
	
	JLabel lblNewLabel_2_1_1_2_2 = new JLabel("Lọc theo : ");
	lblNewLabel_2_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2_2.setBounds(559, 606, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2_2);
	
	lop = new JTextField();
	lop.setFont(new Font("Arial", Font.PLAIN, 14));
	lop.setColumns(10);
	lop.setBounds(311, 612, 222, 24);
	contentPane.add(lop);
	
	hovaten = new JTextField();
	hovaten.setFont(new Font("Arial", Font.PLAIN, 14));
	hovaten.setColumns(10);
	hovaten.setBounds(647, 538, 202, 24);
	contentPane.add(hovaten);
	
	trangthai = new JTextField();
	trangthai.setFont(new Font("Arial", Font.PLAIN, 14));
	trangthai.setColumns(10);
	trangthai.setBounds(647, 573, 202, 24);
	contentPane.add(trangthai);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
	comboBox.setBackground(new Color(255, 255, 255));
	comboBox.setBounds(647, 612, 202, 22);
	 comboBox.addItem("Tất cả các môn");
     comboBox.addItem("Các môn ĐẠT");
     comboBox.addItem("Các môn Trượt");
     comboBox.addItem("Xếp hạng theo lớp");
     comboBox.addItem("Xếp hạng theo kì gần nhất");
     
     
	contentPane.add(comboBox);
	
	JButton btnNewButton_1 = new JButton("Lọc");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnNewButton_1.setBackground(new Color(255, 255, 255));
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnNewButton_1.setBounds(874, 612, 68, 23);
	contentPane.add(btnNewButton_1);
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setIcon(new ImageIcon(KMAJourneyView.class.getResource("/view/0011 (2).jpg")));
	lblNewLabel_4.setBounds(706, 30, 76, 75);
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
	lblNewLabel_5.setBounds(874, 544, 37, 21);
	contentPane.add(lblNewLabel_5);
	
	gpa = new JTextField();
	gpa.setFont(new Font("Arial", Font.PLAIN, 14));
	gpa.setColumns(10);
	gpa.setBounds(921, 538, 60, 24);
	contentPane.add(gpa);
	
	

	
	
	
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
	}
	public void getSession(String masv){
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
		
			  
			    
			    this.sinhVienModel = session.get(SinhVien.class,masv);
			    this.hocPhanModel =  this.sinhVienModel.getHocPhan();
			   
			    for(HocPhan x: this.hocPhanModel) {
			    	System.out.println(x.toString());
			    }
			  
				
				tr.commit();
				session.close();}
			
	}
    
	public void fetch() {
		String masv = this.masinhvienfetch.getText()+"";
		//Truy vấn thông tin từ database
	   this.getSession(masv);
	 
	   // Đẩy thông tin vào view
	   this.thongTinSinhVien();
	    List<HocPhan> list =  this.hocPhanModel;
	    int stt=1;
	   for(HocPhan x: list ) {
		   this.taoBangDiemChiTiet(x,stt);
		   stt++;
	   }
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
	}
	   
	   


		
		
	
    
	

