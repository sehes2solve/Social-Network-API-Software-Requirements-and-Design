package Post;

public class PostView {
    static PostView object=null;
    private PostView(){}
    public static PostView getInstance(){
        if(object==null)object=new PostView();
        return object;
    }
    public void createRegPost(String content,int userId){}
    public void createGroupPost(String content,int userId,int groupId){}
    public void createAdPost(String content,int userId){}
    public void createPagePost(String content,int pageId){}
}
