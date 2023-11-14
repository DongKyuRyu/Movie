package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import DAO.CustomerDAO;
import VO.CustomerVO;

public class IdSearch extends WindowAdapter implements ActionListener {
	private Frame f, IDCopyCheck;
	private Button IdSearch, returnButton, PwdSearch, IDCopy, IDCopyCheckBt;
	TextField Name, Email;
	Label NameLabel, idtitle, EmailLabel, Info, IDCopyCheckLb;

	private CustomerDAO customerDao = CustomerDAO.getInstance();
	private String name = "";
	private String email = "";

	public IdSearch() {
		Font IdSearchFont = new Font("고딕", Font.BOLD, 50);
		Font RegisterIdPwdFont = new Font("고딕", Font.BOLD, 23);
		Font InfoFont = new Font("고딕", Font.BOLD, 20);

		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		// 매인 프레임
		f = new Frame("아이디 찾기");
		f.setSize(700, 400);
		f.setLayout(null);
		f.setBackground(new Color(188, 205, 194));
		f.setResizable(false);
		f.setLocation((scr.width - 700) / 2, (scr.height - 400) / 2);
		f.addWindowListener(this);

		// 아이디 찾기 타이틍
		idtitle = new Label("아이디 찾기");
		idtitle.setBounds((700 - 260) / 2, 60, 260, 50);
		idtitle.setForeground(Color.WHITE);
		idtitle.setFont(IdSearchFont);

		// NameLabel
		NameLabel = new Label("Name : ");
		NameLabel.setBounds(100, 118, 90, 50);
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setFont(RegisterIdPwdFont);

		// Namem 입력창
		Name = new TextField();
		Name.setBounds(200, 132, 300, 27);
		Name.setFont(RegisterIdPwdFont);

		// EmailLabel
		EmailLabel = new Label("Email : ");
		EmailLabel.setBounds(100, 158, 90, 50);
		EmailLabel.setForeground(Color.WHITE);
		EmailLabel.setFont(RegisterIdPwdFont);

		// Email 입력창
		Email = new TextField();
		Email.setBounds(200, 170, 300, 27);
		Email.setFont(RegisterIdPwdFont);

		// Id 찾기 버튼
		IdSearch = new Button("ID 찾기");
		IdSearch.setBounds(510, 133, 80, 60);
		IdSearch.setBackground(new Color(188, 205, 227));
		IdSearch.addActionListener(this);

		// Id 출력 라벨
		Info = new Label();
		Info.setBounds(200, 200, 210, 25);
		Info.setForeground(Color.red);
		Info.setFont(InfoFont);

		// 로그인창으로 돌아가기 버튼
		returnButton = new Button("로그인 하러 가기");
		returnButton.setBounds(200, 230, 100, 50);
		returnButton.setBackground(new Color(188, 205, 227));
		returnButton.addActionListener(this);

		// 비밀번호 찾기 버튼
		PwdSearch = new Button("비밀번호 찾기");
		PwdSearch.setBounds(305, 230, 100, 50);
		PwdSearch.setBackground(new Color(188, 205, 227));
		PwdSearch.addActionListener(this);

		// Id 복사 버튼
		IDCopy = new Button("아이디 복사");
		IDCopy.setBounds(420, 205, 80, 30);
		IDCopy.setBackground(new Color(188, 205, 227));
		IDCopy.addActionListener(this);

		IDCopyCheck = new Frame("아이디 복사 완료");
		IDCopyCheck.setSize(200, 130);
		IDCopyCheck.setLayout(null);
		IDCopyCheck.setBackground(new Color(188, 205, 194));
		IDCopyCheck.setResizable(false);
		IDCopyCheck.setLocation((scr.width - 200) / 2, (scr.height - 100) / 2);
		IDCopyCheck.addWindowListener(this);

		IDCopyCheckBt = new Button("확인");
		IDCopyCheckBt.setBounds(60, 80, 80, 30);
		IDCopyCheckBt.setBackground(new Color(188, 205, 227));
		IDCopyCheckBt.addActionListener(this);

		IDCopyCheckLb = new Label("아이디 복사 완료");
		IDCopyCheckLb.setBounds(20, 50, 160, 30);
		IDCopyCheckLb.setFont(InfoFont);
		IDCopyCheckLb.setBackground(new Color(188, 205, 194));

		f.add(returnButton);
		f.add(Info);
		f.add(IdSearch);
		f.add(Email);
		f.add(EmailLabel);
		f.add(Name);
		f.add(NameLabel);
		f.add(idtitle);
		f.setVisible(true);

		IDCopyCheck.add(IDCopyCheckBt);
		IDCopyCheck.add(IDCopyCheckLb);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("로그인 하러 가기")) {
			f.setVisible(false);
			Login login = new Login();
		}

		if (e.getActionCommand().equals("비밀번호 찾기")) {
			f.setVisible(false);
			PwdSearch pwdsearch = new PwdSearch();
		}

		if (e.getActionCommand().equals("ID 찾기")) {
			if (Name.getText().equals("") || Email.getText().equals("")) {
				Info.setText("Name과 Email을 입력해주세요.");
			} else {
				name = Name.getText().trim();
				email = Email.getText().trim();
				String viewID = searchID(name, email);
				if (viewID == null)
					NonSearchID();
				else {
					Info.setText("ID : " + searchID(name, email));
					f.add(PwdSearch);
					f.add(IDCopy);
				}
			}
		}

		if (e.getActionCommand().equals("아이디 복사")) {
			StringSelection data = new StringSelection(searchID(name, email));
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(data, data);
			IDCopyCheck.setVisible(true);
		}

		if (e.getActionCommand().equals("확인")) {
			IDCopyCheck.setVisible(false);
		}
	}

	public String searchID(String name, String email) {
		customerDao.connect();
		String checkName = customerDao.SearchID(name, email);
		return checkName;
	}

	private void NonSearchID() {
		Info.setText("존재하지 않습니다.");
	}

	public static void main(String[] args) {
		IdSearch id = new IdSearch();
	}
}
