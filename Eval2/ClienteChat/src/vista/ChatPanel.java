package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import modelos.ChatMessage;

import javax.swing.JButton;
import javax.swing.JTable;

public class ChatPanel extends JPanel {
	private JTextField textMessage;
	private JTable chatTable;
	private ChatMessage chatData;

	/**
	 * Create the panel.
	 */
	public ChatPanel(ChatMessage chatData) {
		this.chatData=chatData;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 48, 344, 188);
		add(scrollPane);
		
		chatTable = new JTable();
		scrollPane.setViewportView(chatTable);
		
		textMessage = new JTextField();
		textMessage.setBounds(49, 249, 265, 22);
		add(textMessage);
		textMessage.setColumns(10);
		
		JButton btnSend = new JButton("->");
		btnSend.setBounds(326, 249, 67, 22);
		add(btnSend);

	}
}
