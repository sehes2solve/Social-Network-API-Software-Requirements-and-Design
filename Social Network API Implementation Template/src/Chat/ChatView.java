package Chat;

import java.util.ArrayList;

public class ChatView {
    private static ChatView object=null;
    private ChatView(){}
    public static ChatView getInstance(){
        if(object==null)object=new ChatView();
        return object;
    }

    // the view will just call these methods from the controller
    public void sendMsg(int sender_id,int reciever_id,String content){

    }
    public ArrayList<ChatEntity> getMsgs(int user1_id, int user2_id){
        return null;
    }
    public ArrayList<ChatNotification> getNotifications(int user_id){
        return null;
    }
}
