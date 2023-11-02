package MainFrame;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import DAO.MovieDAO;
//import VO.MovieVO;

public class MovieList extends WindowAdapter implements ActionListener, ItemListener{
	private Frame f;
	private Checkbox selectMovie1, selectMovie2, selectMovie3;
	private Panel Movienamelist;
	private Label Title, movielist;
	private Button Next, Befor;
	private String movieName = "";
	
//	private MovieVO movie;
//	
//	private MovieDAO movieDao = MovieDAO.getInstance();
//	MovieVO customer = new MovieVO();

	public MovieList() {
		Font TitleFont = new Font("고딕", Font.BOLD, 60);
		Font movielistFont = new Font("고딕", Font.BOLD, 55);
		Font movieNameFont = new Font("고딕", Font.BOLD, 50);
		
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		
		f = new Frame("영화예매");
		f.setResizable(false);
		f.setSize(500, 700);
		f.setBackground(new Color(188, 205, 194));
		f.setLayout(null);
		f.setLocation((scr.width-500)/2,(scr.height-700)/2);
		f.addWindowListener(this);
		
		CheckboxGroup moviename = new CheckboxGroup();
		selectMovie1 = new Checkbox("30일", moviename, false);
		selectMovie2 = new Checkbox("용감한 시민", moviename, false);
		selectMovie3 = new Checkbox("천박사", moviename, false);
		selectMovie1.setBounds(10, 70, 370, 54);
		selectMovie2.setBounds(10, 134, 370, 54);
		selectMovie3.setBounds(10, 188, 370, 54);
		selectMovie1.setFont(movieNameFont);
		selectMovie2.setFont(movieNameFont);
		selectMovie3.setFont(movieNameFont);
		selectMovie1.addItemListener(this);
		selectMovie2.addItemListener(this);
		selectMovie3.addItemListener(this);
		
		movielist = new Label("영화 제목");
		movielist.setBounds(75, 10, 250, 57);
		movielist.setFont(movielistFont);
		
		Title = new Label("GreenHouse");
		Title.setBounds(70, 100, 360, 80);
		Title.setFont(TitleFont);
		
		Movienamelist = new Panel();
		Movienamelist.setLayout(null);
		Movienamelist.setBackground(Color.lightGray);
		Movienamelist.setBounds(50, 180,400, 400);
		
		Next = new Button("다 음");
		Next.setBounds(260, 625, 100, 30);
		Next.setBackground(new Color(188, 205, 227));
		Next.addActionListener(this);
		
		Befor = new Button("이 전");
		Befor.setBounds(140, 625, 100, 30);
		Befor.setBackground(new Color(188, 205, 227));
		Befor.addActionListener(this);

		Movienamelist.add(movielist);
		Movienamelist.add(selectMovie1);
		Movienamelist.add(selectMovie2);
		Movienamelist.add(selectMovie3);
		
		f.add(Befor);
		f.add(Movienamelist);
		f.add(Title);
		f.setVisible(true);
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("이 전")) {
			f.setVisible(false);
			MainFrame mainframe = new MainFrame();
		}
		if (e.getActionCommand().equals("다 음")) {
//			movieDao.connect();
//			movie = movieDao.getMovie(movieName);

			f.setVisible(false);
			CalendarEx calendarex = new CalendarEx("다 음");
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getItem().equals("30일"))
			this.movieName = "30일";
		else if(e.getItem().equals("천박사"))
			this.movieName = "천박사";
		else if(e.getItem().equals("용감한 시민"))
			this.movieName = "용감한 시민";
		if (e.getItem().equals("30일") || e.getItem().equals("천박사") || e.getItem().equals("용감한 시민")) {
			f.add(Next);
		}
	}
	
	public String returnMovie() {
		return movieName;
	}
	
	public static void main(String[] args) {
		MovieList frame = new MovieList();
	}
}
