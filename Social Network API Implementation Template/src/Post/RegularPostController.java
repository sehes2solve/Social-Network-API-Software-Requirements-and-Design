package Post;

import java.util.ArrayList;

class RegularPostController implements IPostController{
    static RegularPostController object=null;
    private RegularPostController(){}
    public static RegularPostController getInstance(){
        if(object==null)object=new RegularPostController();
        return object;
    }

    @Override
    public void createPost(String content, int userId) {

    }

    @Override
    public ArrayList<IPostEntity> getPosts(int userId) {
        return null;
    }
}
