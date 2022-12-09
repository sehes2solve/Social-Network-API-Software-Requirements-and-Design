package Post;

class AdPostEntity extends IPostEntity{
    String header,head_line1,head_line2,text_description1
            ,text_description2,text_description3;
    @Override
    public void save() {

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHead_line1() {
        return head_line1;
    }

    public void setHead_line1(String head_line1) {
        this.head_line1 = head_line1;
    }

    public String getHead_line2() {
        return head_line2;
    }

    public void setHead_line2(String head_line2) {
        this.head_line2 = head_line2;
    }

    public String getText_description1() {
        return text_description1;
    }

    public void setText_description1(String text_description1) {
        this.text_description1 = text_description1;
    }

    public String getText_description2() {
        return text_description2;
    }

    public void setText_description2(String text_description2) {
        this.text_description2 = text_description2;
    }

    public String getText_description3() {
        return text_description3;
    }

    public void setText_description3(String text_description3) {
        this.text_description3 = text_description3;
    }
}
