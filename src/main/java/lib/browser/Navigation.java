package lib.browser;

import java.util.Stack;

public class Navigation {
    private Location current;
    private Stack<Location> backward = new Stack<>();
    private Stack<Location> forward = new Stack<>();

    public void current(Location location) {
        if (current != null) {
            backward.add(current);
        }
        current = location;
        forward = new Stack<>();
    }

    public void backward() {
        forward.add(current);
        current = backward.pop();
    }

    public void forward() {
        backward.add(current);
        current = forward.pop();
    }

    public boolean hasBackward() {
        return backward.size() > 0;
    }

    public boolean hasForward() {
        return forward.size() > 0;
    }

    public Location getLocation() {
        return current;
    }
}
