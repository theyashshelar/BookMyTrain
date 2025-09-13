import java.util.HashMap;
import java.util.Map;

public class UserService {
    public static boolean isLoggedIn;
    private Map<String,User> userMap = new HashMap<>();
    private static User currentUser = null;

    public boolean registerUser(String userName, String password, String fullName, String contact){
        if (userMap.containsKey(userName)) {
            System.out.println("Username already taken, Please choose another");
            return false;
        }
        User user = new User(userName, password, password, fullName, contact);
        userMap.put(userName,user);
        System.out.println("Registration Successful");
        return true;
    }

    public boolean loginUser(String userName, String password) {
        if (!userMap.containsKey(userName)) {
            System.out.println("No User Found");
            return false;
        }
        User user = userMap.get(userName);
        if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect Password");
            return false;
        }

        currentUser = user;
        System.out.println("Welcome : "+currentUser.getFullName() + "!");
        return true;
    }

    public void logOutUser() {
        if (currentUser != null) {
            System.out.println("Logged Out "+ currentUser.getFullName());
        }
        currentUser=null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}
