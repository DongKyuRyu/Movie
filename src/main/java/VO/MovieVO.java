package VO;

import java.awt.Image;

public class MovieVO {
	private String movieName;
	private String ageLimit;
	private int RunningTime;
	private String imgSrc;
	
	public MovieVO() {}

	public MovieVO(String movieName, String ageLimit, int RunningTime, String imgSrc) {
		super();
		this.movieName = movieName;
		this.ageLimit = ageLimit;
		this.RunningTime = RunningTime;
		this.imgSrc = imgSrc;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(String ageLimit) {
		this.ageLimit = ageLimit;
	}

	public int getRunningTime() {
		return RunningTime;
	}

	public void setRunningTime(int RunningTime) {
		this.RunningTime = RunningTime;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

}