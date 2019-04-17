package devTool.panels;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.common.collect.LinkedListModel;

import devTool.models.EditableChoice;
import devTool.models.EditableJob;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author peakyDicers
 *
 */
public class ChoiceListDisplay extends JFrame {
	private static final long serialVersionUID = 532546922468957302L;
	private JPanel contentPane;
	private EditableChoice selectedChoice = null;
	private JButton btnSelect;
	
	//used for setting head choice.
	/**
	 * This constructor is used specifically for setting the headChoice in JobInfoPanel.
	 * 
	 * @param listModel The list of choices to display.
	 * @param currJob The current job.
	 * @param panel The JTextPanel that displays the id of the headChoice.
	 * @param graph The graph that displays the choices.
	 */
	public ChoiceListDisplay(LinkedListModel<EditableChoice> listModel, EditableJob currJob, JTextField panel, ChoicesGraph graph) {
		initalize(listModel);
		
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedChoice == null)
					return;
				
				//set choice id.
				currJob.headChoice = selectedChoice.id;
				panel.setText(selectedChoice.id);
				graph.setHeadChoiceId(selectedChoice.id);
				dispose();
			}
		});
	}
	
	/**
	 * This constructor is used specifically for adding a child choice to a Choice.
	 * 
	 * @param listModel The list of choices to display.
	 * @param children The list of children in this choice. Used to add selected choice to this list.
	 * @param graph The graph that displays the choices.
	 */
	public ChoiceListDisplay(LinkedListModel<EditableChoice> listModel, ArrayListModel<String> children,
			ChoicesGraph graph) {
		initalize(listModel);
		

		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedChoice == null)
					return;

				// check if child is going to be a duplicate, if so, don't add it.
				for (String childId : children) {
					if (childId.compareTo(selectedChoice.id) == 0) {
						JOptionPane.showMessageDialog(null, "You've already added this child.");
						return;
					}
				}

				children.add(selectedChoice.id);
				graph.populateGraph();
				dispose();
			}
		});
	}
	
	private void initalize(LinkedListModel<EditableChoice> listModel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		btnSelect = new JButton("Select");
		contentPane.add(btnSelect, BorderLayout.SOUTH);
		
		JList<EditableChoice> list = new JList<EditableChoice>();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedChoice = list.getSelectedValue();
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(listModel);
		contentPane.add(list, BorderLayout.CENTER);
	}
}
