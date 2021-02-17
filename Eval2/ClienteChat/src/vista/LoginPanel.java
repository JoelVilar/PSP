package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import modelos.ChatMessage;

public class LoginPanel extends JPanel {
	private JTextField usernameText;
	private ChatMessage chatData;
	private JPanel framePane;

	/**
	 * Create the panel.
	 */
	public LoginPanel(ChatMessage chatData) {
		this.chatData = chatData;
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
		
		btnEnter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int option = e.getKeyChar();
				switch(option) {
				case KeyEvent.VK_ENTER:
					chatData.setUsername(usernameText.getText());
					ChatFrame.changePanel(new ChatPanel(chatData));
				}
			}
		});

	}

}
