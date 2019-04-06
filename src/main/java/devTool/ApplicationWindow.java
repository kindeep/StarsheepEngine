package devTool;

import java.io.File;

import devTool.Panels.*;
import devTool.XMLBuilder.GameModel;
import devTool.XMLBuilder.MissionsModel;
import devTool.XMLBuilder.XMLBuilder;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

public class ApplicationWindow {

	private JFrame mainFrame;
	private GameModel gameModel;
	private MissionsModel missionsModel;
	private XMLBuilder xml;
	
	MissionsPanel missionsPanel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.mainFrame.setVisible(true);
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
		//set default save location.
		xml = XMLBuilder.getInstance();
		xml.setBaseDir(new File("."));
		
		initialize();
	}
	
	private void loadDirectory(File directory) {
		//set as write location for xmlBuilder.
		xml.setBaseDir(directory);
		
		//read mission.xml and missions panel.
		this.missionsModel.loadMissionsFile(directory);
		missionsPanel.updateMissions(this.missionsModel.getMissions());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		gameModel = new GameModel();
		missionsModel = new MissionsModel();

		mainFrame = new JFrame();
		mainFrame.setTitle("Starsheep Developer Tool");
		mainFrame.setBounds(100, 100, 700, 450);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		GeneralPanel generalPanel = new GeneralPanel(gameModel);
		tabbedPane.addTab("General", null, generalPanel, null);

		JPanel Missions = new JPanel();
		tabbedPane.addTab("Missions", null, Missions, null);
		Missions.setLayout(new BorderLayout(0, 0));

		missionsPanel = new MissionsPanel(missionsModel);
		Missions.add(missionsPanel);

		JPanel Traits = new JPanel();
		tabbedPane.addTab("Traits", null, Traits, null);

		JToolBar toolBar = new JToolBar();
		mainFrame.getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton newGameBtn = new JButton("New Game");
		toolBar.add(newGameBtn);

		JButton openGameBtn = new JButton("Open Game");
		openGameBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});	
		
		openGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				int returnVal = chooser.showOpenDialog(mainFrame);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File directory = chooser.getSelectedFile();
					//TODO: save current game
					
					//TODO: load current game.
					loadDirectory(directory);
				}
			}
		});
		
		toolBar.add(openGameBtn);

		JButton exportBtn = new JButton("Export Game");
		toolBar.add(exportBtn);

		JPanel panel = new JPanel();
		toolBar.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		JButton saveBtn = new JButton("Save");
		saveBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XMLBuilder.buildGameModelData(gameModel);
			}
		});
		saveBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(saveBtn);
	}
}