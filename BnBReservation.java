package assignment1;

public class BnBReservation extends HotelReservation{

    private int breakfastFee = 10*100;
    private int nights;

    public BnBReservation(String name, Hotel hotel, String type, int nights){
        super(name, hotel, type, nights);
        this.nights = nights;
    }

    @Override
    public int getCost() {
        return ((breakfastFee * this.nights) + super.getCost());
    }
}
