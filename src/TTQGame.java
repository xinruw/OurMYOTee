
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;  
import java.awt.event.KeyListener;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseMotionListener;  
import java.util.Timer;  
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;  
import javax.swing.JPanel;  
  
/* 
 * 1--窗口+面板+固定 
 * 2--在面板上画出一个小球（中央处） 
 * 3--让小球动起来 
 * 4--对小球的运动方向和方向值进行判断，并进行处理方向的修正，实现小球的反弹 
 * 5--添加脸萌并实现鼠标控制脸萌移动 
 * 6--小球碰到脸萌和没有碰到脸萌的情况处理 
 *  
 */  
public class TTQGame extends JFrame implements MouseMotionListener{  

	private static final long serialVersionUID = 1L;  
    private int fw = 1000 ; //窗口的尺寸  
    private int fh = 462 ;  
    private TTQP ttqp = null ;  
    private int bx = 200 ; //球的初始位置  
    private int by = 200 ;  
    private int b2r = 40 ; //球的尺寸  
    private String direction = "right_down" ; //初始方向 右下  
    private Timer timer = new Timer();  
    private int block_x = 350 ;  //脸萌的初始位置
    private int block_y = 442 ;  
    private int block_w = 120 ;  
    private int block_h = 50 ;    
    private double speed = 1.0 ;  //速度
    private int score = 0 ;  //分数
    

    private ImageIcon image;
    private String path; // 脸萌的存储位置
    private ImageIcon img;//背景图
    private JLabel imgLabel;//背景标签
    private Container cp;
    
    /*
     * 构造函数
     */
    public TTQGame(String path) { // path是脸萌的存储位置
        this.setAlwaysOnTop(true);  
        this.setUndecorated(true);
       	this.path = path;
        
        //this.getContentPane().setBackground(Color.DARK_GRAY);  
        //layeredPane=new JLayeredPane();
       
        //创建背景的那些东西

        img = new ImageIcon("img.png");//这是背景图片
        imgLabel = new JLabel(img);//将背景图放在标签里。

        this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        //注意这里是关键，将背景标签添加到jframe的LayeredPane面板里。
      	imgLabel.setBounds(0, 0, 1000, 562);//设置背景标签的位置
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout());

        ((JPanel)cp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。

        ttqp = new TTQP();  
        this.add(ttqp);
        // layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);
        //layeredPane.add(ttqp,JLayeredPane.MODAL_LAYER);
        //this.setLayeredPane(layeredPane);
        this.setSize(fw, fh + 100);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
        this.setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseMotionListener(this);  
        this.addKeyListener(new KeyListener() {  
            @Override  
            public void keyTyped(KeyEvent e) {}  
            @Override  
            public void keyReleased(KeyEvent e) {}  
            @Override  
            public void keyPressed(KeyEvent e) {if(e.getKeyCode()==32){System.exit(0);}}});//空格键退出  
    }  
    
    class TTQP extends JPanel{  
        private static final long serialVersionUID = 1L;  
        public TTQP() {
            this.setOpaque(false);  
            timer.schedule(new TimerTask() {  
                @Override  
                public void run() {  //实现小球的移动  
                    /* 
                     * 定义好每一个方向的坐标处理 
                     */  
                    if("right_down".equalsIgnoreCase(direction)){ //右下方向的位置处理  
                        bx += speed ;  by += speed  ;  
                    }  
                    if("right_up".equalsIgnoreCase(direction)){ //右上方向的位置处理  
                        bx += speed ;  by -= speed ;  
                    }  
                    if("left_up".equalsIgnoreCase(direction)){//左上方向的位置处理  
                        bx -= speed ;  by -= speed ;  
                    }  
                    if("left_down".equalsIgnoreCase(direction)){//左下方向的位置处理  
                        bx -= speed ;  by += speed ;  
                    }  
                    /* 
                     * 定义好发生什么情况时，如何修正小球的方向 
                     */  
//                  如果小球底部y坐标值>=脸萌头部的y坐标    by + b2r >= block_y+50    
//                  并且小球底部x坐标值>=脸萌上边的x坐标    bx + b2r/2 >= block_x   
//                  并且<=脸萌上边的x坐标值+脸萌的宽度       bx + b2r/2 <= block_x + block_w          
//                  那么 正常改变方向         
//                  否则 程序停止 GAME OVER          
                    if(by + b2r >= block_y+50 && bx + b2r/2 >= block_x && bx + b2r/2 <= block_x + block_w){  
                        if("right_down".equalsIgnoreCase(direction)){ //小球来自右下  
                            direction = "right_up" ;  
                            speed += 0.5 ;  
                            score ++ ;  
                        }else{ //小球来自左下  
                            direction = "left_up" ;  
                            speed += 0.5 ;  
                            score ++;  
                        }  
                    }  
                    if(by + b2r >= fh+100){  
                        JOptionPane.showMessageDialog(ttqp, "GAME OVER !", "玩家提示信息",JOptionPane.DEFAULT_OPTION);  
                        Runtime.getRuntime().exit(0);  
                    }  
                      
                    if(bx+b2r>=fw){ //右边的判断  
                        if("right_up".equalsIgnoreCase(direction)){ //小球来自 右上  
                            direction = "left_up" ;  
                        }else{  //小球来自右下  
                            direction = "left_down" ;  
                        }  
                    }  
                    if(by<=0){ //顶边的判断  
                        if("left_up".equalsIgnoreCase(direction)){ //小球来自 左上  
                            direction = "left_down" ;  
                        }else{  //小球来自右上  
                            direction = "right_down" ;  
                        }  
                    }  
                    if(bx<=0){ //左边的判断  
                        if("left_up".equalsIgnoreCase(direction)){ //小球来自 左上  
                            direction = "right_up" ;  
                        }else{  //小球来自左下  
                            direction = "right_down" ;  
                        }  
                    }  
                    TTQP.this.repaint() ;  
                }  
            }, 0 , 10) ;  
        }  
        @Override  
        public void paint(Graphics g) {  
            g.setColor(Color.WHITE);//球的颜色  
            g.fillOval(bx, by, b2r, b2r);  //画球
              
            super.paintComponent(g);
            image = new ImageIcon(path); //脸萌图片 
            Image imop = image.getImage();
            g.drawImage(imop, block_x, block_y, block_w, block_h+100,this); //画出脸萌图片               
            g.setColor(Color.RED) ;  
            g.drawString("SCORE : " + score, 20, 20) ;  //显示分数
        }  
    }  
    
    public static void main(String[] args) {  
        new TTQGame("C:\\Users\\wxr302124\\Desktop\\myFacu.png");  
    }  
    
    @Override  
    public void mouseDragged(MouseEvent e) { //拖拽方法 实现控制脸萌的移动  
        block_x = e.getX();  
        if (block_x <=0){  
            block_x = 0 ;  
        }  
        if (block_x+block_w >=fw){  
            block_x = fw-block_w ;  
        }  
        this.repaint() ;  
    }  
    
    @Override  
    public void mouseMoved(MouseEvent e) {}  
}
