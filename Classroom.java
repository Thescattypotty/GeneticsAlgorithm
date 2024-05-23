public class Classroom {

    private final int roomId;
    private final String roomNumber;
    private final int capacity;

    private final String roomType;

    public Classroom(int roomId, String roomNumber, int capacity, String roomType) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.roomType = roomType;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomType() {
        return roomType;
    }

}
