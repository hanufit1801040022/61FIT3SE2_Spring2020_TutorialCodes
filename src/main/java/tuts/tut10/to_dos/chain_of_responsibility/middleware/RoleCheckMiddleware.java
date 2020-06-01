package tuts.tut10.to_dos.chain_of_responsibility.middleware;

/**
 * ConcreteHandler. Checks a user's role.
 */
public class RoleCheckMiddleware extends Middleware {
	//TO-DO: Implement the check() method
    public boolean check(String email, String password) {
    	/*if email = 'admin@example.com' => display welcome message for admin then return true
        else, display welcome message for normal user */
        if (email.equals("admin@example.com")) {
            System.out.println("Welcome, ADMIN!");
        } else {
            System.out.println("Welcome, NORMAL USER!");
        }
         
        return checkNext(email, password);
    }
}