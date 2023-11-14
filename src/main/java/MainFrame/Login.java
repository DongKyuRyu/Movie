package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import DAO.CustomerDAO;
import VO.CustomerVO;

public class Login extends WindowAdapter implements ActionListener {
	private Frame f;
	private Button login, Register, PwdSearch, IdSearch;
	TextField id, pwd;
	Label Lab_1;
	private JLabel img1;
	private CustomerDAO customerDao = CustomerDAO.getInstance();
	private CustomerVO customer;
	private MovieData moviedata = MovieData.getInstance();
	private String pid = "";
	private String password = "";
	private ImageIcon imageicon;
	private JButton movieporster;
	private URL searchURL;

	public Login() {
		Font LoginFont = new Font("고딕", Font.BOLD, 100);
		Font LoginFont1 = new Font("고딕", Font.BOLD, 40);
		Font IdPwdFont = new Font("고딕", Font.BOLD, 40);
		Font trueandfalseFont = new Font("고딕", Font.BOLD, 17);

		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		f = new Frame("Login");
		f.setSize(900, 700);
		f.setLayout(null);
		f.setBackground(new Color(188, 205, 194));
		f.setResizable(false);
		f.setLocation((scr.width - 900) / 2, (scr.height - 700) / 2);
		f.addWindowListener(this);

		// 로그인 버튼
		login = new Button("Login");
		login.setBackground(new Color(188, 205, 227));
		login.setBounds(300, 380, 300, 50);
		login.setFont(LoginFont1);
		login.addActionListener(this);

		// 아이디 찾기 버튼
		IdSearch = new Button("ID 찾기");
		IdSearch.setBackground(new Color(188, 205, 227));
		IdSearch.setBounds(300, 435, 75, 40);
		IdSearch.addActionListener(this);

		// 비밀번호찾기 버튼
		PwdSearch = new Button("Pwd 찾기");
		PwdSearch.setBackground(new Color(188, 205, 227));
		PwdSearch.setBounds(380, 435, 70, 40);
		PwdSearch.addActionListener(this);

		// 회원가입 버튼
		Register = new Button("회원가입");
		Register.setBackground(new Color(188, 205, 227));
		Register.setBounds(455, 435, 145, 40);
		Register.addActionListener(this);

		// ID 라벨
		Label lid = new Label("ID : ", Label.RIGHT);
		lid.setBounds(0, 250, 300, 50);
		lid.setForeground(Color.white);
		lid.setFont(IdPwdFont);

		// Password 라벨
		Label lpwd = new Label("Password : ", Label.RIGHT);
		lpwd.setBounds(0, 300, 300, 50);
		lpwd.setForeground(Color.white);
		lpwd.setFont(IdPwdFont);

		// login 라벨
		Label Login = new Label("Green House", Label.CENTER);
		Login.setBounds(190, 150, 620, 100);
		Login.setForeground(Color.WHITE);
		Login.setBackground(new Color(188, 205, 194));
		Login.setFont(LoginFont);

		// 로고
		searchURL = getClass().getResource("/img/Logo2.png");
		imageicon = new ImageIcon(searchURL);
		Image image = imageicon.getImage();
		Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		movieporster = new JButton(scaledIcon);// 크기 바꿀때 imageicon-->scaledIcon 으로 변경
		movieporster.setBounds(90, 150, 100, 100);
		movieporster.setBackground(Color.red);
		movieporster.setBorderPainted(false);
		movieporster.setFocusPainted(false);
		movieporster.setContentAreaFilled(false);

		// ID 입력창
		id = new TextField();
		id.setBounds(300, 255, 300, 40);
		id.setBackground(Color.lightGray);
		id.setForeground(Color.DARK_GRAY);
		id.setFont(IdPwdFont);

		// Password 입력창
		pwd = new TextField();
		pwd.setBounds(300, 310, 300, 40);
		pwd.setBackground(Color.lightGray);
		pwd.setForeground(Color.DARK_GRAY);
		pwd.setFont(IdPwdFont);

		// 아이디 비밀번호 확인 출력창
		Lab_1 = new Label();
		Lab_1.setBounds(300, 350, 300, 30);
		Lab_1.setBackground(new Color(188, 205, 194));
		Lab_1.setForeground(Color.red);
		Lab_1.setFont(trueandfalseFont);
		pwd.setEchoChar('*');

		f.add(movieporster);
		f.add(Login);
		f.add(lid);
		f.add(id);
		f.add(IdSearch);
		f.add(lpwd);
		f.add(pwd);
		f.add(PwdSearch);
		f.add(Lab_1);
		f.add(login);
		f.add(Register);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Login")) {
			System.out.println("로그인 시도");
			pid = id.getText();
			password = pwd.getText();
			System.out.println(id + ", " + password);
			login(pid, password);
		} else if (e.getActionCommand().equals("회원가입")) {
			f.setVisible(false);
			Register Re = new Register();
		}
		if (e.getActionCommand().equals("ID 찾기")) {
			f.setVisible(false);
			IdSearch idsearch = new IdSearch();
		}

		if (e.getActionCommand().equals("Pwd 찾기")) {
			f.setVisible(false);
			PwdSearch pwd = new PwdSearch();
		}
	}

	public void login(String pid, String password) {
		customerDao.connect();
		int checkIndex = customerDao.login(pid, password);
		
		if (id.getText().equals("") || pwd.getText().equals("")) {
			NullInfo();
		} else {
			switch (checkIndex) {
			case 0: // 성공
				moviedata.setMovieID(pid);
				loginSuccess();
				break;
			case -1:
				passwordError();
				break;
			case -2:
				loginFail();
				break;
			default:
				System.out.println("시스템 오류입니다.");
				break;
			}
		}
	}

	// 로그인 성공
	private void loginSuccess() {
		Lab_1.setText("로그인이 되었습니다.");
		f.setVisible(false);
		customer = customerDao.selectById(pid);
		MainFrame mainframe = new MainFrame();
	}

	// 비밀번호 오류
	private void passwordError() {
		Lab_1.setText("아이디 비밀번호가 틀림");
	}

	// 등록되지 않은 아이디
	private void loginFail() {
		Lab_1.setText("회원 정보가 존재하지 않습니다.");
	}

	private void NullInfo() {
		Lab_1.setText("ID 와 PASSWORD 를 입력해주세요.");
	}

	public static void main(String[] args) {
		Login tft = new Login();
	}
}