package assignment1;

public class FlightReservation extends Reservation{

    private Airport departure;
    private Airport arrival;

    public FlightReservation(String name, Airport depart, Airport arrive){
        super(name);

        if (depart.equals(arrive)){
            throw new IllegalArgumentException("Departure and arrival airport cannot be the same.");
        }

        departure = depart;
        arrival = arrive;
    }

    @Override
    public int getCost() {
        double fuelCost = 124 * (Airport.getDistance(this.departure, this.arrival)/167.52);
        double depFees = departure.getFees();
        double arrFees = arrival.getFees();
        double extraCost = 5375;
        // in cents
        return (int) Math.ceil(fuelCost + depFees + arrFees + extraCost);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof FlightReservation){
            boolean one = ((FlightReservation) obj).reservationName() == this.reservationName();
            boolean two = ((FlightReservation) obj).getCost() == this.getCost();
            boolean three = ((FlightReservation) obj).departure == this.departure;
            boolean four = ((FlightReservation) obj).arrival == this.arrival;

            return one && two && three && four;
        }

        return false;
    }
}
