package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.main.java.Util.CloseUtil;
import src.main.java.Util.ConnUtil;
import src.main.java.VO.CustomerVO;

//singleton 으로 구현
public class CustomerDAO {

	private static CustomerDAO instance = new CustomerDAO();

	private CustomerDAO() {
	}

	public static CustomerDAO getInstance() {
		return instance;
	}

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public void connect() {
		try {
			con = ConnUtil.getConnection();
			System.out.println("데이터 베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// select - 회원 검색 - 로그인
	/*
	 * 1) id 확인 - 있는 id -> 비밀번호확인 1. 비밀번호가 틀림 -> return // 비밀번호를 확인하세요 2. 비밀번호가 맞음
	 * -> login 완료. - 연결 해줌. 9+
	 * 
	 * - 없는 id -> return // id를 확인하세요
	 */

	// 아이디로 찾아오기
	public CustomerVO selectById(String id) {
		String sql = "select * from customer where id = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			CustomerVO customer = new CustomerVO();
			// id 확인
			if (rs.next()) {
				customer.setName(rs.getString("name"));
				customer.setId(rs.getString("id"));
				customer.setPassword(rs.getString("password"));
				customer.setEmail(rs.getString("email"));
//				customer.setBirthday(rs.getString("birthday"));
//				customer.setPreference(rs.getString("preference"));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	// 회원가입에서 아이디 중복 체크
	// 중복 : 0 실패 : 사용 가능 : -1 | 데이터베이스 오류 : -2
	public int Duplication(String id) {
		String sql = "select * from customer where id = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// id 확인
			if (rs.next()) {
				System.out.println("id가 확인됨. ");
				String pid = rs.getString("id"); // 실제 아이디
				if (id.equals(pid)) {
					System.out.println("이미 존재하는 ID입니다.");
					return 0;
				}
			}
			else {
				System.out.println("사용 가능한 아이디입니다.");
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -2;
	}
	
	
	// 아이디 찾기
	// 1. 이름, 이메일을 입력 받는다. 2. 받은 값을 DataBase에서 select 사용해서 아이디를 찾는다. 3. 찾은 아이디값을 String 타입으로 return 해준다. 
	public String SearchID(String name, String email) {
		String sql = "select * from customer where name = ? AND EMAIL = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			
			CustomerVO customer = new CustomerVO();

			// id 확인
			if (rs.next()) {
				String Name = rs.getString("name");
				String Email = rs.getString("email");
				String DBid = rs.getString("ID");
				customer.setId(DBid);
				String ID = customer.getId();
				if (name.equals(Name) && email.equals(Email)) {
					System.out.println("일치하는 회원 정보가 존재합니다.");
					return ID;
				}
			}
			else {
				System.out.println("회원 정보가 존재하지 않습니다.");
				return "NonExist";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return "Error";
	}
	
	// 비밀번호 찾기
	// 1. 이름, 아이디를 입력 받는다. 2. 받은 값을 DataBase에서 select 사용해서 비밀번호가 존재하는지 확인한다. 3. 비밀번호가 존재한다면 0을 return한다.
	public int SearchPWD(String name, String id) {
		String sql = "select * from customer where name = ? AND id = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
//			CustomerVO customer = new CustomerVO();

			// id 확인
			if (rs.next()) {
				String Name = rs.getString("name");
				String ID = rs.getString("id");
//				String DBpwd = rs.getString("password");
//				customer.setPassword(DBpwd);
//				String PWD = customer.getId();
				if (name.equals(Name) && id.equals(ID)) {
					System.out.println("PassWord를 찾았습니다.");
					return 0;
				}
			}
			else {
				System.out.println("정확하게 입력해 주세요.");
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -2;
	}
	
	
	
	// 비밀번호 변경
	public void ChangePWD(String password, String id) {
		String sql = "update customer set password = ? where id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	// 로그인
	// 성공 : 0 실패 : 비밀번호오류 : -1, 등록되지않은 아이디 : -2 | 데이터베이스 오류 : -3;
	public int login(String id, String password) {
		String sql = "select * from customer where id = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// id 확인
			if (rs.next()) {
				System.out.println("id가 확인됨. ");
				String pwd = rs.getString("password"); // 실제 비밀번호

				// 1) 비밀번호가 맞는 경우.
				if (password.equals(pwd)) {
					System.out.println("로그인 완료");
					return 0;
				}
				// 2) 비밀번호가 틀린 경우
				else {
					return -1;
				}
			}
			// 없는 id
			else {
				return -2;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -3; // 데이터베이스 오류
	}
	
	//회원가입
	public boolean register(CustomerVO customer) {
		String name = customer.getName();
		String id = customer.getId();
		String password = customer.getPassword();
		String email = customer.getEmail();
//		String birthday = customer.getBirthday();
//		String preference = customer.getPreference();

		String sql = "insert into customer values (?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, email);
//			pstmt.setString(5, birthday);
//			pstmt.setString(6, preference);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(pstmt, con);
		}
		return false;
	}


	// update - 아이디 및 비밀번호 변경

	// delete - 회원 삭제

}