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



   public void setSeatVO(String SeatNumberrr) {
      this.SeatNumberrr = SeatNumberrr;
   }
   
   public String getSeatVO() {
      return SeatNumberrr;
   }


	   public String toString() {
	      String SeatText = SeatNumberrr;
	      return SeatText;
	   }


	   public String getSeatNumberrr() {
	      return SeatNumberrr;
	   }
}