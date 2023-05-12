package assignment1;

public class Basket {

    private Reservation[] reservations;
    //more?

    public Basket(){
        this.reservations = new Reservation[0];
    }

    public Reservation[] getProducts(){
        Reservation[] reservationsCopy = this.reservations;

        //for loop make new array?

        return reservationsCopy;
    }

    public int add(Reservation input){
        Reservation[] reservationsAdded;
        reservationsAdded = new Reservation[this.reservations.length + 1];
        Reservation[] old = getProducts();

        for(int i = 0; i < this.reservations.length; i++){
            reservationsAdded[i] = old[i];
        }

        reservationsAdded[reservationsAdded.length-1] = input;
        this.reservations = reservationsAdded;

        return this.reservations.length;
    }

    public boolean remove(Reservation remove){

        if(this.reservations.length == 0){
            return false;
        }

        Reservation[] tmp;
        tmp = new Reservation[this.reservations.length-1];
        int m = 0;

        for(Reservation element: reservations){

            if(element.equals(remove)){

                this.reservations[m] = null;
                int j = 0;

                for(int i = 0; i < reservations.length; i++){
                    if(reservations[i] != null){
                        tmp[j] = reservations[i];
                        j ++;
                    }
                }

                this.reservations = tmp;
                return true;
            }
            m++;
        }

        return false;

    }

    public void clear(){
        this.reservations = new Reservation[0];
    }

    public int getNumOfReservations(){
        return this.reservations.length;
    }

    public int getTotalCost(){
        int price = 0;

        for(Reservation element: reservations){
            price += element.getCost();
        }
        return price;
    }




}
