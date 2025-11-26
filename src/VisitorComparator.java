
import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
     @Override
    public int compare(Visitor visitor1, Visitor visitor2) {
        //compare by visitorID 
        int idComparison = visitor1.getVisitorID().compareTo(visitor2.getVisitorID());
        if (idComparison != 0) {
            return idComparison;
        }

        // if visitorID is the same, compare by height
        return Integer.compare(visitor1.getHeight(), visitor2.getHeight());
    }
}