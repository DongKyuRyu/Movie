package MainFrame;

import DAO.CustomerDAO;

public class MovieData {
	private static MovieData instance = new MovieData();
	private String MovieList; 
	private String MovieTime;
	private String MovieDate;
	private int MoviePeople;
	private String MovieSeat;
	private String MovieSeat2;
	
	private String MoviePay; //원가
	private String Moviediscount; //할인
	private String discountprice; //최종

<<<<<<< HEAD
	public MovieData() {
	}
	
	public static MovieData getInstance() {
		return instance;
	}
	
	public MovieData(String MovieList, String MovieTime, String MovieDate, int MoviePeople, String MovieSeat,  String MoviePay) {
=======
	public MovieData(String MovieList, String MovieTime, String MovieDate, int MoviePeople, String MovieSeat, String MovieSeat2, String MoviePay, String Moviediscount, String diiscountprice) {
>>>>>>> branch 'master' of https://github.com/DongKyuRyu/Movie.git
		this.MovieList = MovieList;
		this.MovieTime = MovieTime;
		this.MovieDate = MovieDate;
		this.MoviePeople = MoviePeople;
		this.MovieSeat = MovieSeat;
		this.MovieSeat = MovieSeat2;
		this.MoviePay = MoviePay;
		this.Moviediscount = Moviediscount;
		this.discountprice =diiscountprice;
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
	
<<<<<<< HEAD
=======
	public String getMovieSeat2() {
		return MovieSeat;
	}

	public void setMovieSeat2(String movieSeat2) {
		MovieSeat2 = movieSeat2;
	}
>>>>>>> branch 'master' of https://github.com/DongKyuRyu/Movie.git

	public String getMoviePay() {
		return MoviePay;
	}

	public void setMoviePay(String moviePay) {
		MoviePay = moviePay;
	}
	
	public MovieData() {
	}
	
	public static MovieData getInstance() {
		return instance;
	}
	
	public String getMoviediscount() {
		return Moviediscount;
	}

	public void setMoviediscount(String moviediscount) {
		Moviediscount = moviediscount;
	}

	public String getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(String discountprice) {
		this.discountprice = discountprice;
	}
}