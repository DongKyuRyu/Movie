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
import java.util.Stack;

import DAO.MovieDAO;
import DAO.SeatDAO;
import DAO.TicketDAO;
import VO.MovieVO;
import VO.SeatVO;
import VO.TicketVO;

public class Seat extends WindowAdapter implements ActionListener {
	private Frame f;
	private Label Screen, seatLabel;
	private Panel SeatPanel;
	private Button Seat[][], Befor, Next, Cancel;
	private String SeatNumber[][], SeatsNumber, TestSeatsNumber;
	private int adultCount, teenagerCount, totalSelected = 0;
	private Stack<Button> selectSeats = new Stack<>(); // 선택한 좌석을 저장할 스택
	private NumberOfPeople numberofpeople;

	private String SeatIJ, SeatJ;
	private char SeatRow;

	// VO
	private TicketVO ticket;
	private MovieVO movie;
	private SeatVO seat;

	// DAO
	private MovieDAO movieDao = MovieDAO.getInstance();
	private SeatDAO seatDao = SeatDAO.getInstance();
	private TicketDAO ticketDao = TicketDAO.getInstance(); // 등록 용도

	public void setSeatsNumber(String SeatsNumber) {
		this.SeatsNumber = SeatsNumber;
	}

	public String getSeatsNumber() {
		return SeatsNumber;
	}

	public Seat(int adultCount, int teenagerCount, NumberOfPeople numberofpeople) {
		this.adultCount = adultCount;
		this.teenagerCount = teenagerCount;
		this.numberofpeople = numberofpeople;

		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		f = new Frame("좌석 선택");
		f.setSize(900, 700);
		f.setLayout(null);
		f.setBackground(new Color(188, 205, 194));
		f.setResizable(false);
		f.setLocation((scr.width - 900) / 2, (scr.height - 700) / 2);
		f.addWindowListener(this);

		Screen = new Label("SCREEN", Label.CENTER);
		Screen.setBackground(Color.gray);
		Screen.setBounds(100, 50, 700, 25);

		Seat = new Button[5][20];
		SeatPanel = new Panel();
		SeatPanel.setSize(800, 200);
		SeatPanel.setLocation(50, 150);
		SeatPanel.setLayout(new GridLayout(5, 20, 15, 15));
		SeatNumber = new String[5][20];

		Cancel = new Button("좌석 다시 선택");
		Cancel.setBounds(400, 585, 100, 30);
		Cancel.setBackground(new Color(188, 205, 227));
		Cancel.addActionListener(this);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 20; j++) {
				char seatRow = (char) (i + 65);
				String seatNumber = String.format("%c%d", seatRow, j + 1);

				SeatNumber[i][j] = seatNumber;
				Seat[i][j] = new Button(SeatNumber[i][j]);
				Seat[i][j].setBackground(Color.gray);
				Seat[i][j].setFont(new Font("맑은 고딕", Font.PLAIN, 10));
				Seat[i][j].setBackground(Color.white);

				SeatPanel.add(Seat[i][j]);
				int finalI = i;
				int finalJ = j;
				SeatRow = seatRow;
				Seat[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (totalSelected < adultCount + teenagerCount) {
							Seat[finalI][finalJ].setEnabled(false);
							totalSelected++;

							selectSeats.push(Seat[finalI][finalJ]);

							if (totalSelected == 1) {
								TestSeatsNumber = seatNumber;
							} else {
								TestSeatsNumber += ", " + seatNumber;
							}

							setSeatsNumber(TestSeatsNumber);

							System.out.println(TestSeatsNumber);

							if (totalSelected == adultCount + teenagerCount) {
								System.out.print(SeatIJ);
								f.add(Next);
							}
						}
					}
				});
			}
		}

		Befor = new Button("이 전");
		Befor.setBounds(325, 625, 100, 30);
		Befor.setBackground(new Color(188, 205, 227));
		Befor.addActionListener(this);

		Next = new Button("다 음");
		Next.setBounds(475, 625, 100, 30);
		Next.setBackground(new Color(188, 205, 227));
		Next.addActionListener(this);

		f.add(Cancel);
		f.add(Befor);
		f.add(SeatPanel);
		f.add(Screen);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("이 전")) {
			f.setVisible(false);
//         NumberOfPeople numberofpeople = new NumberOfPeople();
		}

		if (e.getActionCommand().equals("다 음")) {
			f.setVisible(false);
			seatDao.connect();
			Pay pay = new Pay(adultCount, teenagerCount);
		}

		if (e.getActionCommand().equals("좌석 다시 선택")) {
			if (totalSelected > 0) {
				totalSelected--;

				Button lastSelectedSeat = selectSeats.pop();
				lastSelectedSeat.setEnabled(true);
				if (totalSelected < adultCount + teenagerCount) {
					f.remove(Next);
				}
			}
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		MovieList movieList = new MovieList();
		CalendarEx calendarex = new CalendarEx("Scheduler", movieList);
		MovieTime movieTime = new MovieTime(calendarex);
		NumberOfPeople num = new NumberOfPeople(movieTime);
		Seat seat = new Seat(1, 1, num);
	}
}