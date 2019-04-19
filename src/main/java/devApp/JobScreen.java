package devApp;

import javax.swing.JPanel;

import com.jgoodies.common.collect.ArrayListModel;

import engine.starsheep.space.Mission;
import engine.starsheep.space.job.JobFlyer;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobScreen extends JFrame {
    private  JList<JobFlyer> jList_jobs;
    private JobFlyer selectedJob;
    
    public JobScreen() {
        initalize();
        
        Mission currMission = Application.getGameInstance().getMissionsController().getCurrentMission();
        ArrayListModel<JobFlyer> listModel = new ArrayListModel<>(currMission.getJobFlyers());
        jList_jobs.setModel(listModel);
    }
    
    public void initalize() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 324, 505);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setVisible(true);
        jList_jobs = new JList<>();
        jList_jobs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedJob = jList_jobs.getSelectedValue();
            }
        });
        getContentPane().add(jList_jobs, BorderLayout.CENTER);
        
        JLabel lbl_screenName = new JLabel("Job Screen");
        lbl_screenName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        getContentPane().add(lbl_screenName, BorderLayout.NORTH);
        
        JPanel panel_btns = new JPanel();
        getContentPane().add(panel_btns, BorderLayout.SOUTH);
        
        JButton btn_back = new JButton("Back");
        panel_btns.add(btn_back);
        
        JButton btn_enterJob = new JButton("Enter Job");
        btn_enterJob.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Application.getGameInstance().getMissionsController().setCurrentJob(selectedJob.getJobId());
                ChoiceScreen choiceScreen = new ChoiceScreen();
            }
        });
        panel_btns.add(btn_enterJob);
    }
}
