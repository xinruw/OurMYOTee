import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(null
				);
		frame.setBounds(100, 100, 781, 696);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon icon1 = new ImageIcon("C:\\Java programming\\MYOTee\\src\\pic_s1_0.png");
		ImageIcon icon2 = new ImageIcon("C:\\Java programming\\MYOTee\\src\\pic_rs1_25.png");
		ImageIcon icon3 = new ImageIcon("C:\\Java programming\\MYOTee\\src\\pic_s3_1.png");
	
		icon3.setImage(icon3.getImage().getScaledInstance(50,100,Image.SCALE_DEFAULT));
		
		JButton button1 = new JButton("");
		button1.setBounds(28, 15, 115, 106);
		button1.setIcon(icon1);
		frame.getContentPane().add(button1);
		
		JLabel label2 = new JLabel("");
		label2.setBounds(350, 68, 315, 260);
		label2.setLocation(0, 0);
		
		JLabel label = new JLabel("");
		label.setBounds(50, 29, 241, 216);
		label2.setLocation(50, 0);
		
		JButton button2 = new JButton("");
		button2.setBounds(38, 137, 115, 92);
		button2.setIcon(icon2);
		frame.getContentPane().add(button2);
		
		JButton button3 = new JButton("");
		button3.setBounds(15, 254, 153, 106);
		button3.setIcon(icon3);
		frame.getContentPane().add(button3);
		
		JPanel panel = new JPanel();
		panel.setBounds(348, 68, 317, 260);
		panel.setBackground(null);
		panel.setLayout(null); // 使用自定义的位置（setLocation）
		frame.getContentPane().add(panel);
		panel.add(label2);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 349, 408, 260);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		JButton[] btns = new JButton[20];
		for (int i=0;i<20;i++){
			btns[i]=new JButton("1");
			btns[i].setPreferredSize(new Dimension(10,150));
			panel_1.add(btns[i]);
		}	
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setIcon(icon1);
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label2.setIcon(icon2);
			}
		});
		
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label2.setIcon(icon3);
				Dimension imageSize = panel.getSize();
			    BufferedImage image = new BufferedImage(imageSize.width,
			            imageSize.height, BufferedImage.TYPE_INT_ARGB);
			    Graphics2D g = image.createGraphics();
			    File f = new File("C:\\Java programming\\MYOTee\\src\\1.png");
			    panel.paint(g);
			    g.dispose();
			    try {
			        ImageIO.write(image, "png", f);
			    } catch (IOException e1) {}
			}
		});
		
		
	}
}
