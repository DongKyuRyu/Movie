package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import MainFrame.MovieData;
import Util.CloseUtil;
import Util.ConnUtil;
import VO.SeatVO;
import VO.TicketVO;

public class TicketDAO {
	private static TicketDAO instance = new TicketDAO();
	private MovieData moviedata = MovieData.getInstance();
	private SeatVO seatvo = SeatVO.getInstance();

	private TicketDAO() {
	}

	public static TicketDAO getInstance() {
		return instance;
	}

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public void connect() {
		try {
			con = ConnUtil.getConnection();
			// System.out.println("데이터 베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 티켓 검색 select List (input 고객 이름)
	public ArrayList<TicketVO> selectList(String customerId) {
		String sql = "select * from ticket where customerId = ? "; //이 아이디가 예매한 내역을 모조리 뽑아주세요!
		
		ArrayList<TicketVO> list = new ArrayList<>();
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customerId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String seatNumber = rs.getString("seatNumber");
				String roomNumber = rs.getString("roomNumber");
				String movieName = rs.getString("movieName");
				String dDay = rs.getString("dDay");
				String time = rs.getString("time");
				String reservedDate = rs.getString("reservedDate");
				String cost = rs.getString("cost");
				int person = rs.getInt("person");
				TicketVO ticketVO = new TicketVO(
						customerId,seatNumber,roomNumber,movieName,
						dDay,time, cost, person	
						);
				list.add(ticketVO);
			}
			//System.out.println("예약된 좌석 select");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
		return list;
	}
	
	//예매 취소 -> delete - 그냥 삭제 해버린다.
		public void setSeatCancel(TicketVO ticket) {
			String seatNumber = ticket.getSeatNumber();
			String roomNumber = ticket.getRoomNumber();
			String Time = ticket.getTime();
			
			String sql = "delete from seat where seatNumber = ? and roomNumber = ? and Time = ? ";
			try {
				connect();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, seatNumber);
				pstmt.setString(2, roomNumber);
				pstmt.setString(3, Time);
				pstmt.executeUpdate();
				System.out.println("좌석 예약 취소");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				CloseUtil.close(pstmt, con);
			}
		}
		
	// 티켓 삭제  delete (예매취소)
	public void delete(TicketVO ticket) {
		String id = ticket.getId();// 고객 아이디 -ticketingView 0
		String seatNumber = ticket.getSeatNumber(); // 좌석 이름 -seatView 0
		String roomNumber = ticket.getRoomNumber(); // 극장 이름 -ticketingView 0
		String movieName = ticket.getMovieName(); // 관 번호 -ticketingView 0
		String time = ticket.getTime(); // 영화 회차 -ticketingView 0
		String sql = "delete from ticket "
				+ "where id = ? and seatNumber = ? and roomNumber = ? and movieName = ?"
				+ "and time = ? ";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, seatNumber);
			pstmt.setString(3, roomNumber);
			pstmt.setString(4, movieName);
			pstmt.setString(5, time);
			pstmt.executeUpdate();
			System.out.println("티켓 삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
	}

	
	// 티켓 등록  insert
	public void insert(TicketVO ticket) {
		String id = ticket.getId();// 고객 아이디 -ticketingView 0
		String seatNumber = ticket.getSeatNumber(); // 좌석 이름 -seatView 0
		String roomNumber = ticket.getRoomNumber(); // 관 번호 -ticketingView 0
		String movieName = ticket.getMovieName(); // 영화 이름 -ticketingView 0
		String dDay = ticket.getDday();
		String time = ticket.getTime(); // 영화 회차 -ticketingView 0
		String cost = ticket.getCost(); // 티켓 가격 -ticketingView 0
		int person = ticket.getPerson(); // 인원 수 -ticketingView 0

		// 예약한 시간 저장하기
		SimpleDateFormat f = new SimpleDateFormat("yyyy년 MM월dd일 HH시mm분ss초");
		Calendar c = Calendar.getInstance();
		String reservedDate = f.format(c.getTime()); // 현재날짜를 전달.
		String sql = "insert into ticket values (?,?,?,?,?,?,?,?)";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, seatNumber);
			pstmt.setString(3, roomNumber);
			pstmt.setString(4, movieName);
			pstmt.setString(5, dDay);
			pstmt.setString(6, time);
			pstmt.setString(7, cost);
			pstmt.setInt(8, person);
			System.out.println(ticket.toString());
			pstmt.executeUpdate();
			System.out.println("티켓 등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
	}
	
	public ArrayList<String> selectSeat(String Moviename, String Dday, String Time) {
		ArrayList<String> SeatNumber = new ArrayList<String>();
		SeatVO Seatnum = new SeatVO();
		
		try {
			connect();
			String sql = "select SEATNUMBER from TICKET where Moviename = ? and Dday = ? and Time = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Moviename);
			pstmt.setString(2, Dday);
			pstmt.setString(3, Time);
			rs = pstmt.executeQuery();		
			
			while(rs.next()) {
//				String duplicateseat = rs.getString("SEATNUMBER");
				Seatnum.setSeatVO(rs.getString("SEATNUMBER"));
				
				SeatNumber.add(Seatnum.getSeatVO());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			CloseUtil.close(pstmt, con);
		}
		return SeatNumber;
	}
}