package VO;

import java.sql.Timestamp;

public class TicketVO {
	private String name; // 고객 이름 -ticketing
	private String id; // 고객 아이디 -ticketing
	private String seatNumber; // 좌석 이름 -seat //A1,A2 .. 이런식으로 들어감.
	private String roomNumber; // 관 번호 -seat
	private String movieName; // 영화 이름 -ticketing
	private String dDay; // 영화 시작 날짜 -ticketing
	private String time; // 영화 회차 - seat
	private String reservedDate; // 영화 예매 날짜. 년 월 일 -- > 예약한 날짜만 나옴. - seat
	private int cost; // 티켓 가격 -ticketing
	private int person; // 인원 수 -ticketing

	public TicketVO() {
		super();
	}

	public TicketVO(String name, String id, String seatNumber, String roomNumber, String movieName,
			String dDay, String time, String reservedDate, int cost, int person) {
		super();
		this.name = name;
		this.id = id;
		this.seatNumber = seatNumber;
		this.roomNumber = roomNumber;
		this.movieName = movieName;
		this.dDay = dDay;
		this.time = time;
		this.reservedDate = reservedDate;
		this.cost = cost;
		this.person = person;
	}
	@Override
	public String toString() {
		String text =
				name +" " + id + " "+ seatNumber + " " + roomNumber + " " + movieName
				+ " " + dDay
				+ " " + time
				+ " " + reservedDate
				+ " " + cost +" " + person;
		return text;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public String getDday() {
		return dDay;
	}

	public void setDday(String dDay) {
		this.dDay = dDay;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(String reserveDate) {
		this.reservedDate = reserveDate;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

}