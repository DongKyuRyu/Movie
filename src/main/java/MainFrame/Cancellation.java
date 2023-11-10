package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
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

import DAO.MovieDAO;
import DAO.TicketDAO;

public class Cancellation extends WindowAdapter implements ActionListener {
   private Frame f;
   private Panel mainposter;
   private Label name, Date, MovieRoom, Seat,Person , TotalPay;
   private Button ok, clear;
   private URL searchURL;
   private ImageIcon imageicon;
   private JButton movieposter;

   private MovieData moviedata = MovieData.getInstance();
   private MovieDAO movieDao = MovieDAO.getInstance();
   private TicketDAO TicketDao = TicketDAO.getInstance();

   public Cancellation() {
      Font Movieposter = new Font("고딕", Font.BOLD, 20);
      Font Movieposter1 = new Font("고딕", Font.BOLD, 17);
      Font TotalPayFont = new Font("고딕", Font.BOLD, 27);
      movieDao.connect();
      TicketDao.connect();
      

      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

      f = new Frame();
      f.setLayout(null);
      f.setSize(800, 780);
      f.setBackground(new Color(188, 205, 194));
      f.setResizable(false);
      f.setLocation((scr.width - 800) / 2, (scr.height - 800) / 2);
      f.addWindowListener(this);

      String Id = moviedata.getMovieID();
      String movie = TicketDao.ticketid(Id);
      String movieName = movieDao.SearchMovieposter(movie);
      searchURL = getClass().getResource(movieName);
      imageicon = new ImageIcon(searchURL);
      movieposter = new JButton(imageicon);
      Image image = imageicon.getImage();
      Image scaledImage = image.getScaledInstance(300, 350, Image.SCALE_SMOOTH);
      ImageIcon scaledIcon = new ImageIcon(scaledImage);
      movieposter = new JButton(scaledIcon);
      movieposter.setBounds(50, 50, 300, 350);
      movieposter.setBackground(Color.PINK);
      movieposter.setBorderPainted(false);
      movieposter.setFocusPainted(false);
      movieposter.setContentAreaFilled(false);
      

//      TicketDao.selectList(Id).get(0).getSeatNumber()
      // 영수증 크기
      mainposter = new Panel();
      mainposter.setLayout(null);
      mainposter.setBounds(200, 80, 400, 650);
      mainposter.setBackground(Color.lightGray);

      name = new Label();
      name.setBounds(50, 420, 350, 25);
      name.setBackground(Color.lightGray);
      name.setFont(Movieposter);
      name.setText("영화 제목 : " + TicketDao.selectList(Id).get(0).getMovieName() );

      Date = new Label();
      Date.setBounds(50, 450, 350, 25);
      Date.setBackground(Color.lightGray);
      Date.setFont(Movieposter);
      Date.setText("일        시 : "+ TicketDao.selectList(Id).get(0).getDday());

      MovieRoom = new Label("상  영  관 :"+ TicketDao.selectList(Id).get(0).getRoomNumber());
      MovieRoom.setBounds(52, 480, 350, 25);
      MovieRoom.setBackground(Color.lightGray);
      MovieRoom.setFont(Movieposter);      

      Person  = new Label();
      Person .setBounds(52, 515, 350, 25);
      Person .setBackground(Color.lightGray);
      Person .setFont(Movieposter);
      Person .setText("인        원 :"+ TicketDao.selectList(Id).get(0).getPerson());
      
      Seat = new Label();
      Seat.setBounds(52, 550, 350, 25);
      Seat.setBackground(Color.lightGray);
      Seat.setFont(Movieposter1);
      Seat.setText("좌          석 :"+TicketDao.selectList(Id).get(0).getSeatNumber());
      
      TotalPay = new Label("총금액 : 0원");
      TotalPay.setBounds(50, 600, 350, 29);
      TotalPay.setBackground(Color.lightGray);
      TotalPay.setForeground(Color.red);
      TotalPay.setFont(TotalPayFont);
      TotalPay.setText("총금액 : "+ TicketDao.selectList(Id).get(0).getCost() + "원");

      clear = new Button("예매 취소");
      clear.setBounds((scr.width - 750) / 2, 735, 60, 30);
      clear.setBackground(Color.cyan);
      clear.addActionListener(this);
      
      ok = new Button("HOME");
      ok.setBounds((scr.width - 900) / 2, 735, 60, 30);
      ok.setBackground(Color.cyan);
      ok.addActionListener(this);

      mainposter.add(movieposter);
      mainposter.add(name);
      mainposter.add(Person);
      mainposter.add(TotalPay);
      mainposter.add(Seat);
      mainposter.add(MovieRoom);
      mainposter.add(Date);
      f.add(ok);
      f.add(clear);
      f.add(mainposter);
      f.setVisible(true);
   }

   public void windowClosing(WindowEvent e) {
      System.exit(0);
   }

   public static void main(String[] args) {
      Cancellation f = new Cancellation();
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("HOME")) {
         f.setVisible(false);
         MainFrame main = new MainFrame();
      }
      if (e.getActionCommand().equals("예매 취소")) {
          f.setVisible(false);
          MainFrame main = new MainFrame();
       }
   }
}