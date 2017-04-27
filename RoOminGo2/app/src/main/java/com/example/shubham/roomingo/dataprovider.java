package com.example.shubham.roomingo;

/**
 * Created by Shubham on 11-04-2017.
 */
public class dataprovider {
    private String RoomName;
    private String ID;

    public dataprovider(String RoomName, String ID)
    {


        this.RoomName = RoomName;
        this.ID = ID;
    }

    public String getRoomName() {

        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
