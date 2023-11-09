package MainFrame;

import DAO.CustomerDAO;

public class MovieData {
	private static MovieData instance = new MovieData();
	private String MovieList; 
	private String MovieTime;
	private String MovieDate;
	private int MoviePeople;
	
	private String MovieSeat;
	private String DuplicateSeat;
	
	private String MovieID;
	private String IdName;
	private String IdEmail;
	
	private String MovieRoomNum;
	
	private String MoviePay; //원가
	private String Moviediscount; //할인
	private String discountprice; //최종

	public MovieData() {
	}
	
	public static MovieData getInstance() {
		return instance;
	}
	
	public MovieData(String MovieList, String MovieTime, String MovieDate, int MoviePeople, String MovieSeat, String DuplicateSeat, String MovieID, String IdName, String IdEmail, String MovieRoomNum, String MoviePay, String Moviediscount, String diiscountprice) {
		this.MovieList = MovieList;
		this.MovieTime = MovieTime;
		this.MovieDate = MovieDate;
		this.MoviePeople = MoviePeople;
		
		this.MovieSeat = MovieSeat;
		this.DuplicateSeat = DuplicateSeat;
		
		this.MovieID = MovieID;
		this.IdName = IdName;
		this.IdEmail = IdEmail;
		
		this.MovieRoomNum = MovieRoomNum;
		
		this.MoviePay = MoviePay;
		this.Moviediscount = Moviediscount;
		this.discountprice =diiscountprice;
		
	}

	public String getDuplicateSeat() {
		return DuplicateSeat;
	}

	public void setDuplicateSeat(String duplicateSeat) {
		DuplicateSeat = duplicateSeat;
	}

	public String getMovieRoomNum() {
		return MovieRoomNum;
	}

	public void setMovieRoomNum(String movieRoomNum) {
		MovieRoomNum = movieRoomNum;
	}

	public String getMovieID() {
		return MovieID;
	}

	public void setMovieID(String movieID) {
		MovieID = movieID;
	}

	public String getIdName() {
		return IdName;
	}

	public void setIdName(String idName) {
		IdName = idName;
	}

	public String getIdEmail() {
		return IdEmail;
	}

	public void setIdEmail(String idEmail) {
		IdEmail = idEmail;
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