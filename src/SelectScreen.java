import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SelectScreen extends JPanel implements ActionListener{
	private GUI gui;
	JPanel frame;
	JLabel label;
	JButton joltButton;
	JButton megaButton;
	JButton charButton;
	JButton gyarButton;
	JButton exeggButton;
	JButton machButton;
	JButton dragButton;
	JButton steelButton;
	JButton donButton;
	JButton snorButton;
	JButton genButton;
	JButton tyButton;
	JButton sciButton;
	JButton clefButton;
	JButton houndButton;
	JButton lapButton;
	JButton nidButton;
	JButton arcButton;
	JButton contButton;
	JPanel scrollPanel;
	Fighter user_mon;
	Fighter opp_mon;
	private static final long serialVersionUID = 1L;
	
	public SelectScreen(GUI gui) {
		this.gui = gui;
		Font font = new Font("Monospaced", Font.PLAIN, 14);
		UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
		ImageIcon joltIcon = new ImageIcon(getClass().getResource("/images/jolteon.png"));
		ImageIcon megaIcon = new ImageIcon(getClass().getResource("/images/meganium.png"));
		ImageIcon charizardIcon = new ImageIcon(getClass().getResource("/images/charizard.png"));
		ImageIcon gyarIcon = new ImageIcon(getClass().getResource("/images/gyarados.png"));
		ImageIcon exeggutorIcon = new ImageIcon(getClass().getResource("/images/exeggutor.png"));
		ImageIcon machampIcon = new ImageIcon(getClass().getResource("/images/machamp.png"));
		ImageIcon continueIcon = new ImageIcon(getClass().getResource("/images/button.png"));
		ImageIcon dragIcon = new ImageIcon(getClass().getResource("/images/dragonite.png"));
		ImageIcon steelIcon = new ImageIcon(getClass().getResource("/images/steelix.png"));
		ImageIcon donIcon = new ImageIcon(getClass().getResource("/images/donphan.png"));
		ImageIcon snorIcon = new ImageIcon(getClass().getResource("/images/snorlax.png"));
		ImageIcon genIcon = new ImageIcon(getClass().getResource("/images/gengar.png"));
		ImageIcon tyIcon = new ImageIcon(getClass().getResource("/images/tyranitar.png"));
		ImageIcon sciIcon = new ImageIcon(getClass().getResource("/images/scizor.png"));
		ImageIcon clefIcon = new ImageIcon(getClass().getResource("/images/clefable.png"));
		ImageIcon houndIcon = new ImageIcon(getClass().getResource("/images/houndoom.png"));
		ImageIcon lapIcon = new ImageIcon(getClass().getResource("/images/lapras.png"));
		ImageIcon nidIcon = new ImageIcon(getClass().getResource("/images/nidoking.png"));
		ImageIcon arcIcon = new ImageIcon(getClass().getResource("/images/arcanine.png"));
		joltButton = createButton(joltIcon, this);
		megaButton = createButton(megaIcon, this);
		charButton = createButton(charizardIcon, this);
		gyarButton = createButton(gyarIcon, this);
		exeggButton = createButton(exeggutorIcon, this);
		machButton = createButton(machampIcon, this);
		dragButton = createButton(dragIcon, this);
		steelButton = createButton(steelIcon, this);
		donButton = createButton(donIcon, this);
		snorButton = createButton(snorIcon, this);
		genButton = createButton(genIcon, this);
		tyButton = createButton(tyIcon, this);
		sciButton = createButton(sciIcon, this);
		clefButton = createButton(clefIcon, this);
		houndButton = createButton(houndIcon, this);
		lapButton = createButton(lapIcon, this);
		nidButton = createButton(nidIcon, this);
		arcButton = createButton(arcIcon, this);
		contButton = createButton(continueIcon, this);
		contButton.setVisible(false);
		label = new JLabel("<html>Choose your<br>Pokemon!</html>");
		scrollPanel = new JPanel();
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.X_AXIS));
		JPanel column1 = createColumn(joltButton, charButton);
		JPanel column2 = createColumn(megaButton, gyarButton);
		JPanel column3 = createColumn(exeggButton, machButton);
		JPanel column4 = createColumn(dragButton, steelButton);
		JPanel column5 = createColumn(donButton, snorButton);
		JPanel column6 = createColumn(genButton, tyButton);
		JPanel column7 = createColumn(sciButton, clefButton);
		JPanel column8 = createColumn(houndButton, lapButton);
		JPanel column9 = createColumn(nidButton, arcButton);
		
		scrollPanel.add(column1);
		scrollPanel.add(Box.createHorizontalStrut(10)); // spacing
		scrollPanel.add(column2);
		scrollPanel.add(Box.createHorizontalStrut(10));
		scrollPanel.add(column3);
		scrollPanel.add(Box.createHorizontalStrut(10));
		scrollPanel.add(column4);
		scrollPanel.add(Box.createHorizontalStrut(10));
		scrollPanel.add(column5);
		scrollPanel.add(Box.createHorizontalStrut(10));
		scrollPanel.add(column6);
		scrollPanel.add(Box.createHorizontalStrut(10));
		scrollPanel.add(column7);
		scrollPanel.add(Box.createHorizontalStrut(10));
		scrollPanel.add(column8);
		scrollPanel.add(Box.createHorizontalStrut(10));
		scrollPanel.add(column9);
		
		
		JScrollPane scrollPane = new JScrollPane(scrollPanel,
			    JScrollPane.VERTICAL_SCROLLBAR_NEVER,
			    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new java.awt.Dimension(600, 200));
		scrollPane.setBorder(null);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);

		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(label, BorderLayout.CENTER);
		bottomPanel.add(contButton, BorderLayout.EAST);
			
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		add(scrollPane, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == joltButton) {
			label.setText("<html>You have selected<br>Jolteon!</html>");
			contButton.setVisible(true);
			this.opp_mon = chooseOpp();
			this.user_mon = Create.createJolteon();
		}
		else if (e.getSource() == megaButton) {
			label.setText("<html>You have selected<br>Meganium!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createMeganium();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == charButton) {
			label.setText("<html>You have selected<br>Charizard!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createCharizard();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == gyarButton) {
			label.setText("<html>You have selected<br>Gyarados!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createGyarados();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == machButton) {
			label.setText("<html>You have selected<br>Machamp!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createMachamp();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == exeggButton) {
			label.setText("<html>You have selected<br>Exeggutor!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createExeggutor();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == dragButton) {
			label.setText("<html>You have selected<br>Dragonite!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createDragonite();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == steelButton) {
			label.setText("<html>You have selected<br>Steelix!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createSteelix();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == donButton) {
			label.setText("<html>You have selected<br>Donphan!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createDonphan();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == snorButton) {
			label.setText("<html>You have selected<br>Snorlax!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createSnorlax();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == genButton) {
			label.setText("<html>You have selected<br>Gengar!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createGengar();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == tyButton) {
			label.setText("<html>You have selected<br>Tyranitar!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createTyranitar();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == sciButton) {
			label.setText("<html>You have selected<br>Scizor!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createScizor();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == clefButton) {
			label.setText("<html>You have selected<br>Clefable!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createClefable();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == houndButton) {
			label.setText("<html>You have selected<br>Houndoom!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createHoundoom();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == lapButton) {
			label.setText("<html>You have selected<br>Lapras!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createLapras();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == nidButton) {
			label.setText("<html>You have selected<br>Nidoking!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createNidoking();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == arcButton) {
			label.setText("<html>You have selected<br>Arcanine!</html>");
			contButton.setVisible(true);
			this.user_mon = Create.createArcanine();
			this.opp_mon = chooseOpp();
		}
		else if (e.getSource() == contButton) {
			gui.panel.add(new Battle(gui, user_mon, opp_mon), "Battle");
			gui.clip.stop();
			try {
				gui.clip = GUI.playMusic("/music/red.wav");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			gui.showPanel("Battle");
		}
	}
	
	private Fighter chooseOpp() {
		Random random = new Random();
		int rand = random.nextInt(18);
		if (rand == 0) {
			return Create.createJolteon();
		}
		if (rand == 1) {
			return Create.createMeganium();
		}
		if (rand == 2) {
			return Create.createCharizard();
		}
		if (rand == 3) {
			return Create.createCharizard();
		}
		if (rand == 4) {
			return Create.createMachamp();
		}
		if (rand == 5) {
			return Create.createExeggutor();
		}
		if (rand == 6) {
			return Create.createDragonite();
		}
		if (rand == 7) {
			return Create.createSteelix();
		}
		if (rand == 8) {
			return Create.createDonphan();
		}
		if (rand == 9) {
			return Create.createSnorlax();
		}
		if (rand == 10) {
			return Create.createGengar();
		}
		if (rand == 11) {
			return Create.createTyranitar();
		}
		if (rand == 12) {
			return Create.createScizor();
		}
		if (rand == 13) {
			return Create.createClefable();
		}
		if (rand == 14) {
			return Create.createHoundoom();
		}
		if (rand == 15) {
			return Create.createLapras();
		}
		if (rand == 16) {
			return Create.createNidoking();
		}
		return Create.createArcanine();
	}
	
	private JButton createButton(ImageIcon icon, ActionListener listener) {
		JButton button = new JButton(icon);
		button.setBorderPainted(false);          
		button.setContentAreaFilled(false);      
		button.setFocusPainted(false);
		button.setOpaque(false);
		button.addActionListener(listener);
		return button;
	}
	
	private JPanel createColumn(JButton one, JButton two){
		JPanel column = new JPanel();
		column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
		column.add(one);
		column.add(two);
		column.setOpaque(false);
		return column;
	}
	
}