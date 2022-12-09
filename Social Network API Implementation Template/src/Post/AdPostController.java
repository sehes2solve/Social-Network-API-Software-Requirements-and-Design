package Post;

import java.util.ArrayList;

class AdPostController implements IPostController {
    static AdPostController object=null;
    private AdPostController(){}
    public static AdPostController getInstance(){
        if(object==null)object=new AdPostController();
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
