package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.main.java.Util.CloseUtil;
import src.main.java.Util.ConnUtil;
import src.main.java.VO.SeatVO;
import src.main.java.VO.TicketVO;

public class SeatDAO {
	private static SeatDAO instance = new SeatDAO();

	private SeatDAO() {
	}

	public static SeatDAO getInstance() {
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

	// 예매 하기
	public void setSeatRerserved(SeatVO seat) {
		String seatNumber = seat.getSeatNumber();
		String reservedDate = seat.getReservedDate();
		String roomNumber = seat.getRoomNumber();
		String time = seat.getTime();
		String sql = "insert into seat values(?,?,?,?,?)";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seatNumber);
			pstmt.setString(2, reservedDate);
			pstmt.setString(3, roomNumber);
			pstmt.setString(4, time);
			pstmt.setString(5, "y");
			pstmt.executeUpdate();
			// System.out.println("좌석 update");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
	}

	// 예매 취소 -> delete - 그냥 삭제 해버린다.
	public void setSeatCancel(TicketVO ticket) {
		String seatNumber = ticket.getSeatNumber();
		String reservedDate = ticket.getReservedDate();
		String roomNumber = ticket.getRoomNumber();
		String time = ticket.getTime();
		String sql = "delete from seat where seatnumber = ? and reserveddate = ? and roomnumber = ? and time = ? ";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seatNumber);
			pstmt.setString(2, reservedDate);
			pstmt.setString(3, roomNumber);
			pstmt.setString(4, time);
			pstmt.executeUpdate();
			System.out.println("좌석 예약 취소");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
	}

	// 예약된 좌석의 번호만 받아오기 select
	public ArrayList<String> getSeatList(String ReservedDate, String roomNumber, String time) {
		String sql = "select * from seat where reserveddate = ? and roomnumber = ? and time = ? and reserved = 'y'";
		ArrayList<String> list = new ArrayList<>();
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ReservedDate);
			pstmt.setString(2, roomNumber);
			pstmt.setString(3, time);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String seatNumber = rs.getString("seatnumber");
				list.add(seatNumber);
			}
			// System.out.println("예약된 좌석 select");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
		return list;
	}
}