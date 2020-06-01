package tuts.tut10.to_dos.chain_of_responsibility.middleware;

import java.util.regex.Pattern;

import tuts.tut10.to_dos.chain_of_responsibility.server.Server;

/**
 * ConcreteHandler. Checks whether a user with the given credentials exists.
 */
public class UserExistsMiddleware extends Middleware {
    private static final Pattern EMAIL_REGEX = Pattern.compile("[A-Za-z0-9_]+@\\w+\\.\\w+");
    private Server server;

    // TO-DO: Implement the UserExistsMiddleWare() method
    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        // TO-DO: Check for invalid email => show error message then return false
        if (!EMAIL_REGEX.matcher(email).matches() || !server.hasEmail(email)) {
            System.out.println("Email is invalid!");
            return false;
        }

        // TO-DO: Check for invalid password for an email => show error message then
        // return false
        if (!server.isValidPassword(email, password)) {
            System.out.println("Password is wrong!");
            return false;
        }

        return checkNext(email, password);
    }
}