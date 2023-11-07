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

public class PwdSearch extends WindowAdapter implements ActionListener {
	private Frame f, clearf;
	private Button PwdSearch, ChangePwd, LoginMove, clearbt;
	TextField Tf1, Name, Id, Pwd, Pwd2;
	Label PwdTitle, NameLabel, IdLabel, TrueAndFalse, PwdLabel, PwdLabel2, clearlb;
	Font PwdSearchFont = new Font("고딕", Font.BOLD, 50);
	Font RegisterIdPwdFont = new Font("고딕", Font.BOLD, 23);
	Font NewPwdFont = new Font("고딕", Font.BOLD, 15);
	Font InfoFont = new Font("고딕", Font.BOLD, 10);

	private CustomerDAO customerDao = CustomerDAO.getInstance();
	CustomerVO customer = new CustomerVO();
	private String name = "";
	private String id = "";
  
	public PwdSearch() {
		Font clearFont = new Font("고딕", Font.PLAIN, 25);

		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		// 매인 프레임
		f = new Frame("PwdSearch");
		f.setSize(700, 400);
		f.setLayout(null);
		f.setBackground(new Color(188, 205, 194));
		f.setResizable(false);
		f.setLocation((scr.width - 700) / 2, (scr.height - 400) / 2);
		f.addWindowListener(this);

		// 비밀번호 찾기 타이틀
		PwdTitle = new Label("비밀번호 찾기");
		PwdTitle.setBounds((700 - 312) / 2, 60, 312, 50);
		PwdTitle.setForeground(Color.WHITE);
		PwdTitle.setFont(PwdSearchFont);

		// NameLabel
		NameLabel = new Label("Name : ");
		NameLabel.setBounds(105, 118, 90, 50);
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setFont(RegisterIdPwdFont);

		// Namem 입력창
		Name = new TextField();
		Name.setBounds(200, 132, 300, 28);
		Name.setFont(RegisterIdPwdFont);

		// IdLabel
		IdLabel = new Label("ID : ");
		IdLabel.setBounds(145, 158, 50, 50);
		IdLabel.setForeground(Color.WHITE);
		IdLabel.setFont(RegisterIdPwdFont);

		// Id 입력창
		Id = new TextField();
		Id.setBounds(200, 170, 300, 28);
		Id.setFont(RegisterIdPwdFont);

		// 비밀번호 찾기 버튼
		PwdSearch = new Button("비밀번호 찾기");
		PwdSearch.setBounds(510, 133, 90, 60);
		PwdSearch.setBackground(new Color(188, 205, 227));
		PwdSearch.addActionListener(this);

		// 비밀번호 출력 라벨
		TrueAndFalse = new Label();
		TrueAndFalse.setBounds(200, 200, 300, 20);
		TrueAndFalse.setForeground(Color.red);
		TrueAndFalse.setFont(InfoFont);

		// 로그인창으로 이동
		LoginMove = new Button("로그인 창으로 이동");
		LoginMove.setBounds(200, 222, 120, 50);
		LoginMove.setBackground(new Color(188, 205, 227));
		LoginMove.addActionListener(this);

		// 비밀번호 변경 완료창
		clearf = new Frame();
		clearf.setSize(250, 150);
		clearf.setLayout(null);
		clearf.setBackground(new Color(188, 205, 194));
		clearf.setResizable(false);
		clearf.setLocation((scr.width - 250) / 2, (scr.height - 150) / 2);
		
		// 비밀번호 변경 완료버튼
		clearbt = new Button("확인");
		clearbt.setBounds(100, 100, 50, 30);
		clearbt.addActionListener(this);

		// 비밀번호 변경 라벨
		clearlb = new Label("비밀번호 변경 완료");
		clearlb.setBounds(17, 55, 220, 30);
		clearlb.setFont(clearFont);

		f.add(LoginMove);
		f.add(TrueAndFalse);
		f.add(PwdSearch);
		f.add(Id);
		f.add(IdLabel);
		f.add(Name);
		f.add(NameLabel);
		f.add(PwdTitle);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("확인")) {
			f.setVisible(false);
			clearf.setVisible(false);
			Login login = new Login();
		}
		if (e.getActionCommand().equals("비밀번호 찾기")) {
			name = Name.getText();
			id = Id.getText();

			if (name.equals("") || id.equals("")) {
				TrueAndFalse.setText("이름과 아이디를 입력해주세요.");
			} else if (searchPWD(name, id) == 0) {
				// 로그인창으로 이동 버튼 삭제
				f.remove(LoginMove);

				// Password 라벨
				PwdLabel = new Label("New Password : ");
				PwdLabel.setBounds(62, 226, 125, 25);
				PwdLabel.setFont(NewPwdFont);

				// Password 확인 라벨
				PwdLabel2 = new Label("Confirm Password : ");
				PwdLabel2.setBounds(34, 266, 150, 25);
				PwdLabel2.setFont(NewPwdFont);

				// Password 입력창
				Pwd = new TextField();
				Pwd.setBounds(200, 225, 300, 27);
				Pwd.setBackground(Color.lightGray);
				Pwd.setForeground(Color.DARK_GRAY);
				Pwd.setEchoChar('*');
				Pwd.setFont(NewPwdFont);

				// Password확인 입력창
				Pwd2 = new TextField();
				Pwd2.setBounds(200, 265, 300, 27);
				Pwd2.setBackground(Color.lightGray);
				Pwd2.setForeground(Color.DARK_GRAY);
				Pwd2.setEchoChar('*');
				Pwd2.setFont(NewPwdFont);

				// 비밀번호 변경 버튼 --------------------액션뭐시기에서 액션리스너는 안먹히는지
				ChangePwd = new Button("비밀번호 변경");
				ChangePwd.setBounds(510, 227, 90, 60);
				ChangePwd.setBackground(new Color(188, 205, 227));
				ChangePwd.addActionListener(this);

				// 로그인창으로 이동
				LoginMove = new Button("로그인 창으로 이동");
				LoginMove.setBounds(200, 300, 120, 50);
				LoginMove.setBackground(new Color(188, 205, 227));
				LoginMove.addActionListener(this);

				f.add(LoginMove);
				f.add(ChangePwd);
				f.add(PwdLabel);
				f.add(PwdLabel2);
				f.add(Pwd);
				f.add(Pwd2);
			} else {
				TrueAndFalse.setText("가입하신 이름과 아이디 정보가 일치하지 않습니다.");
			}
		}
		if (e.getActionCommand().equals("로그인 창으로 이동")) {
			f.setVisible(false);
			Login login = new Login();
		}

