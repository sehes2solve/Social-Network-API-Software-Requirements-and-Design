package User;

import java.util.ArrayList;

class PendingRequestEntity {
    static ArrayList<PendingRequestEntity> pendingRequestEntities=new ArrayList<>();
    int sender,reciever;
    // once a request is retrieved from the database it's deleted from
    // the database
    static ArrayList<Integer> getPendingReq(int user){
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<PendingRequestEntity> toBeDel=new ArrayList<>();
        for(PendingRequestEntity PR:pendingRequestEntities){
            if(PR.reciever==user){
                res.add(PR.sender);
                toBeDel.add(PR);
            }
        }
        for(PendingRequestEntity pr:toBeDel){
            pendingRequestEntities.remove(pr);
        }
        return res;
    }
    void save(){
        pendingRequestEntities.add(this);
    }
    void delete(){
        pendingRequestEntities.remove(this);
    }
}
