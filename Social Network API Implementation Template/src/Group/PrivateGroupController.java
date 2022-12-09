package Group;

import java.util.ArrayList;

class PrivateGroupController implements IGroupController{
    static PrivateGroupController object=null;
    private PrivateGroupController(){}
    public static PrivateGroupController getInstance(){
        if(object==null)object=new PrivateGroupController();
        return object;
    }

    public ArrayList<PendingRequest> getPendingRequests(int groupId){
        return null;
    }
    public void acceptPendingRequest(int pendingRequestId){}
    public void denyPendingRequest(int pendingRequestId){}

    @Override
    public void createGroup(String name, int userId) {

    }

    @Override
    public void addMember(int groupId, int userId) {

    }
}
