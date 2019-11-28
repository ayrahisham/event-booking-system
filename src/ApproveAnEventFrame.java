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

class ApproveAnEventFrame extends JFrame implements ActionListener
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
   
    ApproveAnEventFrame (String user)
    {
        // Web title
        super ("UOW Approve An Event");
        
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
        banner1.setText ("APPROVE AN EVENT");
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
       
        name = MainFrame.staffArray[0].viewEventName();
        date = MainFrame.staffArray[0].viewEventDate();
        time = MainFrame.staffArray[0].viewEventTime();
        venue = MainFrame.staffArray[0].viewEventVenue();
        price = String.valueOf (MainFrame.staffArray[0].viewEventPrice());
        promo = MainFrame.staffArray[0].viewEventPromo();
        seats = String.valueOf (MainFrame.staffArray[0].viewEventSeats());
        
        eventname = new JTextField(name);
        eventname.setEditable(false);
        eventname.setFont(formfont2);     
        JLabel enamelabel = new JLabel ("Event Name:");
        enamelabel.setLabelFor(eventname);
        enamelabel.setFont (formfont);
        add (enamelabel);
        add (eventname);

        eventdate = new JTextField(date);
        eventdate.setEditable(false);
        eventdate.setFont(formfont2);
        JLabel edatelabel = new JLabel ("Event Date:(DD/MM/YYYY)");
        edatelabel.setLabelFor(eventdate);
        edatelabel.setFont (formfont);
        add (edatelabel);
        add (eventdate);
        
        String[] session = {time};
        eventtime = new JComboBox (session);
        eventtime.setEditable(false);
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
        
        String[] venue2 = {venue};
        eventvenue = new JComboBox (venue2);
        eventvenue.setEditable(false);
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
        eventcapacity.setEditable(false);
        eventcapacity.setFont(formfont2);
        JLabel eticketlabel = new JLabel ("No. Of Event Tickets:");
        eticketlabel.setLabelFor(eventcapacity);
        eticketlabel.setFont (formfont);
        add (eticketlabel);
        add (eventcapacity);
        
        eventprice = new JTextField(price);
        eventprice.setEditable(false);
        eventprice.setFont(formfont2);
        JLabel epricelabel = new JLabel ("Event Price: $");
        epricelabel.setLabelFor(eventprice);
        epricelabel.setFont (formfont);
        add (epricelabel);
        add (eventprice);
        
        eventpromo = new JTextField(promo);
        eventpromo.setEditable(false);
        eventpromo.setFont(formfont2);
        JLabel epromolabel = new JLabel ("Event Promo Code:");
        epromolabel.setLabelFor(eventpromo);
        epromolabel.setFont (formfont);
        add (epromolabel);
        add (eventpromo);
          
        backbutton = new JButton ("REJECT");
        backbutton.setFont (formfont2);
        backbutton.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                    
                MainFrame.staffArray[0].changeStatus("REJECT");

                JOptionPane.showMessageDialog(null , "You've rejected " + eventname.getText() + " event successfully",
                            "Event Rejected", JOptionPane.ERROR_MESSAGE);
                dispose ();
                AdminEventFrame aef = new AdminEventFrame (userID);
                aef.setVisible (true);
                aef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                aef.setSize (1200, 1000);
            }
        });
        add (backbutton);
        
        submitbutton = new JButton ("APPROVE");
        submitbutton.setFont (formfont2);     
        add (submitbutton);
        submitbutton.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                MainFrame.staffArray[0].changeStatus("APPROVED");
                
                if(MainFrame.staffArray[0].viewEventVenue().equals ("Seminar Room"))
                {
                    MainFrame.venueUseCounter_SR += 1;
            }
                else
                {
                    MainFrame.venueUseCounter_MPH += 1;
                }
                
                JOptionPane.showMessageDialog(null , "You've approved " + eventname.getText() + " event successfully",
                            "Event Approved", JOptionPane.INFORMATION_MESSAGE);
                dispose ();
                AdminEventFrame aef = new AdminEventFrame (userID);
                aef.setVisible (true);
                aef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                aef.setSize (1200, 1000);
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
