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
import java.awt.ScrollPane;



public class JourneyManagerView extends JFrame {
    private SinhVien sinhVienModel = null;
    private List<HocPhan> hocPhanModel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Container menuBar;
	private JTextField masinhvien;
	private JTextField khoa;
	private JTextField lop;
	private JTextField hovaten;
	private JTextField trangthai;
	private JTextField gpa;
	private JComboBox comboBox;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_14;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;

	public JourneyManagerView() {
		
		sinhVienModel = new SinhVien();
		hocPhanModel = new ArrayList<HocPhan>();
		this.setTitle("KMA Journey");
		URL url = JourneyManagerView.class.getResource("Image.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(img);
		
	//KMAJourneyControl actionListener = new KMAJourneyControl(this);	
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
	
	JSeparator separator_1 = new JSeparator();
	separator_1.setForeground(new Color(0, 0, 0));
	separator_1.setBackground(new Color(255, 255, 255));
	separator_1.setBounds(10, 128, 1001, 2);
	contentPane.add(separator_1);
	
	JLabel lblNewLabel_2_1 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1.setBounds(20, 167, 102, 29);
	contentPane.add(lblNewLabel_2_1);
	
	masinhvien = new JTextField();
	masinhvien.setFont(new Font("Arial", Font.PLAIN, 16));
	masinhvien.setBounds(132, 168, 222, 24);
	contentPane.add(masinhvien);
	masinhvien.setColumns(10);
	
	JLabel lblNewLabel_2_1_1 = new JLabel("Khóa : ");
	lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1.setBounds(20, 207, 92, 22);
	contentPane.add(lblNewLabel_2_1_1);
	
	khoa = new JTextField();
	khoa.setFont(new Font("Arial", Font.PLAIN, 16));
	khoa.setColumns(10);
	khoa.setBounds(132, 203, 222, 24);
	contentPane.add(khoa);
	
	JLabel lblNewLabel_2_1_1_1 = new JLabel("Lớp :");
	lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_1.setBounds(20, 238, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_1);
	
	JLabel lblNewLabel_2_1_1_2 = new JLabel("Họ và tên : ");
	lblNewLabel_2_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2.setBounds(389, 168, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2);
	
	JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Trạng thái : ");
	lblNewLabel_2_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2_1.setBounds(389, 205, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2_1);
	
	JLabel lblNewLabel_2_1_1_2_2 = new JLabel("Lọc theo : ");
	lblNewLabel_2_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_2_2.setBounds(389, 238, 92, 27);
	contentPane.add(lblNewLabel_2_1_1_2_2);
	
	lop = new JTextField();
	lop.setFont(new Font("Arial", Font.PLAIN, 16));
	lop.setColumns(10);
	lop.setBounds(132, 238, 222, 24);
	contentPane.add(lop);
	
	hovaten = new JTextField();
	hovaten.setFont(new Font("Arial", Font.PLAIN, 16));
	hovaten.setColumns(10);
	hovaten.setBounds(504, 168, 202, 24);
	contentPane.add(hovaten);
	
	trangthai = new JTextField();
	trangthai.setFont(new Font("Arial", Font.PLAIN, 16));
	trangthai.setColumns(10);
	trangthai.setBounds(504, 205, 202, 24);
	contentPane.add(trangthai);
	
	 comboBox = new JComboBox();
	comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
	comboBox.setBackground(new Color(255, 255, 255));
	comboBox.setBounds(504, 240, 202, 22);
	 comboBox.addItem("Tất cả các môn");
     comboBox.addItem("Lọc môn ĐẠT");
     comboBox.addItem("Lọc môn TRƯỢT");
     comboBox.addItem("Xếp hạng theo lớp");
     comboBox.addItem("Xếp hạng theo kì gần nhất");
     
     
	contentPane.add(comboBox);
	
	JButton btnNewButton_1 = new JButton("Lọc");
	//btnNewButton_1.addActionListener(actionListener);
	btnNewButton_1.setBackground(new Color(255, 255, 255));
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnNewButton_1.setBounds(734, 239, 68, 23);
	contentPane.add(btnNewButton_1);
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setIcon(new ImageIcon(JourneyManagerView.class.getResource("/view/Logo Học Viện Kỹ Thuật Mật Mã - ACTVN (1).jpg")));
	lblNewLabel_4.setBounds(647, 30, 70, 70);
	contentPane.add(lblNewLabel_4);
	
	JSeparator separator_3 = new JSeparator();
	separator_3.setForeground(new Color(0, 0, 0));
	separator_3.setBounds(10, 154, 167, 2);
	contentPane.add(separator_3);
	
	JLabel lblNewLabel_5 = new JLabel("GPA :");
	lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_5.setBounds(757, 171, 37, 21);
	contentPane.add(lblNewLabel_5);
	
	gpa = new JTextField();
	gpa.setHorizontalAlignment(SwingConstants.CENTER);
	gpa.setFont(new Font("Arial", Font.PLAIN, 16));
	gpa.setColumns(10);
	gpa.setBounds(806, 168, 60, 24);
	contentPane.add(gpa);
	
	JPanel contentPane_1 = new JPanel();
	contentPane_1.setLayout(null);
	contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane_1.setBackground(Color.WHITE);
	contentPane_1.setBounds(0, 0, 1034, 672);
	contentPane.add(contentPane_1);
	
	JMenuBar menuBar_1 = new JMenuBar();
	menuBar_1.setBounds(20, 0, 76, 21);
	contentPane_1.add(menuBar_1);
	
	JSeparator separator_1_1 = new JSeparator();
	separator_1_1.setForeground(Color.BLACK);
	separator_1_1.setBackground(Color.WHITE);
	separator_1_1.setBounds(10, 128, 1001, 2);
	contentPane_1.add(separator_1_1);
	
	JLabel lblNewLabel_2_1_5 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1_5.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_5.setBounds(20, 167, 102, 29);
	contentPane_1.add(lblNewLabel_2_1_5);
	
	textField_1 = new JTextField();
	textField_1.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_1.setColumns(10);
	textField_1.setBounds(132, 168, 222, 24);
	contentPane_1.add(textField_1);
	
	JLabel lblNewLabel_2_1_1_3 = new JLabel("Khóa : ");
	lblNewLabel_2_1_1_3.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_1_3.setBounds(20, 207, 92, 22);
	contentPane_1.add(lblNewLabel_2_1_1_3);
	
	textField_2 = new JTextField();
	textField_2.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_2.setColumns(10);
	textField_2.setBounds(132, 203, 222, 24);
	contentPane_1.add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_3.setColumns(10);
	textField_3.setBounds(132, 238, 222, 24);
	contentPane_1.add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_4.setColumns(10);
	textField_4.setBounds(504, 168, 202, 24);
	contentPane_1.add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_5.setColumns(10);
	textField_5.setBounds(504, 205, 202, 24);
	contentPane_1.add(textField_5);
	
	JComboBox comboBox_1 = new JComboBox();
	comboBox_1.setFont(new Font("Arial", Font.PLAIN, 14));
	comboBox_1.setBackground(Color.WHITE);
	comboBox_1.setBounds(504, 240, 202, 22);
	contentPane_1.add(comboBox_1);
	
	JLabel lblNewLabel_4_1 = new JLabel("New label");
	lblNewLabel_4_1.setBounds(647, 30, 70, 70);
	contentPane_1.add(lblNewLabel_4_1);
	
	JLabel lblNewLabel_3_1_2 = new JLabel("THÔNG TIN SINH VIÊN");
	lblNewLabel_3_1_2.setForeground(Color.BLACK);
	lblNewLabel_3_1_2.setFont(new Font("Arial", Font.BOLD, 15));
	lblNewLabel_3_1_2.setBounds(8, 128, 179, 28);
	contentPane_1.add(lblNewLabel_3_1_2);
	
	JSeparator separator_3_2 = new JSeparator();
	separator_3_2.setForeground(Color.BLACK);
	separator_3_2.setBounds(10, 154, 167, 2);
	contentPane_1.add(separator_3_2);
	
	JLabel lblNewLabel_5_1 = new JLabel("GPA :");
	lblNewLabel_5_1.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_5_1.setBounds(757, 171, 37, 21);
	contentPane_1.add(lblNewLabel_5_1);
	
	textField_6 = new JTextField();
	textField_6.setHorizontalAlignment(SwingConstants.CENTER);
	textField_6.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_6.setColumns(10);
	textField_6.setBounds(806, 168, 60, 24);
	contentPane_1.add(textField_6);
	
	JPanel contentPane_2 = new JPanel();
	contentPane_2.setLayout(null);
	contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane_2.setBackground(Color.WHITE);
	contentPane_2.setBounds(0, 0, 1034, 672);
	contentPane_1.add(contentPane_2);
	
	JMenuBar menuBar_2 = new JMenuBar();
	menuBar_2.setBounds(20, 0, 76, 21);
	contentPane_2.add(menuBar_2);
	
	JLabel lblNewLabel_7 = new JLabel("KMA Journey");
	lblNewLabel_7.setFont(new Font("Dubai Medium", Font.BOLD, 30));
	lblNewLabel_7.setBounds(727, 34, 179, 60);
	contentPane_2.add(lblNewLabel_7);
	
	JLabel lblNewLabel_2_3 = new JLabel("Mã sinh viên");
	lblNewLabel_2_3.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
	lblNewLabel_2_3.setBounds(10, 67, 108, 27);
	contentPane_2.add(lblNewLabel_2_3);
	
	textField_7 = new JTextField();
	textField_7.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_7.setColumns(10);
	textField_7.setBounds(116, 61, 222, 33);
	contentPane_2.add(textField_7);
	
	JButton btnNewButton_4 = new JButton(" Fetch");
	btnNewButton_4.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 16));
	btnNewButton_4.setBackground(Color.WHITE);
	btnNewButton_4.setBounds(367, 61, 114, 33);
	contentPane_2.add(btnNewButton_4);
	
