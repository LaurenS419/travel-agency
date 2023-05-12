package assignment1;

public class Hotel {

    private String name;
    private Room[] rooms;

    public Hotel(String name, Room[] rooms){
        this.name = name;
        this.rooms = new Room[rooms.length];

        for(int i = 0; i < rooms.length; i++){
            this.rooms[i] = new Room(rooms[i]);
        }
    }

    public int reserveRoom(String type){
        for(Room element: rooms){
            if(element.getType() == type){
                element.changeAvailability();
                return element.getPrice();
            }
        }
        throw new IllegalArgumentException("No room of that type available.");
    }

    public boolean cancelRoom(String type){
        for(Room element: rooms){
            if(element.getType() == type){
                element.changeAvailability();
                return true;
            }
        }
        return false;
    }

}
