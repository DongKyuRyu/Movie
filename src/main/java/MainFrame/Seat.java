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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import DAO.MovieDAO;
import DAO.TicketDAO;
import VO.MovieVO;
import VO.TicketVO;

public class Seat extends WindowAdapter implements ActionListener {
	private Frame f;
	private Label Screen;
	private Panel SeatPanel;
	private Button Seat[][], Befor, Next, Cancel, AllCancel;
	private String SeatNumber[][], TestSeatsNumber, SEATDATA, TestSeatsNumber2;
	private int adultCount, teenagerCount, totalSelected = 0;
	private Stack<Button> selectSeats = new Stack<>(); // 선택한 좌석을 저장할 스택

	private char SeatRow;

	private MovieData moviedata = MovieData.getInstance();

	// DAO
	private MovieDAO movieDao = MovieDAO.getInstance();
	private TicketDAO ticketDao = TicketDAO.getInstance(); // 등록 용도

	private ArrayList<String> SeatNumberr = ticketDao.selectSeat(moviedata.getMovieList(), moviedata.getMovieDate(),
			moviedata.getMovieTime());

	public Seat(int adultCount, int teenagerCount) {
		this.adultCount = adultCount;
		this.teenagerCount = teenagerCount;

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
		Cancel.setBounds(325, 585, 100, 30);
		Cancel.setBackground(new Color(188, 205, 227));
		Cancel.addActionListener(this);

		AllCancel = new Button("좌석 전체 다시 선택");
		AllCancel.setBounds(470, 585, 110, 30);
		AllCancel.setBackground(new Color(188, 205, 227));
		AllCancel.addActionListener(this);

		// 좌석 중복 확인
		ticketDao.connect();
		for (int i = 0; i < SeatNumberr.size(); i++) {
			String seatdata = SeatNumberr.get(i);

			if (i == 0) {
				SEATDATA = seatdata;
			} else if (i > 0) {
				SEATDATA += ", " + seatdata;
			}
		}

		if (SEATDATA == null) {
			// 좌석 생성
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
						private String realSeatIJ;

						public void actionPerformed(ActionEvent e) {
							if (totalSelected < adultCount + teenagerCount) {
								Seat[finalI][finalJ].setEnabled(false);
								totalSelected++;

								selectSeats.push(Seat[finalI][finalJ]);

								if (totalSelected == 1) {
									TestSeatsNumber = seatNumber;
								} else if (totalSelected > 1) {
									TestSeatsNumber += ", " + seatNumber;
								}
								
								String TSN[] = TestSeatsNumber.split(", ");
								Arrays.sort(TSN);
								for (int i = 0; i < TSN.length; i++) {
									if (i == 0) {
										TestSeatsNumber2 = TSN[i];
									} else {
										TestSeatsNumber2 += ", " + TSN[i];
									}
								}
								moviedata.setMovieSeat(TestSeatsNumber2);

								if (totalSelected == adultCount + teenagerCount) {
//											System.out.println(moviedata.getMovieList() + "/" + moviedata.getMovieDate() + "/"
//													+ moviedata.getMovieTime() + "/" + moviedata.getMoviePeople() + "/"
//													+ moviedata.getMovieSeat());
//											System.out.println(moviedata.getMoviePeople());
									Next.setEnabled(true);
								}
							}
						}
					});
				}
			}

		} else {
			String[] SeatDATA = SEATDATA.split(", ");

			for (int i = 0; i < SeatDATA.length; i++) {
				System.out.println(SeatDATA[i]);
			}

			// 좌석 생성
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

					for (int k = 0; k < SeatDATA.length; k++) {
						if (SeatDATA[k].equals(seatNumber)) {
							Seat[finalI][finalJ].setEnabled(false);
						}
					}

					Seat[i][j].addActionListener(new ActionListener() {
						private String realSeatIJ;

						public void actionPerformed(ActionEvent e) {
							if (totalSelected < adultCount + teenagerCount) {
								Seat[finalI][finalJ].setEnabled(false);
								totalSelected++;

								selectSeats.push(Seat[finalI][finalJ]);

								if (totalSelected == 1) {
									TestSeatsNumber = seatNumber;
								} else if (totalSelected > 1) {
									TestSeatsNumber += ", " + seatNumber;
								}
								moviedata.setMovieSeat(TestSeatsNumber);

								if (totalSelected == adultCount + teenagerCount) {
//								System.out.println(moviedata.getMovieList() + "/" + moviedata.getMovieDate() + "/"
//										+ moviedata.getMovieTime() + "/" + moviedata.getMoviePeople() + "/"
//										+ moviedata.getMovieSeat());
//								System.out.println(moviedata.getMoviePeople());
									Next.setEnabled(true);
								}
							}
						}
					});
				}
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
		Next.setEnabled(false);

		f.add(AllCancel);
		f.add(Next);
		f.add(Cancel);
		f.add(Befor);
		f.add(SeatPanel);
		f.add(Screen);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("이 전")) {
			f.setVisible(false);
			NumberOfPeople numberofpeople = new NumberOfPeople();
		}

		if (e.getActionCommand().equals("다 음")) {
			f.setVisible(false);
			 System.out.println(moviedata.getMovieList() + "/" + moviedata.getMovieDate()
			 + "/"
			 + moviedata.getMovieTime() + "/" + moviedata.getMoviePeople() + "/" +
			 moviedata.getMovieSeat());
			Pay pay = new Pay(adultCount, teenagerCount);
		}

		if (e.getActionCommand().equals("좌석 다시 선택")) {
			if (totalSelected > 0) {
				totalSelected--;

				Button lastSelectedSeat = selectSeats.pop();
				lastSelectedSeat.setEnabled(true);
				if (totalSelected < adultCount + teenagerCount) {
					Next.setEnabled(false);
				}
			}
		}

		if (e.getActionCommand().equals("좌석 전체 다시 선택")) {
			if (totalSelected > 0) {
				int AllClear = totalSelected;
				for (int i = 0; i < AllClear; i++) {
					totalSelected--;

					Button lastSelectedSeat = selectSeats.pop();
					lastSelectedSeat.setEnabled(true);
				}
				if (totalSelected < adultCount + teenagerCount) {
					Next.setEnabled(false);
				}
			}
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		Seat seat = new Seat(1, 1);
	}
}