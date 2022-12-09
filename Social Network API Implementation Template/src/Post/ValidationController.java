package Post;

class ValidationController {
    static ValidationController object=null;
    private ValidationController(){}
    public static ValidationController getInstance(){
        if(object==null)object=new ValidationController();
        return object;
    }
    boolean isPremium(int userId){
        return true;
    }
    // checks if that user is the admin of this page
    boolean pageAdmin(int userId,int pageId){
        return true;
    }
}
