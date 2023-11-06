package VO;

public class MovieVO {
	private String movieName;
	private String startDate;
	private String endDate;
	private String ageLimit;
	private int runningTime;
	private String imgSrc;
	
	public MovieVO() {}

	public MovieVO(String movieName, String startDate, String endDate, String ageLimit, int runningTime, String imgSrc) {
		super();
		this.movieName = movieName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.ageLimit = ageLimit;
		this.runningTime = runningTime;
		this.imgSrc = imgSrc;
	}
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	public String getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(String ageLimit) {
		this.ageLimit = ageLimit;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

}