package com.Kiyivinski.graphical;

import com.Kiyivinski.graphical.listeners.MainMouseListener;
import com.Kiyivinski.graphical.listeners.interfaces.ConnectInterface;
import org.javalite.activejdbc.Base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The type Main frame.
 */
public class MainFrame extends JFrame implements ConnectInterface {
    private JTabbedPane layout;
    private String database;
    private String user;
    private String password;
    private final String title = "FOCUS ON TITLE TO DISCOVER DEVELOPER";

    /**
     * Instantiates a new Main frame.
     */
    public MainFrame() {
        this.setTitle(this.title);
        this.setSize(1024, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu mainMenu = new JMenu("Program");
        JMenuItem mainMenuExit = new JMenuItem("Exit");
        mainMenuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Base.close();
                System.exit(0);
            }
        });

        mainMenu.add(mainMenuExit);
        menuBar.add(mainMenu);
        this.setJMenuBar(menuBar);

        this.addMouseListener(new MainMouseListener(this));

        this.layout = new JTabbedPane();
        this.add(layout);

        this.createLoginLayout();
        this.setVisible(true);
    }

    private void createLoginLayout() {

        JPanel databasePanel = new DatabasePanel(this);
        this.layout.addTab("Database", databasePanel);
        this.layout.setTabPlacement(SwingConstants.LEFT);

    }

    private void createMainLayout() {
        StudentPanel studentPanel = new StudentPanel();
        studentPanel.setConnect(this.database, this.user, this.password);

        UnitPanel unitPanel = new UnitPanel();
        unitPanel.setConnect(this.database, this.user, this.password);

        SemesterPanel semesterPanel = new SemesterPanel();
        semesterPanel.setConnect(this.database, this.user, this.password);

        CoursePanel coursePanel = new CoursePanel();
        coursePanel.setConnect(this.database, this.user, this.password);

        AssessmentPanel assessmentPanel = new AssessmentPanel();
        assessmentPanel.setConnect(this.database, this.user, this.password);

        this.layout.addTab("Student", studentPanel);
        this.layout.addTab("Units", unitPanel);
        this.layout.addTab("Semesters", semesterPanel);
        this.layout.addTab("Courses", coursePanel);
        this.layout.addTab("Assessment", assessmentPanel);
    }

    public void setConnect(String database, String user, String password) {
        if (database.equals("FAILURE")) {
            JOptionPane.showMessageDialog(this, "Connection Failed");
        } else {
            this.database = database;
            this.user = user;
            this.password = password;

            this.layout.removeTabAt(0);
            this.createMainLayout();
        }
    }

    public void connect() {
        if (!Base.hasConnection()) {
            Base.open("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + database, user, password);
        }
    }
}
