package lib.browser;

public class Bookmark {
    private int id;
    private int idUser;
    private String name;
    private Location location;

    public Bookmark(int id, int idUser, String name, Location location) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    
}