		if (e.getActionCommand().equals("비밀번호 변경")) {
			if (Pwd.getText().equals("") || Pwd2.getText().equals("")) {
				TrueAndFalse.setText("변경하실 비밀번호를 입력해주세요.");
			} else if (Pwd.getText().equals(Pwd2.getText())) {
				customerDao.connect();
				customerDao.ChangePWD(Pwd.getText(), id);
				TrueAndFalse.setText("변경이 완료되었습니다.");
				clearf.add(clearlb);
				clearf.add(clearbt);
				clearf.setVisible(true);
			} else {
				TrueAndFalse.setText("입력하신 비밀번호가 다름니다.");
			}
		}
	}

	public int searchPWD(String name, String id) {
		customerDao.connect();
		int checkPWD = customerDao.SearchPWD(name, id);
		if (checkPWD == 0) { // 성공
			checkSuccess();
			return 0;
		} else {
			checkFail();
			return -1;
		}
	}

	private void checkSuccess() {
		TrueAndFalse.setText("변경할 비밀번호를 입력해주세요.");
	}

	private void checkFail() {
		TrueAndFalse.setText("가입하신 이름과 아이디 정보가 일치하지 않습니다.");
	}

	public static void main(String[] args) {
		PwdSearch pwdSearch = new PwdSearch();
	}
}
