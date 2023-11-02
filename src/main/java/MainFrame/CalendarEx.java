package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class CalendarEx extends Frame {
	Panel pDate = new Panel();
	Panel pUp = new Panel();

	Button btnPrevMon = new Button("◀");
	Button btnNextMon = new Button("▶");
	Label lblYearMon = new Label();

	Button[] btnArr = new Button[42];

	Calendar curMon = Calendar.getInstance();
	private Calendar now;
	private String year;
	private String month;
	private String day;
	private String today;

	CalendarEx(String title) {
		super(title);

		Dimension scr1 = Toolkit.getDefaultToolkit().getScreenSize();

		pUp.setBackground(Color.yellow);
		pUp.setLayout(new FlowLayout(FlowLayout.CENTER));
		pUp.add(btnPrevMon);
		pUp.add(lblYearMon);
		pUp.add(btnNextMon);

		pDate.setLayout(new GridLayout(6, 7));

		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button("");
			pDate.add(btnArr[i]);
			btnArr[i].addActionListener(new BtnEventHandler());
		}

		btnPrevMon.addActionListener(new BtnEventHandler());
		btnNextMon.addActionListener(new BtnEventHandler());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				we.getWindow().setVisible(false);
				we.getWindow().dispose();
				System.exit(0);
			}
		});

		add(pUp, "North");
		add(pDate, "Center");
		setBounds(200, 200, 500, 300);
		setDays(curMon);
		setVisible(true);
		setLocation((scr1.width - 500) / 2, (scr1.height - 300) / 2);
	}// MyScheduler

	void setDays(Calendar date) {
		int year = date.get(Calendar.YEAR);
		int month = date.get(Calendar.MONTH);

		lblYearMon.setText(year + "년" + (month + 1) + "월");

		Calendar sDay = Calendar.getInstance(); // 시작일

		sDay.set(year, month, 1);
		sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);

		for (int i = 0; i < btnArr.length; i++, sDay.add(Calendar.DATE, 1)) {
			int day = sDay.get(Calendar.DATE);
			btnArr[i].setLabel(day + "");
			
			if (sDay.get(Calendar.MONTH) != month) {
				btnArr[i].setBackground(Color.lightGray);
				btnArr[i].setEnabled(false);
			} else {
				btnArr[i].setBackground(Color.white);
				btnArr[i].setEnabled(true);
				
				Calendar now = Calendar.getInstance();
				if(sDay.get(Calendar.MONTH) == now.get(Calendar.MONTH) && day < now.get(Calendar.DAY_OF_MONTH)) {
					btnArr[i].setEnabled(false);
				}
			}
		}
		this.month = Integer.toString(month + 1);
		this.year = Integer.toString(year);
	}

	class BtnEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Button src = (Button) ae.getSource();

			for (int i = 0; i < btnArr.length; i++) {
				if (src == btnArr[i]) {
					day = btnArr[i].getLabel();

					btnArr[i].setEnabled(false);
					setVisible(false);
					MovieTime movie = new MovieTime();
				}
			}

			if (src == btnPrevMon) {
				curMon.add(Calendar.MONDAY, -1);
			} else if (src == btnNextMon) {
				curMon.add(Calendar.MONTH, 1);
			}
			setDays(curMon);
			repaint();
		}
	}
	
	public String returnCalendar() {
		today = year + "-" + month + "-" + day;
		return today;
	}

	public static void main(String[] args) {
		CalendarEx mainWin = new CalendarEx("Scheduler");

	}// main

}
