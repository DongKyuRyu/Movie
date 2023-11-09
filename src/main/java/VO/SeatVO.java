package VO;

public class SeatVO {
	private static SeatVO instance = new SeatVO();
	
	private String SeatNumberrr;

	public SeatVO() {
		super();
	}
	
	public static SeatVO getInstance() {
		return instance;
	}

	public SeatVO(String SeatNumberr) {
		this.SeatNumberrr = SeatNumberrr;
	}

	public String toString() {
		String SeatText = SeatNumberrr;
		return SeatText;
	}

	public String getSeatNumberrr() {
		return SeatNumberrr;
	}

	public void setSeatNumberrr(String seatNumberrr) {
		SeatNumberrr = seatNumberrr;
	}
}
