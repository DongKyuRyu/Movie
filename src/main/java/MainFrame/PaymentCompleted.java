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
	private Label MovieName, Date, MovieRoom, Seat, Discount, Pay, TotalPay, MovieName2, Date2, MovieRoom2, Seat2,
			Discount2, Pay2, TotalPay2;
	private Button clear;
	private URL searchURL;
	private ImageIcon imageicon;
	private JButton movieposter;
	
	private MovieData moviedata = MovieData.getInstance();
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
		mainposter.setBounds(200, 80, 400, 650);
		mainposter.setBackground(Color.lightGray);

		// 영화 포스터 자리
		movieDao.connect();
		String movieName = movieDao.SearchMovieposter(moviedata.getMovieList());
		searchURL = getClass().getResource(movieName);
		imageicon = new ImageIcon(searchURL);
		movieposter = new JButton(imageicon);
		Image image = imageicon.getImage();
		Image scaledImage = image.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		movieposter = new JButton(scaledIcon);// 크기 바꿀때 imageicon-->scaledIcon 으로 변경
		movieposter.setBounds(50, 50, 300, 350);
		movieposter.setBackground(Color.PINK);
		movieposter.setBorderPainted(false);
		movieposter.setFocusPainted(false);
		movieposter.setContentAreaFilled(false);

		MovieName = new Label();
		MovieName.setBounds(50, 420, 350, 25);
		MovieName.setBackground(Color.lightGray);
		MovieName.setFont(Movieposter);
		MovieName.setText("영화 제목 : " + moviedata.getMovieList());

		Date = new Label();
		Date.setBounds(50, 450, 350, 25);
		Date.setBackground(Color.lightGray);
		Date.setFont(Movieposter);
		Date.setText("일        시 : " + moviedata.getMovieDate());

		MovieRoom = new Label("상  영  관 :");
		MovieRoom.setBounds(52, 480, 350, 25);
		MovieRoom.setBackground(Color.lightGray);
		MovieRoom.setFont(Movieposter);
		if (moviedata.getMovieList().equals("30일")) {
			MovieRoom.setText("상 영 관 : 1관");
		} else if (moviedata.getMovieList().equals("플라워 킬링 문")) {
			MovieRoom.setText("상 영 관 : 2관");
		} else if (moviedata.getMovieList().equals("빌리와 용감한 녀석들")) {
			MovieRoom.setText("상 영 관 : 3관");
		} else if (moviedata.getMovieList().equals("소년들")) {
			MovieRoom.setText("상 영 관 : 4관");
		} else if (moviedata.getMovieList().equals("용감한 시민")) {
			MovieRoom.setText("상 영 관 : 5관");
		} else if (moviedata.getMovieList().equals("바람 따라 만나리")) {
			MovieRoom.setText("상 영 관 : 6관");
		} else if (moviedata.getMovieList().equals("오픈 더 도어")) {
			MovieRoom.setText("상 영 관 : 7관");
		} else if (moviedata.getMovieList().equals("시수")) {
			MovieRoom.setText("상 영 관 : 8관");
		} else if (moviedata.getMovieList().equals("두사람을 위한 식탁")) {
			MovieRoom.setText("상 영 관 : 9관");
		} else if (moviedata.getMovieList().equals("톡투미")) {
			MovieRoom.setText("상 영 관 : 10관");
		} else if (moviedata.getMovieList().equals("더 킬러")) {
			MovieRoom.setText("상 영 관 : 11관");
		} else if (moviedata.getMovieList().equals("그대들은 어떻게 살 것인가")) {
			MovieRoom.setText("상 영 관 : 12관");
		}

		Seat = new Label();
		Seat.setBounds(52, 510, 350, 25);
		Seat.setBackground(Color.lightGray);
		Seat.setFont(Movieposter1);
		Seat.setText("인원 / 좌석 : " + moviedata.getMovieSeat());

		Discount = new Label("할        인 : 0원");
		Discount.setBounds(50, 570, 350, 25);
		Discount.setBackground(Color.lightGray);
		Discount.setFont(Movieposter);
		Discount.setText("할        인 : -" + moviedata.getMoviediscount() + "원");

		Pay = new Label("금        액 : 0원");
		Pay.setBounds(50, 540, 350, 25);
		Pay.setBackground(Color.lightGray);
		Pay.setFont(Movieposter);
		Pay.setText("금        액 : " + moviedata.getMoviePay() + "원");

		TotalPay = new Label("총금액 : 0원");
		TotalPay.setBounds(50, 600, 350, 29);
		TotalPay.setBackground(Color.lightGray);
		TotalPay.setForeground(Color.red);
		TotalPay.setFont(TotalPayFont);
		TotalPay.setText("총금액 : " + moviedata.getDiscountprice() + "원");

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
