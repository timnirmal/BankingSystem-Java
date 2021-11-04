import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    static int count = 0;
    static boolean accountLogin = false;

    public void incrementCount() {
        count++;
    }

    int x = 5;

    public static void createAccount() {
        System.out.println("\nCreate Account : \n");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter your Name");
        String name = myObj.nextLine();  // Read user input

        System.out.println("Enter your Username");
        String usersname = myObj.nextLine();  // Read user input

        System.out.println("Enter your Password");
        String password = myObj.nextLine();  // Read user input

        System.out.println("Enter your Address");
        String address = myObj.nextLine();  // Read user input

        System.out.println("Enter your Age");
        int age = myObj.nextInt();  // Read user input

        System.out.println("Enter your Initial Balance");
        double balance = myObj.nextInt();  // Read user input



        // Create Account Number
        int accountNumber = count++;

        try {
            File file = new File("filename.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("filename1.txt");
            myWriter.write("Account Number: " + accountNumber + "\n");
            myWriter.write("Name: " + name + "\n");
            myWriter.write("Username: " + usersname + "\n");
            myWriter.write("Password: " + password + "\n");
            myWriter.write("Address: " + address + "\n");
            myWriter.write("Age: " + age + "\n");
            myWriter.write("Balance: " + balance + "\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("\nAccount Created : \n"+accountNumber);
    }

    public static boolean login() {
        System.out.println("\nLogin : \n");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter your Username");
        String usersname = myObj.nextLine();  // Read user input

        System.out.println("Enter your Password");
        String password = myObj.nextLine();  // Read user input

        try {
            File file = new File("filename.txt");
            Scanner myReader = new Scanner(file);
            boolean usernamecheck = false;
            boolean passwordcheck = false;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.contains(usersname)){
                    usernamecheck = true;
                }
                if (data.contains(password)){
                    passwordcheck = true;
                }
            }
            myReader.close();
            if (usernamecheck && passwordcheck){
                System.out.println("\nLogin Successful : \n");
                return true;
            }
            else {
                System.out.println("\nLogin Failed : \n");
                return false;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    // Request balance
    /*
    public static void requestBalance(int accountNumber) {
        System.out.println("\nRequest Balance : \n");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        try {
            File file = new File("filename.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.contains( "Balance" )){
                    System.out.println("\nBalance : " + data.substring(data.indexOf("Balance: ") + 9) + "\n");
                }
            }

            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
*/

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        outerloop: while (true) {
            System.out.println("\nWelcome to the Bank of Java\n");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.println("\nEnter your choice : ");
            int choice = myObj.nextInt();  // Read user input

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    //////// Create Account user object for current user
                    BankAccount account = new BankAccount();
                    accountLogin = true;
                    // Add data to the account object
                    createAccountObject(account);

                    if (login()){
                        // You are successfully logged in
                        System.out.println("\nYou are successfully logged in\n");

                        System.out.println("\n1. Request Balance");
                        System.out.println("2. Withdraw Money");
                        System.out.println("3. Deposit Money");
                        System.out.println("4. Transfer Money");
                        System.out.println("5. Close Account");
                        System.out.println("6. Logout");

                        System.out.println("\nEnter your choice : ");

                        int choice2 = myObj.nextInt();  // Read user input
                        switch (choice2) {
                            case 1:
                                requestBalance(accountNumber);
                                break;

                        }
                    }
            }
            // Create BankAccount
            // createAccount();

            // Login
            // login();


            // Add data to
            if (login()) {

            }
            System.out.println("\n");

            // Print Account Balance
            if (accountLogin) {
                System.out.println(account.getAccountBalance());
            }

            // Withdraw Money
            if (accountLogin) {
                System.out.println("\nWithdraw Money : \n");
                System.out.println("Enter amount to withdraw : ");
                double withdraw = myObj.nextDouble();
                account.withdraw(withdraw);

                // Print Account Balance
                System.out.println("Account Balance");
                System.out.println(account.getAccountBalance());

                // Need to save to file
            }

            // Deposit Money
            if (accountLogin) {
                System.out.println("\nDeposit Money : \n");
                System.out.println("Enter amount to deposit : ");
                double deposit = myObj.nextDouble();
                account.deposit(deposit);

                // Print Account Balance
                System.out.println("Account Balance");
                System.out.println(account.getAccountBalance());

                // Need to save to file
            }

            // Transfer Money
            if (accountLogin) {
                System.out.println("\nTransfer Money : \n");

                // Get Destination Account
                System.out.println("Enter destination account number : ");
                int destinationAccountNumber = myObj.nextInt();

                BankAccount destinationAccount = new BankAccount();

                // Need to send the destination account number to the method
                createAccountObject(destinationAccount);


                System.out.println("Enter amount to transfer : ");
                double transfer = myObj.nextDouble();
                //account.transfer(transfer);

                // Need to aff to files

            }

            // Close Account
            if (accountLogin) {
                System.out.println("\nClose Account : \n");
                System.out.println("Are you sure you want to delete account (Y or N)");
                String answer = myObj.next();

                if (answer.equals("Y")) {
                    // Delete account

                    // Need to delete from file

                    System.out.println("Account Deleted");
                } else {
                    System.out.println("Account not deleted");
                }
            }

            // Logout
            if (accountLogin) {
                System.out.println("\nLogout : \n");
                break outerloop;
            }


        }


    }





    private static void createAccountObject(BankAccount account) {
        try {
            File file = new File("filename.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(": ");

                switch (parts[0]) {
                    case "Account Number":
                        account.setAccountNumber(Integer.parseInt(parts[1]));
                        break;
                    case "Name":
                        account.setAccountName(parts[1]);
                        break;
                    case "Address":
                        account.setAccountAddress(parts[1]);
                        break;
                    case "Age":
                        account.setAccountAge(Integer.parseInt(parts[1]));
                        break;
                    case "Balance":
                        account.setAccountBalance(Double.parseDouble(parts[1]));
                        break;
                }
            }
            myReader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(account.toString());
    }
}

// Develop an application to represents the basic operations of a bank

// 1. Create a bank account
// 2. Close a bank account
// 3. Withdraw money
// 4. Deposit money
// 5. Request balance
// 6. Transfer money



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// string, int, float, double, boolean, char, long, short, byte
// byte -128 to 127, short -32,768 to 32,767, int -2,147,483,648 to 2,147,483,647, long -9,223,372,036,854,775,808L to 9,223,372,036,854,775,807
// float -3.4E-45f to 3.4E+38, double -1.7E-308d to 1.7E+308

// String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
/* for (int i = 0; i < cars.length; i++) {
  System.out.println(cars[i]);
}*/

//for (type variable : arrayname) {}

// Multi-dimensional array int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Java Classes

/*{
    int x = 5;

    public static void main(String[] args) {
        System.out.println("Hello World");
        Main obj = new Main();
        System.out.println(obj.x);
    }
}*/

// final int x = 10; - Stop overriding






/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

