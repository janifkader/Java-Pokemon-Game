import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class GUI implements MouseListener, ActionListener{
	JFrame frame;
	JPanel panel;
	JButton button;
	JButton start;
	JButton aButton;
	Clip clip;
	BackgroundPanel bgPanel;
	
	public GUI() throws Exception {
		frame = new JFrame();
		
		panel = new JPanel(new CardLayout());
		panel.add(new SelectScreen(this), "Select");
		bgPanel = new BackgroundPanel("/images/home.png");
		
		BackgroundPanel gameboy = new BackgroundPanel("/images/gameboy.png");
		gameboy.setPreferredSize(new Dimension(670, 400));
		bgPanel.setBounds(54, 64, 414, 222);
		panel.setBounds(54, 64, 414, 222);
		panel.add(bgPanel, "BG");
		start = new JButton();
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.setFocusPainted(false);
		start.setText("");
		start.setIcon(null);
		start.setEnabled(true);
		start.setVisible(true);  
		start.addActionListener(this);
		start.setBounds(330, 375, 50, 50);
		aButton = new JButton();
		aButton.setBounds(418, 355, 55, 55);
		aButton.setOpaque(false);
		aButton.setContentAreaFilled(false);
		aButton.setBorderPainted(false);
		aButton.setFocusPainted(false);
		aButton.setText("");
		aButton.setIcon(null);
		aButton.setEnabled(true);
		aButton.setVisible(true);  
		aButton.addActionListener(this);
		JLabel pressB = new JLabel("Press B to Quit");
		pressB.setBounds(190, 500, 200, 100);
		JLabel pressA = new JLabel("Press A to Restart");
		pressA.setBounds(180, 520, 200, 100);
		pressB.setForeground(Color.WHITE);
		pressA.setForeground(Color.WHITE);

		gameboy.add(panel);
		gameboy.add(start);
		gameboy.add(aButton);
		gameboy.add(pressB);
		gameboy.add(pressA);
		
		frame.add(gameboy);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pokemon Clone");;
		frame.setUndecorated(true); 
	    showPanel("BG");
	    frame.setSize(new Dimension(520, 600));
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.addMouseListener(this);
	    
	    clip = playMusic("/music/eterna.wav");
	}
	
	public void showPanel(String code) {
		CardLayout cards = (CardLayout)(panel.getLayout());
		cards.show(panel, code);
		frame.setLocationRelativeTo(null);
		System.out.println(frame.getSize());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			playSound("/fx/click.wav");
			this.frame.dispose();
		}
		if (e.getSource() == aButton) {
			playSound("/fx/click.wav");
			showPanel("Select");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		showPanel("Select");
		Component c = e.getComponent();
        c.removeMouseListener(this);
	}
	
	public static void main(String[] args) {
		try {
			new GUI();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Clip playMusic(String song) throws Exception {
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(SelectScreen.class.getResource(song));
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f);
		clip.start();
		return clip;
	}
	
	public static void playSound(String sound) {
		try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(SelectScreen.class.getResource(sound));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } 
		catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
