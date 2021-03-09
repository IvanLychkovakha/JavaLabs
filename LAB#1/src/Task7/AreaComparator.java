package Task7;

import java.util.Comparator;

public class  AreaComparator implements Comparator<Triangle> {
    public int compare(Triangle h1, Triangle h2) {
        if (h1.getS() == h2.getS()) {
            return 0;
        }
        if (h1.getS() < h2.getS()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}