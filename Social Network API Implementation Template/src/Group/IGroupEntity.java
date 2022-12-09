package Group;

abstract class IGroupEntity {
    // this is an abstract class not interface because we have attributes
    int adminId=0;
    String name=null;
    int numOfMembers=0;
    abstract void save();
    void setAdminId(){}
    void setName(){}
    void getAdminId(){}
    void getName(){}
}
