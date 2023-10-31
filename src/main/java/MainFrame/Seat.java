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

public class Seat extends WindowAdapter implements ActionListener {
	private Frame f;
	private Label Screen;
	private Panel SeatPanel;
	private Button Seat[][];
	private String SeatNumber[][];
	private GridLayout Seatnum;

	public Seat() {

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
		for (char ch = 'A'; ch <= 'E'; ch++) {
			for (int j = 1; j <= 20; j++) {
				Seatnum = new GridLayout(5, 20, 10, 10);
				Seat[ch][j] = new Button(SeatNumber[ch][j]);
				Seat[ch][j].setBackground(Color.gray);
				Seat[ch][j].setFont(new Font("맑은 고딕", 0, 10));
				Seat[ch][j].setForeground(Color.white);
				Seat[ch][j].addActionListener(this);
				
				SeatPanel.add(Seat[ch][j]);
			}
		}

		f.add(Screen);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		Seat seat = new Seat();
	}
}
