package lib.browser;

import java.util.Iterator;
import java.util.LinkedList;

public class History implements Iterable {
    private LinkedList<Location> locations = new LinkedList<>();
    
    public void add(Location location) {
        locations.add(location);
    }

    @Override
    public Iterator iterator() {
        return locations.iterator();
    }
}
