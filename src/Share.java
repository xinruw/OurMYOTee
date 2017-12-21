
public class Share {
	public Share () { 
		if(java.awt.Desktop.isDesktopSupported()){  
	        try{  
	            //创建一个URI实例,注意不是URL  
	            java.net.URI uri=java.net.URI.create("http://weibo.com");  
	            //获取当前系统桌面扩展  
	            java.awt.Desktop dp=java.awt.Desktop.getDesktop();  
	            //判断系统桌面是否支持要执行的功能  
	            if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){  
	                //获取系统默认浏览器打开链接  
	                dp.browse(uri);  
	            }  
	        }catch(java.lang.NullPointerException e){  
	            //此为uri为空时抛出异常  
	        }catch(java.io.IOException e){  
	            //此为无法获取系统默认浏览器  
	        }  
	    }  
	}
}
