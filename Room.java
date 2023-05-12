package assignment1;

public class Room {

    private String type;
    private int price;
    private boolean available;

    public Room(String type){
        this.type = type;

        if (type.equalsIgnoreCase("double")) {
            price = 90*100;
        } else if (type.equalsIgnoreCase("queen")) {
            price = 110*100;
        } else if (type.equalsIgnoreCase("king")) {
            price = 150*100;
        } else {
            throw new IllegalArgumentException("Room must be of type double, queen, or king.");
        }
        this.available = true;
    }

    public Room(Room r){
        if (r.type.equalsIgnoreCase("double")){
            price = 90*100;
        } else if (r.type.equalsIgnoreCase("queen")){
            price = 110*100;
        } else if (r.type.equalsIgnoreCase("king")){
            price = 150*100;
        }
        available = true;
        type = r.getType();

    }

    public String getType(){
        return this.type;
    }

    public int getPrice(){
        return this.price;
    }

    public void changeAvailability(){
        available = !available;
    }

    public static Room findAvailableRoom(Room[] rooms, String type){
        for (int i = 0; i < rooms.length; i++){
            if(rooms[i] == null){
                continue;
            }
            if (rooms[i].type.equalsIgnoreCase((type)) && rooms[i].available) {
                return rooms[i];
            }
        }

        return null;
    }

    public static boolean makeRoomAvailable(Room[] rooms, String type){
        for (int i = 0; i < rooms.length; i++){
            if(rooms[i] == null){
                continue;
            }
            if (rooms[i].type.equalsIgnoreCase((type)) && !rooms[i].available) {
                rooms[i].available = true;
                return true;
            }
        }

        return false;
    }

}
