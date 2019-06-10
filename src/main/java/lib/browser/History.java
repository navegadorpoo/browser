package lib.browser;

public class History {
    private int id;
    private int idUser;
    private Location location;

    public History(int id, int idUser, Location location) {
        this.id = id;
        this.idUser = idUser;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
