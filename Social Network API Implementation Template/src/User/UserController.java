package User;

import java.util.ArrayList;

class UserController {
    private IUserEntity loggedUser=null;
    static UserController object=null;
    private UserController(){}
    static UserController getInstance(){
        if(object==null)object=new UserController();
        return object;
    }
    IUserEntity getUserById(int id){
        return IUserEntity.getUserById(id);
    }
    // once a request is retrieved from the database it's deleted from
    // the database
    ArrayList<Integer> getPendingFriendRequests(int userId){
        return PendingRequestEntity.getPendingReq(userId);
    }
    boolean createUser(String name,String pass,String email,String date
            ,String birthdate,String country,boolean gender){
        UserValidationController valid=UserValidationController.getInstance();
        if(!valid.signUp(name,email,pass))return false;
        IUserEntity userEntity=new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(pass);
        userEntity.setEmail(email);
        userEntity.setCountry(country);
        userEntity.setBirth_date(birthdate);
        userEntity.setDate(date);
        if(gender){
            userEntity.setGender(Gender.MALE);
        }else{
            userEntity.setGender(Gender.FEMALE);
        }
        userEntity.save();
        // after creating the user we log him into the system
        loggedUser=userEntity;
        return true;
    }
    // returning null means failed to login
    IUserEntity login(String email,String password){
        UserValidationController valid=UserValidationController.getInstance();
        if(!valid.login(email))return null;
        loggedUser=IUserEntity.getUserByEmail(email);
        if(loggedUser.password.equals(password))return loggedUser;
        return null;
    }
    IUserEntity getLoggedUser(){
        return loggedUser;
    }
    void sendFriendRequest(int senderId,int recieverId){
        PendingRequestEntity PR=new PendingRequestEntity();
        PR.reciever=recieverId;
        PR.sender=senderId;
        PR.save();
    }
    void upgrade(int userId,String creditCard){
        IUserEntity user=IUserEntity.getUserById(userId);
        if(user==null)return;
        if(user instanceof PremiumUserEntity){
            // if he's already premium then do nothing
            return;
        }
        user.delete();
        PremiumUserEntity newUser=new PremiumUserEntity();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setCountry(user.getCountry());
        newUser.setDate(user.getDate());
        newUser.setEmail(user.getEmail());
        newUser.setBirth_date(user.getBirth_date());
        newUser.setCreditCard(creditCard);
        newUser.setGender(user.getGender());
        newUser.setId(user.getId());
        newUser.save();
        loggedUser=newUser;
    }
    IUserEntity searchByEmail(String email){
        return IUserEntity.getUserByEmail(email);
    }
    ArrayList<IUserEntity> searchByName(String name){
        return IUserEntity.getUserByName(name);
    }
    void downgrade(PremiumUserEntity user){}
    void acceptFriendRequest(int user1Id,int user2Id){
        FriendRelationEntity FR=new FriendRelationEntity();
        FR.user1Id=user1Id;
        FR.user2Id=user2Id;
        FR.save();
    }
    ArrayList<Integer> getFriends(int userId){
        return FriendRelationEntity.getFriends(userId);
    }
}
