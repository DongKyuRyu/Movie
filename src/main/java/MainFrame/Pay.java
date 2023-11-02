package MainFrame;

import java.awt.Button;
import java.awt.Choice;
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

public class Pay extends WindowAdapter implements ActionListener{
	private Frame faPay;
	private Button pay, theater, seatseat, paypay, success;
	private Label movie, cash;
	private Choice coupon;
	private Panel pa1, pa2, pa3, pa4;
	
	public Pay() {
		String calendar = new CalendarEx("Scheduler").returnCalendar();
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		
		faPay = new Frame();
		faPay.setLocation((scr.width-800)/2,(scr.height-530)/2);
		faPay.setSize(800, 530);
		faPay.setBackground(new Color(188, 205, 194));
		faPay.addWindowListener(this);
		
		pay = new Button(" 결 제 하 기 ");
		pay.addActionListener(this);
		pay.setBackground(new Color(188, 205, 194));
		
		pa1 = new Panel();
		
		
		pa2 = new Panel();
		
		
		pa3 = new Panel();
		
		
		pa4 = new Panel();
		
		
		movie = new Label("         예   매   정   보          ");
		movie.setFont(new Font("돋움", 2, 15));
		
		cash = new Label("          결   제   하   기          ");
		cash.setFont(new Font("돋움", 2, 15));
		
		coupon = new Choice();
		
		theater = new Button("01 상영관");
		theater.setBackground(Color.lightGray);
		
		seatseat = new Button("02 인원 / 좌석");
		seatseat.setBackground(Color.lightGray);
		
		paypay = new Button("03 결제");
		paypay.setBackground(new Color(188, 205, 194));
		
		success = new Button("04 결제 완료");
		success.setBackground(Color.lightGray);
		
		coupon.add("신규 고객 15% 할인 쿠폰");
		coupon.add("기존 고객 5% 할인 쿠폰");
		coupon.add("컴백 고객 10% 할인 쿠폰");
		
		pa1.add(theater);
		pa1.add(seatseat);
		pa1.add(paypay);
		pa1.add(success);
		
		pa2.add(movie);
		pa3.add(cash);
		pa3.add(coupon);
		pa4.add(pay);
		
		faPay.add(pa1, "North");
		faPay.add(pa2, "West");
		faPay.add(pa3, "East");
		faPay.add(pa4, "South");
		faPay.setVisible(true);
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		Pay pa = new Pay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(" 결 제 하 기 ")) {
			faPay.setVisible(false);
			PaymentCompleted paymentcompleted = new PaymentCompleted();
		}
	}
}
