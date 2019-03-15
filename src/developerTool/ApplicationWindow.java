package developerTool;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import developerTool.Panels.*;

public class ApplicationWindow {

	private JFrame frmStarsheepDeveloperTool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frmStarsheepDeveloperTool.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStarsheepDeveloperTool = new JFrame();
		frmStarsheepDeveloperTool.setTitle("Starsheep Developer Tool");
		frmStarsheepDeveloperTool.setBounds(100, 100, 700, 450);
		frmStarsheepDeveloperTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStarsheepDeveloperTool.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmStarsheepDeveloperTool.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		GeneralPanel generalPanel = new GeneralPanel();
		tabbedPane.addTab("General", null, generalPanel, null);
		
		JPanel Missions = new JPanel();
		tabbedPane.addTab("Missions", null, Missions, null);
		Missions.setLayout(new BorderLayout(0, 0));
		
		MissionsPanel missionsPanel = new MissionsPanel();
		Missions.add(missionsPanel);
		
		JPanel Traits = new JPanel();
		tabbedPane.addTab("Traits", null, Traits, null);
		
		JToolBar toolBar = new JToolBar();
		frmStarsheepDeveloperTool.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton newGameBtn = new JButton("New Game");
		toolBar.add(newGameBtn);
		
		JButton openGameBtn = new JButton("Open Game");
		toolBar.add(openGameBtn);
		
		JButton exportBtn = new JButton("Export Game");
		toolBar.add(exportBtn);
		
		JPanel panel = new JPanel();
		toolBar.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		JButton saveBtn = new JButton("Save");
		saveBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(saveBtn);
	}
}