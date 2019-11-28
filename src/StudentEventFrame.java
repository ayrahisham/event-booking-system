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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

class StudentEventFrame extends JFrame implements ActionListener
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
   private final JMenuItem menu2Item1;
   private final JMenuItem menu2Item2;
   private final JMenuItem menu2Item3;
   private final JMenuItem menu2Item4;
   private final JMenuItem menu2Item5;
   private final JTextField searchbar;
   public static int id;
   public static String eventname;
   public static boolean event1ok = false;
   public static boolean event2ok = false;
   public static boolean event3ok = false;
   public String userID;
   
   StudentEventFrame (String user)
   {
       // Web title
        super ("UOW Student Event Booking System");
        
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
        banner2.setText("EVENT BOOKING SYSTEM");
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
        
        // Web 2nd menu
        menu2 = new JMenu ("FIND AN EVENT");
        menu2.setForeground (Color.WHITE);
        menu2.setFont (menufont);
        menu2.setMnemonic(KeyEvent.VK_F);
        menu2.getAccessibleContext().setAccessibleDescription("Search for An Event");
        menubar.add (menu2);
        
        submenufont = new Font ("comic-sans", Font.BOLD, 20);
        
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
        menu3.getAccessibleContext().setAccessibleDescription("Manage Bookings");
        menubar.add (menu3);
        
        ImageIcon bookicon = new ImageIcon (getClass().getResource("book.png"));
        Image newbookicon = bookicon.getImage(); // transform it 
        Image newbook = newbookicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        bookicon = new ImageIcon(newbook);  // transform it back
        JMenuItem book = new JMenuItem("Book", bookicon);
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
        
        ImageIcon updateicon = new ImageIcon (getClass().getResource("update.png"));
        Image newupdateicon = updateicon.getImage(); // transform it 
        Image newup = newupdateicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        updateicon = new ImageIcon(newup);  // transform it back
        JMenuItem update = new JMenuItem("Edit", updateicon);
        update.setFont (submenufont);
        update.setMnemonic(KeyEvent.VK_F);
        update.addActionListener (new ActionListener() 
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
        menu3.add(update);
        
        ImageIcon deleteicon = new ImageIcon (getClass().getResource("delete.png"));
        Image newdeleteicon = deleteicon.getImage(); // transform it 
        Image newdel = newdeleteicon.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        deleteicon = new ImageIcon(newdel);  // transform it back
        JMenuItem delete = new JMenuItem("Cancel", deleteicon);
        delete.setFont (submenufont);
        delete.setMnemonic(KeyEvent.VK_F);
        delete.addActionListener (new ActionListener() 
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
        menu3.add(delete);
        
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
        menu4.getAccessibleContext().setAccessibleDescription("Log Out of Account");
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
        
        ImageIcon p1 = new ImageIcon (getClass().getResource("promo.jpg"));
        JButton promo = new JButton ();
        promo.setIcon (p1);
        promo.setHorizontalAlignment (SwingConstants.CENTER);
        add (promo);
        
        Font tablefont = new Font("Serif", Font.ITALIC, 14);
        Font tableheader = new Font ("SansSerif", Font.BOLD, 12);
        
        
        staffObject defa = new staffObject("NO EVENTS", "NO EVENTS","NO EVENTS","NO EVENTS", 0, 0, "NO EVENTS", 1);
            
        if (MainFrame.staffArray[0] != null && MainFrame.staffArray[0].viewEventStatus().equals ("APPROVED"))
        {
            ImageIcon event1 = new ImageIcon (getClass().getResource("event1.jpg"));
            Image newevent1 = event1.getImage(); // transform it 
            Image newe1 = newevent1.getScaledInstance(400, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            event1 = new ImageIcon(newe1);  // transform it back
            JLabel e1 = new JLabel (event1);
            add(e1);
            
            DefaultTableModel dm1 = new DefaultTableModel();
            dm1.setDataVector(new Object[][]{ 
                                            {"NAME", MainFrame.staffArray[0].viewEventName()},
                                            {"DATE", MainFrame.staffArray[0].viewEventDate()}, 
                                            {"TIME: " + MainFrame.staffArray[0].viewEventTime(), "VENUE: " + MainFrame.staffArray[0].viewEventVenue()},
                                            {"PRICE", "$" + MainFrame.staffArray[0].viewEventPrice()},
                                            {"PROMO CODE", MainFrame.staffArray[0].viewEventPromo()},
                                            },
                              new Object [] {MainFrame.staffArray[0].viewEventMonth() + " ID: " + MainFrame.staffArray[0].viewEventID(), "SEAT CAPACITY: " + MainFrame.staffArray[0].viewEventSeats()}
                               );           
            JTable table1 = new JTable(dm1);
            table1.setFont(tablefont);
            table1.getTableHeader().setFont (tableheader);
            table1.setShowGrid(false);
            table1.setIntercellSpacing(new Dimension(1, 1));
            table1.setEnabled(false);
            table1.setPreferredSize(new Dimension (500, 400));


            JScrollPane scrollPane1 = new JScrollPane(table1);
            JPanel panel1 = new JPanel();
            panel1.add(scrollPane1);
            getContentPane().add(panel1, BorderLayout.CENTER);
            add (panel1);
        }
        else
        {
            ImageIcon event1 = new ImageIcon (getClass().getResource("event1.jpg"));
            Image newevent1 = event1.getImage(); // transform it 
            Image newe1 = newevent1.getScaledInstance(400, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            event1 = new ImageIcon(newe1);  // transform it back
            JLabel e1 = new JLabel (event1);
            add(e1);
            
            DefaultTableModel dm1 = new DefaultTableModel();
            dm1.setDataVector(new Object[][]{ 
                                            {"NAME", defa.viewEventName()},
                                            {"DATE", defa.viewEventDate()}, 
                                            {"TIME: " + defa.viewEventTime(), "VENUE: " + defa.viewEventVenue()},
                                            {"PRICE", "$" + defa.viewEventPrice()},
                                            {"PROMO CODE", defa.viewEventPromo()},
                                            },
                              new Object [] {defa.viewEventMonth() + " ID: " + defa.viewEventID(), "SEAT CAPACITY: " + defa.viewEventSeats()}
                               );           
            JTable table1 = new JTable(dm1);
            table1.setFont(tablefont);
            table1.getTableHeader().setFont (tableheader);
            table1.setShowGrid(false);
            table1.setIntercellSpacing(new Dimension(1, 1));
            table1.setEnabled(false);
            table1.setPreferredSize(new Dimension (500, 400));


            JScrollPane scrollPane1 = new JScrollPane(table1);
            JPanel panel1 = new JPanel();
            panel1.add(scrollPane1);
            getContentPane().add(panel1, BorderLayout.CENTER);
            add (panel1);
        }

        // Event 2
        if (MainFrame.staffArray[1] != null && MainFrame.staffArray[1].viewEventStatus().equals ("APPROVED"))
        {
            ImageIcon event2 = new ImageIcon (getClass().getResource("event2.jpg"));
            Image newevent2 = event2.getImage(); // transform it 
            Image newe2 = newevent2.getScaledInstance(400, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            event2 = new ImageIcon(newe2);  // transform it back
            JLabel e2 = new JLabel (event2);
            add(e2);

            DefaultTableModel dm2 = new DefaultTableModel();
            dm2.setDataVector(new Object[][]{ 
                                            {"NAME", MainFrame.staffArray[1].viewEventName()},
                                            {"DATE", MainFrame.staffArray[1].viewEventDate()}, 
                                            {"TIME: " + MainFrame.staffArray[1].viewEventTime(), "VENUE: " + MainFrame.staffArray[1].viewEventVenue()},
                                            {"PRICE", "$" + MainFrame.staffArray[1].viewEventPrice()},
                                            {"PROMO CODE", MainFrame.staffArray[1].viewEventPromo()},
                                            },
                              new Object [] {MainFrame.staffArray[1].viewEventMonth() + " ID: " + MainFrame.staffArray[1].viewEventID(), "SEAT CAPACITY: " + MainFrame.staffArray[1].viewEventSeats()}
                               );            
            JTable table2 = new JTable(dm2);
            table2.setFont(tablefont);
            table2.getTableHeader().setFont (tableheader);
            table2.setShowGrid(false);
            table2.setIntercellSpacing(new Dimension(1, 1));
            table2.setEnabled(false);
            table2.setPreferredSize(new Dimension (500, 400));

            JScrollPane scrollPane2 = new JScrollPane(table2);
            JPanel panel2 = new JPanel();
            panel2.add(scrollPane2);
            getContentPane().add(panel2, BorderLayout.CENTER);
            add (panel2);
        }
        else
        {
            ImageIcon event2 = new ImageIcon (getClass().getResource("event2.jpg"));
            Image newevent2 = event2.getImage(); // transform it 
            Image newe2 = newevent2.getScaledInstance(400, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            event2 = new ImageIcon(newe2);  // transform it back
            JLabel e2 = new JLabel (event2);
            add(e2);

            DefaultTableModel dm2 = new DefaultTableModel();
            dm2.setDataVector(new Object[][]{ 
                                            {"NAME", defa.viewEventName()},
                                            {"DATE", defa.viewEventDate()}, 
                                            {"TIME: " + defa.viewEventTime(), "VENUE: " + defa.viewEventVenue()},
                                            {"PRICE", "$" + defa.viewEventPrice()},
                                            {"PROMO CODE", defa.viewEventPromo()},
                                            },
                              new Object [] {defa.viewEventMonth() + " ID: " + defa.viewEventID(), "SEAT CAPACITY: " + defa.viewEventSeats()}
                               );             
            JTable table2 = new JTable(dm2);
            table2.setFont(tablefont);
            table2.getTableHeader().setFont (tableheader);
            table2.setShowGrid(false);
            table2.setIntercellSpacing(new Dimension(1, 1));
            table2.setEnabled(false);
            table2.setPreferredSize(new Dimension (500, 400));

            JScrollPane scrollPane2 = new JScrollPane(table2);
            JPanel panel2 = new JPanel();
            panel2.add(scrollPane2);
            getContentPane().add(panel2, BorderLayout.CENTER);
            add (panel2);
        }

        // Event 3
        if (MainFrame.staffArray[2] != null && MainFrame.staffArray[2].viewEventStatus().equals ("APPROVED"))
        {
            ImageIcon event3 = new ImageIcon (getClass().getResource("event3.jpg"));
            Image newevent3 = event3.getImage(); // transform it 
            Image newe3 = newevent3.getScaledInstance(400, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            event3 = new ImageIcon(newe3);  // transform it back
            JLabel e3 = new JLabel (event3);
            add(e3);

            DefaultTableModel dm3 = new DefaultTableModel();
            dm3.setDataVector(new Object[][]{ 
                                            {"NAME", MainFrame.staffArray[2].viewEventName()},
                                            {"DATE", MainFrame.staffArray[2].viewEventDate()}, 
                                            {"TIME: " + MainFrame.staffArray[2].viewEventTime(), "VENUE: " + MainFrame.staffArray[2].viewEventVenue()},
                                            {"PRICE", "$" + MainFrame.staffArray[2].viewEventPrice()},
                                            {"PROMO CODE", MainFrame.staffArray[2].viewEventPromo()},
                                            },
                              new Object [] {MainFrame.staffArray[2].viewEventMonth() + " ID: " + MainFrame.staffArray[2].viewEventID(), "SEAT CAPACITY: " + MainFrame.staffArray[2].viewEventSeats()}
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
            getContentPane().add(panel3, BorderLayout.CENTER);
        }
        else
        {
            ImageIcon event3 = new ImageIcon (getClass().getResource("event3.jpg"));
            Image newevent3 = event3.getImage(); // transform it 
            Image newe3 = newevent3.getScaledInstance(400, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            event3 = new ImageIcon(newe3);  // transform it back
            JLabel e3 = new JLabel (event3);
            add(e3);

            DefaultTableModel dm3 = new DefaultTableModel();
            dm3.setDataVector(new Object[][]{ 
                                            {"NAME", defa.viewEventName()},
                                            {"DATE", defa.viewEventDate()}, 
                                            {"TIME: " + defa.viewEventTime(), "VENUE: " + defa.viewEventVenue()},
                                            {"PRICE", "$" + defa.viewEventPrice()},
                                            {"PROMO CODE", defa.viewEventPromo()},
                                            },
                              new Object [] {defa.viewEventMonth() + " ID: " + defa.viewEventID(), "SEAT CAPACITY: " + defa.viewEventSeats()}
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
            getContentPane().add(panel3, BorderLayout.CENTER);
        }   
        
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
