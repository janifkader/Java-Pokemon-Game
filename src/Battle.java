import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class Battle extends JPanel implements ActionListener{
	private GUI gui;
	Fighter user_mon;
	Fighter opp_mon;
	JPanel frame;
	JPanel bot_panel;
	JPanel poke_panel;
	JPanel move_panel;
	JPanel text_panel;
	JPanel stat_panel;
	JPanel health_panel;
	JLabel move_used;
	JLabel user_pokemon;
	JLabel opp_pokemon;
	JLabel stat_used;
	JButton move1;
	JButton move2;
	JButton move3;
	JButton move4;
	JProgressBar user_health;
	JProgressBar opp_health;
	boolean goingUp = true;
	boolean isJumping = false;
	private int jumpHeight = 5;
    private int step = 2;
    private int offset = 0;
    private static final long serialVersionUID = 1L;
	
	public Battle(GUI gui, Fighter user_mon, Fighter opp_mon) {
		this.gui = gui;
		this.user_mon = user_mon;
		this.opp_mon = opp_mon;
		//frame.setResizable(false);
		
		bot_panel = new JPanel();
		bot_panel.setBorder(BorderFactory.createEmptyBorder(5, 30, 10, 30));
		bot_panel.setLayout(new CardLayout());
		
		poke_panel = new JPanel();
		poke_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		poke_panel.setLayout(new GridLayout(1, 2));
		user_pokemon = new JLabel(new ImageIcon(getClass().getResource(user_mon.back_sprite)));
		opp_pokemon = new JLabel(new ImageIcon(getClass().getResource(opp_mon.sprite)));
		poke_panel.add(user_pokemon);
		poke_panel.add(opp_pokemon);
		poke_panel.setOpaque(false);
		
		move_panel = new JPanel();
		move_panel.setBorder(BorderFactory.createEmptyBorder(5, 30, 10, 30));
		move_panel.setLayout(new GridLayout(2, 2));
		move1 = createButton(user_mon.moveset.get(0));
		move2 = createButton(user_mon.moveset.get(1));
		move3 = createButton(user_mon.moveset.get(2));
		move4 = createButton(user_mon.moveset.get(3));
		move_panel.add(move1);
		move_panel.add(move2);
		move_panel.add(move3);
		move_panel.add(move4);
		move_panel.setOpaque(false);
		
		text_panel = new JPanel();
		text_panel.setBorder(BorderFactory.createEmptyBorder(5, 30, 10, 30));
		text_panel.setLayout(new GridLayout(1, 1));
		move_used = new JLabel("");
		text_panel.add(move_used);
		
		stat_panel = new JPanel();
		stat_panel.setBorder(BorderFactory.createEmptyBorder(5, 30, 10, 30));
		stat_panel.setLayout(new GridLayout(1, 1));
		stat_used = new JLabel("");
		stat_panel.add(stat_used);
		
		bot_panel.add(move_panel, "Moves");
		bot_panel.add(text_panel, "Used");
		bot_panel.add(stat_panel, "Stat");
		bot_panel.setOpaque(false);
		
		health_panel = new JPanel();
		health_panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 5, 30));
		health_panel.setLayout(new GridLayout(1, 2));
		user_health = new JProgressBar(0, (int)user_mon.stats.get(0).value);
		user_health.setValue((int)user_mon.stats.get(0).value);
		user_health.setStringPainted(true);
		opp_health = new JProgressBar(0, (int)opp_mon.stats.get(0).value);
		opp_health.setValue((int)opp_mon.stats.get(0).value);
		opp_health.setStringPainted(true);
		opp_health.setForeground(Color.RED);
		health_panel.add(user_health);
		health_panel.add(opp_health);
		health_panel.setOpaque(false);

		
		BackgroundPanel bgPanel = new BackgroundPanel("/images/battle.jpg");
		bgPanel.setLayout(new BorderLayout());
		bgPanel.add(poke_panel, BorderLayout.NORTH);
		bgPanel.add(health_panel, BorderLayout.CENTER);
		bgPanel.add(bot_panel, BorderLayout.SOUTH);
		setLayout(new BorderLayout());
		add(bgPanel, BorderLayout.NORTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == move1) {
			if (user_mon.stats.get(3).value >= opp_mon.stats.get(3).value) {
				handleMove(0, opp_mon.chooseMove(user_mon), user_mon, opp_mon, 0);
			}
			else {
				handleMove(opp_mon.chooseMove(user_mon), 0, opp_mon, user_mon, 0);
			}
		}
		else if (e.getSource() == move2) {
			if (user_mon.stats.get(3).value >= opp_mon.stats.get(3).value) {
				handleMove(1, opp_mon.chooseMove(user_mon), user_mon, opp_mon, 0);
			}
			else {
				handleMove(opp_mon.chooseMove(user_mon), 1, opp_mon, user_mon, 0);
			}
		}
		else if (e.getSource() == move3) {
			if (user_mon.stats.get(3).value >= opp_mon.stats.get(3).value) {
				handleMove(2, opp_mon.chooseMove(user_mon), user_mon, opp_mon, 0);
			}
			else {
				handleMove(opp_mon.chooseMove(user_mon), 2, opp_mon, user_mon, 0);
			}
		}
		else if (e.getSource() == move4) {
			if (user_mon.stats.get(3).value >= opp_mon.stats.get(3).value) {
				handleMove(3, opp_mon.chooseMove(user_mon), user_mon, opp_mon, 0);
			}
			else {
				handleMove(opp_mon.chooseMove(user_mon), 3, opp_mon, user_mon, 0);
			}
		}
	}
	
	public JButton createButton(Move move) {
		JButton button = new JButton(move.name);
		button.setBackground(move.type.color);
		button.setForeground(Color.WHITE);
		button.addActionListener(this);
		button.setFocusPainted(false);
		return button;
	}
	
	private void handleMove(int user_move, int opp_move, Fighter user, Fighter opp, int i) {
	    CardLayout cards = (CardLayout)(bot_panel.getLayout());
	    move_used.setText(user.name + " Used " + user.moveset.get(user_move).name + "!");
	    cards.show(bot_panel, "Used");
	    user.useMove(opp, user_move);
	    new Timer(1000, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent evt) {
	        	opp_health.setValue((int)Math.ceil(opp_mon.stats.get(0).value));
	            opp_health.setStringPainted(true);
	            user_health.setValue((int)Math.ceil(user_mon.stats.get(0).value));
	            user_health.setStringPainted(true);
	            goingUp = true;
	            int originalY = (user == user_mon) ? user_pokemon.getY() : opp_pokemon.getY();
	            Timer jumpTimer = new Timer(15, null); // ~60 FPS
	            jumpTimer.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	playEffect(user.moveset.get(user_move));
	                    if (goingUp) {
	                        offset -= step;
	                        if (offset <= -jumpHeight) {
	                            goingUp = false;
	                        }
	                    } else {
	                        offset += step;
	                        if (offset >= 0) {
	                            offset = 0;
	                            isJumping = false;
	                            goingUp = true;
	                            ((Timer) e.getSource()).stop(); // stop when done
	                        }
	                    }

	                    if (user == user_mon) {
	                        user_pokemon.setLocation(user_pokemon.getX(), originalY + offset);
	                    } else {
	                        opp_pokemon.setLocation(opp_pokemon.getX(), originalY + offset);
	                    }
	                }
	            });
	            jumpTimer.start();
	        
	            
	            ((Timer) evt.getSource()).stop();

	            if (user.stats.get(0).value <= 0 || opp.stats.get(0).value <= 0) {
	            	if (user.stats.get(0).value <= 0) {
	            		stat_used.setText(user_mon.name + " fainted!");
            			cards.show(bot_panel, "Stat");
            			stat_used.repaint();
            			bot_panel.revalidate();
            			bot_panel.repaint();
	            	}
	            	if (opp_mon.stats.get(0).value <= 0) {
	            		stat_used.setText(opp_mon.name + " fainted!");
            			cards.show(bot_panel, "Stat");
            			stat_used.repaint();
            			bot_panel.revalidate();
            			bot_panel.repaint();
	            	}
	                new Timer(1500, new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent evt2) {
	                        if (user_mon.stats.get(0).value <= 0) {
	                        	gui.panel.add(new End(gui, "Lost"), "End");
	                        	gui.showPanel("End");
	                        } else if (opp_mon.stats.get(0).value <= 0) {
	                        	gui.panel.add(new End(gui, "Won"), "End");
	                        	gui.showPanel("End");
	                        }
	                        ((Timer) evt2.getSource()).stop();
	                    }
	                }).start();
	            }
	            else {
	            	if (!user_mon.message.equals("") || !opp_mon.message.equals("")) {
	            		CardLayout cards = (CardLayout)(bot_panel.getLayout());
	            		if (!user_mon.message.equals("")) {
	            			stat_used.setText(user_mon.message);
	            			cards.show(bot_panel, "Stat");
	            			stat_used.repaint();
	            			bot_panel.revalidate();
	            			bot_panel.repaint();
        		        	user_mon.message = "";
        		        	new Timer(1000, new ActionListener() {
        		        		@Override
        		        		public void actionPerformed(ActionEvent e) {
        		        			if (i == 0) {
        		        				handleMove(opp_move, user_move, opp, user, 1);
        		        			} else if (i == 1) {
        		        				cards.show(bot_panel, "Moves");
        		        			}
        		        			((Timer) e.getSource()).stop();
        		        		}
        		        	}).start();
	            		}
	            		if (!opp_mon.message.equals("")) {
	            			stat_used.setText(opp_mon.message);
	            			cards.show(bot_panel, "Stat");
	            			stat_used.repaint();
	            			bot_panel.revalidate();
	            			bot_panel.repaint();
        		        	opp_mon.message = "";
        		        	new Timer(1000, new ActionListener() {
        		        		@Override
        		        		public void actionPerformed(ActionEvent e) {
        		        			if (i == 0) {
        		        				handleMove(opp_move, user_move, opp, user, 1);
        		        			} else if (i == 1) {
        		        				cards.show(bot_panel, "Moves");
        		        			}
        		        			((Timer) e.getSource()).stop();
        		        		}
        		        	}).start();
	            		}
	            	}
	            	else {
	            		if (i == 0) {
			            	handleMove(opp_move, user_move, opp, user, 1);
			            }
			            else if (i == 1) {
			            	cards.show(bot_panel, "Moves");
			            }
	            	}
		            ((Timer) evt.getSource()).stop();
	            }
	        }
	    }).start();
	}
	public static void playEffect(Move move) {
		try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(SelectScreen.class.getResource("/fx/" + move.name + ".wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            clip.start();
        } 
		catch (Exception e) {
            e.printStackTrace();
        }
	}
}