	JSeparator separator_1_2 = new JSeparator();
	separator_1_2.setForeground(Color.BLACK);
	separator_1_2.setBackground(Color.WHITE);
	separator_1_2.setBounds(10, 128, 1001, 2);
	contentPane_2.add(separator_1_2);
	
	JComboBox comboBox_2 = new JComboBox();
	comboBox_2.setFont(new Font("Arial", Font.PLAIN, 14));
	comboBox_2.setBackground(Color.WHITE);
	comboBox_2.setBounds(504, 240, 202, 22);
	contentPane_2.add(comboBox_2);
	
	JButton btnNewButton_1_2 = new JButton("Lọc");
	btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
	btnNewButton_1_2.setBackground(Color.WHITE);
	btnNewButton_1_2.setBounds(734, 239, 68, 23);
	contentPane_2.add(btnNewButton_1_2);
	
	JLabel lblNewLabel_4_2 = new JLabel("New label");
	lblNewLabel_4_2.setBounds(647, 30, 70, 70);
	contentPane_2.add(lblNewLabel_4_2);
	
	JSeparator separator_3_3 = new JSeparator();
	separator_3_3.setForeground(Color.BLACK);
	separator_3_3.setBounds(10, 154, 167, 2);
	contentPane_2.add(separator_3_3);
	
