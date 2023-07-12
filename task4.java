import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class task4 {
    private static Map<String, String> userCredentials = new HashMap<>();
    private static Map<String, UserProfile> userProfiles = new HashMap<>();
    private static int examDurationMinutes = 30; // Exam duration in minutes

    public static void main(String[] args) {
        initializeUserCredentials();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Examination System!");

        boolean quit = false;
        while (!quit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Login");
            System.out.println("2. Update Profile");
            System.out.println("3. Change Password");
            System.out.println("4. Start Exam");
            System.out.println("5. Logout");

            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character from the input buffer

            switch (option) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    updateProfile(scanner);
                    break;
                case 3:
                    changePassword(scanner);
                    break;
                case 4:
                    startExam(scanner);
                    break;
                case 5:
                    logout();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the Online Examination System!");
    }

    private static void initializeUserCredentials() {
        // Initialize user credentials (username and password)
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        // ...
    }

    private static void login(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            // Additional logic for starting the exam or other operations after login
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void updateProfile(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (userProfiles.containsKey(username)) {
            System.out.print("New Name: ");
            String name = scanner.nextLine();
            System.out.print("New Email: ");
            String email = scanner.nextLine();

            UserProfile userProfile = userProfiles.get(username);
            userProfile.setName(name);
            userProfile.setEmail(email);

            System.out.println("Profile updated successfully.");
        } else {
            System.out.println("User does not exist.");
        }
    }

    private static void changePassword(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (userCredentials.containsKey(username)) {
            System.out.print("Current Password: ");
            String currentPassword = scanner.nextLine();
            System.out.print("New Password: ");
            String newPassword = scanner.nextLine();

            if (userCredentials.get(username).equals(currentPassword)) {
                userCredentials.put(username, newPassword);
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("Incorrect current password.");
            }
        } else {
            System.out.println("User does not exist.");
        }
    }

    private static void startExam(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (userCredentials.containsKey(username)) {
            // Additional logic for starting the exam, displaying questions, and handling answers
            System.out.println("Exam started for user: " + username);

            // Simulating the exam timer
            try {
                System.out.println("The exam duration is " + examDurationMinutes + " minutes. The timer starts now.");
                TimeUnit.MINUTES.sleep(examDurationMinutes);
                System.out.println("Time's up! The exam will be auto-submitted.");
                // Additional logic for auto-submitting the exam and displaying the results
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("User does not exist.");
        }
    }

    private static void logout() {
        System.out.println("Logout successful.");
    }
}

class UserProfile {
    private String name;
    private String email;

    public UserProfile(String name, String email) {
        this.name = name;
        this.email = email;
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
}
