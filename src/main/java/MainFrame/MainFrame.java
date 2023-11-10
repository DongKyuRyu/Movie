package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import DAO.TicketDAO;
import VO.TicketVO;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainFrame extends WindowAdapter implements ActionListener {
	private Frame f;
	private Button b1, b2, b3, b4, logout, checkedok;
	private Label Title, checked;
	private Dialog popup;
	private ImageIcon imageicon;
	private JButton movieporster;
	private URL searchURL;
	
	private TicketDAO TicketDao = TicketDAO.getInstance();
	private MovieData moviedata = MovieData.getInstance();

	public MainFrame() {
		Font TitleFont = new Font("고딕", Font.BOLD, 60);
		Font thisisFont = new Font("고딕", Font.BOLD, 10);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		TicketDao.connect();

		f = new Frame("영화예매");
		f.setResizable(false);
		f.setSize(500, 700);
		f.setBackground(new Color(188, 205, 194));
		f.setLayout(null);
		f.setLocation((scr.width - 500) / 2, (scr.height - 700) / 2);
		f.addWindowListener(this);

		b1 = new Button("영화 예매");
		b1.setBounds(50, 200, 400, 150);
		b1.setBackground(new Color(188, 205, 227));
		b1.addActionListener(this);

		b2 = new Button("오늘도 빛날 네게 해주고싶은말");
		b2.setBounds(275, 200, 175, 150);
		b2.setBackground(new Color(188, 205, 227));

		b2.addActionListener(this);

		b3 = new Button("예매 확인");
		b3.setBounds(50, 400, 175, 150);
		b3.setBackground(new Color(188, 205, 227));
		b3.addActionListener(this);

		b4 = new Button("내 정보");
		b4.setBounds(275, 400, 175, 150);
		b4.setBackground(new Color(188, 205, 227));
		b4.addActionListener(this);

		logout = new Button("Logout");
		logout.setBounds(165, 600, 170, 50);
		logout.setBackground(new Color(188, 205, 227));
		logout.addActionListener(this);

		Title = new Label("GreenHouse");
		Title.setForeground(Color.WHITE);
		Title.setBounds(110, 80, 360, 80);
		Title.setFont(TitleFont);

		popup = new Dialog(f, "예매 확인", true);
		popup.setSize(200, 100);
		popup.setLayout(new FlowLayout());
		popup.setLocation((scr.width - 200) / 2, (scr.height - 100) / 2);

		checked = new Label("예매 정보가 없습니다.");
		checkedok = new Button(" 확 인 ");
		checkedok.addActionListener(this);
		popup.add(checked);
		popup.add(checkedok);
		popup.addWindowListener(this);

		// 로고
		searchURL = getClass().getResource("/img/Logo2.png");
		imageicon = new ImageIcon(searchURL);
		Image image = imageicon.getImage();
		Image scaledImage = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		movieporster = new JButton(scaledIcon);// 크기 바꿀때 imageicon-->scaledIcon 으로 변경
		movieporster.setBounds(30, 80, 80, 80);
		movieporster.setBackground(Color.red);
		movieporster.setBorderPainted(false);
		movieporster.setFocusPainted(false);
		movieporster.setContentAreaFilled(false);

		f.add(movieporster);
		f.add(Title);
		f.add(logout);
		f.add(b4);
		f.add(b3);
		f.add(b1);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Logout")) {
			f.setVisible(false);
			System.out.println("로그아웃 완료");
			Login login = new Login();
		}

		if (e.getActionCommand().equals("영화 예매")) {
			f.setVisible(false);
			MovieList movielist = new MovieList();
		}


		if (e.getActionCommand().equals("내 정보")) {
			f.setVisible(false);
			information Information = new information();

		}

		if (e.getActionCommand().equals("예매 확인")) {
			if (TicketDao.checkedTicket(moviedata.getMovieID()) != null) {
				f.setVisible(false);
				Cancellation cancellation = new Cancellation();
			} else {
				popup.setVisible(true);
				TicketDao.connect();
				System.out.println(TicketDao.selectList(moviedata.getMovieID()));

			}
		}
		if (e.getActionCommand().equals(" 확 인 ")) {
			popup.setVisible(false);
			System.out.println(TicketDao.selectList(moviedata.getMovieID()));

		}

		if (e.getActionCommand().equals("오늘도 빛날 네게 해주고싶은말")) {
			ThisIsForYou thisis = new ThisIsForYou();
		}
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}
}