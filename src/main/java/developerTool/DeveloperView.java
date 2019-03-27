package developerTool;

import engine.starsheep.space.Controller;
import engine.starsheep.space.Mission;
import engine.starsheep.space.StarGameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This is an implementation of a View as defined by the Starsheep Engine View.
 *
 */
public class DeveloperView extends JFrame implements StarGameView {
	private static final long serialVersionUID = 1L;
	Controller controller;
	ArrayList<JLabel> missionLabels;

	public DeveloperView(Controller c) {
		controller = c;
		missionLabels = new ArrayList<JLabel>();
		initUI();
	}
	
	private void initUI() {
		setTitle("Starsheep Developer Tool");
		setSize(300,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton missionsBtn = new JButton("View Missions");
		JPanel p = new JPanel();
		p.add(missionsBtn);
		this.add(p);
		
		missionsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Mission> missions= controller.getMissions();
				// temp print out all missions.
				for (int i = 0; i < missions.size(); i++) {
					Mission m = missions.get(i);
					JLabel missionLabel = new JLabel(m.getJobFlyers().get(0).getName());
					missionLabels.add(missionLabel);
					System.out.println(m.getJobFlyers().get(0).getName());
					p.add(missionLabel);
					p.revalidate();
					p.repaint();
					revalidate();
					repaint();
				}
			}
		});
	}
	
	private void viewMission() {
		
	}

	@Override
	public void log(Object toPrint) {
		// TODO Auto-generated method stub
		
	}
}
