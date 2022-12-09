package Group;

interface IGroupController {
    public void createGroup(String name,int userId);
    public void addMember(int groupId,int userId);
}
