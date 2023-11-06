package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NumberOfPeople extends WindowAdapter implements ActionListener{
	private Frame f;
	private Panel SeatPanel;
	private Button Seat[][], Next, Befor;
	private String SeatNumber[];
	private Button[] seletedButton;
	private Label adult, Teenager, price, adultpeople, teenagerpeople, totalpeople;
	private MovieTime movieTime;
	private int HumanCount;
	
	public void setHumanCount(int HumanCount) {
		this.HumanCount = HumanCount;
	}
	
	public int getHumanCount() {
		return HumanCount;
	}

	public NumberOfPeople(MovieTime movieTime) {
		this.movieTime = movieTime;
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		f = new Frame("인원 선택");
		f.setSize(700, 500);
		f.setLayout(null);
		f.setBackground(new Color(188, 205, 194));
		f.setResizable(false);
		f.setLocation((scr.width - 700) / 2, (scr.height - 500) / 2);
		f.addWindowListener(this);

		adult = new Label("성인");
		adult.setBounds(150, 202, 40, 22);
		adult.setFont(new Font("맑은 고딕", Font.PLAIN, 20));

		Teenager = new Label("청소년");
		Teenager.setBounds(130, 244, 60, 22);
		Teenager.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		Next = new Button("다 음");
		Next.setBounds(375, 450, 100, 30);
		Next.setBackground(new Color(188, 205, 227));
		Next.addActionListener(this);
		
		Befor = new Button("이 전");
		Befor.setBounds(225, 450, 100, 30);
		Befor.setBackground(new Color(188, 205, 227));
		Befor.addActionListener(this);

		Seat = new Button[2][9];
		SeatPanel = new Panel();
		SeatPanel.setSize(300, 70);
		SeatPanel.setLocation(200, 200);
		SeatPanel.setLayout(new GridLayout(2, 8, 15, 15));
		SeatNumber = new String[9];
		seletedButton = new Button[2];
		
		price = new Label("성인 : 9,000   /   청소년 : 7,000");
		price.setBounds(130, 280, 300, 17);
		price.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		price.setForeground(Color.red);
		
		adultpeople = new Label("성인 : 0명");
		adultpeople.setBounds(130, 300, 55, 17);
		
		teenagerpeople = new Label("청소년 : 0명");
		teenagerpeople.setBounds(195, 300, 70, 17);
		
		totalpeople = new Label("총 : 0명");
		totalpeople.setBounds(275, 300, 70, 17);
		
		
		for (int i = 0; i < 2; i++) {
			seletedButton[i] = null;
			for (int j = 0; j < 9; j++) {
				String seatNumber = String.format("%d", j);

				SeatNumber[j] = seatNumber;
				Seat[i][j] = new Button(SeatNumber[j]);
				Seat[i][j].setBackground(Color.gray);
				Seat[i][j].setFont(new Font("맑은 고딕", Font.PLAIN, 10));
				Seat[i][j].setBackground(Color.white);
				Seat[i][j].addActionListener(this);
				Seat[i][0].setEnabled(false);

				SeatPanel.add(Seat[i][j]);
				int finalI = i;
				int finalJ = j;
				
				String total = Integer.toString(finalJ);

				Seat[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (seletedButton[finalI] != null) {
							seletedButton[finalI].setEnabled(true);
						}
						Seat[finalI][0].setEnabled(true);
						Seat[finalI][finalJ].enable(false);
						seletedButton[finalI] = Seat[finalI][finalJ];
						if (Seat[finalI][finalJ].equals(Seat[0][finalJ]) || Seat[finalI][finalJ].equals(Seat[1][finalJ])) {
							f.add(Next);
						}
						
						if (Seat[finalI][finalJ].equals(Seat[0][finalJ])) {
							adultpeople.setText("성인 : " + total + "명");
						}
						
						if (Seat[finalI][finalJ].equals(Seat[1][finalJ])) {
							teenagerpeople.setText("청소년 : " + total + "명");
						}
						
						// totalpeople Label에 성인과 청소년 합을 출력
				        int adultCount = Integer.parseInt(adultpeople.getText().replaceAll("[^0-9]", ""));
				        int teenagerCount = Integer.parseInt(teenagerpeople.getText().replaceAll("[^0-9]", ""));
				        int totalPeopleCount = adultCount + teenagerCount;
				        setHumanCount(totalPeopleCount);
				        totalpeople.setText("총 : " + totalPeopleCount + "명");
					}
				});
			}
		}

		f.add(totalpeople);
		f.add(teenagerpeople);
		f.add(adultpeople);
		f.add(price);
		f.add(Befor);
		f.add(Teenager);
		f.add(adult);
		f.add(SeatPanel);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("이 전")) {
			f.setVisible(false);
//			MovieTime movie = new MovieTime(CalendarEx.this);
		}
		
		if(e.getActionCommand().equals("다 음")) {
			f.setVisible(false);
			int adultCount = Integer.parseInt(adultpeople.getText().replaceAll("[^0-9]", ""));
		    int teenagerCount = Integer.parseInt(teenagerpeople.getText().replaceAll("[^0-9]", ""));
		    
		   
		    int HumanCount = getHumanCount();
		    
		    System.out.println(HumanCount);
		    
			Seat seat = new Seat(adultCount, teenagerCount, NumberOfPeople.this);
			
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public static String totalpice(int adultCount, int teenagerCount) {
	    int totalpice = adultCount * 9000 + teenagerCount * 7000;
	    return Integer.toString(totalpice);
	}

	public static void main(String[] args) {
		MovieList movieList = new MovieList();
		CalendarEx calendarex = new CalendarEx("Scheduler", movieList);
		MovieTime movieTime = new MovieTime(calendarex);
		NumberOfPeople num = new NumberOfPeople(movieTime);

	}
}