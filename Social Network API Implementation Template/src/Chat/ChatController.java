package Chat;

import java.util.ArrayList;

class ChatController {
    private static ChatController object=null;
    private ChatController(){}
    public static ChatController getInstance(){
        if(object==null)object=new ChatController();
        return object;
    }
    public void sendMsg(int sender_id,int reciever_id,String content){
        // this method adds the method in the chat notification table
    }
    public ArrayList<ChatEntity> getMsgs(int user1_id, int user2_id){
        return null;
    }
    public ArrayList<ChatNotification> getNotifications(int user_id){
        // after getting notifications they will be deleted from
        // the table and added in the chat entity table
        return null;
    }
}
