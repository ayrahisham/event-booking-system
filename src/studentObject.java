import java.io.Serializable;

class studentObject implements Serializable
{
    private String userID;
    private int eventid;
    private String eventname;
    private String eventdate;
    private String eventtime;
    private String eventvenue;
    private int eventtickets;
    private double eventpaid;
    private boolean checkBooked = true;
    
    studentObject()
    {
        //empty
    }
    
    studentObject(String name, int id, String date, String time, String venue, int tickets, double paid)
    {
        this.eventname = name;
        this.eventid = id;
        this.eventdate = date;
        this.eventtime = time;
        this.eventvenue = venue;
        this.eventtickets = tickets;
        this.eventpaid = paid;
    }
    
    public String viewUserID()
    {
        return userID;
    }
    
    public int viewEventID ()
    {
        return eventid;
    }
    
    public String viewEventName ()
    {
        return eventname;
    }
    
    
    public String viewEventDate()
    {
        return eventdate;
    }
    
    public String viewEventTime()
    {
        return eventtime;
    }
    
    public String viewEventVenue()
    {
        return eventvenue;
    }
    
    public int viewEventTickets()
    {
        return eventtickets;
    }
    
    public double viewEventPaid()
    {
        return eventpaid;
    }
    
    public void changeEventSeats (int seats)
    {
        this.eventtickets = seats;
    }
    
    public void changeEventPaid (double price)
    {
        this.eventpaid = price;
    }
    
    public void setUserID (String id)
    {
        this.userID = id;
    }
    
    public void changeCheckBooked()
    {
        this.checkBooked = false;
    }
    
    
    @Override
    public String toString ()
    {
        return String.format("%s\t%s\t%s\t%s\t%s\t%d\t%f",
                            userID,
                            eventname,
                            eventdate,
                            eventtime, 
                            eventvenue,
                            eventtickets,
                            eventpaid);
    }
}