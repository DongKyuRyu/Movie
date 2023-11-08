package MainFrame;

import DAO.CustomerDAO;

public class MovieData {
	private static MovieData instance = new MovieData();
	private String MovieList; 
	private String MovieTime;
	private String MovieDate;
	private int MoviePeople;
	private String MovieSeat;
	private String Id;
	private String MoviePay; //원가
	private String Moviediscount; //할인
	private String Discountprice; //최종
	private String MovieRoomnNum;

	public MovieData(String Id, String MovieList, String MovieTime, String MovieDate, int MoviePeople, String MovieSeat, String MoviePay, String Moviediscount, String Discountprice, String MovieRoomnNum) {
		this.Id = Id;
		this.MovieList = MovieList;
		this.MovieTime = MovieTime;
		this.MovieDate = MovieDate;
		this.MoviePeople = MoviePeople;
		this.MovieSeat = MovieSeat;
		this.MoviePay = MoviePay;
		this.Moviediscount = Moviediscount;
		this.Discountprice = Discountprice;
		this.MovieRoomnNum = MovieRoomnNum;
	}
	
	public String getMovieRoomNum() {
		return MovieRoomnNum;
	}
	
	public void setMovieRoomNum(String movieroomnum) {
		MovieRoomnNum = movieroomnum;
	}
	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
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
		return Discountprice;
	}

	public void setDiscountprice(String discountprice) {
		Discountprice = discountprice;
	}
}