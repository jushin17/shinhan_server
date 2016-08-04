package testpackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
 
public class GCMVo {
    // android �� ���� ����
    private String title = "Push";
    private String msg = "push testtestest";
    private String typeCode = "�ڵ��Դϴ�.";
    
    // push ��� ����
    private String regId; // regId
    private boolean pushSuccessOrFailure; // ���� ����
    private String msgId = ""; // �޽��� ID
    private String errorMsg = ""; // �����޽���
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) throws UnsupportedEncodingException {
        this.title = URLEncoder.encode(title, "UTF-8");
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) throws UnsupportedEncodingException {
        this.msg = URLEncoder.encode(msg, "UTF-8");
    }
 
    public String getTypeCode() {
        return typeCode;
    }
 
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
 
    public boolean getPushSuccessOrFailure() {
        return pushSuccessOrFailure;
    }
 
    public void setPushSuccessOrFailure(boolean pushSuccessOrFailure) {
        this.pushSuccessOrFailure = pushSuccessOrFailure;
    }
 
    public String getErrorMsg() {
        return errorMsg;
    }
 
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
 
    public void setRegId(String regId) {
        this.regId = regId;
    }
 
    public String getMsgId() {
        return msgId;
    }
 
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
 
    public String getRegId() {
        return regId;
    }
    
    
    
}