package MainFrame;

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
	private String MoviePay; // 원가
	private String Moviediscount; // 할인
	private String Discountprice; // 최종

	private int adultCount, teenagerCount;

	public MovieData() {
	}

	public static MovieData getInstance() {
		return instance;
	}

	public MovieData(String MovieList, String MovieTime, String MovieDate, int MoviePeople, String MovieSeat,
			String DuplicateSeat, String MovieID, String IdName, String IdEmail, String MovieRoomNum, String MoviePay,
			String Moviediscount, String discountprice, int adultCount, int teenagerCount) {
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
		this.Discountprice = discountprice;
		this.adultCount = adultCount;
		this.teenagerCount = teenagerCount;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getTeenagerCount() {
		return teenagerCount;
	}

	public void setTeenagerCount(int teenagerCount) {
		this.teenagerCount = teenagerCount;
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
		return Discountprice;
	}

	public void setDiscountprice(String discountprice) {
		Discountprice = discountprice;
	}
}