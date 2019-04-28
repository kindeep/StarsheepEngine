package devTool.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import devTool.JsonBuilder;
import devTool.models.EditableJobFlyer;
import devTool.models.EditableMission;
import devTool.models.GameDataManager;
import devTool.models.MissionsModel;
import java.awt.Canvas;
import java.awt.Panel;

public class MissionsPanel extends JPanel {

	private static final long serialVersionUID = -9215001740566008009L;
	private EditableMission currMission;
	private EditableJobFlyer selectedJob = null;

	private JTextField txtField_missionTitle;
	private JTextField txtField_missionDescription;
	private JTextField txtField_staminaCost;
	private JTextField txtField_missionId;
	private JButton btn_editJob;
	private JButton btn_newJob;
	private JButton btn_newMission;
	private JLabel lbl_image;
	private JLabel lbl_imageDisplay;

	private ArrayListModel<EditableJobFlyer> jobListModel;
	private ArrayListModel<EditableMission> missionListModel = null;
	private JList<EditableMission> jList_missionList;
	private JList<EditableJobFlyer> jList_jobList;

	/**
	 * Create the panel.
	 */

	public void updateMissions() {
		this.missionListModel = GameDataManager.getInstance().getMissionsModel().getMissions();
		jList_missionList.setModel(missionListModel);
	}

	private void deleteMission() {
		GameDataManager.getInstance().getMissionsModel().removeMission(currMission);

		// clear fields.
		txtField_missionId.setText("");
		txtField_missionTitle.setText("");
		txtField_missionDescription.setText("");
		txtField_staminaCost.setText("");
		jobListModel = null;
		btn_editJob.setEnabled(false);
		btn_newJob.setEnabled(false);
	}

	private void updateCanvas() {
		lbl_imageDisplay.setIcon(null);
		if (currMission.imageId == null) return;
		
//		Toolkit t = Toolkit.getDefaultToolkit();
//		Image img = t.getImage(JsonBuilder.getInstance().getBaseDir() + "/assets/" + currMission.imageId);
//		System.out.println(img);
//		canvas.setSize(1000,800);
//		canvas.setVisible(true);
//		canvas.getGraphics().drawImage(img, 0, 0, null);
//		canvas.revalidate();
//		canvas.repaint();
		
		String path = JsonBuilder.getInstance().getBaseDir() + "/assets/" + currMission.imageId;
		Image image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Double factor = 200.0/image.getWidth(null);
		image = image.getScaledInstance((int)(image.getWidth(null)*factor), (int)(image.getHeight(null)*factor), Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		lbl_imageDisplay.setIcon(icon);
		
		repaint();
		revalidate();
	}

	public MissionsPanel() {

		setLayout(new BorderLayout(0, 0));

		JPanel listPanel = new JPanel();
		listPanel.setBorder(new LineBorder(Color.MAGENTA));
		add(listPanel, BorderLayout.WEST);
		listPanel.setLayout(new BorderLayout(5, 0));

		JPanel missionBtns = new JPanel();
		listPanel.add(missionBtns, BorderLayout.SOUTH);
		missionBtns.setLayout(new BoxLayout(missionBtns, BoxLayout.Y_AXIS));

		JButton btn_newMission = new JButton("New Mission");
		missionBtns.add(btn_newMission);

		JButton btn_deleteMission = new JButton("Delete Mission");
		missionBtns.add(btn_deleteMission);

		// mission form labels + textfields.
		JPanel missionEditor = new JPanel();
		missionEditor.setBackground(Color.GREEN);
		add(missionEditor, BorderLayout.CENTER);
		missionEditor.setLayout(new BorderLayout(0, 0));
		jList_missionList = new JList<EditableMission>();

		JPanel panel_center = new JPanel();
		missionEditor.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));

