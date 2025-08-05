public class KoreanRestaurant extends Restaurant {
    private String number;
    private String breakTime;

    public KoreanRestaurant() {
        super();
    }

    public KoreanRestaurant(int resId, String name, String address, String signatureMenu, int rate, String number, String breakTime){
        super(resId, name, address, signatureMenu, rate);
        this.number = number;
        this.breakTime = breakTime;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getBreakTime(){
        return this.breakTime;
    }

    public void setBreakTime(String breakTime){
        this.breakTime = breakTime;
    }

    
}
