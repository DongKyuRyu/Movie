package MainFrame;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

public class Pay extends WindowAdapter implements ActionListener, ItemListener, TextListener {
	private Frame faPay;
	private Button pay;
	private Label movie, cash, disCount, payplan, cardnum, phonenum, totalprice;
	private Choice coupon;
	private Panel movieinfo, payinfo;
	private TextField cardText1, cardText2, cardText3, cardText4, phonText1, phonText2, phonText3;
	private Checkbox paycard, payphone;
	private int cardmaxLength = 4, phonemaxLength = 3, teenagerCount, adultCount;
	public Pay(int adultCount, int teenagerCount) {
		String calendar = new CalendarEx("Scheduler").returnCalendar();
		String totalPrice = NumberOfPeople.totalpice(adultCount, teenagerCount);

		int totalPrice1 = Integer.parseInt(totalPrice);
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		String totalsum = decimalFormat.format(totalPrice1);
		
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		faPay = new Frame();
		faPay.setLayout(null);
		faPay.setResizable(false);
		faPay.setLocation((scr.width - 800) / 2, (scr.height - 530) / 2);
		faPay.setSize(800, 530);
		faPay.setBackground(new Color(188, 205, 194));
		faPay.addWindowListener(this);

		pay = new Button(" 결 제 하 기 ");
		pay.setBounds(350, 470, 100, 30);
		pay.setBackground(new Color(188, 205, 227));
		pay.addActionListener(this);

		movie = new Label("예매 정보", Label.CENTER);
		movie.setFont(new Font("돋움", Font.BOLD, 25));
		movie.setBounds(20, 50, 370, 50);
		movie.setBackground(Color.gray);

		cash = new Label("결제 하기", Label.CENTER);
		cash.setFont(new Font("돋움", Font.BOLD, 25));
		cash.setBounds(410, 50, 370, 50);
		cash.setBackground(Color.gray);

		movieinfo = new Panel();
		movieinfo.setBounds(20, 110, 370, 345);
		movieinfo.setBackground(Color.lightGray);

		payinfo = new Panel();
		payinfo.setLayout(null);
		payinfo.setBounds(410, 110, 370, 345);
		payinfo.setBackground(Color.lightGray);

		disCount = new Label("● 할인 쿠폰", Label.CENTER);
		disCount.setFont(new Font("돋움", Font.BOLD, 13));
		disCount.setBounds(30, 115, 80, 17);
		disCount.setBackground(Color.lightGray);

		coupon = new Choice();
		coupon.setLocation(30, 140);
		coupon.setSize(315, 0);
		coupon.add("해당사항 없음");
		coupon.add("신규 고객 15% 할인 쿠폰");
		coupon.add("기존 고객 5% 할인 쿠폰");
		coupon.add("컴백 고객 10% 할인 쿠폰");

		payplan = new Label("● 결제 수단", Label.CENTER);
		payplan.setFont(new Font("돋움", Font.BOLD, 13));
		payplan.setBounds(30, 30, 80, 17);
		payplan.setBackground(Color.lightGray);

		cardnum = new Label("카드 번호");
		cardnum.setBounds(30, 50, 55, 15);

		phonenum = new Label("휴대폰 번호");
		phonenum.setBounds(30, 50, 70, 15);

		CheckboxGroup payplne = new CheckboxGroup();
		paycard = new Checkbox("카드", payplne, false);
		paycard.setBounds(130, 30, 50, 17);
		paycard.setFont(new Font("돋움", Font.BOLD, 13));
		paycard.addItemListener(this);

		cardText1 = new TextField();
		cardText1.setBounds(30, 70, 50, 20);
		cardText1.addTextListener(this);

		cardText2 = new TextField();
		cardText2.setBounds(90, 70, 50, 20);
		cardText2.setEchoChar('*');
		cardText2.addTextListener(this);

		cardText3 = new TextField();
		cardText3.setBounds(150, 70, 50, 20);
		cardText3.setEchoChar('*');
		cardText3.addTextListener(this);

		cardText4 = new TextField();
		cardText4.setBounds(210, 70, 50, 20);
		cardText4.addTextListener(this);

		payphone = new Checkbox("휴대폰", payplne, false);
		payphone.setBounds(190, 30, 80, 17);
		payphone.setFont(new Font("돋움", Font.BOLD, 13));
		payphone.addItemListener(this);

		phonText1 = new TextField();
		phonText1.setBounds(30, 70, 50, 20);
		phonText1.addTextListener(this);

		phonText2 = new TextField();
		phonText2.setBounds(90, 70, 50, 20);
		phonText2.addTextListener(this);

		phonText3 = new TextField();
		phonText3.setBounds(150, 70, 50, 20);
		phonText3.addTextListener(this);
		
		totalprice = new Label();
		totalprice.setBounds(30,  220,  200,  22);
		totalprice.setFont(new Font("돋움", Font.BOLD, 20));
		totalprice.setText("총금액 : " + totalsum + "원");

		payinfo.add(totalprice);
		payinfo.add(paycard);
		payinfo.add(payphone);
		payinfo.add(payplan);
		payinfo.add(coupon);
		payinfo.add(disCount);

		faPay.add(payinfo);
		faPay.add(cash);
		faPay.add(movieinfo);
		faPay.add(pay);
		faPay.add(movie);
		faPay.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		Pay pa = new Pay(5, 2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(" 결 제 하 기 ")) {
			faPay.setVisible(false);
			PaymentCompleted paymentcompleted = new PaymentCompleted();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getItem().equals("카드")) {
			payinfo.remove(phonenum);
			payinfo.remove(phonText1);
			payinfo.remove(phonText2);
			payinfo.remove(phonText3);
			payinfo.add(cardnum);
			payinfo.add(cardText1);
			payinfo.add(cardText2);
			payinfo.add(cardText3);
			payinfo.add(cardText4);
		}

		if (e.getItem().equals("휴대폰")) {
			payinfo.remove(cardnum);
			payinfo.remove(cardText1);
			payinfo.remove(cardText2);
			payinfo.remove(cardText3);
			payinfo.remove(cardText4);
			payinfo.add(phonenum);
			payinfo.add(phonText1);
			payinfo.add(phonText2);
			payinfo.add(phonText3);
		}
	}

	public void textValueChanged(TextEvent e) {
		if (e.getSource() == cardText1) {
			String text = cardText1.getText();
			if (text.length() == cardmaxLength) {
				cardText2.requestFocus(); // cardText1이 4글자가 되면 cardText2로 포커스 이동
			}
		} else if (e.getSource() == cardText2) {
			String text = cardText2.getText();
			if (text.length() == cardmaxLength) {
				cardText3.requestFocus(); // cardText2가 4글자가 되면 cardText3로 포커스 이동
			}
		} else if (e.getSource() == cardText3) {
			String text = cardText3.getText();
			if (text.length() == cardmaxLength) {
				cardText4.requestFocus(); // cardText3이 4글자가 되면 cardText4로 포커스 이동
			}
		}

		if (e.getSource() == phonText1) {
			String text1 = phonText1.getText();
			if (text1.length() == phonemaxLength) {
				phonText2.requestFocus(); // cardText1이 4글자가 되면 cardText2로 포커스 이동
			}
		} else if (e.getSource() == phonText2) {
			String text = phonText2.getText();
			if (text.length() == cardmaxLength) {
				phonText3.requestFocus(); // cardText2가 4글자가 되면 cardText3로 포커스 이동
			}
		}
	}
}
