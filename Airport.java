package assignment1;

public class Airport {

    private int xCoord;
    private int yCoord;
    private int feeCents;

    public Airport(int xCoord, int yCoord, int feeCents){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.feeCents = feeCents;
    }

    public int getFees(){
        return this.feeCents;
    }

    public static int getDistance(Airport a1, Airport a2){
        int distance = (int) Math.ceil(Math.sqrt
                (Math.pow((a1.xCoord - a2.xCoord),2) + Math.pow((a1.yCoord - a2.yCoord),2)));
        return distance;
    }

}
