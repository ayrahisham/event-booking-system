import javax.swing.JFrame;

public class MainFrame {
    
    static staffObject staffArray[];
    static int counter = 0;
    static studentObject eventsArray[];
    static int eventsCounter = 0;
    static int venueUseCounter_SR = 0;
    static int venueUseCounter_MPH = 0;
   
    public static void main(String [] args)
    {
        staffArray = new staffObject[3]; 
        eventsArray = new studentObject[4];
        
       
        /*
        staffObject staff = new staffObject ("DEFAULT EVENT", "10/10/2018", "9AM - 5PM", "Hall", 50, 5.0, "ASD", 50);
        staff.setEventMonth("Octber");
        staff.changeStatus("APPROVED");
        staffArray[0] = staff;
        staffArray[1] = staff;
        staffArray[2] = staff;
       
        studentObject s1 = new studentObject (MainFrame.staffArray[0].viewEventName(), 
                                                            MainFrame.staffArray[0].viewEventID(), 
                                                            MainFrame.staffArray[0].viewEventDate(), 
                                                            MainFrame.staffArray[0].viewEventTime(), 
                                                            MainFrame.staffArray[0].viewEventVenue(), 
                                                            10, 5.0);
        s1.setUserID("Admin");
        eventsArray[0] = s1;
*/
        
                       
        LoginFrame slf = new LoginFrame ();
        slf.setVisible (true);
        slf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        slf.setSize (800, 800);
    }
    
}
