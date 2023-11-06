package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.CloseUtil;
import Util.ConnUtil;
import VO.MovieVO;

public class MovieDAO {
	private static MovieDAO instance = new MovieDAO();
	
	private MovieDAO() {
	}

	public static MovieDAO getInstance() {
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

	// 무비 리스트 출력하기.
	public ArrayList<MovieVO> selectList() {
		ArrayList<MovieVO> list = new ArrayList<>();
		try {
			connect();
			String sql = "select * from movie";

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MovieVO movie = new MovieVO();
				movie.setMovieName(rs.getString("moviename"));
				movie.setStartDate(rs.getString("startdate"));
				movie.setEndDate(rs.getString("enddate"));
				movie.setAgeLimit(rs.getString("agelimit"));
				movie.setRunningTime(rs.getInt("runningTime"));
				movie.setImgSrc(rs.getString("imgSrc"));
				list.add(movie);
			}
		} catch (Exception e) {
		} finally {
			CloseUtil.close(pstmt, con);
		}
		return list;
	}

	// 무비 하나 출력
	public MovieVO getMovie(String name) { // 영화 이름 을 받고 영화를 출력함.
		String sql = "select * from movie where moviename = ?";
		MovieVO movie = new MovieVO();
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				movie.setMovieName(rs.getString("moviename"));
				movie.setStartDate(rs.getString("startdate"));
				movie.setEndDate(rs.getString("enddate"));
				movie.setAgeLimit(rs.getString("agelimit"));
				movie.setRunningTime(rs.getInt("time"));
				movie.setImgSrc(rs.getString("imgSrc"));
				return movie;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
		return null;
	}

	public String SearchMovieposter(String name) {
		String sql = "SELECT imgsrc FROM MOVIE WHERE MovieName = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			String poster;
			if (rs.next()) {
				poster = rs.getString("imgSrc");
				return poster;
				
			}
		} catch (Exception e) { //try 블록에서 발생한 예외를 처리하기 위한 부분, 
			//Exception은 모든 예외의 최상위 클래스이기 때문에 모든 종류의 예외를 처리가능
			
			e.printStackTrace();
		} finally {//try 블록 수행 중 예외가 발생하든 안 하든 무조건 실행되는 블록
			CloseUtil.close(pstmt, con);
			//CloseUtil 클래스의 close 메서드를 호출하여 데이터베이스 관련 자원을 해제
		}//이렇게 메서드를 통해 자원을 해제하는 이유는 코드 중복을 방지하고 가독성을 높이기 위함
		return null;
	}
}