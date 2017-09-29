/**
 * Created by Tamás Ferenc on 2017. 09. 28..
 */
public class TravelLocation {

    private String name;
    private TravelLocation previous;
    private TravelLocation slow;
    private TravelLocation fast;

    public TravelLocation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrevious(TravelLocation previous) {
        this.previous = previous;
    }

    public TravelLocation getPrevious() {
        return previous;
    }

    public boolean hasLoop() {
        slow = this;
        fast = this;
        while (fast != null && fast.getPrevious() != null) {
            slow = slow.getPrevious();
            fast = fast.getPrevious().getPrevious();

            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
