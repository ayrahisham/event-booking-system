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

class UpdateAnEventFrame extends JFrame implements ActionListener
{
   private final JLabel footer;
   private final Font footerfont;
   private final JLabel banner1;
   private final JLabel banner2;
   private final JTextField eventname;
   private final JTextField eventdate;
   private final JComboBox eventtime;
   private final JComboBox eventvenue;
   private final JTextField eventcapacity;
   private final JTextField eventprice;
   private final JTextField eventpromo;
   private final JButton submitbutton;
   private final JButton backbutton;
   public static Formatter output;
   public static String selectedeventtime;
   public static String selectedeventvenue;
   public static String name;
   public static String date;
   public static String time;
   public static String venue;
   public static String price;
   public static String promo;
   public static String seats;
   public String userID;
   public int eventIndex;
   
    UpdateAnEventFrame (String user, int index)
    {
        // Web title
        super ("UOW Update An Event");
        
        this.userID = user;
        this.eventIndex = index;
        
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
        banner1.setText ("UPDATE AN EVENT");
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
       
        staffObject staff = MainFrame.staffArray[eventIndex];
        name = staff.viewEventName();
        date = staff.viewEventDate();
        price = String.valueOf (staff.viewEventPrice());
        promo = staff.viewEventPromo();
        seats = String.valueOf (staff.viewEventSeats());
        
        
        eventname = new JTextField(name);
        eventname.setFont(formfont2);     
        JLabel enamelabel = new JLabel ("Event Name:");
        enamelabel.setLabelFor(eventname);
        enamelabel.setFont (formfont);
        add (enamelabel);
        add (eventname);

        eventdate = new JTextField(date);
        eventdate.setFont(formfont2);
        JLabel edatelabel = new JLabel ("Event Date:(DD/MM/YYYY)");
        edatelabel.setLabelFor(eventdate);
        edatelabel.setFont (formfont);
        add (edatelabel);
        add (eventdate);
        
        String[] session = {"9AM - 5PM"};
        eventtime = new JComboBox (session);
        eventtime.setFont(formfont2);
        eventtime.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JComboBox cb = (JComboBox) e.getSource ();
                selectedeventtime = (String) cb.getSelectedItem ();
            }
        });
        
        JLabel etimelabel = new JLabel ("Event Time:");
        etimelabel.setLabelFor(eventtime);
        etimelabel.setFont (formfont);
        add (etimelabel);
        add (eventtime);
        
        String[] venue = {"Seminar Room", "Multi-Purpose Hall"};
        eventvenue = new JComboBox (venue);
        eventvenue.setFont(formfont2);
        eventvenue.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JComboBox cb = (JComboBox) e.getSource ();
                selectedeventvenue = (String) cb.getSelectedItem ();
            }
        });
        JLabel evenuelabel = new JLabel ("Event Venue:");
        evenuelabel.setLabelFor(eventvenue);
        evenuelabel.setFont (formfont);
        add (evenuelabel);
        add (eventvenue);
        
        eventcapacity = new JTextField(seats);
        eventcapacity.setFont(formfont2);
        JLabel eticketlabel = new JLabel ("No. Of Event Tickets:");
        eticketlabel.setLabelFor(eventcapacity);
        eticketlabel.setFont (formfont);
        add (eticketlabel);
        add (eventcapacity);
        
        eventprice = new JTextField(price);
        eventprice.setFont(formfont2);
        JLabel epricelabel = new JLabel ("Event Price: $");
        epricelabel.setLabelFor(eventprice);
        epricelabel.setFont (formfont);
        add (epricelabel);
        add (eventprice);
        
        eventpromo = new JTextField(promo);
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
                    StaffEventFrame stef = new StaffEventFrame (userID);
                    stef.setVisible (true);
                    stef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    stef.setSize (1200, 1000);
                    dispose ();
                }
            }
        });
        add (backbutton);
        
        submitbutton = new JButton ("UPDATE");
        submitbutton.setFont (formfont2);     
        add (submitbutton);
        submitbutton.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                boolean nameok = true;
                boolean dateok = true;
                boolean timeok = true;
                boolean venueok = true;
                boolean seatsok = true;
                boolean priceok = true;
                double price = 0;
                int capacity = 0;
                
                // Check for valid event names
                char [] symbol = new char[30];
                symbol[0] = '!';
                symbol[1] = '@';
                symbol[2] = '#';
                symbol[3] = '%';
                symbol[4] = '^';
                symbol[5] = '&';
                symbol[6] = '*';
                symbol[7] = '(';
                symbol[8] = ')';
                symbol[9] = '-';
                symbol[10] = '_';
                symbol[11] = '+';
                symbol[12] = '=';
                symbol[13] = '[';
                symbol[14] = '{';
                symbol[15] = '}';
                symbol[16] = ']';
                symbol[17] = ';';
                symbol[18] = ':';
                symbol[19] = '"';
                symbol[20] = ',';
                symbol[21] = '<';
                symbol[22] = '>';
                symbol[23] = '.';
                symbol[24] = '/';
                symbol[25] = '?';
                symbol[26] = '\\';
                symbol[27] = '|';
                symbol[28] = '~';
                symbol[29] = '`';
                int counter = 0;
                char [] eventName = eventname.getText().toCharArray();
             
                for (int j = 0; j < eventname.getText().length(); j++)
                {
                    for (int i = 0; i < 30; i++)
                    {
                        if (eventName[j] == symbol[i])
                        {
                            ++counter;
                            JOptionPane.showMessageDialog(null , "Do not insert symbols in " + eventname.getText(),
                        "Invalid Name", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                
                if (counter > 0)
                {
                    nameok = false;
                }
                
                if (eventname.getText ().equals (""))
                {
                    nameok = false;
                    JOptionPane.showMessageDialog(null , "Please give a name to the event",
                        "Invalid Name", JOptionPane.ERROR_MESSAGE);
                }
                
                //Check for valid dates
                if (eventdate.getText ().equals (""))
                {
                    dateok = false;
                    JOptionPane.showMessageDialog(null , "Please give a date to the event",
                        "Invalid Date", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                
                    char [] eventDate = eventdate.getText().toCharArray();
                    if (eventDate.length > 10 || eventDate.length < 10)
                    {
                        dateok = false;
                    JOptionPane.showMessageDialog(null , "Event date is invalid",
                        "Invalid Date", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        int d1 = eventDate[0] - '0';
                        int d2 = eventDate[1] - '0';
                        char h1 = eventDate[2];
                        int m1 = eventDate[3] - '0';
                        int m2 = eventDate[4] - '0';
                        char h2 = eventDate[5];
                        int y1 = eventDate[6] - '0';
                        int y2 = eventDate[7] - '0';
                        int y3 = eventDate[8] - '0';
                        int y4 = eventDate[9] - '0';

                        if (h1 != '/' || h2 != '/')
                        {
                            dateok = false;
                            JOptionPane.showMessageDialog(null , "Event date is invalid",
                            "Invalid Date", JOptionPane.ERROR_MESSAGE);              
                        }

                        if ((y1 < 3 && y2 < 10 && y3 < 10 && y3 > 0 && y4 < 10 && y4 > 7))
                        {
                            if((m1 < 2 && m2 < 3) || (m1 < 1 && m2 < 10))
                            {
                                dateok = true;
                            }
                            else
                            {
                                dateok = false;
                                JOptionPane.showMessageDialog(null , "Event date is invalid",
                                "Invalid Date", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            dateok = false;
                            JOptionPane.showMessageDialog(null , "Event date is invalid",
                            "Invalid Date", JOptionPane.ERROR_MESSAGE);
                            UpdateAnEventFrame uef = new UpdateAnEventFrame(userID, eventIndex);
                            uef.setVisible (true);
                            uef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                            uef.setSize (1500, 800);
                            dispose ();
                        }
                    }
                }
                
                // Check for valid event capacity
                if (eventcapacity.getText ().equals (""))
                {
                    seatsok = false;
                    JOptionPane.showMessageDialog(null , "Event capacity cannot be empty",
                        "Invalid Capacity", JOptionPane.ERROR_MESSAGE);
                }
                
                try
                {
                   capacity = Integer.parseInt(eventcapacity.getText());
                }
                catch (NumberFormatException ex)
                {
                    seatsok = false;
                    JOptionPane.showMessageDialog(null , "Event capacity is invalid; must be (1-100)",
                    "Invalid Capacity", JOptionPane.ERROR_MESSAGE);
                }
                
                if (capacity < 1 || capacity > 100)
                {
                    seatsok = false;
                    JOptionPane.showMessageDialog(null , "Event capacity is invalid; must be (1-100)",
                    "Invalid Capacity", JOptionPane.ERROR_MESSAGE);
                }
                
                // Check for valid event price
                if (eventprice.getText ().equals (""))
                {
                    price = 0.00;
                }
                else
                {
                    try
                    {
                        price = Double.parseDouble(eventprice.getText ()); 
                    }
                    catch (NumberFormatException ex)
                    {
                        priceok = false;
                        JOptionPane.showMessageDialog(null , "Event price is invalid; must be numeric",
                        "Invalid Price", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                // Check for valid event promo
                if (eventpromo.getText ().equals (""))
                {
                    eventpromo.setText("null");
                }
               /* 
               if (selectedeventtime.equals (""))
                {
                    timeok = false;
                    JOptionPane.showMessageDialog(null , "Event time cannot be empty",
                        "Invalid Time", JOptionPane.ERROR_MESSAGE);
                }
                
                if (selectedeventvenue.equals (""))
                {
                    venueok = false;
                    JOptionPane.showMessageDialog(null , "Event venue cannot be empty",
                        "Invalid Venue", JOptionPane.ERROR_MESSAGE);
                }
                */
               if (nameok == true && dateok == true && seatsok == true &&
                        venueok == true && timeok == true && priceok == true)
                {   
                    staffObject staff = new staffObject (eventname.getText(), eventdate.getText(),
                selectedeventtime, selectedeventvenue, capacity, price, eventpromo.getText(), capacity);
                    
                    staff.changeStatus("PENDING");
                    MainFrame.staffArray[eventIndex] = staff;
                    
                    JOptionPane.showMessageDialog(null , "You've updated " + eventname.getText() + " event successfully",
                        "Event Updated", JOptionPane.INFORMATION_MESSAGE);
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
                        StaffEventFrame sef = new StaffEventFrame (userID);
                        sef.setVisible (true);
                        sef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                        sef.setSize (1200, 1000);
                    }
                }
               else
                {
                    UpdateAnEventFrame uef = new UpdateAnEventFrame(userID, eventIndex);
                    uef.setVisible (true);
                    uef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    uef.setSize (1500, 800);
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
