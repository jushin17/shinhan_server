package testpackage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
 
/**
 * GCM UTIL
 * 
 * gcm-server.jar, json-simple-1.1.1.jar �ʿ�
 * 
 * @author 
 *
 */
public class GCMUtil {
    static final String API_KEY = "AIzaSyC7_ap-iljehkO6WRGfo4v03XfvDAnoQeE"; // server api key
    private static final int MAX_SEND_CNT = 999; // 1ȸ �ִ� ���� ���� ��
    
    // android ���� ���� extra key (android app �� �����ؾ� ��)
    static final String TITLE_EXTRA_KEY = "TITLE";
    static final String MSG_EXTRA_KEY = "MSG";
    static final String TYPE_EXTRA_CODE = "TYPE_CODE";
    // android ���� ���� extras key 
 
    List<String> resList = null;
    private Sender sender;
    private Message message;
    
    public ArrayList<GCMVo> rtnList;
 
    /**
     * GCM Util ������
     * RegistrationId ����, sender ����, message ����
     * 
     * @param reslist : RegistrationId
     * @param gcmVo : msg ����
     */
    public GCMUtil(List<String> reslist, GCMVo gcmVo) {
        sender = new Sender(API_KEY);
        this.resList = reslist;
        setMessage(gcmVo);
        rtnList = new ArrayList<GCMVo>();
        sendGCM();
    }
 
    /**
     * �޽��� ����
     * @param gcmVo
     */
    private void setMessage(GCMVo gcmVo) {
        Builder builder = new Message.Builder();
        builder.addData(TITLE_EXTRA_KEY, gcmVo.getTitle());
        builder.addData(MSG_EXTRA_KEY, gcmVo.getMsg());
        builder.addData(TYPE_EXTRA_CODE, gcmVo.getTypeCode());
        message = builder.build();
    }
 
    /**
     * �޽��� ����
     */
    private void sendGCM() {
        if (resList.size() > 0) {
            if (resList.size() <= MAX_SEND_CNT) { // �ѹ��� 1000�Ǹ� ���� �� ����
                sendMultivastResult(resList);
            } else {
                List<String> resListTemp = new ArrayList<String>();
                for (int i = 0; i < resList.size(); i++) {
                    if ((i + 1) % MAX_SEND_CNT == 0) {
                        sendMultivastResult(resListTemp);
                        resListTemp.clear();
                    }
                    resListTemp.add(resList.get(i));
                }
 
                // 1000�Ǿ� ������ ���� �� ������
                if(resListTemp.size() != 0){
                        sendMultivastResult(resListTemp);
                }
            }
        }
 
    }
 
    /**
     * ���� ��Ƽ �޽��� ����
     * 
     * @param list
     */
    private void sendMultivastResult(List<String> list) {
        try {
            
            MulticastResult multiResult = sender.send(message, list, 5); // �߼��� �޽���, �߼��� Ÿ��(RegistrationId), Retry Ƚ��
            List<Result> resultList = multiResult.getResults();
            
            
            for (int i=0; i<resultList.size(); i++){
                Result result = resultList.get(i);
 
                // ��� ����
                GCMVo rtnGcmVo = new GCMVo();
                rtnGcmVo.setRegId(list.get(i));
                rtnGcmVo.setMsgId(result.getMessageId());
                rtnGcmVo.setErrorMsg(result.getErrorCodeName());
            
                if (result.getMessageId() != null) { // ���� ����
                    rtnGcmVo.setPushSuccessOrFailure(true);
                } else { // ���� ����
                    rtnGcmVo.setPushSuccessOrFailure(false);
                }
                
                rtnList.add(rtnGcmVo);
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}