package MainFrame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ThisIsForYou extends WindowAdapter implements ActionListener {
	private Frame f;
	private Label Title, Talk, Talk2, Talk3, Talk4, Talk5, Talk6;
	private Panel Talknum;
	private ImageIcon imageicon;
	private JButton movieporster;
	private URL searchURL;
	private Button MainMove;
	private int num;

	public ThisIsForYou() {
		Font TitleFont = new Font("고딕", Font.BOLD, 30);
		Font TalkFont = new Font("고딕", Font.BOLD, 17);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();

		f = new Frame("너에게 해주고싶은말");
		f.setResizable(false);
		f.setSize(500, 370);
		f.setBackground(new Color(188, 205, 194));
		f.setLayout(null);
		f.setLocation((scr.width - 500) / 2, (scr.height - 500) / 2);

		Title = new Label("오늘도 빛나는 너에게");
		Title.setForeground(Color.BLACK);
		Title.setBounds(140, 80, 300, 80);
		Title.setFont(TitleFont);

		Talknum = new Panel();
		Talknum.setLayout(null);
		Talknum.setBounds(50, 170, 400, 114);

		Talk = new Label("", Label.CENTER);
		Talk.setBounds(0, 0, 400, 19);
		Talk.setBackground(Color.LIGHT_GRAY);
		Talk.setFont(TalkFont);

		Talk2 = new Label("", Label.CENTER);
		Talk2.setBounds(0, 19, 400, 19);
		Talk2.setBackground(Color.LIGHT_GRAY);
		Talk2.setFont(TalkFont);

		Talk3 = new Label("", Label.CENTER);
		Talk3.setBounds(0, 38, 400, 19);
		Talk3.setBackground(Color.LIGHT_GRAY);
		Talk3.setFont(TalkFont);

		Talk4 = new Label("", Label.CENTER);
		Talk4.setBounds(0, 57, 400, 19);
		Talk4.setBackground(Color.LIGHT_GRAY);
		Talk4.setFont(TalkFont);

		Talk5 = new Label("", Label.CENTER);
		Talk5.setBounds(0, 76, 400, 19);
		Talk5.setBackground(Color.LIGHT_GRAY);
		Talk5.setFont(TalkFont);

		Talk6 = new Label("", Label.CENTER);
		Talk6.setBounds(0, 95, 400, 19);
		Talk6.setBackground(Color.LIGHT_GRAY);
		Talk6.setFont(TalkFont);

		num = (int) (Math.random() * 28);

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
		}
		// 로고
		searchURL = getClass().getResource("/img/Logo2.png");
		imageicon = new ImageIcon(searchURL);
		Image image = imageicon.getImage();
		Image scaledImage = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		movieporster = new JButton(scaledIcon);// 크기 바꿀때 imageicon-->scaledIcon 으로 변경
		movieporster.setBounds(60, 80, 80, 80);
		movieporster.setBackground(Color.red);
		movieporster.setBorderPainted(false);
		movieporster.setFocusPainted(false);
		movieporster.setContentAreaFilled(false);

		MainMove = new Button("매인으로");
		MainMove.setBounds(165, 300, 170, 50);
		MainMove.setBackground(new Color(188, 205, 227));
		MainMove.addActionListener(this);

		Talknum.add(Talk);
		Talknum.add(Talk2);
		Talknum.add(Talk3);
		Talknum.add(Talk4);
		Talknum.add(Talk5);
		Talknum.add(Talk6);

		f.add(Talknum);
		f.add(MainMove);
		f.add(movieporster);
		f.add(Title);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("매인으로")) {
			f.setVisible(false);
		}
	}

	public static void main(String[] args) {
		ThisIsForYou thisIS = new ThisIsForYou();
	}
}