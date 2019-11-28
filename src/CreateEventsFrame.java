import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class CreateEventsFrame extends JFrame implements ActionListener
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
   private final JButton clearbutton;
   public static String selectedeventid;
   public static String selectedeventtime = "";
   public static String selectedeventvenue = "";
   public static String selectedeventprice;
   public static double newprice;
   public String userID;
   
    CreateEventsFrame (String user)
    {
        // Web title
        super ("UOW Create An Event");
        
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
        banner1.setText ("CREATE AN EVENT");
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
        
        eventname = new JTextField(20);
        eventname.setFont(formfont2);       
        eventname.addActionListener (this);
        JLabel enamelabel = new JLabel ("Event Name:");
        enamelabel.setLabelFor(eventname);
        enamelabel.setFont (formfont);
        add (enamelabel);
        add (eventname);

        eventdate = new JTextField(10);
        eventdate.setFont(formfont2);
        eventdate.addActionListener (this);
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
        eventvenue.setSelectedIndex(1);
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
        
        eventcapacity = new JTextField(2);
        eventcapacity.setFont(formfont2);
        eventcapacity.addActionListener (this);
        JLabel ecapacitylabel = new JLabel ("Event Capacity:");
        ecapacitylabel.setLabelFor(eventcapacity);
        ecapacitylabel.setFont (formfont);
        add (ecapacitylabel);
        add (eventcapacity);
        
        eventprice = new JTextField(10);
        eventprice.setFont(formfont2);
        eventprice.addActionListener (this);
        JLabel epricelabel = new JLabel ("Event Price: $");
        epricelabel.setLabelFor(eventprice);
        epricelabel.setFont (formfont);
        add (epricelabel);
        add (eventprice);
        
        eventpromo = new JTextField(10);
        eventpromo.setFont(formfont2);
        eventpromo.addActionListener (this);
        JLabel epromolabel = new JLabel ("Event Promo Code:");
        epromolabel.setLabelFor(eventpromo);
        epromolabel.setFont (formfont);
        add (epromolabel);
        add (eventpromo);
        
        
        
        clearbutton = new JButton ("CLEAR");
        clearbutton.setFont (formfont2);
        clearbutton.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getSource () == clearbutton)
                {
                    eventname.setText ("");
                    eventdate.setText ("");
                    eventcapacity.setText ("");
                    eventprice.setText ("");
                    eventpromo.setText ("");
                }
            }
        });
        add (clearbutton);
        
        submitbutton = new JButton ("CREATE");
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

                        if (h1 != '/' && h2 != '/')
                        {
                            dateok = false;
                            JOptionPane.showMessageDialog(null , "Event date is invalid",
                            "Invalid Date", JOptionPane.ERROR_MESSAGE);               
                        }

                        if ((y1 < 3 && y2 < 10 && y3 < 10 && y4 < 10 || 
                                y1 > 1 && y2 > -1 && y3 > 0 && y4 > 7))
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
                
                if (nameok == true && dateok == true && seatsok == true &&
                        venueok == true && timeok == true && priceok == true)
                {   
                        staffObject staff = new staffObject (eventname.getText(), eventdate.getText(),
                                selectedeventtime, selectedeventvenue, capacity, price, eventpromo.getText(), capacity);
                        staff.changeStatus("PENDING");
                        staff.setUserID(userID);
                        
                        MainFrame.staffArray[MainFrame.counter] = staff;
                        MainFrame.counter++;

                        JOptionPane.showMessageDialog(null , "You've created " + eventname.getText() + " event successfully",
                                "Event Created", JOptionPane.INFORMATION_MESSAGE);
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
                    CreateEventsFrame cef = new CreateEventsFrame(userID);
                    cef.setVisible (true);
                    cef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    cef.setSize (1500, 800);
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
