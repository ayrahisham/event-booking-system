import java.io.Serializable;

class staffObject implements Serializable
{
    private final int eventID;
    private String eventname;
    private String eventdate;
    private final String eventtime;
    private final String eventvenue;
    private int eventcapacity;
    private double eventprice;
    private String eventpromo;
    private String eventstatus;
    public static int eventno = 0;
    private int seatcounter;
    private String month;
    public String userID;
    
    
    staffObject(String name, String date, String time, String venue, int seats, double price, String promo, int seatleft)
    {
        ++eventno;
        this.eventID = eventno;
        this.eventname = name;
        this.eventdate = date;
        this.eventtime = time;
        this.eventvenue = venue;
        this.eventcapacity = seats;
        this.eventprice = price;
        this.eventpromo = promo;
        this.seatcounter = seatleft;
    }
    
    public int viewEventID()
    {
        return eventID;
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
    
    public int viewEventSeats()
    {
        return eventcapacity;
    }
    
    public double viewEventPrice()
    {
        return eventprice;
    }
        
    public String viewEventPromo()
    {
        return eventpromo;
    }
    
    public int viewSeatsLeft ()
    {
        return seatcounter;
    }
    
    public String viewEventStatus ()
    {
        return eventstatus;
    }
    
    public int viewEventNo()
    {
        return eventno;
    }
    
    public String viewUserID()
    {
        return userID;
    }
    
    public void setUserID (String userID)
    {
        this.userID = userID;
    }
    
    public void changeEventName (String name)
    {
        this.eventname = name;
    }
    
    public void changeEventDate(String date)
    {
        this.eventdate = date;
    }
    
    public void changeEventSeats (int seats)
    {
        this.eventcapacity = seats;
    }
    
    public void changeEventPrice(double price)
    {
        this.eventprice = price;
    }
    
    public void changePromo(String promo)
    {
        this.eventpromo = promo;
    }
    
    public void changeSeatsLeft (int seatleft)
    {
        this.seatcounter = seatleft;
    }
    
    public void changeStatus (String status)
    {
        this.eventstatus = status;
    }
    
    public void setEventMonth(String month)
    {
        this.month = month;
    }
    
    public String viewEventMonth()
    {
        return month;
    }
    
    public void increaseSeats(int x)
    {
        this.seatcounter += x;
    }
    
    @Override
    public String toString ()
    {
        return String.format("%d\t%s\t%s\t%s\t%s\t%d\t%f\t%s\t%d\t%s", 
                            eventID,
                            eventname,
                            eventdate,
                            eventtime, 
                            eventvenue,
                            eventcapacity,
                            eventprice,
                            eventpromo,
                            seatcounter,
                            eventstatus);
    }
}
