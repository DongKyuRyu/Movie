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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NumberOfPeople extends WindowAdapter implements ActionListener, ItemListener {
	private Frame f;
	private Panel SeatPanel;
	private Button Seat[][], Next, Befor;
	private String SeatNumber[];
	private Button[] seletedButton;
	private Label adult, Teenager;

	public NumberOfPeople() {
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

		Seat = new Button[2][8];
		SeatPanel = new Panel();
		SeatPanel.setSize(300, 70);
		SeatPanel.setLocation(200, 200);
		SeatPanel.setLayout(new GridLayout(2, 8, 15, 15));
		SeatNumber = new String[8];
		seletedButton = new Button[2];

		for (int i = 0; i < 2; i++) {
			seletedButton[i] = null;
			for (int j = 0; j < 8; j++) {
				String seatNumber = String.format("%d", j + 1);

				SeatNumber[j] = seatNumber;
				Seat[i][j] = new Button(SeatNumber[j]);
				Seat[i][j].setBackground(Color.gray);
				Seat[i][j].setFont(new Font("맑은 고딕", Font.PLAIN, 10));
				Seat[i][j].setBackground(Color.white);
				Seat[i][j].addActionListener(this);

				SeatPanel.add(Seat[i][j]);
				int finalI = i;
				int finalJ = j;

				Seat[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (seletedButton[finalI] != null) {
							seletedButton[finalI].setEnabled(true);
						}
						Seat[finalI][finalJ].enable(false);
						seletedButton[finalI] = Seat[finalI][finalJ];
						if (Seat[finalI][finalJ].equals(Seat[0][finalJ]) || Seat[finalI][finalJ].equals(Seat[1][finalJ])) {
							f.add(Next);
						}
					}
				});
			}
		}

		f.add(Befor);
		f.add(Teenager);
		f.add(adult);
		f.add(SeatPanel);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("이 전")) {
			f.setVisible(false);
			MovieTime movietime = new MovieTime();
		}
		
		if(e.getActionCommand().equals("다 음")) {
			f.setVisible(false);
			Seat seat = new Seat();
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		NumberOfPeople num = new NumberOfPeople();
	}

	public void itemStateChanged(ItemEvent e) {

	}
}
