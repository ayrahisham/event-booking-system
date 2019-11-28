class VenueUseObject 
{
    public String venue;
    public String date;
    public String userID;
    public String eventName;
          
    VenueUseObject(String venue, String date, String userID, String name)
    {
        this.venue = venue;
        this.date = date;
        this.userID = userID;
        this.eventName = name;
    }
    
    public String getEventName()
    {
        return eventName;
    }
    
    public String getVenue()
    {
        return venue;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getUserID()
    {
        return userID;
    }
    
    public void setVenue(String venue)
    {
        this.venue = venue;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public void setUserID(String userID)
    {
        this.userID = userID;
    }       
    
    public void setEventNaem(String eventName)
    {
        this.eventName = eventName;
    }
}

