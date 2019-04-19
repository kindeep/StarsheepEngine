package devApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.common.collect.ArrayListModel;

import engine.starsheep.space.Choice;
import engine.starsheep.space.controller.MissionsController;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoiceScreen extends JFrame {

    private JPanel contentPane;
    private JList<Choice> jList_choices;
    private Choice selectedChoice;
    private ArrayListModel<Choice> choicesModel;
    /**
     * Launch the application.
     */
    public ChoiceScreen() {
       initalize();
       
       
       //adds all children choices to the List Model.
       choicesModel = new ArrayListModel<>();
       updateListModel();
       
       jList_choices.setModel(choicesModel);
    }
    
    public void updateChoice() {
        Application.getGameInstance().getMissionsController().setCurrentChoice(selectedChoice);
        updateListModel();
    }
    
    public void updateListModel() {
        MissionsController missionsController =  Application.getGameInstance().getMissionsController();
        choicesModel.clear();
        System.out.println("curr choice id: " + missionsController.getCurrentChoice().getID());
        List<String> choiceIds = missionsController.getCurrentChoice().getChildrenChoicesIds();
        System.out.println("length" + choiceIds.size());
        for (int i = 0; i < choiceIds.size(); i++) {
           String childId = choiceIds.get(i);
           Choice choice = missionsController.getCurrentJob().getChoices().get(childId);
           System.out.println(choice);
           choicesModel.add(choice);
        }
    }
    
    public void initalize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 299, 484);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_choiceData = new JPanel();
        contentPane.add(panel_choiceData);
        panel_choiceData.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_btns = new JPanel();
        panel_choiceData.add(panel_btns, BorderLayout.SOUTH);
        
        JButton btn_enterChoice = new JButton("Enter Choice");
        btn_enterChoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateChoice();
            }
        });
        panel_btns.add(btn_enterChoice);
        
        jList_choices = new JList();
        jList_choices.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedChoice = jList_choices.getSelectedValue();
            }
        });
        panel_choiceData.add(jList_choices, BorderLayout.CENTER);
        
        JLabel lbl_screenName = new JLabel("Choice ");
        lbl_screenName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        contentPane.add(lbl_screenName, BorderLayout.NORTH);
    }

}
