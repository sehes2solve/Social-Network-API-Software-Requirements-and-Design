import User.UserView;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Test()
public class TestingClass {
    @Test
    public void signUpTest1() {
        String name="abdallah";
        String email="abdonaguib99@gmail.com";
        String password="password";
        String country="Egypt";
        String date="1/1/2011";
        String birthDate="1/1/2011";
        UserView userView=UserView.getInstance();
        userView.createUser(name,password,email,date,birthDate
                ,country,true);
        Assert.assertEquals(userView.searchByEmail(email),
                userView.getLoggedUser());
    }
    @Test
    public void signUpTest2() {
        String name="abdallah";
        // this mail is wrong so it shouldn't be created
        String email="abdonaguib99";
        String password="password";
        String country="Egypt";
        String date="1/1/2011";
        String birthDate="1/1/2011";
        UserView userView=UserView.getInstance();
        userView.createUser(name,password,email,date,birthDate
                ,country,true);
        Assert.assertNull(userView.searchByEmail(email));
    }

    @Test
    public void sendFriendRequestTest(){
        String name="abdallah";
        String email="4234abdo@gmail.com";
        String password="password";
        String country="Egypt";
        String date="1/1/2011";
        String birthDate="1/1/2011";
        UserView userView=UserView.getInstance();
        userView.createUser(name,password,email,date,birthDate
                ,country,true);
        int abdoId=userView.getLoggedUser().getId();

        name="ali";
        email="al12433i@gmail.com";
        password="password";
        country="Egypt";
        date="1/1/2011";
        birthDate="1/1/2011";
        userView=UserView.getInstance();
        userView.createUser(name,password,email,date,birthDate
                ,country,true);
        // currently ali is the logged user and he is the sender
        userView.sendFriendRequest(userView.getLoggedUser().getId(),
                abdoId);

        userView.login("4234abdo@gmail.com","password");
        ArrayList<Integer> requests=userView.getPendingFriendRequests(userView.getLoggedUser().getId());
        Assert.assertEquals(requests.size(),1);
    }

    @Test
    public void acceptFriendRequestTest(){
        String name="abdallah";
        String email="abd534534o@gmail.com";
        String password="password";
        String country="Egypt";
        String date="1/1/2011";
        String birthDate="1/1/2011";
        UserView userView=UserView.getInstance();
        userView.createUser(name,password,email,date,birthDate
                ,country,true);
        int abdoId=userView.getLoggedUser().getId();

        name="ali";
        email="al3123i@gmail.com";
        password="password";
        country="Egypt";
        date="1/1/2011";
        birthDate="1/1/2011";
        userView=UserView.getInstance();
        userView.createUser(name,password,email,date,birthDate
                ,country,true);
        // currently ali is the logged user and he is the sender
        userView.sendFriendRequest(userView.getLoggedUser().getId(),
                abdoId);

        // now abdo is the logged user
        userView.login("abd534534o@gmail.com","password");
        ArrayList<Integer> requests=userView.getPendingFriendRequests(userView.getLoggedUser().getId());
        ArrayList<Integer> friendsBeforeAccepting=userView.getFriends(userView.getLoggedUser().getId());
        Assert.assertEquals(friendsBeforeAccepting.size(),0);

        userView.acceptFriendRequest(requests.get(0),userView.getLoggedUser().getId());

        ArrayList<Integer> friendsAfterAccepting=userView.getFriends(userView.getLoggedUser().getId());
        Assert.assertEquals(friendsAfterAccepting.size(),1);
    }
}
