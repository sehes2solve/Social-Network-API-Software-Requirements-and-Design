import User.IUserEntity;
import User.PremiumUserEntity;
import User.UserView;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner cin=new Scanner(System.in);
    public static void main(String[] args) {
        mainMenu();
    }
    static void mainMenu(){
        System.out.println("1- sign up");
        System.out.println("2- login");
        int inp=cin.nextInt();
        if(inp==1){
            signUp();
        }else{
            signIn();
        }
    }
    static void signUp(){
        System.out.println("Enter the name");
        String name=cin.next();

        System.out.println("Enter the email");
        String email=cin.next();

        System.out.println("Enter the password");
        String pass=cin.next();

        System.out.println("Enter the country");
        String country=cin.next();

        System.out.println("Enter the birthdate");
        String birthdate=cin.next();

        System.out.println("Enter the date");
        String date=cin.next();

        System.out.println("is male ? (answer with 0 for no and 1 for yes)");
        int gender=cin.nextInt();
        boolean isMale=false;
        if(gender==1)isMale=true;
        UserView userView=UserView.getInstance();
        if(!userView.createUser(name,pass,email,date,birthdate,country,isMale)){
            System.out.println("couldn't register , please review your data");
            mainMenu();
        }
        mainFunctions();
    }
    static void signIn(){
        System.out.println("Enter the email");
        String email=cin.next();
        System.out.println("Enter the password");
        String pass=cin.next();
        UserView userView=UserView.getInstance();
        if(userView.login(email,pass)==null){
            System.out.println("couldn't login");
            mainMenu();
        }
        mainFunctions();
    }
    static void mainFunctions(){
        System.out.println("1- send friend request");
        System.out.println("2- accept friend request");
        System.out.println("3- get friends");
        System.out.println("4- upgrade");
        System.out.println("5- is premuim");
        System.out.println("6- signout");
        int inp=cin.nextInt();
        if(inp==1){
            sendRequest();
        }else if(inp==2){
            acceptRequest();
        }else if(inp==3){
            getFriends();
        }else if(inp==4){
            upgrade();
        }else if(inp==5){
            ispre();
        }else if(inp==6){
            mainMenu();
        }else{
            System.out.println("wrong input");
            mainFunctions();
        }
    }
    static void upgrade(){
        UserView userView=UserView.getInstance();
        userView.upgrade(userView.getLoggedUser().getId(),"123");
        mainFunctions();
    }
    static void ispre(){
        UserView userView=UserView.getInstance();
        IUserEntity user=userView.getLoggedUser();
        if(user instanceof PremiumUserEntity){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        mainFunctions();
    }
    static void sendRequest(){
        System.out.println("enter the user email");
        String email=cin.next();
        UserView userView=UserView.getInstance();
        IUserEntity user=userView.searchByEmail(email);
        if(user==null){
            System.out.println("email not found");
            mainFunctions();
            return;
        }
        userView.sendFriendRequest(userView.getLoggedUser().getId(),
                user.getId());
        mainFunctions();
    }
    static void acceptRequest(){
        UserView userView=UserView.getInstance();
        ArrayList<Integer> requests=userView.getPendingFriendRequests(userView.getLoggedUser().getId());
        for(int req:requests){
            IUserEntity userEntity=userView.getUserById(req);
            System.out.println(userEntity.getId()+" "+userEntity.getName());
        }
        System.out.println("Enter the number of requests you want to accept and then their IDs");
        int cnt=cin.nextInt();
        for(int i=0 ; i<cnt ; i++){
            int id=cin.nextInt();
            if(!requests.contains(id)){
                System.out.println("wrong id");
                i--;
                continue;
                // i-- to make him enter this id again
            }
            userView.acceptFriendRequest(userView.getLoggedUser().getId(),
                    id);
        }
        mainFunctions();
    }
    static void getFriends(){
        UserView userView=UserView.getInstance();
        ArrayList<Integer> friends=userView.getFriends(userView.getLoggedUser().getId());
        for(Integer id:friends){
            System.out.println(userView.getUserById(id).getEmail());
        }
        mainFunctions();
    }
}
