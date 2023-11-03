package MainFrame;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import VO.CustomerVO;
import VO.MovieVO;

public class Ticket extends WindowAdapter implements ActionListener, ItemListener {
	private Frame fa;
	private Panel pa1, pa2, pa3, pa4;
	private Label  movieName, movieDate;
	private Button theater, seat, pay, success, next;
	private List selectTime;
	private Checkbox selectMovie1, selectMovie2, selectMovie3;

	private CustomerVO customer;
	private MovieVO movieStatus = new MovieVO();

	public Ticket() {
		Font LabelFont = new Font("고딕", Font.BOLD, 50);
		Font movieNameFont = new Font("고딕", Font.BOLD, 30);
  
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		fa = new Frame("Ticketing");
		fa.setSize(800, 530);
		fa.setLayout(null);
		fa.setResizable(false);
		fa.setBackground(new Color(188, 205, 194));
		fa.setLocation((scr.width - 800) / 2, (scr.height - 530) / 2);
		fa.addWindowListener(this);

		pa1 = new Panel();
		pa1.setBackground(Color.lightGray);
		pa1.setBounds(10, 148, 390, 370);
		pa1.setLayout(null);

		pa2 = new Panel();
		pa2.setBackground(Color.pink);
		pa2.setBounds(400, 148, 390, 370);
		pa2.setLayout(null);

		pa3 = new Panel();
		pa3.setBackground(Color.green);
		pa3.setBounds(0, 240, 200, 100);
		pa3.setLayout(null);

		pa4 = new Panel();
		pa4.setBounds(225, 30, 350, 30);
		pa4.setLayout(null);

		CheckboxGroup moviename = new CheckboxGroup();
		selectMovie1 = new Checkbox("30일", moviename, false);
		selectMovie2 = new Checkbox("용감한 시민", moviename, false);
		selectMovie3 = new Checkbox("천박사", moviename, false);
		selectMovie1.setBounds(10, 14, 370, 34);
		selectMovie2.setBounds(10, 48, 370, 34);
		selectMovie3.setBounds(10, 82, 370, 34);
		selectMovie1.setFont(movieNameFont);
		selectMovie2.setFont(movieNameFont);
		selectMovie3.setFont(movieNameFont);
		selectMovie1.addItemListener(this);
		selectMovie2.addItemListener(this);
		selectMovie3.addItemListener(this);

		theater = new Button("01 상영관");
		seat = new Button("02 인원 / 좌석");
		pay = new Button("03 결제");
		success = new Button("04 결제 완료");
		next = new Button("다음");
		next.setBounds(365, 485, 70, 30);
		next.addActionListener(this);

		selectTime = new List(4);
		selectTime.setBounds(410, 300, 370, 100);

		theater.setBackground(new Color(188, 205, 194));
		seat.setBackground(Color.lightGray);
		pay.setBackground(Color.lightGray);
		success.setBackground(Color.lightGray);

		movieName = new Label("      영화 제목");
		movieName.setBounds(10, 70, 390, 75);
		movieName.setBackground(Color.GRAY);
		movieName.setFont(LabelFont);

		movieDate = new Label("         날  짜");
		movieDate.setBounds(400, 70, 390, 75);
		movieDate.setBackground(Color.GRAY);
		movieDate.setFont(LabelFont);

		pa1.add(selectMovie1);
		pa1.add(selectMovie2);
		pa1.add(selectMovie3);
		fa.add(next);

		pa4.add(theater);
		pa4.add(seat);
		pa4.add(pay);
		pa4.add(success);

		fa.add(selectTime);
		fa.add(pa1);
		fa.add(pa2);
		fa.add(movieDate);
		fa.add(movieName);
		fa.add(pa4);
		fa.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public Ticket(CustomerVO customer) {
		this.customer = customer;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("다음")) {
			fa.setVisible(false);
			Seat seat = new Seat(0,0);
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getItem().equals("천박사")) {

		}

		if (e.getItem().equals("30일")) {
			selectTime.removeAll();
			selectTime.add("10:00 ~ 12:10");
			selectTime.add("12:30 ~ 14:40");
		}

		if (e.getItem().equals("용감한 시민")) {
			selectTime.removeAll();
			selectTime.add("12:30 ~ 14:40");
		}
	}

	public static void main(String[] args) {
		Ticket tic = new Ticket();
	}
}
