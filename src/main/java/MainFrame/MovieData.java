package MainFrame;

import DAO.CustomerDAO;

public class MovieData {
	private static MovieData instance = new MovieData();
	private String MovieList; 
	private String MovieTime;
	private String MovieDate;
	private int MoviePeople;
	private String MovieSeat;
	private String MoviePay;

	public MovieData() {
	}
	
	public static MovieData getInstance() {
		return instance;
	}
	
	public MovieData(String MovieList, String MovieTime, String MovieDate, int MoviePeople, String MovieSeat, String MoviePay) {
		this.MovieList = MovieList;
		this.MovieTime = MovieTime;
		this.MovieDate = MovieDate;
		this.MoviePeople = MoviePeople;
		this.MovieSeat = MovieSeat;
		this.MoviePay = MoviePay;
	}

	public String getMovieList() {
		return MovieList;
	}

	public void setMovieList(String movieList) {
		MovieList = movieList;
	}

	public String getMovieTime() {
		return MovieTime;
	}

	public void setMovieTime(String movieTime) {
		MovieTime = movieTime;
	}

	public String getMovieDate() {
		return MovieDate;
	}

	public void setMovieDate(String movieDate) {
		MovieDate = movieDate;
	}

	public int getMoviePeople() {
		return MoviePeople;
	}

	public void setMoviePeople(int moviePeople) {
		MoviePeople = moviePeople;
	}

	public String getMovieSeat() {
		return MovieSeat;
	}

	public void setMovieSeat(String movieSeat) {
		MovieSeat = movieSeat;
	}

	public String getMoviePay() {
		return MoviePay;
	}

	public void setMoviePay(String moviePay) {
		MoviePay = moviePay;
	}
	
}
