package Post;

import java.util.ArrayList;

class GroupPostController implements IPostController{
    static GroupPostController object=null;
    private GroupPostController(){}
    public static GroupPostController getInstance(){
        if(object==null)object=new GroupPostController();
        return object;
    }

    @Override
    public void createPost(String content, int userId) {

    }

    @Override
    public ArrayList<IPostEntity> getPosts(int groupId) {
        return null;
    }
}
