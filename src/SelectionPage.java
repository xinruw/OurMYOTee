import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectionPage extends JFrame {

	/* 性别 */
	final int BOY = 0;
	final int GIRL = 1;
	
	private JPanel contentPane;
	private ImageIcon icBoy;
	private ImageIcon icGirl;
	private JButton btnBoy;
	private JButton btnGirl;
	private int sex; // 性别
	private JLabel back;
	private ImageIcon icback;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionPage frame = new SelectionPage();
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
	public SelectionPage() {
		this.sex = 0;
		setTitle("OurMYOTee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1028, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		icBoy = new ImageIcon("bt_man_up.png");
		icGirl = new ImageIcon("bt_woman_up.png");
		/*	
		lblBoy = new JLabel("");
		
		lblBoy.setIcon(icBoy);
		lblBoy.setBounds(190, 72, 200, 200);
		contentPane.add(lblBoy);
		
		lblGirl = new JLabel("");
		
		lblGirl.setIcon(icGirl);
		lblGirl.setBounds();
		contentPane.add(lblGirl);
		*/
		back = new JLabel("");
		icback = new ImageIcon("b2.png");
		back.setIcon(icback);
		back.setBounds(0,0,1010,700);
		contentPane.add(back);
		
		btnBoy = new JButton("");
		btnBoy.setIcon(icBoy);
		btnBoy.setBounds(310, 95, 200, 200);
		contentPane.add(btnBoy);
		
		btnGirl = new JButton("");
		btnGirl.setIcon(icGirl);
		btnGirl.setBounds(510, 95, 200, 200);
		contentPane.add(btnGirl);
		
		
		
		btnBoy.addActionListener((event)->{
			sex = BOY;
			this.setVisible(false);
			MainPage mpBoy = new MainPage(sex);
			mpBoy.setVisible(true);
		});
		btnGirl.addActionListener((event)->{
			sex = GIRL;
			this.dispose();
			MainPage mpGirl = new MainPage(sex);
			mpGirl.setVisible(true);
		});		
	}
}
