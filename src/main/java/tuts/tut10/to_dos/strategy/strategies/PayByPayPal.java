package tuts.tut10.to_dos.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        // TO-DO: 'put' some test data (password & email) to DATA_BASE
        DATA_BASE.put("123456", "binhdoitsme@gmail.com");
        DATA_BASE.put("1", "abc@abc.com");
    }

    // TO-DO: Implement the collectPaymentDetails() method
    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
        // TO-DO: Add 'try-catch' block to catch the IO error
        while (!signedIn) {
            try {
            // TO-DO: Ask for email & password then save them to suitable variables
            System.out.print("Enter your email: ");
            email = READER.readLine();
            System.out.print("Enter your password: ");
            password = READER.readLine();

            // TO-DO: Verify the input values then display suitable message
            boolean verified = verify();
            if (verified) {
                System.out.println("Verified user!");
            } else {
                System.out.println("Unauthenticated user!");
            }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    // TO-DO: Implement the pay() method
    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
        /*
         * if customer already 'signedIn' => display a message to show that customer is
         * paying with PayPal with money amount then return true else return false
         */
        if (signedIn) {
            System.out.println("Paying with PayPal...");
            return true;
        }
        return false;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}   