package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import DAO.CustomerDAO;
import VO.CustomerVO;

public class Register extends WindowAdapter implements ActionListener {
	private Frame Register, clearf;
	private Button b1, Finish, close, clearbt;
	private TextField newId, newPwd, Pwd2, Email, Name;
	private Label NameTrueAndFalse, RegisterLabel, IdTrueAndFalse, PwdTrueAndFalse, IdLabel, PwdLabel, PwdLabel2,
			EmailLabel, NameLabel, clearlb;
	private boolean pwd, name;

	private CustomerDAO customerDao = CustomerDAO.getInstance();
	private CustomerVO customer = new CustomerVO();
	private String pid = "";
	private String password = "";
	private String newName = "";
	private String newEmail = "";

	public Register() {
		Font RegisterFont = new Font("고딕", Font.BOLD, 50);
		Font RegisterIdPwdFont = new Font("고딕", Font.BOLD, 25);
		Font clearFont = new Font("고딕", Font.PLAIN, 25);

		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		// 매인 프레임
		Register = new Frame("Register");
		Register.setSize(900, 450);
		Register.setLayout(null);
		Register.setBackground(new Color(188, 205, 194));
		Register.setResizable(false);
		Register.setLocation((scr.width - 900) / 2, (scr.height - 450) / 2);
		Register.addWindowListener(this);

		// 회원가입 라벨
		RegisterLabel = new Label("회원가입");
		RegisterLabel.setBounds(350, 60, 300, 50);
		Register.setForeground(Color.WHITE);
		RegisterLabel.setFont(RegisterFont);

		// ID 라벨
		IdLabel = new Label("ID : ");
		IdLabel.setBounds(300, 130, 40, 25);
		IdLabel.setFont(RegisterIdPwdFont);

		// Password 라벨
		PwdLabel = new Label("Password : ");
		PwdLabel.setBounds(208, 180, 140, 25);
		PwdLabel.setFont(RegisterIdPwdFont);

		// Password 확인 라벨
		PwdLabel2 = new Label("Confirm Password : ");
		PwdLabel2.setBounds(108, 215, 240, 25);
		PwdLabel2.setFont(RegisterIdPwdFont);

		// ID 입력창
		newId = new TextField();
		newId.setBounds(350, 130, 250, 27);
		newId.setBackground(Color.lightGray);
		newId.setForeground(Color.DARK_GRAY);
		newId.setFont(RegisterIdPwdFont);

		// Password 입력창
		newPwd = new TextField();
		newPwd.setBounds(350, 181, 250, 27);
		newPwd.setBackground(Color.lightGray);
		newPwd.setForeground(Color.DARK_GRAY);
		newPwd.setEchoChar('*');
		newPwd.setFont(RegisterIdPwdFont);

		// Password확인 입력창
		Pwd2 = new TextField();
		Pwd2.setBounds(350, 215, 250, 27);
		Pwd2.setBackground(Color.lightGray);
		Pwd2.setForeground(Color.DARK_GRAY);
		Pwd2.setEchoChar('*');
		Pwd2.setFont(RegisterIdPwdFont);

		// ID 중복확인 출력창
		IdTrueAndFalse = new Label();
		IdTrueAndFalse.setBackground(new Color(188, 205, 194));
		IdTrueAndFalse.setForeground(Color.red);
		IdTrueAndFalse.setBounds(350, 160, 250, 22);

		// Password 중복확인 출력창
		PwdTrueAndFalse = new Label();
		PwdTrueAndFalse.setBackground(new Color(188, 205, 194));
		PwdTrueAndFalse.setForeground(Color.red);
		PwdTrueAndFalse.setBounds(350, 240, 250, 22);
		pwd = false;

		// 중복확인 버튼
		b1 = new Button("중복확인");
		b1.setBounds(610, 130, 100, 27);
		b1.setBackground(new Color(188, 205, 227));
		b1.setForeground(Color.BLACK);
		b1.addActionListener(this);

		// 이름 라벨
		NameLabel = new Label("Name : ");
		NameLabel.setFont(RegisterIdPwdFont);
		NameLabel.setBounds(257, 260, 90, 27);

		// 이름 입력창
		Name = new TextField();
		Name.setBounds(350, 261, 250, 27);
		Name.setBackground(Color.lightGray);
		Name.setForeground(Color.DARK_GRAY);
		Name.setFont(RegisterIdPwdFont);

		NameTrueAndFalse = new Label();
		NameTrueAndFalse.setBounds(350, 325, 250, 22);
		NameTrueAndFalse.setForeground(Color.red);
		name = false;

		// Emalil 입력창
		Email = new TextField();
		Email.setBounds(350, 295, 250, 27);
		Email.setBackground(Color.lightGray);
		Email.setForeground(Color.DARK_GRAY);
		Email.setFont(RegisterIdPwdFont);

		// Email 라벨
		EmailLabel = new Label("Email : ");
		EmailLabel.setFont(RegisterIdPwdFont);
		EmailLabel.setBounds(257, 295, 90, 27);

		// 회원가입 완료 버튼
		Finish = new Button("회원가입");
		Finish.setBounds(500, 350, 100, 27);
		Finish.setForeground(Color.BLACK);
		Finish.setBackground(new Color(188, 205, 227));
		Finish.addActionListener(this);

		// 취소 버튼
		close = new Button("취소");
		close.setBounds(350, 350, 100, 27);
		close.setForeground(Color.BLACK);
		close.setBackground(new Color(188, 205, 227));
		close.addActionListener(this);
		
		// 회원가입 완료창
		clearf = new Frame();
		clearf.setSize(200, 150);
		clearf.setLayout(null);
		clearf.setBackground(new Color(188, 205, 194));
		clearf.setResizable(false);
		clearf.setLocation((scr.width - 200) / 2, (scr.height - 150) / 2);
		
		// 회원가입 완료버튼
		clearbt = new Button("확인");
		clearbt.setBounds(75, 100, 50, 30);
		clearbt.addActionListener(this);
		
		// 회원가입 라벨
		clearlb = new Label("회원가입 완료");
		clearlb.setBounds(20, 55, 165, 30);
		clearlb.setFont(clearFont);

		Register.add(NameTrueAndFalse);
		Register.add(close);
		Register.add(EmailLabel);
		Register.add(Email);
		Register.add(PwdTrueAndFalse);
		Register.add(PwdLabel2);
		Register.add(Pwd2);
		Register.add(Name);
		Register.add(NameLabel);
		Register.add(IdTrueAndFalse);
		Register.add(b1);
		Register.add(newPwd);
		Register.add(newId);
		Register.add(PwdLabel);
		Register.add(IdLabel);
		Register.add(RegisterLabel);
		Register.setVisible(true);
	}

