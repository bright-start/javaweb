package jFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JSpinner;

public class example extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					example frame = new example();
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
	public example() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(5, 5, 0, 251);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(25, 10, 32, 21);
		contentPane.add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(78, 9, 103, 23);
		contentPane.add(chckbxNewCheckBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(153, 38, 125, 21);
		contentPane.add(passwordField);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(30, 66, 6, 21);
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(81, 85, 54, 15);
		contentPane.add(lblNewLabel);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(361, 121, 17, 86);
		contentPane.add(scrollBar);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(14, 207, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(40, 10, 6, 21);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(40, 5, 6, 21);
		contentPane.add(textPane_2);
		
		JSlider slider = new JSlider();
		slider.setBounds(89, 155, 200, 26);
		contentPane.add(slider);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(288, 242, 146, 19);
		contentPane.add(progressBar);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(288, 100, 29, 22);
		contentPane.add(spinner);
	}
}
