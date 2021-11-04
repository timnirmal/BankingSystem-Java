import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        String pathname = usersname + ".txt";
        File f = new File(pathname);

        if(f.exists()){
            while (true){
                System.out.println(usersname);
                System.out.println(pathname);
                String newname = usersname;
                if (usersname != pathname){
                    break;
                }
                System.out.println("Username already exists.");
                System.out.println(" Please try again.\n");
                System.out.println("Enter your Username");
                usersname = myObj.nextLine();  // Read user input
            }
        }


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


        // Create User Data file as username.txt
        try {
            // File name should be the same as the username
            File file = new File(usersname + ".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Write user data to username.txt
        try {
            FileWriter myWriter = new FileWriter(usersname + ".txt");
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


        //////////// Create user account files as usernameaccount.txt ////////////
        try {
            // File name should be the same as the username
            File file = new File(usersname + "account.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Write user data to usernameaccount.txt
        try {
            FileWriter myWriter = new FileWriter(usersname + "account.txt");
            //      Date
//      Transaction Type
//          0 - Initial Balance
//          1 - Deposit
//          2 - Withdraw
//          3 - Transfer
//      Transaction Amount
//      Balance
//      Destination Account (Bank or Other User)
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            //timeStamp,0,balance,balance,Bank
            myWriter.write(timeStamp + " , 0 , " + balance + " , " + balance + " , Bank\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        //////////// Open and Write Bank account files as bank.txt ////////////
        try {
            FileWriter myWriter = new FileWriter("bank.txt");
            //      Date
//      Transaction Type
//          0 - Initial Balance
//          1 - Deposit
//          2 - Withdraw
//          3 - Transfer
//      Transaction Amount
//      Balance
//      Destination Account (Bank or Other User)
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            //timeStamp,0,balance,balance,Bank
            myWriter.write(timeStamp + " , 0 , " + balance + " , " + balance + " , " + accountNumber + "\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

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

        //////////// Create Bank account files as bank.txt ////////////
        try {
            // File name should be the same as the username
            File file = new File("bank.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

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

                    //////// Login
                    innerloop : while (login()){
                        // You are successfully logged in
                        System.out.println("\nYou are successfully logged in\n");

                        System.out.println("\nW E L C O M E\n");

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
                                // Print Account Balance
                                if (accountLogin) {
                                    System.out.println(account.getAccountBalance());
                                }
                                break;

                            case 2:
                                // Withdraw Money

                                System.out.println("\nWithdraw Money : \n");
                                System.out.println("Enter amount to withdraw : ");
                                double withdraw = myObj.nextDouble();
                                account.withdraw(withdraw);

                                // Print Account Balance
                                System.out.println("Account Balance");
                                System.out.println(account.getAccountBalance());

                                // Need to save to file


                                // Write user data to usernameaccount.txt
                                writeFiles(account, withdraw, 1);

                                //////////// Open and Write Bank account files as bank.txt ////////////
                                writeBankFile(account, withdraw,1);


                                break;
                            case 3:
                                // Deposit Money
                                System.out.println("\nDeposit Money : \n");
                                System.out.println("Enter amount to deposit : ");
                                double deposit = myObj.nextDouble();
                                account.deposit(deposit);

                                // Print Account Balance
                                System.out.println("Account Balance");
                                System.out.println(account.getAccountBalance());

                                // Need to save to file


                                // Write user data to usernameaccount.txt
                                writeFiles(account, deposit,2);


                                //////////// Open and Write Bank account files as bank.txt ////////////
                                writeBankFile(account, deposit,2);

                                break;
                            case 4:
                                // Transfer Money
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

                                // Need to add to files
                                writeFiles(account, transfer,3);
                                writeFiles(destinationAccount, transfer,3);
                                writeFiles(account, transfer,3);
                                writeFiles(destinationAccount, transfer,3);

                                break;

                            case 5:
                                // Close Account
                                System.out.println("\nClose Account : \n");
                                System.out.println("Are you sure you want to delete account (Y or N)");
                                String answer = myObj.next();

                                if (answer.equals("Y")) {
                                    // Delete account
                                    File file = new File("filename.txt");
                                    if (file.delete()) {
                                        System.out.println("Deleted the file: " + file.getName());
                                    } else {
                                        System.out.println("Failed to delete the file.");
                                    }

                                    // Need to delete from file
                                    File fileAccount = new File("filename.txt");
                                    if (fileAccount.delete()) {
                                        System.out.println("Deleted the file: " + fileAccount.getName());
                                    } else {
                                        System.out.println("Failed to delete the file.");
                                    }

                                    System.out.println("Account Deleted");
                                } else {
                                    System.out.println("Account not deleted");
                                }
                                break;

                            case 6:
                                // Logout
                                System.out.println("\nLogout : \n");
                                break innerloop;
                        }


                    }
                    // End of inner loop (Login)

                    //////// Exit
                case 3:
                    break outerloop;
            }
            // Enf of outer loop




        }


    }

    private static void writeBankFile(BankAccount account, double amount, int transactionType ) {
        try {
            FileWriter myWriter = new FileWriter(account.getAccountUserName() + "account.txt");
            //FileWriter myWriter = new FileWriter("bank.txt");
            //      Date
//      Transaction Type
//          0 - Initial Balance
//          1 - Withdraw
//          2 - Deposit
//          3 - Transfer
//      Transaction Amount
//      Balance
//      Destination Account (Bank or Other User)
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            //timeStamp,0,balance,balance,Bank
            myWriter.write(timeStamp + " , " + transactionType + " , " + amount + " , " + account.getAccountBalance() + " , " + account.getAccountNumber() + "\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void writeFiles(BankAccount account, double amount, int transactionType ) {
        try {
            FileWriter myWriter = new FileWriter(account.getAccountUserName() + "account.txt");
            //      Date
//      Transaction Type
//          0 - Initial Balance
//          1 - Withdraw
//          2 - Deposit
//          3 - Transfer
//      Transaction Amount
//      Balance
//      Destination Account (Bank or Other User)
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            //timeStamp,0,balance,balance,Bank
            myWriter.write(timeStamp + " , " + transactionType + " , " + amount + " , " + account.getAccountBalance() + " , Bank\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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

