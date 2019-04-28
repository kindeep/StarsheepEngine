package devApp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.common.collect.ArrayListModel;

import engine.starsheep.space.Choice;
import engine.starsheep.space.controller.MissionsController;
import engine.starsheep.space.job.TraitDependency;
import javax.swing.JTextField;

public class ChoiceScreen extends JFrame {

    private JPanel contentPane;
    private JList<Choice> jList_choices;
    private Choice selectedChild;
    private ArrayListModel<Choice> choicesModel;
    private JPanel panel_dependency;
    private JTextField txtField_stamina;
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
        MissionsController missionsController = Application.getGameInstance().getMissionsController();
        boolean success = missionsController.makeChoice(selectedChild);
        if (!success)
        	JOptionPane.showMessageDialog(this, "Not even skillz, ): ");
        updateListModel();
    }
    
    public void updateDependenciesPanel() {
        panel_dependency.removeAll();
      
        if (selectedChild != null)
            for (TraitDependency trait: selectedChild.getTraitDependencies()) {
                TraitDependencyNode node = new TraitDependencyNode(trait.getId(), String.valueOf(trait.getWeight()));
                panel_dependency.add(node);
            }
        
        panel_dependency.revalidate();
        panel_dependency.repaint();
    }
    
    public void updateListModel() {
        MissionsController missionsController =  Application.getGameInstance().getMissionsController();
        txtField_stamina.setText(String.valueOf(missionsController.getPlayerStamina()));
        choicesModel.clear();
        List<String> choiceIds = missionsController.getCurrentChoice().getChildrenChoicesIds();
        for (int i = 0; i < choiceIds.size(); i++) {
           String childId = choiceIds.get(i);
           Choice choice = missionsController.getCurrentJob().getChoices().get(childId);
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
                selectedChild = null;
                updateDependenciesPanel();
            }
        });
        panel_btns.add(btn_enterChoice);
        
        JPanel panel_list_and_dependency = new JPanel();
        panel_choiceData.add(panel_list_and_dependency, BorderLayout.CENTER);
        panel_list_and_dependency.setLayout(new BorderLayout(0, 0));
        
        panel_dependency = new JPanel();
        panel_list_and_dependency.add(panel_dependency, BorderLayout.CENTER);
        panel_dependency.setLayout(new BoxLayout(panel_dependency, BoxLayout.Y_AXIS));
        
        jList_choices = new JList();
        panel_list_and_dependency.add(jList_choices, BorderLayout.NORTH);
        
        JPanel panel_header = new JPanel();
        panel_choiceData.add(panel_header, BorderLayout.NORTH);
        
        JLabel lbl_stamina = new JLabel("Stamina:");
        lbl_stamina.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_header.add(lbl_stamina);
        
        txtField_stamina = new JTextField();
        txtField_stamina.setEditable(false);
        panel_header.add(txtField_stamina);
        txtField_stamina.setColumns(10);
        jList_choices.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedChild = jList_choices.getSelectedValue();
                updateDependenciesPanel();
            }
        });
    }

}
