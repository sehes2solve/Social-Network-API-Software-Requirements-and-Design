package Post;

import java.util.ArrayList;

class PagePostController implements IPostController{
    static PagePostController object=null;
    private PagePostController(){}
    public static PagePostController getInstance(){
        if(object==null)object=new PagePostController();
        return object;
    }

    @Override
    public void createPost(String content, int pageId) {

    }

    @Override
    public ArrayList<IPostEntity> getPosts(int pageId) {
        return null;
    }
}