		JPanel panel_form = new JPanel();
		panel_center.add(panel_form);
		panel_form.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("left:50dlu"), ColumnSpec.decode("center:53dlu:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("max(15dlu;default)"),
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lbl_missionId = new JLabel("Mission id:");
		panel_form.add(lbl_missionId, "1, 2, left, default");

		txtField_missionId = new JTextField();
		txtField_missionId.setEnabled(false);
		txtField_missionId.setEditable(false);
		panel_form.add(txtField_missionId, "2, 2, fill, default");
		txtField_missionId.setColumns(10);

		JLabel lbl_missionTitle = new JLabel("Mission title:");
		panel_form.add(lbl_missionTitle, "1, 3, left, default");
		txtField_missionTitle = new JTextField();

		panel_form.add(txtField_missionTitle, "2, 3, fill, default");
		txtField_missionTitle.setColumns(10);

		JLabel lbl_description = new JLabel("Description:");
		panel_form.add(lbl_description, "1, 5, left, default");

		txtField_missionDescription = new JTextField();
		panel_form.add(txtField_missionDescription, "2, 5, fill, default");
		txtField_missionDescription.setColumns(10);

		JLabel lbl_staminaCost = new JLabel("Stamina Cost:");
		panel_form.add(lbl_staminaCost, "1, 7, left, default");

		txtField_staminaCost = new JTextField();
		panel_form.add(txtField_staminaCost, "2, 7, fill, default");
		txtField_staminaCost.setColumns(10);

		lbl_image = new JLabel("Image:");
		panel_form.add(lbl_image, "1, 9, left, default");

		JButton btnBrowse = new JButton("Browse");

		panel_form.add(btnBrowse, "2, 9");
		
		JPanel panel_image = new JPanel();
		missionEditor.add(panel_image, BorderLayout.SOUTH);
		
		lbl_imageDisplay = new JLabel("");
		panel_image.add(lbl_imageDisplay);
		Dimension d = new Dimension(100,100);
		panel_image.setMaximumSize(d);

		jobListModel = new ArrayListModel<EditableJobFlyer>();

		listPanel.add(jList_missionList);
		jList_missionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JPanel rightPanel = new JPanel();
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setBorder(new LineBorder(Color.ORANGE));
		rightPanel.setLayout(new BorderLayout(0, 0));

		jList_jobList = new JList<EditableJobFlyer>();
		jList_jobList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // only one item can be selected.

		rightPanel.add(jList_jobList);

		// job button panel --------------
		JPanel jobBtns = new JPanel();
		rightPanel.add(jobBtns, BorderLayout.SOUTH);
		jobBtns.setLayout(new BoxLayout(jobBtns, BoxLayout.Y_AXIS));

		btn_editJob = new JButton("Edit Job");
		jobBtns.add(btn_editJob);

		btn_newJob = new JButton("New Job");
		jobBtns.add(btn_newJob);

		// ==================== listeners ====================

		// browse image.
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				fc.addChoosableFileFilter(imageFilter);
				int result = fc.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					
					String fileName = JsonBuilder.getInstance().createImageFile(fc.getSelectedFile());
					if (fileName != null) {
						currMission.imageId = fileName;
						JOptionPane.showMessageDialog(null, "Image saved successfully.");
						updateCanvas();
					} else {
						JOptionPane.showMessageDialog(null, "Image save Error!!");
					}
				}
			}
		});

		txtField_missionTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				currMission.title = txtField_missionTitle.getText();
				jList_missionList.updateUI();
			}
		});

		// clicked on a job.
		jList_jobList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedJob = jList_jobList.getSelectedValue();
			}
		});

		// edit job button pressed.
		btn_editJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobEditor jobEditor = new JobEditor(currMission, selectedJob.id);
				jobEditor.setVisible(true);
			}
		});

		// new job button pressed.
		btn_newJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JobEditor jobEditor = new JobEditor(currMission);
				jobEditor.setVisible(true);
			}
		});

		// delete a mission.
		btn_deleteMission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int reply = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to delete mission: " + currMission.title, "ARE YOU SURE?",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					reply = JOptionPane.showConfirmDialog(null,
							currMission.title + " and all its jobs and choices will be DELETED. Are you sure?",
							"FINAL WARNING", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION)
						deleteMission();
				}
			}
		});

		// clicked on a mission.
		jList_missionList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedJob = null;
				currMission = jList_missionList.getSelectedValue();

				// update data in fields.
				txtField_missionTitle.setText(currMission.title);
				txtField_missionDescription.setText(currMission.description);
				txtField_staminaCost.setText(String.valueOf(currMission.staminaCost));
				txtField_missionId.setText(currMission.id);
				btn_editJob.setEnabled(true);
				btn_newJob.setEnabled(true);

				// update job list.
				jList_jobList.setModel(currMission.jobFlyers);
				
				//update canvas
				updateCanvas();
			}
		});

		// new mission button pressed.
		btn_newMission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditableMission mission = new EditableMission();
				mission.title = "unnamed mission";
				mission.id = UUID.randomUUID().toString();
				GameDataManager.getInstance().getMissionsModel().addMission(mission);
			}
		});
	}
}
