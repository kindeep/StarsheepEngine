package devTool;

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
import developerTool.XMLBuilder.GameModel;
import developerTool.XMLBuilder.MissionsModel;
import developerTool.XMLBuilder.XMLBuilder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ApplicationWindow {

	private JFrame frmStarsheepDeveloperTool;
	private GameModel gameModel;
	private MissionsModel missionsModel;

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

		gameModel = new GameModel();
		missionsModel = new MissionsModel();

		frmStarsheepDeveloperTool = new JFrame();
		frmStarsheepDeveloperTool.setTitle("Starsheep Developer Tool");
		frmStarsheepDeveloperTool.setBounds(100, 100, 700, 450);
		frmStarsheepDeveloperTool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStarsheepDeveloperTool.getContentPane().setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmStarsheepDeveloperTool.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		GeneralPanel generalPanel = new GeneralPanel(gameModel);
		tabbedPane.addTab("General", null, generalPanel, null);

		JPanel Missions = new JPanel();
		tabbedPane.addTab("Missions", null, Missions, null);
		Missions.setLayout(new BorderLayout(0, 0));

		MissionsPanel missionsPanel = new MissionsPanel(missionsModel);
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