package devTool.Panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.common.collect.LinkedListModel;

import devTool.models.EditableChoice;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChoiceListDisplay extends JFrame {

	private JPanel contentPane;
	private EditableChoice selectedChoice = null;
	private JFrame frame = this;

	/**
	 * Create the frame.
	 */
	public ChoiceListDisplay(LinkedListModel<EditableChoice> listModel, ArrayListModel<String> children, ChoicesPanel choicesPanel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 267, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JButton btnSelect = new JButton("Select");
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
		
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedChoice == null)
					return;
				
				//check if child is going to be a duplicate, if so, don't add it.
				for (String childId: children){
					if (childId.compareTo(selectedChoice.id) == 0) {
						JOptionPane.showMessageDialog(null, "You've already added this child.");
						return;
					}
				}
				
				children.add(selectedChoice.id);
				choicesPanel.updateGraph();
				dispose();
			}
		});
	}
}
