package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelos.ChatMessage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ChatPanel extends JPanel {
	private ChatMessage chatData;
	private JTextField usernameText;
	private JTable chat;
	/**
	 * Create the panel.
	 */
	public ChatPanel(ChatMessage chatData) {
		this.chatData=chatData;
		setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, "name_39712233652616");
		panel.setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setHorizontalAlignment(SwingConstants.CENTER);
		usernameText.setBounds(32, 246, 264, 22);
		panel.add(usernameText);
		usernameText.setColumns(10);
		
		JButton sendButton = new JButton("Send");
		sendButton.setBounds(309, 246, 97, 21);
		panel.add(sendButton);
		sendButton.addActionListener(e->System.out.println());
		sendButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int option = e.getKeyChar();
				switch (option) {
				case KeyEvent.VK_ENTER:
					break;
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 33, 374, 200);
		panel.add(scrollPane);
		
		chat = new JTable();
		scrollPane.setViewportView(chat);
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnCount(1);
		tableModel.setRowCount(0);

	}
}
