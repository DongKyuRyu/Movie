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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MovieList implements ActionListener, ItemListener, WindowListener {
    private Frame f;
    private Checkbox selectMovie1, selectMovie2, selectMovie3,selectMovie4,selectMovie5,selectMovie6,selectMovie7, selectMovie8, selectMovie9,selectMovie10,selectMovie11,selectMovie12;
    private Panel Movienamelist;
    private Label Title, movielist;
    private Button Next, Befor;
    private String movieName;

    private MovieData moviedata = MovieData.getInstance();
    
//    public void setMovieName(String movieName) {
//        this.movieName = movieName;
//    }
//
//    public String getMovieName() {
//        return movieName;
//    }
    
    

    public MovieList() {
        Font TitleFont = new Font("고딕", Font.BOLD, 60);
        Font movielistFont = new Font("고딕", Font.BOLD, 55);
        Font movieNameFont = new Font("고딕", Font.BOLD, 20);

        Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

        f = new Frame("영화예매");
        f.setResizable(false);
        f.setSize(500, 700);
        f.setBackground(new Color(188, 205, 194));
        f.setLayout(null);
        f.setLocation((scr.width - 500) / 2, (scr.height - 700) / 2);
        f.addWindowListener(this);

        CheckboxGroup moviename = new CheckboxGroup();
        selectMovie1 = new Checkbox("그대들은 어떻게 살 것인가", moviename, false);
        selectMovie2 = new Checkbox("플라워 킬링 문", moviename, false);
        selectMovie3 = new Checkbox("30일", moviename, false);
        selectMovie4 = new Checkbox("빌리와 용감한 녀석들", moviename, false);
        selectMovie5 = new Checkbox("용감한시민", moviename, false);
        selectMovie6 = new Checkbox("바람 따라 만나리", moviename, false);
        selectMovie7 = new Checkbox("오픈 더 도어", moviename, false);
        selectMovie8 = new Checkbox("소년들", moviename, false);
        selectMovie9 = new Checkbox("시수", moviename, false);
        selectMovie10 = new Checkbox("두사람을 위한 식탁", moviename, false);
        selectMovie11 = new Checkbox("톡투미", moviename, false);
        selectMovie12 = new Checkbox("더 킬러", moviename, false);
        selectMovie1.setBounds(10, 70, 370, 22);
        selectMovie2.setBounds(10, 94, 370, 22);
        selectMovie3.setBounds(10, 116, 370, 22);
        selectMovie4.setBounds(10, 138, 370, 22);
        selectMovie5.setBounds(10, 160, 370, 22);
        selectMovie6.setBounds(10, 182, 370, 22);
        selectMovie7.setBounds(10, 204, 370, 22);
        selectMovie8.setBounds(10, 226, 370, 22);
        selectMovie9.setBounds(10, 248, 370, 22);
        selectMovie10.setBounds(10, 270, 370, 22);
        selectMovie11.setBounds(10, 292, 370, 22);
        selectMovie12.setBounds(10, 314, 370, 22);
        selectMovie1.setFont(movieNameFont);
        selectMovie2.setFont(movieNameFont);
        selectMovie3.setFont(movieNameFont);
        selectMovie4.setFont(movieNameFont);
        selectMovie5.setFont(movieNameFont);
        selectMovie6.setFont(movieNameFont);
        selectMovie7.setFont(movieNameFont);
        selectMovie8.setFont(movieNameFont);
        selectMovie9.setFont(movieNameFont);
        selectMovie10.setFont(movieNameFont);
        selectMovie11.setFont(movieNameFont);
        selectMovie12.setFont(movieNameFont);
        selectMovie1.addItemListener(this);
        selectMovie2.addItemListener(this);
        selectMovie3.addItemListener(this);
        selectMovie4.addItemListener(this);
        selectMovie5.addItemListener(this);
        selectMovie6.addItemListener(this);
        selectMovie7.addItemListener(this);
        selectMovie8.addItemListener(this);
        selectMovie9.addItemListener(this);
        selectMovie10.addItemListener(this);
        selectMovie11.addItemListener(this);
        selectMovie12.addItemListener(this);

        movielist = new Label("영화 제목");
        movielist.setBounds(75, 10, 250, 57);
        movielist.setFont(movielistFont);

        Title = new Label("GreenHouse");
        Title.setBounds(70, 100, 360, 80);
        Title.setFont(TitleFont);

        Movienamelist = new Panel();
        Movienamelist.setLayout(null);
        Movienamelist.setBackground(Color.lightGray);
        Movienamelist.setBounds(50, 180, 400, 400);

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
        Movienamelist.add(selectMovie4);
        Movienamelist.add(selectMovie5);
        Movienamelist.add(selectMovie6);
        Movienamelist.add(selectMovie7);
        Movienamelist.add(selectMovie8);
        Movienamelist.add(selectMovie9);
        Movienamelist.add(selectMovie10);
        Movienamelist.add(selectMovie11);
        Movienamelist.add(selectMovie12);

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
            f.setVisible(false);
            CalendarEx calendarEx = new CalendarEx("다 음");
        }
    }

        public void itemStateChanged(ItemEvent e) {
            if (e.getItem().equals("그대들은 어떻게 살 것인가"))
                moviedata.setMovieList("그대들은 어떻게 살 것인가");
            else if (e.getItem().equals("플라워 킬링 문"))
                moviedata.setMovieList("플라워 킬링 문");
            else if (e.getItem().equals("30일"))
                moviedata.setMovieList("30일");
            else if (e.getItem().equals("빌리와 용감한 녀석들"))
                moviedata.setMovieList("빌리와 용감한 녀석들");
            else if (e.getItem().equals("소년들"))
                moviedata.setMovieList("소년들");
            else if (e.getItem().equals("용감한시민"))
                moviedata.setMovieList("용감한시민");
            else if (e.getItem().equals("바람 따라 만나리"))
                moviedata.setMovieList("바람 따라 만나리");
            else if (e.getItem().equals("오픈 더 도어"))
                moviedata.setMovieList("오픈 더 도어");
            else if (e.getItem().equals("시수"))
                moviedata.setMovieList("시수");
            else if (e.getItem().equals("두사람을 위한 식탁"))
                moviedata.setMovieList("두사람을 위한 식탁");
            else if (e.getItem().equals("톡투미"))
                moviedata.setMovieList("톡투미");
            else if (e.getItem().equals("더 킬러"))
                moviedata.setMovieList("더 킬러");
            if (e.getItem().equals("그대들은 어떻게 살 것인가") || e.getItem().equals("플라워 킬링 문") || e.getItem().equals("빌리와 용감한 녀석들")||e.getItem().equals("30일") || e.getItem().equals("소년들") ||e.getItem().equals("용감한시민") || e.getItem().equals("바람 따라 만나리") ||e.getItem().equals("오픈 더 도어") || e.getItem().equals("시수") ||e.getItem().equals("두사람을 위한 식탁") || e.getItem().equals("톡투미") ||e.getItem().equals("더 킬러")) {
                f.add(Next);
            }
        }

    public static void main(String[] args) {
        MovieList frame = new MovieList();
        
    }

	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}