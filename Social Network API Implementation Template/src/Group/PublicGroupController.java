package Group;

class PublicGroupController implements IGroupController{
    static PublicGroupController object=null;
    private PublicGroupController(){}
    public static PublicGroupController getInstance(){
        if(object==null)object=new PublicGroupController();
        return object;
    }

    @Override
    public void createGroup(String name, int userId) {}

    @Override
    public void addMember(int groupId, int userId) {}
}
