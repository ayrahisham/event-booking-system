import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class VenueEventsFrame extends JFrame implements ActionListener
{  
   private final JLabel banner1;
   private final JLabel banner2;
   private final JLabel footer;
   private final Font menufont;
   private final Font submenufont;
   private final Font footerfont;
   private final JMenuBar menubar;
   private final JMenu menu1;
   private final JMenu menu2;
   private final JMenu menu3;
   private final JMenu menu4;
   private final JMenu menu5;
   private final JMenuItem menu2Item1;
   private final JMenuItem menu2Item2;
   private final JMenuItem menu2Item3;
   private final JMenuItem menu2Item4;
   private final JMenuItem menu2Item5;
   private final JTextField searchbar;
   public String userID;
   
   VenueEventsFrame (String user)
   {
       // Web title
        super ("UOW Admin Event Management System");
        
        this.userID = user;
        
        // Web grid
        GridLayout gl = new GridLayout (7, 7);
        setLayout (gl);
        
        // Web background color
        getContentPane().setBackground(new Color (250, 250, 250));
        
        // Web banner 1
        ImageIcon banner = new ImageIcon (getClass().getResource("banner.gif"));
        Image newbanner = banner.getImage(); // transform it 
        Image newb = newbanner.getScaledInstance(400, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        banner = new ImageIcon(newb);  // transform it back
        banner1 = new JLabel (banner);
        add(banner1);
        
        // Web banner 2
        banner = new ImageIcon (getClass().getResource("banner3.jpg"));
        newbanner = banner.getImage(); // transform it 
        newb = newbanner.getScaledInstance(500, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        banner = new ImageIcon(newb);  // transform it back
        banner2 = new JLabel (banner);
        banner2.setText("EVENT MANAGEMENT SYSTEM");
        banner2.setFont (new Font ("monospaced", Font.BOLD, 35));
        banner2.setHorizontalTextPosition (0);
        banner2.setHorizontalAlignment (JLabel.CENTER);
        banner2.setForeground(Color.BLACK);
        add(banner2);
        
        // Web menubar
        menubar = new JMenuBar ();
        menubar.setBackground (Color.DARK_GRAY);
        menufont = new Font ("comic-sans", Font.BOLD, 18);
        add(menubar);
        
        // Web 1st menu
        menu1 = new JMenu ("HOME");
        menu1.setForeground (Color.WHITE);
        menu1.setFont (menufont);
        menu1.setMnemonic(KeyEvent.VK_F);
        menu1.getAccessibleContext().setAccessibleDescription("Back to Homepage");
        menubar.add (menu1);
        
        submenufont = new Font ("comic-sans", Font.BOLD, 20);
        
        ImageIcon homeicon = new ImageIcon (getClass().getResource("home.png"));
        Image newhomeicon = homeicon.getImage(); // transform it 
        Image newh = newhomeicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        homeicon = new ImageIcon(newh);  // transform it back
        JMenuItem home = new JMenuItem("Back to Homepage", homeicon);
        home.setFont (submenufont);
        home.setMnemonic(KeyEvent.VK_F);
        home.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    AdminEventFrame aef = new AdminEventFrame (userID);
                    aef.setVisible (true);
                    aef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    aef.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu1.add(home);
        
        // Web 2nd menu
        menu2 = new JMenu ("FIND AN EVENT");
        menu2.setForeground (Color.WHITE);
        menu2.setFont (menufont);
        menu2.setMnemonic(KeyEvent.VK_F);
        menu2.getAccessibleContext().setAccessibleDescription("Search for An Event");
        menubar.add (menu2);
        
        // create menu 2 item 1 and add it to the menu 2
        ImageIcon comedyicon = new ImageIcon (getClass().getResource("comedy.png"));
        Image newcomedyicon = comedyicon.getImage(); // transform it 
        Image newc1 = newcomedyicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        comedyicon = new ImageIcon(newc1);  // transform it back
        menu2Item1 = new JMenuItem("Comedy", comedyicon);
        menu2Item1.setFont (submenufont);
        menu2Item1.setMnemonic(KeyEvent.VK_F);
        menu2.add(menu2Item1);
        
        // create menu 2 item 2 and add it to the menu 2
        ImageIcon concerticon = new ImageIcon (getClass().getResource("concert.png"));
        Image newconcerticon = concerticon.getImage(); // transform it 
        Image newc2 = newconcerticon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        concerticon = new ImageIcon(newc2);  // transform it back
        menu2Item2 = new JMenuItem("Concert", concerticon);
        menu2Item2.setFont (submenufont);
        menu2Item2.setMnemonic(KeyEvent.VK_F);
        menu2.add(menu2Item2);
        
        // create menu 2 item 3 and add it to the menu 2
        ImageIcon danceicon = new ImageIcon (getClass().getResource("dance.jpg"));
        Image newdanceicon = danceicon.getImage(); // transform it 
        Image newd = newdanceicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        danceicon = new ImageIcon(newd);  // transform it back
        menu2Item3 = new JMenuItem("Dance", danceicon);
        menu2Item3.setFont (submenufont);
        menu2Item3.setMnemonic(KeyEvent.VK_F);
        menu2.add(menu2Item3);
        
         // create menu 2 item 4 and add it to the menu 2
        ImageIcon seminaricon = new ImageIcon (getClass().getResource("seminar.png"));
        Image newseminaricon = seminaricon.getImage(); // transform it 
        Image news1 = newseminaricon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        seminaricon = new ImageIcon(news1);  // transform it back
        menu2Item4 = new JMenuItem("Seminar/Workshops", seminaricon);
        menu2Item4.setFont (submenufont);
        menu2Item4.setMnemonic(KeyEvent.VK_F);
        menu2.add(menu2Item4);
        
        // create menu 2 item 5 and add it to the menu 2
        ImageIcon sportsicon = new ImageIcon (getClass().getResource("sports.png"));
        Image newsportsicon = sportsicon.getImage(); // transform it 
        Image news2 = newsportsicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        sportsicon = new ImageIcon(news2);  // transform it back
        menu2Item5 = new JMenuItem("Sports", sportsicon);
        menu2Item5.setFont (submenufont);
        menu2Item5.setMnemonic(KeyEvent.VK_F);
        menu2.add(menu2Item5);
        
        // Web 3rd menu
        menu3 = new JMenu ("MANAGE");
        menu3.setForeground (Color.WHITE);
        menu3.setFont (menufont);
        menu3.setMnemonic(KeyEvent.VK_F);
        menu3.getAccessibleContext().setAccessibleDescription("Manage Events");
        menubar.add (menu3);
        
        ImageIcon requesticon = new ImageIcon (getClass().getResource("request.png"));
        Image newrequesticon = requesticon.getImage(); // transform it 
        Image newreq = newrequesticon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        requesticon = new ImageIcon(newreq);  // transform it back
        JMenuItem request = new JMenuItem("Pending Requests", requesticon);
        request.setFont (submenufont);
        request.setMnemonic(KeyEvent.VK_F);
        request.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    ProcessEventsFrame aef = new ProcessEventsFrame (userID);
                    aef.setVisible (true);
                    aef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    aef.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu3.add(request);
        
        ImageIcon approveicon = new ImageIcon (getClass().getResource("approve.png"));
        Image newapproveicon = approveicon.getImage(); // transform it 
        Image newapp = newapproveicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        approveicon = new ImageIcon(newapp);  // transform it back
        JMenuItem approve = new JMenuItem("Approved Requests", approveicon);
        approve.setFont (submenufont);
        approve.setMnemonic(KeyEvent.VK_F);
        approve.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    ApproveEventsFrame aef = new ApproveEventsFrame (userID);
                    aef.setVisible (true);
                    aef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    aef.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu3.add(approve);
        
        ImageIcon updateicon = new ImageIcon (getClass().getResource("update.png"));
        Image newupdateicon = updateicon.getImage(); // transform it 
        Image newup = newupdateicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        updateicon = new ImageIcon(newup);  // transform it back
        JMenuItem update = new JMenuItem("Update Events", updateicon);
        update.setFont (submenufont);
        update.setMnemonic(KeyEvent.VK_F);
        update.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    UpdateEventsFrame uef = new UpdateEventsFrame (userID);
                    uef.setVisible (true);
                    uef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    uef.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu3.add(update);
        
        ImageIcon deleteicon = new ImageIcon (getClass().getResource("delete.png"));
        Image newdeleteicon = deleteicon.getImage(); // transform it 
        Image newdel = newdeleteicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        deleteicon = new ImageIcon(newdel);  // transform it back
        JMenuItem delete = new JMenuItem("Delete Events", deleteicon);
        delete.setFont (submenufont);
        delete.setMnemonic(KeyEvent.VK_F);
        delete.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    DeleteEventsFrame def = new DeleteEventsFrame (userID);
                    def.setVisible (true);
                    def.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    def.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu3.add(delete);
        
        ImageIcon bookicon = new ImageIcon (getClass().getResource("book.png"));
        Image newbookicon = bookicon.getImage(); // transform it 
        Image newbook = newbookicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        bookicon = new ImageIcon(newbook);  // transform it back
        JMenuItem book = new JMenuItem("Book Events", bookicon);
        book.setFont (submenufont);
        book.setMnemonic(KeyEvent.VK_F);
        book.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    BookingFrame bf = new BookingFrame (userID);
                    bf.setVisible (true);
                    bf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    bf.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu3.add(book);
        
        ImageIcon updateicon2 = new ImageIcon (getClass().getResource("update.png"));
        Image newupdateicon2 = updateicon2.getImage(); // transform it 
        Image newup2 = newupdateicon2.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        updateicon2 = new ImageIcon(newup2);  // transform it back
        JMenuItem update2 = new JMenuItem("Edit Bookings", updateicon2);
        update2.setFont (submenufont);
        update2.setMnemonic(KeyEvent.VK_F);
        update2.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    EditBookingFrame ebf = new EditBookingFrame (userID);
                    ebf.setVisible (true);
                    ebf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    ebf.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu3.add(update2);
        
        ImageIcon deleteicon2 = new ImageIcon (getClass().getResource("delete.png"));
        Image newdeleteicon2 = deleteicon2.getImage(); // transform it 
        Image newdel2 = newdeleteicon2.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        deleteicon2 = new ImageIcon(newdel2);  // transform it back
        JMenuItem delete2 = new JMenuItem("Cancel Bookings", deleteicon2);
        delete2.setFont (submenufont);
        delete2.setMnemonic(KeyEvent.VK_F);
        delete2.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    CancelBookingFrame cbf = new CancelBookingFrame (userID);
                    cbf.setVisible (true);
                    cbf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    cbf.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu3.add(delete2);
        
        // Web 5th menu
        menu5 = new JMenu ("STATISTICS");
        menu5.setForeground (Color.WHITE);
        menu5.setFont (menufont);
        menu5.setMnemonic(KeyEvent.VK_F);
        menu5.getAccessibleContext().setAccessibleDescription("View Historical Statistics");
        menubar.add (menu5);
        
        ImageIcon venueicon = new ImageIcon (getClass().getResource("venue.png"));
        Image newvenueicon = venueicon.getImage(); // transform it 
        Image newven = newvenueicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        venueicon = new ImageIcon(newven);  // transform it back
        JMenuItem venue = new JMenuItem("Venue Usage", venueicon);
        venue.setFont (submenufont);
        venue.setMnemonic(KeyEvent.VK_F);
        venue.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    VenueEventsFrame vef = new VenueEventsFrame (userID);
                    vef.setVisible (true);
                    vef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    vef.setSize (1200, 1000);
                    dispose ();
            }
        });
        menu5.add(venue);
        
        // Add some glue so subsequent menus are pushed to the right
        menubar.add(Box.createHorizontalGlue());
        
        // Web search menu bar
        searchbar = new JTextField ("SEARCH...", 10);
        searchbar.setMaximumSize (searchbar.getPreferredSize());
        menubar.add (searchbar);
        
        // Web 4th menu
        menu4 = new JMenu ("ACCOUNT");
        menu4.setForeground (Color.WHITE);
        menu4.setFont (menufont);
        menu4.setMnemonic(KeyEvent.VK_F);
        menu4.getAccessibleContext().setAccessibleDescription("Manage Account");
        menubar.add (menu4);
        
        ImageIcon logouticon = new ImageIcon (getClass().getResource("logout.png"));
        Image newlogouticon = logouticon.getImage(); // transform it 
        Image newlg1 = newlogouticon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        logouticon = new ImageIcon(newlg1);  // transform it back
        JMenuItem logout = new JMenuItem("Logout", logouticon);
        logout.setFont (submenufont);
        logout.setMnemonic(KeyEvent.VK_F);
        logout.addActionListener (new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                    LoginFrame slf = new LoginFrame ();
                    slf.setVisible (true);
                    slf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    slf.setSize (800, 800);
                    dispose ();
            }
        });
        menu4.add(logout);
        

        Font tablefont = new Font("Serif", Font.ITALIC, 16);
        Font tableheader = new Font ("SansSerif", Font.BOLD, 12);
         
        DefaultTableModel dm3 = new DefaultTableModel();
        dm3.setDataVector(new Object[][]{ 
                                        {"VENUE NAME: ", "SEMINAR ROOM"},
                                        {"VENUE USAGE: ", MainFrame.venueUseCounter_SR},
                                        {"VENUE USAGE PERIOD: ", "5/11/2018 - 11/11/2018"},
                                        },
                          new Object [] {"INFORMATION", "INFORMATION"}
                           );                       
        JTable table3 = new JTable(dm3);
        table3.setFont(tablefont);
        table3.getTableHeader().setFont (tableheader);
        table3.setShowGrid(false);
        table3.setIntercellSpacing(new Dimension(1, 1));
        table3.setEnabled(false);
        table3.setPreferredSize(new Dimension (500, 400));

        JScrollPane scrollPane3 = new JScrollPane(table3);
        JPanel panel3 = new JPanel();
        panel3.add(scrollPane3);
        getContentPane().add(panel3);

        DefaultTableModel dm4 = new DefaultTableModel();
        dm4.setDataVector(new Object[][]{ 
                                        {"VENUE NAME: ", "MULTI-PURPOSE ROOM"},
                                        {"VENUE USAGE: ", MainFrame.venueUseCounter_MPH},
                                        {"VENUE USAGE PERIOD: ", "5/11/2018 - 11/11/2018"},
                                        },
                          new Object [] {"INFORMATION", "INFORMATION"}
                           );                       
        JTable table4 = new JTable(dm4);
        table4.setFont(tablefont);
        table4.getTableHeader().setFont (tableheader);
        table4.setShowGrid(false);
        table4.setIntercellSpacing(new Dimension(1, 1));
        table4.setEnabled(false);
        table4.setPreferredSize(new Dimension (500, 400));

        JScrollPane scrollPane4 = new JScrollPane(table4);
        JPanel panel4 = new JPanel();
        panel4.add(scrollPane4);
        getContentPane().add(panel4);   

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