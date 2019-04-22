package devApp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.jgoodies.common.collect.ArrayListModel;

import engine.starsheep.space.Mission;

public class MissionsScreen extends JPanel {
    JList<Mission> jList_missions;
    Mission selectedMission;

    public MissionsScreen() {
        initalize();
        ArrayListModel<Mission> missionModel = new ArrayListModel<Mission>();

        List<Mission> missions = Application.getGameInstance().getMissionsController().getMissions();
        
        for (int i = 0; i < missions.size(); i++) {
            missionModel.add(missions.get(i));
        }
        jList_missions.setModel(missionModel);
        
        JButton btn_enterMission = new JButton("Enter Mission");
        btn_enterMission.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Application.getGameInstance().getMissionsController().setCurrentMission(selectedMission);
               new JobScreen();
            }
        });
        add(btn_enterMission, BorderLayout.SOUTH);
    }

    public void initalize() {
        setLayout(new BorderLayout(0, 0));

        jList_missions = new JList<>();
        jList_missions.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedMission = jList_missions.getSelectedValue();
            }
        });
        add(jList_missions, BorderLayout.CENTER);

        JLabel lbl_ = new JLabel("Missions Screen");
        lbl_.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbl_, BorderLayout.NORTH);
    }

}
