package User;

import org.hsqldb.User;

import java.util.ArrayList;

public class UserView {
    static UserView object=null;
    UserController controller=UserController.getInstance();
    private UserView(){}
    public static UserView getInstance(){
        if(object==null)object=new UserView();
        return object;
    }
    public ArrayList<Integer> getPendingFriendRequests(int userId){
        return controller.getPendingFriendRequests(userId);
    }
    public ArrayList<Integer> getFriends(int userId){
        return controller.getFriends(userId);
    }
    public IUserEntity getUserById(int id){
        return controller.getUserById(id);
    }
    public void acceptFriendRequest(int user1Id,int user2Id){
        controller.acceptFriendRequest(user1Id,user2Id);
    }
    public boolean createUser(String name,String pass,String email,String date
            ,String birthdate,String country,boolean gender){
        return controller.createUser(name, pass, email, date, birthdate, country,gender);
    }
    public IUserEntity login(String email,String password){
        return controller.login(email,password);
    }
    public IUserEntity getLoggedUser(){
        return controller.getLoggedUser();
    }
    public void sendFriendRequest(int senderId,int recieverId){
        controller.sendFriendRequest(senderId, recieverId);
    }
    public void upgrade(int userId,String creditCard){
        controller.upgrade(userId,creditCard);
    }
    public IUserEntity searchByEmail(String email){
        return controller.searchByEmail(email);
    }
    public ArrayList<IUserEntity> searchByName(String name){
        return controller.searchByName(name);
    }
    public void downgrade(PremiumUserEntity user){}
}
