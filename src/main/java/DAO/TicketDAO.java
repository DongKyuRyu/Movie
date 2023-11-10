package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Util.CloseUtil;
import Util.ConnUtil;
import VO.SeatVO;
import VO.TicketVO;

public class TicketDAO {
	private static TicketDAO instance = new TicketDAO();

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
	public ArrayList<TicketVO> selectList(String Id) {
		String sql = "select * from ticket where Id = ? "; // 이 아이디가 예매한 내역을 모조리 뽑아주세요!

		ArrayList<TicketVO> list = new ArrayList<>();
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String seatNumber = rs.getString("seatNumber");
				String roomNumber = rs.getString("roomNumber");
				String movieName = rs.getString("movieName");
				String dDay = rs.getString("dDay");
				String time = rs.getString("time");
				String cost = rs.getString("cost");
				int person = rs.getInt("person");
				TicketVO ticketVO = new TicketVO(Id, seatNumber, roomNumber, movieName, dDay, time, cost, person);
				list.add(ticketVO);
			}
			// System.out.println("예약된 좌석 select");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
		return list;
	}

	// 티켓 삭제 delete (예매취소)
	public void delete(TicketVO ticket) {
		String id = ticket.getId();// 고객 아이디 -ticketingView 0
		String seatNumber = ticket.getSeatNumber(); // 좌석 이름 -seatView 0
		String roomNumber = ticket.getRoomNumber(); // 관 번호 -ticketingView 0
		String movieName = ticket.getMovieName(); // 영화 이름 -ticketingView 0
		String dDay = ticket.getDday();
		String time = ticket.getTime(); // 영화 회차 -ticketingView 0
		String cost = ticket.getCost(); // 티켓 가격 -ticketingView 0
		int person = ticket.getPerson(); // 인원 수 -ticketingView 0
		String sql = "DELETE FROM (SELECT * FROM ticket WHERE id = :1 AND seatNumber = :2 AND roomNumber = :3 AND movieName = :4 AND dDay = :5 AND time = :6 AND cost = :7 AND person = :8 ORDER BY id DESC) WHERE ROWNUM <= 1";
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
			pstmt.executeUpdate();
			System.out.println("티켓 삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
	}

	// 티켓 등록 insert
	public void insert(TicketVO ticket) {
		String id = ticket.getId();// 고객 아이디 -ticketingView 0
		String seatNumber = ticket.getSeatNumber(); // 좌석 이름 -seatView 0
		String roomNumber = ticket.getRoomNumber(); // 관 번호 -ticketingView 0
		String movieName = ticket.getMovieName(); // 영화 이름 -ticketingView 0
		String dDay = ticket.getDday();
		String time = ticket.getTime(); // 영화 회차 -ticketingView 0
		String cost = ticket.getCost();
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

	public String ticketId(String Id) { // 영화 이름 을 받고 영화를 출력함.
		String sql = "select Moviename from ticket where Id = ? ";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String Moviename = rs.getString("SeatNumber");
				return Moviename;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
		return null;
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

	
	public String checkedTicket(String Id) { // 영화 이름 을 받고 영화를 출력함.
		String sql = "select SeatNumber from ticket where Id = ? ";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String SeatNumber = rs.getString("SeatNumber");
				return SeatNumber;
			}
		} catch (Exception e) {
			return null;
		} finally {
			CloseUtil.close(pstmt, con);
		}
		return null;
	}

}