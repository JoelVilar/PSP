package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelos.ChatMessage;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ChatFrame extends JFrame {

	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void launchFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		changePanel(new LoginPanel(new ChatMessage()));
	}
	
	public static void changePanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.repaint();
		contentPane.revalidate();
		contentPane.setBounds(100, 100, 650, 743);
	}
}
