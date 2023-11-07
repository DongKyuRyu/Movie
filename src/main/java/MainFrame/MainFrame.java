package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends WindowAdapter implements ActionListener{
	private Frame f;
	private Button b1, b2, b3, b4, logout;
	Label Title;
private MovieData moviedata = MovieData.getInstance();
	
	public MainFrame() {
		Font TitleFont = new Font("고딕", Font.BOLD, 60);  
		
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		 
		f = new Frame("영화예매");
		f.setResizable(false);
		f.setSize(500, 700);
		f.setBackground(new Color(188, 205, 194));
		f.setLayout(null);
		f.setLocation((scr.width-500)/2,(scr.height-700)/2);
		f.addWindowListener(this);
		
		b1 = new Button("영화 예매");
		b1.setBounds(50, 200, 175, 150);
		b1.setBackground(new Color(188, 205, 227));
		b1.addActionListener(this);
		
		b2 = new Button("행운의 편지");
		b2.setBounds(275, 200, 175, 150);
		b2.setBackground(new Color(188, 205, 227));
		
		b3 = new Button("예매 확인");
		b3.setBounds(50, 400, 175, 150);
		b3.setBackground(new Color(188, 205, 227));
		b3.addActionListener(this);
		
		b4 = new Button("내 정보");
		b4.setBounds(275, 400, 175, 150);
		b4.setBackground(new Color(188, 205, 227));
		
		logout = new Button("Logout");
		logout.setBounds(165, 600, 170, 50);
		logout.setBackground(new Color(188, 205, 227));
		logout.addActionListener(this);
		
		Title = new Label("GreenHouse");
		Title.setBounds(70, 100, 360, 80);
		Title.setFont(TitleFont);

		f.add(Title);
		f.add(logout);
		f.add(b4);
		f.add(b3);
		f.add(b2);
		f.add(b1);
		f.setVisible(true);
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Logout")) {
			f.setVisible(false);
			Login login = new Login();
		}
		
		if (e.getActionCommand().equals("영화 예매")) {
			f.setVisible(false);
			MovieList movielist = new MovieList();
		}
		
		if (e.getActionCommand().equals("예매 확인")) {
	         if (moviedata.getMovieList() != null) {
	            f.setVisible(false);
	            PaymentCompleted pay = new PaymentCompleted();
	         } else {
	            System.out.println("예매 정보가 없습니다.");
	         }
	      }
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
	}
}
