package assignment1;

public class Customer {

    private String name;
    private int balance;
    private Basket basket;

    public Customer(String name, int balance){
        this.name = name;
        this.balance = balance;
        this.basket = new Basket();
    }

    public String getName(){
        return this.name;
    }

    public int getBalance(){
        return this.balance;
    }

    public Basket getBasket(){
        return this.basket;
    }

    public int addFunds(int input){
        if(input < 0){
            throw new IllegalArgumentException("Input cannot be negative");
        }
        this.balance = this.balance + input;
        return this.balance;

    }

    public int addToBasket(Reservation reservation){
        if(name == reservation.reservationName()) {
            int len = basket.add(reservation);
            return len;
        }
        else{
            throw new IllegalArgumentException("Reservation names don't match.");
        }
    }

    public int addToBasket(Hotel hotel, String type, int nights, boolean breakfast){

        if (breakfast == true) {
            BnBReservation newBnB = new BnBReservation(this.name, hotel, type, nights);
            int len = basket.add(newBnB);
            return len;
        }
        else{
            HotelReservation newHotel = new HotelReservation(this.name, hotel, type, nights);
            int len = basket.add(newHotel);
            return len;
        }

    }

    public int addToBasket(Airport airport1, Airport airport2){
        FlightReservation newFlight = new FlightReservation(this.name, airport1, airport2);

        int len = basket.add(newFlight);
        return len;
    }

    public boolean removeFromBasket(Reservation reservation){
        boolean removed = basket.remove(reservation);
        return removed;
    }

    public int checkOut(){
        if(this.balance < basket.getTotalCost()){
            throw new IllegalStateException("Not enough funds.");
        }

        this.balance = this.balance - basket.getTotalCost();
        basket.clear();

        return this.balance;
    }

}
