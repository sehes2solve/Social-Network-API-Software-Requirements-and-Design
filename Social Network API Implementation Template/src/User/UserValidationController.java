package User;

class UserValidationController {

    static UserValidationController object=null;
    private UserValidationController(){}
    public static UserValidationController getInstance(){
        if(object==null)object=new UserValidationController();
        return object;
    }
    // checks if this user is in the database
    boolean login(String email){
        return IUserEntity.getUserByEmail(email) != null;
    }

    // this validats the data before registering the user
    boolean signUp(String name,String email,String password){
        if(!email.contains("@") || name.length()>20 || password.length()<8
            ){
            return false;
        }
        return true;
    }
}
