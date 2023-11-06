package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import DAO.MovieDAO;

public class PaymentCompleted extends WindowAdapter implements ActionListener {
	private Frame f;
	private Button b1, b2, b3, b4;
	private Panel mainposter;
	private Label MovieName, Date, MovieRoom, Seat, Discount, Pay, TotalPay, MovieName2, Date2, MovieRoom2, Seat2, Discount2, Pay2, TotalPay2;
	private Button clear;
	private URL searchURL;
	private ImageIcon imageicon;
	private JButton  movieposter;
	
	private MovieDAO movieDao = MovieDAO.getInstance();
	
	public PaymentCompleted() {
		Font Movieposter = new Font("고딕", Font.BOLD, 20);
		Font Movieposter1 = new Font("고딕", Font.BOLD, 17);
		Font TotalPayFont = new Font("고딕", Font.BOLD, 27);
		
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		f = new Frame();
		f.setLayout(null);
		f.setSize(800, 780);
		f.setBackground(new Color(188, 205, 194));
		f.setResizable(false);
		f.setLocation((scr.width - 800) / 2, (scr.height - 800) / 2);
		f.addWindowListener(this);
		
		b1 = new Button("01 상영관");
		b1.setBackground(Color.lightGray);
		b1.setBounds(245, 35, 70, 21);

		b2 = new Button("02 인원 / 좌석");
		b2.setBackground(Color.lightGray);
		b2.setBounds(320, 35, 86, 21);
		
		b3 = new Button("03 결제");
		b3.setBackground(Color.lightGray);
		b3.setBounds(410, 35, 60, 21);
		
		b4 = new Button("04 결제 완료");
		b4.setBackground(new Color(188, 205, 194));
		b4.setBounds(475, 35, 80, 21);
		
		// 영수증 크기
		mainposter = new Panel();
		mainposter.setLayout(null);
		mainposter.setBounds(200, 80, 400,650);
		mainposter.setBackground(Color.lightGray);
		
		
		// 영화 포스터 자리
		movieDao.connect();
		String movieName = movieDao.SearchMovieposter("30");
		searchURL = getClass().getResource(movieName);
		imageicon = new ImageIcon(searchURL);
		movieposter = new JButton(imageicon);
		Image image = imageicon.getImage();
		Image scaledImage = image.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		movieposter= new JButton(scaledIcon);//크기 바꿀때 imageicon-->scaledIcon 으로 변경
		movieposter.setBounds(50, 50, 300,350);
		movieposter.setBackground(Color.PINK);
		movieposter.setBorderPainted(false);
		movieposter.setFocusPainted(false);
		movieposter.setContentAreaFilled(false);
		
		MovieName = new Label("영화 제목 :");
		MovieName.setBounds(50, 420, 105,25);
		MovieName.setBackground(Color.lightGray);
		MovieName.setFont(Movieposter);
		
		Date = new Label("일        시 :");
		Date.setBounds(50, 450, 105,25);
		Date.setBackground(Color.lightGray);
		Date.setFont(Movieposter);
		
		MovieRoom = new Label("상  영  관 :");
		MovieRoom.setBounds(50, 480, 105,25);
		MovieRoom.setBackground(Color.lightGray);
		MovieRoom.setFont(Movieposter);
		
		Seat = new Label("인원 / 좌석 :");
		Seat.setBounds(50, 510, 105,25);
		Seat.setBackground(Color.lightGray);
		Seat.setFont(Movieposter1);
		
		Discount = new Label("할        인 :");
		Discount.setBounds(50, 540, 105,25);
		Discount.setBackground(Color.lightGray);
		Discount.setFont(Movieposter);
		
		Pay = new Label("금        액 :");
		Pay.setBounds(50, 570, 105,25);
		Pay.setBackground(Color.lightGray);
		Pay.setFont(Movieposter);
		
		TotalPay = new Label("총금액 :");
		TotalPay.setBounds(50, 600, 105,29);
		TotalPay.setBackground(Color.lightGray);
		TotalPay.setForeground(Color.red);
		TotalPay.setFont(TotalPayFont);
		
		clear = new Button("확인");
		clear.setBounds((scr.width - 800) / 2, 735, 60, 30);
		clear.setBackground(Color.cyan);
		clear.addActionListener(this);
		
		mainposter.add(movieposter);
		mainposter.add(TotalPay);
		mainposter.add(Pay);
		mainposter.add(Discount);
		mainposter.add(Seat);
		mainposter.add(MovieRoom);
		mainposter.add(Date);
		mainposter.add(MovieName);
		
		f.add(clear);
		f.add(mainposter);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.setVisible(true);
	}
	
//	public MovieDAO SearchMovieposter(String name) {
//		movieDao.connect();
//		MovieVO mo = movieDao.SearchMovieposter(name);
//		if(mo.equals(mo)) {
//			return poster;
//		}
//	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		PaymentCompleted pay = new PaymentCompleted();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("확인")) {
			f.setVisible(false);
			MainFrame main = new MainFrame();
		}
	}
}
