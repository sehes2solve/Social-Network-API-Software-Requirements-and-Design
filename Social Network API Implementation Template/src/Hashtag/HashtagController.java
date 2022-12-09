package Hashtag;

import java.util.ArrayList;

class HashtagController {
    static HashtagController object=null;
    private HashtagController(){}
    public static HashtagController getInstance(){
        if(object==null)object=new HashtagController();
        return object;
    }
    void createHashtag(String name,int postId){}
    ArrayList<HashtagEntity> getHashtags(int postId){return null;}

    // gets the IDs of the posts with this hashtag
    ArrayList<Integer> getPosts(String hashtag){return null;}
}
