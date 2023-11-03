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

public class PaymentCompleted extends WindowAdapter implements ActionListener {
   private Frame f;
   private Button b1, b2, b3, b4;
   private Panel mainposter;
   private Label MovieName, Date, MovieRoom, Seat, Discount, Pay, TotalPay, MovieName2, Date2, MovieRoom2, Seat2, Discount2, Pay2, TotalPay2;
   private Button clear;
   private URL searchURL;
   private ImageIcon imageicon;
   private JButton  movieposter;
   
   private MovieDAO movieDao = MovieDAO.getInstance();
   
   public PaymentCompleted() {
      Font Movieposter = new Font("고딕", Font.BOLD, 20);
      Font Movieposter1 = new Font("고딕", Font.BOLD, 17);
      Font TotalPayFont = new Font("고딕", Font.BOLD, 27);
      
      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

      f = new Frame();
      f.setLayout(null);
      f.setSize(800, 780);
      f.setBackground(new Color(188, 205, 194));
      f.setResizable(false);
      f.setLocation((scr.width - 800) / 2, (scr.height - 800) / 2);
      f.addWindowListener(this);
      
      b1 = new Button("01 상영관");
      b1.setBackground(Color.lightGray);
      b1.setBounds(245, 35, 70, 21);

      b2 = new Button("02 인원 / 좌석");
      b2.setBackground(Color.lightGray);
      b2.setBounds(320, 35, 86, 21);
      
      b3 = new Button("03 결제");
      b3.setBackground(Color.lightGray);
      b3.setBounds(410, 35, 60, 21);
      
      b4 = new Button("04 결제 완료");
      b4.setBackground(new Color(188, 205, 194));
      b4.setBounds(475, 35, 80, 21);
      
      // 영수증 크기
      mainposter = new Panel();
      mainposter.setBounds(200, 80, 400,650);
      mainposter.setBackground(Color.lightGray);
      
      
      // 영화 포스터 자리
      movieDao.connect();
      String movieName = movieDao.SearchMovieposter("30일");
//      System.out.println("movieName");
      searchURL = getClass().getResource(movieName);
      imageicon = new ImageIcon(searchURL);
      movieposter = new JButton(imageicon);
      Image image = imageicon.getImage();
      Image scaledImage = image.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
      ImageIcon scaledIcon = new ImageIcon(scaledImage);
      movieposter= new JButton(scaledIcon);//크기 바꿀때 imageicon-->scaledIcon 으로 변경
      movieposter.setBounds(250, 105, 300,350);
      movieposter.setBackground(Color.PINK);
      movieposter.setBorderPainted(false);
      movieposter.setFocusPainted(false);
      movieposter.setContentAreaFilled(false);
      
      MovieName2 = new Label("30일");
      MovieName2.setBounds(335, 470, 105,25);
      MovieName2.setBackground(Color.DARK_GRAY);
      MovieName2.setFont(Movieposter);
      
      Date2 = new Label("일        시");
      Date2.setBounds(337, 500, 105,25);
      Date2.setBackground(Color.DARK_GRAY);
      Date2.setFont(Movieposter);
      
      MovieRoom2 = new Label("상  영  관");
      MovieRoom2.setBounds(338, 530, 105,25);
      MovieRoom2.setBackground(Color.DARK_GRAY);
      MovieRoom2.setFont(Movieposter);
      
      Seat2 = new Label("인원 / 좌석");
      Seat2.setBounds(338, 560, 105,25);
      Seat2.setBackground(Color.DARK_GRAY);
      Seat2.setFont(Movieposter1);
      
      Discount2 = new Label("할        인");
      Discount2.setBounds(337, 590, 105,25);
      Discount2.setBackground(Color.DARK_GRAY);
      Discount2.setFont(Movieposter);
      
      Pay2 = new Label("금        액");
      Pay2.setBounds(337, 620, 105,25);
      Pay2.setBackground(Color.DARK_GRAY);
      Pay2.setFont(Movieposter);
      
      TotalPay2 = new Label("총금액");
      TotalPay2.setBounds(337, 680, 105,29);
      TotalPay2.setBackground(Color.DARK_GRAY);
      TotalPay2.setForeground(Color.red);
      TotalPay2.setFont(TotalPayFont);
      
      MovieName = new Label("영화 제목 :");
      MovieName.setBounds(230, 470, 105,25);
      MovieName.setBackground(Color.lightGray);
      MovieName.setFont(Movieposter);
      
      Date = new Label("일        시 :");
      Date.setBounds(232, 500, 105,25);
      Date.setBackground(Color.lightGray);
      Date.setFont(Movieposter);
      
      MovieRoom = new Label("상  영  관 :");
      MovieRoom.setBounds(233, 530, 105,25);
      MovieRoom.setBackground(Color.lightGray);
      MovieRoom.setFont(Movieposter);
      
      Seat = new Label("인원 / 좌석 :");
      Seat.setBounds(233, 560, 105,25);
      Seat.setBackground(Color.lightGray);
      Seat.setFont(Movieposter1);
      
      Discount = new Label("할        인 :");
      Discount.setBounds(232, 590, 105,25);
      Discount.setBackground(Color.lightGray);
      Discount.setFont(Movieposter);
      
      Pay = new Label("금        액 :");
      Pay.setBounds(232, 620, 105,25);
      Pay.setBackground(Color.lightGray);
      Pay.setFont(Movieposter);
      
      TotalPay = new Label("총금액 :");
      TotalPay.setBounds(232, 680, 105,29);
      TotalPay.setBackground(Color.lightGray);
      TotalPay.setForeground(Color.red);
      TotalPay.setFont(TotalPayFont);
      
      clear = new Button("확인");
      clear.setBounds((scr.width - 800) / 2, 735, 60, 30);
      clear.setBackground(Color.cyan);
      clear.addActionListener(this);
      
      f.add(clear);
      f.add(TotalPay);
      f.add(Pay);
      f.add(Discount);
      f.add(Seat);
      f.add(MovieRoom);
      f.add(Date);
      f.add(MovieName);
      f.add(TotalPay2);
      f.add(Pay2);
      f.add(Discount2);
      f.add(Seat2);
      f.add(MovieRoom2);
      f.add(Date2);
      f.add(MovieName2);
      f.add(movieposter);
      f.add(mainposter);
      f.add(b1);
      f.add(b2);
      f.add(b3);
      f.add(b4);
      f.setVisible(true);
   }
//   public MovieDAO SearchMovieposter(String name) {
//      movieDao.connect();
//      MovieVO mo = movieDao.SearchMovieposter(name);
//      if(mo.equals(mo)) {
//         return poster;
//      }
//   }
   
   public void windowClosing(WindowEvent e) {
      System.exit(0);
   }

   public static void main(String[] args) {
      PaymentCompleted pay = new PaymentCompleted();
   }

   
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("확인")) {
         f.setVisible(false);
         MainFrame main = new MainFrame();
      }
   }
}