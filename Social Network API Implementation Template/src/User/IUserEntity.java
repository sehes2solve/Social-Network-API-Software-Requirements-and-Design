package User;

import java.util.ArrayList;

public abstract class IUserEntity {
    public static ArrayList<IUserEntity> registeredUsers=new ArrayList<>();
    protected String name,email,password,date,birth_date,country;
    protected Gender gender;
    protected int id=-1;
    private static int curId=1;

    public void setId(int id) {
        this.id = id;
    }

    protected boolean isPrem;
    void save(){
        if(id==-1){
            id=curId++;
        }
        registeredUsers.add(this);
    }

    boolean checkExist(){
        // checks whether this user is in database or not
        return true;
    }
    static IUserEntity getUserByEmail(String email){
        for(IUserEntity user:registeredUsers){
            if(user.email.equals(email)){
                return user;
            }
        }
        return null;
    }
    static ArrayList<IUserEntity> getUserByName(String name){
        ArrayList<IUserEntity> res=new ArrayList<>();
        for(IUserEntity user:registeredUsers){
            if(user.name.equals(name))res.add(user);
        }
        return res;
    }
    static IUserEntity getUserById(int id){
        for(IUserEntity user:registeredUsers){
            if(user.id==id)return user;
        }
        return null;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    void delete() {
        registeredUsers.remove(this);
    }
}
