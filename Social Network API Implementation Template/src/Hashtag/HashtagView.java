package Hashtag;

import java.util.ArrayList;

public class HashtagView {
    static HashtagView object=null;
    private HashtagView(){}
    public static HashtagView getInstance(){
        if(object==null)object=new HashtagView();
        return object;
    }
    void createHashtag(String name,int postId){}
    ArrayList<HashtagEntity> getHashtags(int postId){return null;}

    // gets the IDs of the posts with this hashtag
    ArrayList<Integer> getPosts(String hashtag){return null;}
}
