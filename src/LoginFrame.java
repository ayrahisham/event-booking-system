import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

class LoginFrame extends JFrame implements ActionListener
{
    private final JTextField username;
    private final JPasswordField password;
    private final JButton loginbutton;
    private final JButton clearbutton;
    private final JLabel footer;
    public static String studentid;
    public static String id;
    
    LoginFrame ()
    {
        // Web title
        super ("Welcome to UOW Event Booking System");
        
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
        JLabel banner1 = new JLabel (banner);
        banner1.setText ("UOW LOGIN");
        banner1.setFont (new Font ("monospaced", Font.BOLD, 35));
        banner1.setForeground(Color.BLACK);
        add(banner1);
        
        Font formfont = new Font ("times-new-roman", Font.BOLD, 20);
        Font formfont2 = new Font ("times-new-roman", Font.ITALIC, 15);
        
        username = new JTextField(20);
        username.setFont(formfont2);       
        username.addActionListener (this);
        JLabel euserlabel = new JLabel ("User Name:");
        euserlabel.setLabelFor(username);
        euserlabel.setFont (formfont);
        add (euserlabel);
        add (username);
        
        password = new JPasswordField(20);
        password.setFont(formfont2);       
        password.addActionListener (this);
        JLabel epwdlabel = new JLabel ("Password:");
        epwdlabel.setLabelFor(password);
        epwdlabel.setFont (formfont);
        add (epwdlabel);
        add (password);
        
        loginbutton = new JButton ("LOGIN");
        loginbutton.setFont (formfont2);     
        add (loginbutton);
        loginbutton.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (username.getText ().equals ("Staff001") && password.getText().equals ("Staff001")
                    || username.getText ().equals ("Staff002") && password.getText().equals ("Staff002")
                    || username.getText ().equals ("Staff003") && password.getText().equals ("Staff003"))
                {
                    id = username.getText();
                    Component frame = new JFrame();
                    JOptionPane.showMessageDialog(frame , "Welcome " + id + " to UOW Staff Event Management System");
                    dispose ();
                    StaffEventFrame sef = new StaffEventFrame (id);
                    sef.setVisible (true);
                    sef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    sef.setSize (1200, 1000);
                }
                else if (username.getText ().equals ("Student001") && password.getText().equals ("Student001")
                    || username.getText ().equals ("Student002") && password.getText().equals ("Student002")
                    || username.getText ().equals ("Student003") && password.getText().equals ("Student003"))
                {
                    studentid = username.getText();
                    Component frame = new JFrame();
                    JOptionPane.showMessageDialog(frame , "Welcome " + studentid + " to UOW Student Event Booking System");
                    dispose ();
                    StudentEventFrame stef = new StudentEventFrame (studentid);
                    stef.setVisible (true);
                    stef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    stef.setSize (1200, 1000);
                }
                else if (username.getText ().equals ("Admin") && password.getText().equals ("Admin"))
                {
                    id = username.getText();
                    Component frame = new JFrame();
                    JOptionPane.showMessageDialog(frame , "Welcome " + id + " to UOW Admin Event Booking System");
                    dispose ();
                    AdminEventFrame aef = new AdminEventFrame (id);
                    aef.setVisible (true);
                    aef.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                    aef.setSize (1200, 1000);
                }
                else
                {
                    Component frame = new JFrame();
                    JOptionPane.showMessageDialog(frame , "Invalid username/password! Please try again.");
                }
            }
        });
        
        clearbutton = new JButton ("CLEAR");
        clearbutton.setFont (formfont2);
        clearbutton.addActionListener (new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getSource () == clearbutton)
                {
                    username.setText ("");
                    password.setText ("");
                }
            }
        });
        add (clearbutton);
        
         // Web footer
        footer = new JLabel ("Copyright 2017 - 2018. © University of Wollongong, Australia. All rights reserved.");
        footer.setHorizontalAlignment(JLabel.LEFT);
        footer.setVerticalAlignment (JLabel.BOTTOM);
        Font footerfont = new Font ("times-new-roman", Font.ITALIC, 15);
        footer.setFont (footerfont);      
        add(footer, BorderLayout.PAGE_END);
    }
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        
    }
}
