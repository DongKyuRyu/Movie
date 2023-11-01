package VO;

import java.util.Date;

public class SeatVO {
	private String seatNumber;// 좌석번호
	private String reservedDate;
	private String roomNumber;// 관에 대한 정보
	private String time; // 회차수
	private String reserved; // 예약 되어있는지 //날짜가 없는디?

	public SeatVO() {
		super();
	}

	@Override
	public String toString() {
		String text =
				seatNumber +" " + reservedDate + " " + roomNumber + " " + time + " " + reserved;
		return text;
	}
	
	public SeatVO(String seatNumber, String reservedDate, String roomNumber, String time, String reserved) {
		super();
		this.seatNumber = seatNumber;
		this.reservedDate = reservedDate;
		this.roomNumber = roomNumber;
		this.time = time;
		this.reserved = reserved;
	}
	
	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(String reservedDate) {
		this.reservedDate = reservedDate;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
}