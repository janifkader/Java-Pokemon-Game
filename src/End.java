import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class End extends JPanel {
	JPanel frame;
	JLabel label;
	String victory;
	private static final long serialVersionUID = 1L;
	
	public End(GUI gui, String victory) {
		this.victory = victory;
		BackgroundPanel bgPanel = new BackgroundPanel("/images/end.jpg");
		bgPanel.setLayout(new BorderLayout());
		label = new JLabel("You " + victory + " !");
		label.setFont(new Font("Rockwell", Font.BOLD, 40));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		setLayout(new BorderLayout());
		bgPanel.add(label, BorderLayout.CENTER);
		add(bgPanel);
		setBackground(Color.BLACK);
	}
}
