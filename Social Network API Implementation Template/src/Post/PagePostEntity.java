package Post;

class PagePostEntity extends IPostEntity{
    private int pageId;
    @Override
    public void save() {

    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }
}
