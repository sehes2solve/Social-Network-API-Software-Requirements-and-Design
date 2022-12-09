package Post;

abstract class IPostEntity {
    // this is an abstract class not interface because we have attributes
    String content="";
    int userId=0,numOfLikes=0;
    abstract void save();
}
