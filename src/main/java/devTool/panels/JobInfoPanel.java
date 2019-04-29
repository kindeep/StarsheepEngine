package devTool.panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import devTool.JsonBuilder;
import devTool.models.EditableJob;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;

/**
 * 
 * @author peakyDicers
 *
 */
public class JobInfoPanel extends JPanel {
	private static final long serialVersionUID = 8307437995922181547L;

	private EditableJob currJob;
	private JTextField txtField_jobName;
	private JTextField txtField_jobId;
	private JTextField txtField_description;
	private JTextField txtField_reward;
	private JTextField txtField_headChoiceId;
	private JTextField txtField_level;
	private ChoicesGraph graph;
	private JLabel lbl_imageDisplay;

	/**
	 * Create the panel.
	 */
	public JobInfoPanel(EditableJob currJob, ChoicesGraph graph) {
		this.graph = graph;
		
		String jobName = null;
		String description = null;
		String id = null;
		String headChoice = null;
		String level = null;

		if (currJob != null) {
			this.currJob = currJob;
			jobName = currJob.name;
			description = currJob.description;
			id = currJob.id;
			headChoice = currJob.headChoice;
			level = currJob.level;
			graph.setHeadChoiceId(headChoice);
		}
		initialize();
		updateImage();
		
		txtField_jobName.setText(jobName);
		txtField_jobId.setText(id);
		txtField_description.setText(description);
		txtField_headChoiceId.setText(headChoice);
		txtField_level.setText(level);
	}
	
	private void updateImage() {
		lbl_imageDisplay.setIcon(null);
		if (currJob.imageId == null) return;
		
		String path = JsonBuilder.getInstance().getBaseDir() + "/assets/" + currJob.imageId;
		Image image = null;
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Double factor = 200.0/image.getWidth(null);
		image = image.getScaledInstance((int)(image.getWidth(null)*factor), (int)(image.getHeight(null)*factor), Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		lbl_imageDisplay.setIcon(icon);
	}

	public void save() {
		currJob.name = txtField_jobName.getText();
		currJob.description = txtField_description.getText();
		currJob.level = txtField_level.getText();
	}

	public void initialize() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(63dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lbl_level = new JLabel("Level");
		add(lbl_level, "2, 14, left, default");
		
		txtField_level = new JTextField();
		add(txtField_level, "4, 14, fill, default");
		txtField_level.setColumns(10);
		
		JLabel lbl_jobName = new JLabel("Job Name");
		add(lbl_jobName, "2, 2, left, default");

		txtField_jobName = new JTextField();
		add(txtField_jobName, "4, 2, fill, top");
		txtField_jobName.setColumns(10);

		JLabel lbl_jobId = new JLabel("Job Id");
		add(lbl_jobId, "2, 4, left, default");

		txtField_jobId = new JTextField();
		add(txtField_jobId, "4, 4, fill, default");
		txtField_jobId.setColumns(10);
		txtField_jobId.setEditable(false);

		JLabel lbl_description = new JLabel("Description");
		add(lbl_description, "2, 6, left, default");

		txtField_description = new JTextField();
		add(txtField_description, "4, 6, fill, default");
		txtField_description.setColumns(10);

		JLabel lbl_reward = new JLabel("Reward");
		add(lbl_reward, "2, 8, left, default");

		txtField_reward = new JTextField();
		add(txtField_reward, "4, 8, default, fill");
		txtField_reward.setColumns(10);
		
		txtField_headChoiceId = new JTextField();
		txtField_headChoiceId.setEditable(false);
		add(txtField_headChoiceId, "4, 12, fill, default");
		txtField_headChoiceId.setColumns(10);
		
		JLabel lbl_headChoice = new JLabel("Head Choice");
		add(lbl_headChoice, "2, 10, left, default");
		
		JLabel lblImage = new JLabel("Image");
		add(lblImage, "2, 16");
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				fc.addChoosableFileFilter(imageFilter);
				int result = fc.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String fileName = JsonBuilder.getInstance().createImageFile(fc.getSelectedFile(), currJob.id);
					if (fileName != null) {
						currJob.imageId = fileName;
						JOptionPane.showMessageDialog(null, "Image saved successfully.");
						updateImage();
					} else {
						JOptionPane.showMessageDialog(null, "Image save Error!!");
					}
				}
			}
		});
		add(btnBrowse, "4, 16");
		
		lbl_imageDisplay = new JLabel("");
		add(lbl_imageDisplay, "4, 18");

		JButton btnSelectHeadChoice = new JButton("select head choice");
		btnSelectHeadChoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ChoiceListDisplay choiceListDisplay = new ChoiceListDisplay(currJob.choices, currJob, txtField_headChoiceId, graph);
				choiceListDisplay.setVisible(true);
			}
		});
		add(btnSelectHeadChoice, "4, 10");

		JLabel lbl_headChoiceId = new JLabel("HeadChoice id");
		add(lbl_headChoiceId, "2, 12, left, default");
	}
}
