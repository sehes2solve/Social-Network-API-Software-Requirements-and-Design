package Post;

class RegularPostEntity extends IPostEntity{
    private boolean isPublic;
    @Override
    public void save() {

    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
