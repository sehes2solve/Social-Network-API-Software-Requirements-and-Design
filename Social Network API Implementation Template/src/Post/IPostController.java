package Post;

import java.util.ArrayList;

interface IPostController {
    void createPost(String content,int userId);
    ArrayList<IPostEntity> getPosts(int id);
    default void likePost(IPostEntity post){
        post.numOfLikes++;
        post.save();
    }
}
