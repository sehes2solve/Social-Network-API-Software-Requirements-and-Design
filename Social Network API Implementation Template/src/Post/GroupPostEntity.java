package Post;

class GroupPostEntity extends IPostEntity{
    private int groupId;
    @Override
    public void save() {

    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
