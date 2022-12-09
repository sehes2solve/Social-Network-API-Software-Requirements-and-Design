package Group;

import java.util.ArrayList;

public class GroupView {
    private static GroupView object=null;
    private GroupView(){}
    public static GroupView getInstance(){
        if(object==null)object=new GroupView();
        return object;
    }
    public void createGroup(String name,int userId){}
    public void addMember(int groupId,int userId){}
    public ArrayList<PendingRequest> getPendingRequests(int groupId){
        return null;
    }
    public void acceptPendingRequest(int pendingRequestId){}
    public void denyPendingRequest(int pendingRequestId){}
}
