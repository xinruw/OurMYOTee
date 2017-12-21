
import java.awt.*;
import java.io.*;  
import javax.swing.*;
public class WelcomePage extends JFrame {
	
	//创建一个容器
	Container ct;
	//创建背景面板。
	BackgroundPanel bgp;

	//创建一个按钮，用来证明我们的确是创建了背景图片，而不是一张图片。
	JButton jb;

	public static void main(String[] args) throws IOException {
		new WelcomePage(); 
		Music sound = new Music("background.wav");
		InputStream stream =new ByteArrayInputStream(sound.getSamples());
		// play the sound
		sound.play(stream);
	}
	
	public WelcomePage() {
		setTitle("OurMYOTee");
		//不采用任何布局方式。
		ct=this.getContentPane();
		this.setLayout(null);

		//在这里随便找一张400*300的照片既可以看到测试结果。
		bgp=new BackgroundPanel((new ImageIcon("bgp.png")).getImage());
		bgp.setBounds(0,0,1010,700);
		ct.add(bgp);

		//创建按钮
		Icon i = new ImageIcon("point.png");
		jb=new JButton();
		jb.setIcon(i);
		jb.setBounds(440,100,140,76);
		ct.add(jb);
		jb.addActionListener((event)->{ // 显示选择界面
			this.dispose();
			SelectionPage p = new SelectionPage();
			p.setVisible(true);
		});

		this.setSize(1028,750);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class BackgroundPanel extends JPanel {
	Image im;
	public BackgroundPanel(Image im) {
		this.im=im;
		this.setOpaque(true);
	}
	//Draw the back ground.
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	}
}