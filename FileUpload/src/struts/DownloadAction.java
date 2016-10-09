package struts;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class DownloadAction extends ActionSupport {  

    // 下载路径
    private String downloadPath;  

    // 下载文件的文件名
    private String filename;  

    public String getFilename() {  
           return filename;  
    }  

    public void setFilename(String filename) {  
           this.filename = filename;  
    }  

    public void setDownloadPath(String downloadPath){  
           this.downloadPath = downloadPath;  
    }  


	public InputStream getTargetFile() throws FileNotFoundException  {  
	    // 获得下载文件的真实路径
	    String realPath = downloadPath + "/" + getFilename();
	
	    // 返回下载文件对应的输入流  
	    return ServletActionContext.getServletContext().getResourceAsStream(realPath);
	}  
	
	public String execute() {  
	    return "success";  
	}  

}