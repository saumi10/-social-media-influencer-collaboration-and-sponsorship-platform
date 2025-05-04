package Functions;

import Users.*;
import java.util.Scanner;

public class LoginManager {

    private BrandManager[] brandManagers;
    private Influencer[] influencers;
    private Advertiser[] advertisers;
    private Admin admin; // Static admin

    public LoginManager(BrandManager[] brandManagers, Influencer[] influencers, Advertiser[] advertisers, Admin admin) {
        this.brandManagers = brandManagers;
        this.influencers = influencers;
        this.advertisers = advertisers;
        this.admin = admin;
    }

    public User login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        // Search in Brand Managers
        for (BrandManager manager : brandManagers) {
            if (manager.getUsername().equals(username)) {  
                System.out.print("Enter password: ");
                String password = sc.nextLine();// CASE-SENSITIVE
                if(!manager.check(password)) {
                    System.out.println("Invalid password. Login failed.");
                    return null;
                }
                System.out.println("Logged in as Brand Manager: " + manager.getName());
                return manager;
            }
        }

        // Search in Influencers
        for (Influencer influencer : influencers) {
            if (influencer.getUsername().equals(username)) {  // CASE-SENSITIVE
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                if(!influencer.check(password)) {
                    System.out.println("Invalid password. Login failed.");
                    return null;
                }
                System.out.println("Logged in as Influencer: " + influencer.getName());
                return influencer;
            }
        }

        // Search in Advertisers
        for (Advertiser advertiser : advertisers) {
            if (advertiser.getUsername().equals(username)) {  // CASE-SENSITIVE
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                if(!advertiser.check(password)) {
                    System.out.println("Invalid password. Login failed.");
                    return null;
                }
                System.out.println("Logged in as Advertiser: " + advertiser.getName());
                return advertiser;
            }
        }

        // Check Admin
        if (admin != null && admin.getUsername().equals(username)) { // CASE-SENSITIVE
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            if(!admin.check(password)) {
                System.out.println("Invalid password. Login failed.");
                return null;
            }
            System.out.println("Logged in as Admin: " + admin.getUsername());
            return admin;
        }

        System.out.println("Invalid username. Login failed.");
        return null;
    }
}
