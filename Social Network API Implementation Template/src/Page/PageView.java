package Page;

public class PageView {
    static PageView object=null;
    private PageView(){}
    public static PageView getInstance(){
        if(object==null)object=new PageView();
        return object;
    }
    void createPage(String name,int userId){}
    void addFollower(PageEntity pageEntity,int userId){}
}
