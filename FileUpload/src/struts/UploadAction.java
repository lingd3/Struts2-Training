package struts;

import java.io.File;  

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;  

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  

public class UploadAction extends ActionSupport {  

    private static final long serialVersionUID = 1L; 

    // 上传文件者
    private String uploader;  
    // 上传的文件
    private File upload;  
    // 上传文件类型
    private String uploadContentType;  
    // 上传文件的文件名
    private String uploadFileName;  
    // 上传文件的保存路径
    private String savePath;  

    public String execute() throws Exception{

        // 设置上传文件保存路径
        String realpath = getSavePath();

        // 判断上传文件是否为空
        if (upload != null)  {

            // 根据路径以及文件名，新建一个File文件实例
            File savefile = new File(realpath, getUploadFileName());

            // 判断此路径是否已经存在
            if ( !savefile.getParentFile().exists() )
                savefile.getParentFile().mkdirs();

            // 把上传文件拷贝到新路径下，完成上传
            FileUtils.copyFile(upload, savefile);

            // 设置request对象值，表示上传成功
            ActionContext.getContext().put("message", "upload succeed!");

            return "success"; 

        }

         // 其他情况，上传失败
         return "error";

    }  

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public File getUpload() {  
        return upload;  
    }  

    public void setUpload(File upload) {  
        this.upload = upload;  
    }  

    public String getUploadContentType() {  
        return uploadContentType;  
    }  

    public void setUploadContentType(String uploadContentType) {  
        this.uploadContentType = uploadContentType;  
    }  

    public String getUploadFileName() {  
        return uploadFileName;  
    }  

    public void setUploadFileName(String uploadFileName) {  
        this.uploadFileName = uploadFileName;  
    }  

    public String getSavePath() {  

        return ServletActionContext.getServletContext().getRealPath(savePath);  
    }  

    public void setSavePath(String savePath) {  
        this.savePath = savePath;  
    }  

}