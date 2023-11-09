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

public class MovieTime extends WindowAdapter implements ActionListener, ItemListener{
	private Frame f;
	private Checkbox selectMovie1, selectMovie2, selectMovie3;
	private Panel MovieTimelist;
	private Label Title, movieTime;
	private Button Next, Befor;
	
	private MovieData moviedata = MovieData.getInstance();
	
//	public void setChoiceTime(String Choicetime) {
//		this.Choicetime = Choicetime;
//	}
//	
//	public String getChoiceTime() {
//		return Choicetime;
//	}
	
	public MovieTime() {
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
	selectMovie1 = new Checkbox("12:00 ~ 14:20", moviename, false);
	selectMovie2 = new Checkbox("14:30 ~ 16:50", moviename, false);
	selectMovie3 = new Checkbox("17:00 ~ 19:20", moviename, false);
	selectMovie1.setBounds(10, 70, 370, 54);
	selectMovie2.setBounds(10, 128, 370, 54);
	selectMovie3.setBounds(10, 188, 370, 54);
	selectMovie1.setFont(movieNameFont);
	selectMovie2.setFont(movieNameFont);
	selectMovie3.setFont(movieNameFont);
	selectMovie1.addItemListener(this);
	selectMovie2.addItemListener(this);
	selectMovie3.addItemListener(this);
	
	movieTime = new Label("상영 시간");
	movieTime.setBounds(75, 10, 250, 57);
	movieTime.setFont(movielistFont);
	
	Title = new Label("GreenHouse");
	Title.setBounds(70, 100, 360, 80);
	Title.setFont(TitleFont);
	
	MovieTimelist = new Panel();
	MovieTimelist.setLayout(null);
	MovieTimelist.setBackground(Color.lightGray);
	MovieTimelist.setBounds(50, 180,400, 400);
	
	Next = new Button("다 음");
	Next.setBounds(260, 625, 100, 30);
	Next.setBackground(new Color(188, 205, 227));
	Next.addActionListener(this);
	
	Befor = new Button("이 전");
	Befor.setBounds(140, 625, 100, 30);
	Befor.setBackground(new Color(188, 205, 227));
	Befor.addActionListener(this);
	
	MovieTimelist.add(movieTime);
	MovieTimelist.add(selectMovie1);
	MovieTimelist.add(selectMovie2);
	MovieTimelist.add(selectMovie3);
	
//	calendarex.setVisible(false);
	f.add(MovieTimelist);
	f.add(Befor);
	f.add(Title);
	f.setVisible(true);
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getItem().equals("12:00 ~ 14:20")) {
			moviedata.setMovieTime("12:00 ~ 14:20");
		}else if(e.getItem().equals("14:30 ~ 16:50")) {
			moviedata.setMovieTime("14:30 ~ 16:50");
		}else if(e.getItem().equals("17:00 ~ 19:20")) {
			moviedata.setMovieTime("17:00 ~ 19:20");
		}
		
		if (e.getItem().equals("12:00 ~ 14:20") || e.getItem().equals("14:30 ~ 16:50") || e.getItem().equals("17:00 ~ 19:20")) {
			f.add(Next);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("이 전")) {
			f.setVisible(false);
			CalendarEx calendarex = new CalendarEx("이 전");
		}
		if (e.getActionCommand().equals("다 음")) {
			f.setVisible(false);
			System.out.println(moviedata.getMovieList() + " " + moviedata.getMovieDate() + " " + moviedata.getMovieTime());
			NumberOfPeople numberofpeople = new NumberOfPeople();
		}
	}
	
	public static void main(String[] args) {
		MovieTime movie = new MovieTime();
	}
}