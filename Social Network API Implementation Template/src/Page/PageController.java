package Page;

class PageController {
    static PageController object=null;
    private PageController(){}
    public static PageController getInstance(){
        if(object==null)object=new PageController();
        return object;
    }
    void createPage(String name,int userId){}
    void addFollower(PageEntity pageEntity,int userId){}

}