	public void Namecopy() {
		String newName = Name.getText();
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("취소")) {
			Register.setVisible(false);
			Login login = new Login();
		}

		if (e.getActionCommand().equals("중복확인")) {
			if (newId.getText().equals("")) {
				IdTrueAndFalse.setText("사용할 아이디를 입력해주세요.");
			} else {
				pid = newId.getText();
				Duplication(pid);
			}
		}
		if (e.getActionCommand().equals("회원가입")) {
			if (newPwd.getText().equals("") || Pwd2.getText().equals("")) {
				PwdTrueAndFalse.setText("비밀번호를 입력하세요.");
			} else if (newPwd.getText().equals(Pwd2.getText())) {
				PwdTrueAndFalse.setText("비밀번호가 일치합니다.");
				pwd = true;
			} else {
				PwdTrueAndFalse.setText("비밀번호가 일치하지않습니다.");
			}

			if (Name.getText().equals("") || Email.getText().equals("")) {
				NameTrueAndFalse.setText("Name 과 Email을 입력해주세요.");
			} else {
				NameTrueAndFalse.setText("");
				name = true;
			}
			if (pwd == true && name == true) {
				PwdTrueAndFalse.setText("회원가입 성공");
				realregister(pid, password, newName, newEmail);
				clearf.add(clearlb);
				clearf.add(clearbt);
				clearf.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("확인")) {
			clearf.setVisible(false);
			Register.setVisible(false);
			Login login = new Login();
		}
	}

	public void realregister(String name, String id, String password, String email) {
		customerDao.connect();
		if (newPwd.getText().trim().equals(Pwd2.getText().trim())) {
			customer = new CustomerVO(Name.getText().trim(), newId.getText().trim(), newPwd.getText().trim(),
					Email.getText());
			if (customerDao.register(customer)) {
				System.out.println("회원가입 완료");
			} else {
				System.out.println("회원가입 실패");
			}
		} else {
			System.out.println("비밀번호 오류");
		}
	}

	public void Duplication(String pid) {
		customerDao.connect();
		int checkID = customerDao.Duplication(pid);
		switch (checkID) {
		case 0:
			duplicationFalse();
			break;
		case -1:
			duplicationTrue();
			break;
		default:
			System.out.println("시스템 오류입니다.");
			break;
		}
	}

	private void duplicationFalse() {
		IdTrueAndFalse.setText("이미 가입된 아이디 입니다.");
		Register.remove(Finish);
	}

	private void duplicationTrue() {
		IdTrueAndFalse.setText("사용 가능한 아이디 입니다.");
		Register.add(Finish);
	}
	public static void main(String[] args) {
		Register regs = new Register();
	}
}
