package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.json.JSONObject;
import java.awt.CardLayout;

public class LoginPanel extends JPanel {
	private JSONObject chatData;
	private JPanel framePane;
	private JTextField usernameText;

	/**
	 * Create the panel.
	 */
	public LoginPanel(JSONObject chatData) {
		this.chatData = chatData;
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, "name_39332892635125");
		panel.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setHorizontalAlignment(SwingConstants.CENTER);
		usernameText.setColumns(10);
		usernameText.setBounds(127, 160, 197, 22);
		panel.add(usernameText);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(181, 194, 97, 25);
		panel.add(enterButton);
		enterButton.addActionListener(e->beginChat());
		usernameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int option = e.getKeyChar();
				switch (option) {
				case KeyEvent.VK_ENTER:
					beginChat();
					break;
				}
			}
		});
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(144, 109, 166, 16);
		panel.add(usernameLabel);
	}
	
	private void beginChat() {
		chatData.put("username", usernameText.getText());
		ChatFrame.changePanel(new ChatPanel(chatData));
	}

}