	JLabel lblNewLabel_5_2 = new JLabel("GPA :");
	lblNewLabel_5_2.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_5_2.setBounds(757, 171, 37, 21);
	contentPane_2.add(lblNewLabel_5_2);
	
	textField_13 = new JTextField();
	textField_13.setHorizontalAlignment(SwingConstants.CENTER);
	textField_13.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_13.setColumns(10);
	textField_13.setBounds(806, 168, 60, 24);
	contentPane_2.add(textField_13);
	
	JLabel lblNewLabel_3_3 = new JLabel("Management");
	lblNewLabel_3_3.setFont(new Font("Arial", Font.ITALIC, 16));
	lblNewLabel_3_3.setBounds(874, 96, 107, 21);
	contentPane_2.add(lblNewLabel_3_3);
	
	ScrollPane scrollPane_2 = new ScrollPane();
	scrollPane_2.setBounds(20, 293, 991, 140);
	contentPane_2.add(scrollPane_2);
	
	JLabel lblNewLabel_2_1_3_3 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1_3_3.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_3_3.setBounds(197, 497, 102, 29);
	contentPane_2.add(lblNewLabel_2_1_3_3);
	
	JLabel lblNewLabel_2_1_4_3 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1_4_3.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_4_3.setBounds(558, 497, 102, 29);
	contentPane_2.add(lblNewLabel_2_1_4_3);
	
	JLabel lblNewLabel_2_1_4_4 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1_4_4.setFont(new Font("Arial", Font.BOLD, 14));
	lblNewLabel_2_1_4_4.setBounds(558, 537, 102, 29);
	contentPane_2.add(lblNewLabel_2_1_4_4);
	
	textField_15 = new JTextField();
	textField_15.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_15.setColumns(10);
	textField_15.setBounds(309, 498, 222, 24);
	contentPane_2.add(textField_15);
	
	textField_16 = new JTextField();
	textField_16.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_16.setColumns(10);
	textField_16.setBounds(309, 538, 222, 24);
	contentPane_2.add(textField_16);
	
	JLabel lblNewLabel_2_1_4 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1_4.setBounds(197, 537, 102, 29);
	contentPane_2.add(lblNewLabel_2_1_4);
	lblNewLabel_2_1_4.setFont(new Font("Arial", Font.BOLD, 14));
	
