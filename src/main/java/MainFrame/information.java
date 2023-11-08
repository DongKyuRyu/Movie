package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
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

import DAO.CustomerDAO;
import VO.CustomerVO;

public class information extends WindowAdapter implements ActionListener {
	private Frame f;
	private Button b2;
	private Panel Background,historys;
	private URL searchURL;
	private ImageIcon imageicon;
	private JButton b1;
	Label Title, name,email,name1,email1,history;
	private String full;
	private CustomerDAO customerDao = CustomerDAO.getInstance();
	private MovieData moviedata =MovieData.getInstance();
	

	public information() {
		customerDao.connect();
		Font greenFont = new Font("고딕", Font.BOLD, 60);
		Font TitleFont = new Font("고딕", Font.BOLD, 20);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		f = new Frame();
		f.setResizable(false);
		f.setSize(800, 850);
		f.setBackground(new Color(188, 205, 194));
		f.setLayout(null);
		f.setLocation((scr.width - 500) / 2, (scr.height - 700) / 2);
		f.addWindowListener(this);

		Background = new Panel();
		Background.setLayout(null);
		Background.setBounds(100, 150, 600, 600);
		Background.setBackground(Color.lightGray);
	
//버튼으로 변경 -> 홈화면이동 계획이있음 차후에
		Title = new Label("GreenHouse");
		Title.setBounds(230, 50, 360, 80);
		Title.setFont(greenFont);
		//이름표시란
		name = new Label("name");
		name.setBounds(380,  200, 300, 50);
		name.setFont(TitleFont);
		name.setBackground(Color.blue);
		
		//이름적는칸
	
		
		name1 = new Label(customerDao.fullname(moviedata.getMovieID()));
		name1.setBounds(380, 250, 300, 50);
		name1.setFont(TitleFont);
		name1.setBackground(Color.blue);
		//이메일표시란
		email = new Label("email");
		email.setBounds(380, 300, 300, 50);
		email.setFont(TitleFont);
		email.setBackground(Color.gray);
		//이메일 적는칸
		
		email1 = new Label(customerDao.fullemail(moviedata.getMovieID()));
		email1.setBounds(380, 350, 300, 50);
		email1.setFont(TitleFont);
		email1.setBackground(Color.gray);
		//사진넣을 칸
		searchURL = getClass().getResource("/img/my.png");
		imageicon = new ImageIcon(searchURL);
		b1 = new JButton(imageicon);
		b1.setBounds(120, 170, 250, 250);
		b1.setBackground(Color.RED);
		b1.setBorderPainted(false);
		b1.setFocusPainted(false);
		b1.setContentAreaFilled(false);
		
		//히스토리 라벨
		history = new Label("히스토리");
		history.setBounds(120, 440, 300, 50);
		history.setFont(TitleFont);
		history.setBackground(Color.gray);
		//히스토리 적히는칸
		historys = new Panel();
		historys.setLayout(null);
		historys.setBounds(120, 500, 550, 230);
		historys.setBackground(Color.green);
		//홈 버튼
		b2 = new Button("HOME");
		b2.setBounds(350,770, 100, 50);
		b2.setBackground(Color.lightGray);
		b2.addActionListener(this);
		
		f.add(b2);
		f.add(historys);
		f.add(history);
		f.add(name1);
		f.add(email1);
		f.add(name);
		f.add(email);
		f.add(b1);
		f.add(Title);
		f.add(Background);
		f.setVisible(true);

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		information f = new information();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("HOME")) {
			f.setVisible(false);
			MainFrame main = new MainFrame();
		}
	}
	

	public void windowOpened(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
}