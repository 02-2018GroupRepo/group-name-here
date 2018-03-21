package hello;

public class Operator {
    private String setPassword = "password123";

    public boolean checkPassword(String passwordAttempt){
        if(passwordAttempt.equals(setPassword)) {
            return true;
        }
        return false;
    }
}