	JLabel lblNewLabel_2_1_2 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1_2.setBounds(197, 457, 102, 29);
	contentPane_2.add(lblNewLabel_2_1_2);
	lblNewLabel_2_1_2.setFont(new Font("Arial", Font.BOLD, 14));
	
	textField_14 = new JTextField();
	textField_14.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_14.setColumns(10);
	textField_14.setBounds(309, 458, 222, 24);
	contentPane_2.add(textField_14);
	
	JButton btnNewButton_2_2 = new JButton("New button");
	btnNewButton_2_2.setBounds(431, 631, 89, 23);
	contentPane_2.add(btnNewButton_2_2);
	
	JSeparator separator_2 = new JSeparator();
	separator_2.setBounds(10, 276, 1001, 2);
	contentPane_2.add(separator_2);
	separator_2.setForeground(new Color(0, 0, 0));
	
	JButton btnNewButton_2_1_1 = new JButton("New button");
	btnNewButton_2_1_1.setBounds(298, 631, 89, 23);
	contentPane_2.add(btnNewButton_2_1_1);
	
	JButton btnNewButton_2 = new JButton("New button");
	btnNewButton_2.setBounds(180, 631, 89, 23);
	contentPane_2.add(btnNewButton_2);
	
	JButton btnNewButton_2_3 = new JButton("New button");
	btnNewButton_2_3.setBounds(922, 631, 89, 23);
	contentPane_2.add(btnNewButton_2_3);
	
	JLabel lblNewLabel_3_1_1 = new JLabel("THÔNG TIN HỌC PHẦN");
	lblNewLabel_3_1_1.setBounds(8, 439, 179, 28);
	contentPane_2.add(lblNewLabel_3_1_1);
	lblNewLabel_3_1_1.setForeground(Color.BLACK);
	lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 15));
	
	JSeparator separator_3_1 = new JSeparator();
	separator_3_1.setBounds(10, 462, 167, 2);
	contentPane_2.add(separator_3_1);
	separator_3_1.setForeground(Color.BLACK);
	
	JLabel lblNewLabel_2_1_3_1 = new JLabel("Mã sinh viên : ");
	lblNewLabel_2_1_3_1.setBounds(558, 457, 102, 29);
	contentPane_2.add(lblNewLabel_2_1_3_1);
	lblNewLabel_2_1_3_1.setFont(new Font("Arial", Font.BOLD, 14));
	
	textField_17 = new JTextField();
	textField_17.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_17.setColumns(10);
	textField_17.setBounds(668, 458, 222, 24);
	contentPane_2.add(textField_17);
	
	textField_18 = new JTextField();
	textField_18.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_18.setColumns(10);
	textField_18.setBounds(668, 502, 222, 24);
	contentPane_2.add(textField_18);
	
	textField_19 = new JTextField();
	textField_19.setFont(new Font("Arial", Font.PLAIN, 16));
	textField_19.setColumns(10);
	textField_19.setBounds(670, 538, 222, 24);
	contentPane_2.add(textField_19);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setBounds(10, 601, 60, 60);
	contentPane_2.add(lblNewLabel_1);
	lblNewLabel_1.setIcon(new ImageIcon(JourneyManagerView.class.getResource("/view/Seanau-Kungfu-Panda-Squirrel.64.png")));
	btnNewButton_2_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});

	
	
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
			    this.hocPhanModel =  this.sinhVienModel.getHocPhan();
			    
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
		System.out.println(masv);
		//Truy vấn thông tin từ database
	   this.getSession(masv);
	 
	   // Đẩy thông tin vào view
	    this.thongTinSinhVien();
	   
	    int stt=1;
	   for(HocPhan x: this.hocPhanModel) {
		   this.taoBangDiemChiTiet(x,stt);
		   stt++;
	   }
	   System.out.println(this.sinhVienModel.toString());
	  
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

		public void locBang() {
			if(this.comboBox.getSelectedItem().equals("Lọc môn ĐẠT")) {
				this.locHocPhanDat();
			}
			else if (this.comboBox.getSelectedItem().equals("Lọc môn TRƯỢT")){
				this.locHocPhanTruot();
			}
			else if(this.comboBox.getSelectedItem().equals("Tất cả các môn")){
				this.fetch();
			}
			
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
				if(x.getDiemThi() < 4 && x.getDiemTongKet()  < 4) {
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
	}
	   
	   


		
		
	
    
	

