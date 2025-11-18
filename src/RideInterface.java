public interface RideInterface {
    
    // part3
    public void addVisitorToQueue(Visitor visitor);
    public void  removeVisitorFromQueue();
    public void  printQueue();

    // part4
    public void addVisitorToHistory(Visitor visitor);
    public boolean checkVisitorFromHistory(Visitor visitor);
    public int numberOfVisitors();
    public void printRideHistory();

    //part 5
    public void runOneCycle();
}
