package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel {
	private JTextField usernameText;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setHorizontalAlignment(SwingConstants.CENTER);
		usernameText.setBounds(130, 146, 194, 22);
		add(usernameText);
		usernameText.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(169, 117, 116, 16);
		add(lblUsername);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(179, 191, 97, 25);
		add(btnEnter);

	}

}
