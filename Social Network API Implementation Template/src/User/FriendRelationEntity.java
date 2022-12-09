package User;

import java.util.ArrayList;

class FriendRelationEntity {
    static ArrayList<FriendRelationEntity> friendRelationEntities=new ArrayList<>();
    int user1Id,user2Id;
    void save(){
        friendRelationEntities.add(this);
    }
    void delete(){
        friendRelationEntities.remove(this);
    }
    static ArrayList<Integer> getFriends(int userId){
        ArrayList<Integer> friends=new ArrayList<>();
        for(FriendRelationEntity FR:friendRelationEntities){
            if(FR.user1Id==userId)friends.add(FR.user2Id);
            if(FR.user2Id==userId)friends.add(FR.user1Id);
        }
        return friends;
    }
}
