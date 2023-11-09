package VO;

public class SeatVO {

	private static SeatVO instance = new SeatVO();
	private String SeatData;

	public SeatVO() {
	}

	public static SeatVO getInstance() {
		return instance;
	}

	public SeatVO(String SeatData) {
		this.SeatData = SeatData;
	}

	public void setSeatdata(String seatdata) {
		SeatData = seatdata;
	}

	public String getSeatdata() {
		return SeatData;
	}
}
