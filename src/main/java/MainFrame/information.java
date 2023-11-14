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

import DAO.CustomerDAO;
import VO.CustomerVO;

public class information extends WindowAdapter implements ActionListener {
	private Frame f;
	private Button b2;
	private Panel Background, historys;
	private URL searchURL;
	private ImageIcon imageicon;
	private JButton b1;
	private Label Title, name, email, name1, email1, history, Talk, Talk2, Talk3, Talk4, Talk5, Talk6;
	private int num;
	private CustomerDAO customerDao = CustomerDAO.getInstance();
	private MovieData moviedata = MovieData.getInstance();

	public information() {
		customerDao.connect();
		Font greenFont = new Font("고딕", Font.BOLD, 60);
		Font TalkFont = new Font("고딕", Font.BOLD, 20);
		Font TitleFont = new Font("고딕", Font.BOLD, 20);

		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		f = new Frame();
		f.setResizable(false);
		f.setSize(600, 780);
		f.setBackground(new Color(188, 205, 194));
		f.setLayout(null);
		f.setLocation((scr.width - 600) / 2, (scr.height - 780) / 2);
		f.addWindowListener(this);

		Background = new Panel();
		Background.setLayout(null);
		Background.setBounds(50, 150, 500, 550);
		Background.setBackground(Color.lightGray);

		//버튼으로 변경 -> 홈화면이동 계획이있음 차후에
		Title = new Label("GreenHouse", Label.CENTER);
		Title.setBounds(120, 50, 360, 80);
		Title.setFont(greenFont);

		// 이름표시란
		name = new Label("Name");
		name.setBounds(270, 10, 300, 50);
		name.setFont(TitleFont);
		name.setBackground(Color.lightGray);

		// 이름적는칸
		name1 = new Label(customerDao.fullname(moviedata.getMovieID()));
		name1.setBounds(270, 60, 300, 50);
		name1.setFont(TitleFont);
		name1.setBackground(Color.lightGray);

		// 이메일표시란
		email = new Label("E-Mail");
		email.setBounds(270, 120, 300, 50);
		email.setFont(TitleFont);
		email.setBackground(Color.lightGray);

		// 이메일 적는칸
		email1 = new Label(customerDao.fullemail(moviedata.getMovieID()));
		email1.setBounds(270, 170, 300, 50);
		email1.setFont(TitleFont);
		email1.setBackground(Color.lightGray);

		// 사진넣을 칸
		searchURL = getClass().getResource("/img/Logo1.png");
		imageicon = new ImageIcon(searchURL);
		Image image = imageicon.getImage();
		Image scaledImage = image.getScaledInstance(240, 240, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		b1 = new JButton(scaledIcon);
		b1.setBounds(10, 10, 240, 240);
		b1.setBackground(Color.RED);
		b1.setBorderPainted(false);
		b1.setFocusPainted(false);
		b1.setContentAreaFilled(false);

		// 히스토리 라벨
		history = new Label("오늘도 빛나는 너에게 해주고싶은 말", Label.CENTER);
		history.setBounds(50, 250, 400, 50);
		history.setFont(TitleFont);
		history.setBackground(Color.lightGray);

		// 히스토리 적히는칸
		historys = new Panel();
		historys.setLayout(null);
		historys.setBounds(20, 300, 460, 230);
		historys.setBackground(Color.lightGray);

		Talk = new Label("", Label.CENTER);
		Talk.setBounds(0, 0, 460, 38);
		Talk.setBackground(Color.pink);
		Talk.setFont(TalkFont);

		Talk2 = new Label("", Label.CENTER);
		Talk2.setBounds(0, 38, 460, 38);
		Talk2.setBackground(Color.pink);
		Talk2.setFont(TalkFont);

		Talk3 = new Label("", Label.CENTER);
		Talk3.setBounds(0, 75, 460, 38);
		Talk3.setBackground(Color.pink);
		Talk3.setFont(TalkFont);

		Talk4 = new Label("", Label.CENTER);
		Talk4.setBounds(0, 113, 460, 38);
		Talk4.setBackground(Color.pink);
		Talk4.setFont(TalkFont);

		Talk5 = new Label("", Label.CENTER);
		Talk5.setBounds(0, 150, 460, 38);
		Talk5.setBackground(Color.pink);
		Talk5.setFont(TalkFont);

		Talk6 = new Label("", Label.CENTER);
		Talk6.setBounds(0, 187, 460, 38);
		Talk6.setBackground(Color.pink);
		Talk6.setFont(TalkFont);

		// 홈 버튼
		b2 = new Button("HOME");
		b2.setBounds(250, 710, 100, 50);
		b2.setBackground(Color.lightGray);
		b2.addActionListener(this);

		num = (int) (Math.random() * 46);

		switch (num) {
		case 0: {
			Talk.setText("");
			Talk2.setText("최고의 친절은");
			Talk3.setText("상대방이 그 친절을");
			Talk4.setText("깨닫지 못하도록 하는것");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 1: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("올 한해는 우리 항상 웃자");
			Talk4.setText("넌 웃는 모습이 제일 예쁘니까");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 2: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("올 한해 행복해지고 싶다면");
			Talk4.setText("그냥 웃어봐 행복은 그 안에 있어^^");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 3: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("올 해는 너에게 별 볼일 많은");
			Talk4.setText("새해가 되기를 기도할께*^^*");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 4: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("내가 행복의 마술을 걸어줄게! 수리수리마수리~");
			Talk4.setText("올해엔 한해 가득 너에게 좋은 일만 생기거라!!");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 5: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("새해엔 기분 좋은 돼지꿈 꾸고 부~자 되세요!!");
			Talk4.setText("꿀꿀!!");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 6: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("우리 힘껏 달려보자.");
			Talk4.setText("새 해 새 복 듬뿍 받아라!");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 7: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("작년 한해 나의 든든한 오른팔이 되어 줘서 고마워");
			Talk4.setText("올 해는 내가 너의 왼팔이 되어 줄게 화이팅!");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 8: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("너에게 마주앉아 말없이 흐르는 시간이");
			Talk4.setText("결코 아깝지 않은 친구이고 싶다");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 9: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("사랑하는 친구야");
			Talk4.setText("새해에는 원하는 일 모두 이루고 부~자 되길 바래!");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 10: {
			Talk.setText("");
			Talk2.setText("우리 늘 이순간 새해 첫 마음으로 갈아가자");
			Talk3.setText("모든것을 할 수 있고 용서할 수 ");
			Talk4.setText("있을 것 같은 이순간처럼...");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 11: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("쉽 없는 기운으로 내달릴 올 한해!");
			Talk4.setText("네가 주인공인 너의 한해가 되기를!");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 12: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("올해도 지금처럼 난 항상 네 곁에 있어 줄게!");
			Talk4.setText("그리고 사랑 많이 받아! 사랑해!");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 13: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("올해의 하루하루는");
			Talk4.setText("마징가제트처럼, 캔디처럼");
			Talk5.setText("씩씩하게! 또 신나게!");
			Talk6.setText("");
			break;
		}

		case 14: {
			Talk.setText("");
			Talk2.setText("기대를 내려놓으세요");
			Talk3.setText("세상에 대한, 가족에 대한,");
			Talk4.setText("친구에 대한 그리고 나에 대한.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 15: {
			Talk.setText("");
			Talk2.setText("디자인은 하룻밤 재우는 게 좋다.");
			Talk3.setText("하지만 그보다 더 중요한 건");
			Talk4.setText("디자이너가 잠을 잘 자는 것이다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 16: {
			Talk.setText("");
			Talk2.setText("끊임없이 책을 읽고 다양한 것을");
			Talk3.setText("자주 보세요.");
			Talk4.setText("그리고 끊임없이 잊어버리세요.");
			Talk5.setText("그후에도 남는 것이 당신의 지식입니다.");
			Talk6.setText("");
			break;
		}

		case 17: {
			Talk.setText("좋은 기분을 유지하려면");
			Talk2.setText("주의에 기대하지 않는다.");
			Talk3.setText("나자신을 아름다운 풍경이라고");
			Talk4.setText("생각한다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 18: {
			Talk.setText("");
			Talk2.setText("동기부여를 너무 믿지 말아요.");
			Talk3.setText("그건 날씨 같은 거에요.");
			Talk4.setText("좋은 날씨, 나쁜 날씨에 좌우되면");
			Talk5.setText("일은 안 되기 마련이에요.");
			Talk6.setText("");
			break;
		}

		case 19: {
			Talk.setText("");
			Talk2.setText("소심해도 괜찬다.");
			Talk3.setText("소심해도 결과가 나오는 방법은");
			Talk4.setText("생각할 수 있다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 20: {
			Talk.setText("");
			Talk2.setText("날이 좋아서, 날이 좋지않아서, 날이 적당해서");
			Talk3.setText("너와 함께한 모든날이 눈부셨다.");
			Talk4.setText("그리고 무슨일이 벌어져도 네 잘못이 아니다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 21: {
			Talk.setText("");
			Talk2.setText("앞에 한눈을 팔면서 걸어오는 사람이 있다면");
			Talk3.setText("제대로 앞을 보고 있는 사람이 피하게 되죠.");
			Talk4.setText("불합리하지만 그런 법이에요.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 22: {
			Talk.setText("");
			Talk2.setText("애용은 하더라도");
			Talk3.setText("애착은 갖지 않는다");
			Talk4.setText("중요한 것은");
			Talk5.setText("사람의 마음이다.");
			Talk6.setText("");
			break;
		}

		case 23: {
			Talk.setText("");
			Talk2.setText("기대하지 않아요.");
			Talk3.setText("특별함을 바라지 않아요.");
			Talk4.setText("억지로 보람을 찾지 않아요.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 24: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("새로워 보이지 않더라도");
			Talk4.setText("다시 보면 새로움이 숨어 있어요.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 25: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("길이 좁을 때는");
			Talk4.setText("짐을 들이지 않는 게 좋다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 26: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("걱정한다고 불안한 마음이 없어지지 않아요.");
			Talk4.setText("일단 잠부터 자도록 해요.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 27: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("어른이 되어도 순진무구함을 잃지 않기.");
			Talk4.setText("현재의 내 모습과 가장 비슷하게 조정한다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 28: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("결국 중요한 건 타인이 찍은 내모습과");
			Talk4.setText("스스로 찍은 내 모습이 똑같아야 한다는 거에요.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 29: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("자신은 부드럽게 기분은 풍족하게.");
			Talk4.setText("인생의 디자인은 진한 연필로 쉽게 쓱 그린다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 30: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("판단 기준은");
			Talk4.setText("'마음의 평온' 입니다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 31: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("사랑받기 위해서 비굴해지지 않는다");
			Talk4.setText("나를 바꾸지 않고 타인과 소통한다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 32: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("대단한 사람이 어디 숨어 있을지 모른다.");
			Talk4.setText("누구를 대하든 예의를 갖춰서 대한다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 33: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("부족하다고 느끼는 마음이");
			Talk4.setText("다음 만남을 이어줍니다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 34: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("정직한 것과 솔직한 것은 다릅니다.");
			Talk4.setText("생각한 것을 다 말해도 되는것은 아닙니다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 35: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("상대방을 자신의 존재를 과시하는");
			Talk4.setText("대상으로 삼아선 안 됩니다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 36: {
			Talk.setText("");
			Talk2.setText("자신 자신에게 여유가 없다면");
			Talk3.setText("타인에게도 친절해질 수 없어요.");
			Talk4.setText("무슨 일이든 내가 어떤사람이어야 하는지 ");
			Talk5.setText("생각하는 것부터 시작하는 겁니다.");
			Talk6.setText("");
			break;
		}

		case 37: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("원했던 일에서 실패하면 많은 것을 배울 수 있습니다.");
			Talk4.setText("뭐든 손해를 보지 않으면 얻을 수 없어요.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 38: {
			Talk.setText("아아, 순서가 중요한데요.");
			Talk2.setText("이익을 얻으려다가 실패하는 건 당연합니다.");
			Talk3.setText("하지만 먼저 손해를 받아들이고");
			Talk4.setText("새로운 일에 도전하면");
			Talk5.setText("생각지도 못한 길이 보이기도 해요.");
			Talk6.setText("");
			break;
		}

		case 39: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("잘되지 않는 것이 당연합니다.");
			Talk4.setText("");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 40: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("'고민은 일을 복잡하게 만든다.");
			Talk4.setText("생각은 일을 단순하게 만든다.'");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 41: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("연등감은 우월감의 반증");
			Talk4.setText("나 자신과는 겸허하게 지내기.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 42: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("자신감은 뜨기 위한 것이 아니라");
			Talk4.setText("휩쓸리지 않기 위한 추입니다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 43: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("좋은 일을 하면 좋은사람과 함께 하는");
			Talk4.setText("좋은 일을 만날 수 있습니다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 44: {
			Talk.setText("");
			Talk2.setText("");
			Talk3.setText("남에게 보여주는 것 같지만 사실은 남이 보고있다.");
			Talk4.setText("내가 편하지 않으면 남도 그렇게 생각한다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}

		case 45: {
			Talk.setText("");
			Talk2.setText("센스가 뭐냐고 붇는다면");
			Talk3.setText("쓸데없는 일을 하지 않는것이라고 대답한다.");
			Talk4.setText("쓸데없는 일이 뭔지 모르겠다고 한다면");
			Talk5.setText("그것이 센스라고 대답합니다.");
			Talk6.setText("");
			break;
		}

		case 46: {
			Talk.setText("");
			Talk2.setText("스스로 '어떤 사람' 이라고 정해놓지 마세요");
			Talk3.setText("아무도 그 가실에 관심이 없습니다.");
			Talk4.setText("스스로 자신을 구속하고 있을 뿐입니다.");
			Talk5.setText("");
			Talk6.setText("");
			break;
		}
		}

		historys.add(Talk);
		historys.add(Talk2);
		historys.add(Talk3);
		historys.add(Talk4);
		historys.add(Talk5);
		historys.add(Talk6);

		Background.add(historys);
		Background.add(history);
		Background.add(name1);
		Background.add(email1);
		Background.add(name);
		Background.add(email);
		Background.add(b1);

		f.add(b2);
		f.add(Title);
		f.add(Background);
		f.setVisible(true);

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		information f = new information();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("HOME")) {
			f.setVisible(false);
			MainFrame main = new MainFrame();
		}
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
}