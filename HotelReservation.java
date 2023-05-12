package assignment1;

public class HotelReservation extends Reservation {

    private Hotel hotel;
    private String type;
    private int nights;
    private int pricePerNightCents;

    public HotelReservation(String name, Hotel hotel, String type, int nights){
        super(name);

        this.hotel = hotel;
        this.type = type;
        this.nights = nights;

        int price = hotel.reserveRoom(type);
        this.pricePerNightCents = price;
    }

    public int getNumOfNights(){
        return this.nights;
    }

    @Override
    public int getCost() {
        return (this.pricePerNightCents * this.nights);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HotelReservation){
            boolean one = ((HotelReservation) obj).reservationName() == this.reservationName();
            boolean two = ((HotelReservation) obj).getCost() == this.getCost();
            boolean three = ((HotelReservation) obj).getNumOfNights() == this.getNumOfNights();

            return one && two && three;
        }

        return false;

        // look at fields
        // instance of to check if both same type, then check fields
    }
}
