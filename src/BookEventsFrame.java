import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Formatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class BookEventsFrame extends JFrame implements ActionListener
{
   private final JLabel footer;
   private final Font footerfont;
   private final JLabel banner1;
   private final JLabel banner2;
   private final JTextField eventname;
   private final JTextField eventdate;
   private final JComboBox eventtime;
   private final JComboBox eventvenue;
   private final JTextField eventtickets;
   private final JTextField eventprice;
   private final JTextField eventpromo;
   private final JButton submitbutton;
   private final JButton backbutton;
   public static Formatter output;
   public static String bookeventname;
   public static String bookeventdate;
   public static String bookeventtime;
   public static String bookeventvenue;
   public static double newprice;
   public static double bookeventprice;
   public String bookeventpromo;
   public static double studentprice;
   public static int noOfTickets;
   public static int seatCounter;
   public String userID;
   
    BookEventsFrame(String user)
    {
        // Web title
        super ("UOW Book An Event");
        
        this.userID = user;
        
        // Web grid
        GridLayout gl = new GridLayout (11, 11);
        setLayout (gl);
        
        // Web background color
        getContentPane().setBackground(new Color (250, 250, 250));
        
        // Web banner 1
        ImageIcon banner = new ImageIcon (getClass().getResource("banner.gif"));
        Image newbanner = banner.getImage(); // transform it 
        Image newb = newbanner.getScaledInstance(300, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        banner = new ImageIcon(newb);  // transform it back
        banner1 = new JLabel (banner);
        banner1.setText ("BOOK AN EVENT");
        banner1.setFont (new Font ("monospaced", Font.BOLD, 35));
        banner1.setForeground(Color.BLACK);
        add(banner1);
        
        // Web banner 2
        banner = new ImageIcon (getClass().getResource("banner2.jpg"));
        newbanner = banner.getImage(); // transform it 
        newb = newbanner.getScaledInstance(500, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        banner = new ImageIcon(newb);  // transform it back
        banner2 = new JLabel (banner);
        add(banner2);
        
        Font formfont = new Font ("times-new-roman", Font.BOLD, 20);
        Font formfont2 = new Font ("times-new-roman", Font.ITALIC, 15);
          
        bookeventname = MainFrame.staffArray[0].viewEventName();
        bookeventdate = MainFrame.staffArray[0].viewEventDate();
        bookeventtime = MainFrame.staffArray[0].viewEventTime();
        bookeventvenue = MainFrame.staffArray[0].viewEventVenue();
        bookeventprice = MainFrame.staffArray[0].viewEventPrice();
        bookeventpromo = MainFrame.staffArray[0].viewEventPromo();
        seatCounter = MainFrame.staffArray[0].viewSeatsLeft();
        
        eventname = new JTextField(bookeventname);
        eventname.setEditable(false);
        eventname.setFont(formfont2);     
        JLabel enamelabel = new JLabel ("Event Name:");
        enamelabel.setLabelFor(eventname);
        enamelabel.setFont (formfont);
        add (enamelabel);
        add (eventname);

        eventdate = new JTextField(bookeventdate);
        eventdate.setEditable(false);
        eventdate.setFont(formfont2);
        JLabel edatelabel = new JLabel ("Event Date:(DD/MM/YYYY)");
        edatelabel.setLabelFor(eventdate);
        edatelabel.setFont (formfont);
        add (edatelabel);
        add (eventdate);

        String[] session = {bookeventtime};
        eventtime = new JComboBox (session);
        eventtime.setEditable(false);
        eventtime.setFont(formfont2);
        JLabel etimelabel = new JLabel ("Event Time:");
        etimelabel.setLabelFor(eventtime);
        etimelabel.setFont (formfont);
        add (etimelabel);
        add (eventtime);

        String[] venue = {bookeventvenue};
        eventvenue = new JComboBox (venue);
        eventvenue.setEditable(false);
        eventvenue.setFont(formfont2);
        JLabel evenuelabel = new JLabel ("Event Venue:");
        evenuelabel.setLabelFor(eventvenue);
        evenuelabel.setFont (formfont);
        add (evenuelabel);
        add (eventvenue);

        eventtickets = new JTextField(2);
        eventtickets.setFont(formfont2);
        JLabel eticketlabel = new JLabel ("No. Of Event Tickets:");
        eticketlabel.setLabelFor(eventtickets);
        eticketlabel.setFont (formfont);
        add (eticketlabel);
        add (eventtickets);

        eventprice = new JTextField("$" + bookeventprice);
        eventprice.setEditable(false);
        eventprice.setFont(formfont2);
        JLabel epricelabel = new JLabel ("Event Price:");
        epricelabel.setLabelFor(eventprice);
        epricelabel.setFont (formfont);
        add (epricelabel);
        add (eventprice);

        eventpromo = new JTextField(10);
        eventpromo.setFont(formfont2);
        JLabel epromolabel = new JLabel ("Event Promo Code:");
        epromolabel.setLabelFor(eventpromo);
        epromolabel.setFont (formfont);
        add (epromolabel);
        add (eventpromo);
              
        backbutton = new JButton ("BACK");
        backbutton.setFont (formfont2);
        backbutton.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (userID.equals("Admin"))
                {
                    AdminEventFrame stef = new AdminEventFrame (userID);
                    stef.setVisible (true);
                    stef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    stef.setSize (1200, 1000);
                    dispose ();
                }
                else
                {
                    dispose ();
                    StudentEventFrame stef = new StudentEventFrame (userID);
                    stef.setVisible (true);
                    stef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    stef.setSize (1200, 1000);
                }
            }
        });
        add (backbutton);
        
        submitbutton = new JButton ("SUBMIT");
        submitbutton.setFont (formfont2);     
        add (submitbutton);
        submitbutton.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                boolean ticketsok = true;
                
                //Check if no of ticket(s) is/are valid
                if (eventtickets.getText ().equals (""))
                {
                    ticketsok = false;
                    JOptionPane.showMessageDialog(null , "Event tickets cannot be empty",
                        "Invalid No. Of Tickets", JOptionPane.ERROR_MESSAGE);
                }
                
                try
                {
                   Integer.parseInt(eventtickets.getText());
                }
                catch (NumberFormatException ex)
                {
                   ticketsok = false;
                   JOptionPane.showMessageDialog(null , "Event ticket(s) is/are invalid; must be (1-100)",
                    "Invalid No. Of Tickets", JOptionPane.ERROR_MESSAGE);
                }
                
                if (Integer.parseInt (eventtickets.getText ()) < 1 || 
                        Integer.parseInt (eventtickets.getText ()) > 100)
                {
                    ticketsok = false;
                    JOptionPane.showMessageDialog(null , "Event ticket(s) is/are invalid; must be (1-100)",
                    "Invalid No. Of Tickets", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    noOfTickets = Integer.valueOf (eventtickets.getText());
                }
                
                if (noOfTickets > seatCounter)
                {
                    ticketsok = false;
                    JOptionPane.showMessageDialog(null , "Event has only " + seatCounter 
                            + " ticket(s) left!",
                    "Insufficient No. Of Tickets Left", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    seatCounter = seatCounter - noOfTickets;
                }
                
                if (eventpromo.getText().equals (bookeventpromo))
                {
                    studentprice = (noOfTickets * bookeventprice)  - (noOfTickets * 1.5);
                }
                else
                {
                    studentprice = (noOfTickets * bookeventprice);
                }
                
                if (ticketsok == true)
                {    
                    studentObject student = new studentObject (MainFrame.staffArray[0].viewEventName(), 
                                                                MainFrame.staffArray[0].viewEventID(), 
                                                                MainFrame.staffArray[0].viewEventDate(), 
                                                                MainFrame.staffArray[0].viewEventTime(), 
                                                                MainFrame.staffArray[0].viewEventVenue(), 
                                                                noOfTickets, studentprice);
                    student.setUserID(userID);
                    MainFrame.eventsArray[MainFrame.eventsCounter] = student;
                    MainFrame.eventsCounter++;

                    MainFrame.staffArray[0].changeSeatsLeft(seatCounter);

                    JOptionPane.showMessageDialog(null , "You've successfully booked for " 
                        + MainFrame.staffArray[0].viewEventName() + "\n Please proceed to pay $" 
                        + studentprice, "Event booked", JOptionPane.INFORMATION_MESSAGE);
                    dispose ();

                    if (userID.equals("Admin"))
                    {
                        AdminEventFrame aef = new AdminEventFrame (userID);
                        aef.setVisible (true);
                        aef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                        aef.setSize (1200, 1000);
                    }
                    else
                    {
                        StudentEventFrame sef = new StudentEventFrame (userID);
                        sef.setVisible (true);
                        sef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                        sef.setSize (1200, 1000);
                    }
                }
                else
                {
                    BookEventsFrame bef = new BookEventsFrame(userID);
                    bef.setVisible (true);
                    bef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    bef.setSize (1500, 800);
                    dispose ();   
                }
            }
        });
    
        // Web footer
        footer = new JLabel ("Copyright 2017 - 2018. © University of Wollongong, Australia. All rights reserved.");
        footer.setHorizontalAlignment(JLabel.LEFT);
        footer.setVerticalAlignment(JLabel.BOTTOM);
        footerfont = new Font ("times-new-roman", Font.ITALIC, 15);
        footer.setFont (footerfont);       
        add(footer, BorderLayout.PAGE_END);
    }
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        
    }
    
}
