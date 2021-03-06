/********************************************************************************
 * Name             : Nirmal L.Y.T.
 * Index No         : 19/ENG/072
 * Registration No  : EN93921
 *********************************************************************************/

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FilenameFilter;  // Import the FilenameFilter class
import java.io.IOException;     // Import the IOException class to handle errors
import java.text.SimpleDateFormat; // Import the SimpleDateFormat class to format the date
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    static int count = 0;

    public static void createAccount() {
        count =0;
        System.out.println("\nCreate Account : \n");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter your Name");
        String name = myObj.nextLine();  // Read user input

        System.out.println("Enter your Username");
        String username = myObj.nextLine();  // Read user input

        String pathname = username + ".txt";
        File f = new File(pathname);

        if(f.exists()){
            while (true){
                System.out.println("Username already exists.");
                System.out.println(" Please try again.\n");
                System.out.println("Enter your Username");
                username = myObj.nextLine();  // Read user input

                System.out.println(username + ".txt");
                System.out.println(pathname);

                if (!Objects.equals(username, pathname)){
                    System.out.println("Not equal");
                    break;
                }
                if (username.equals(pathname)){
                    System.out.println("Equal");
                    break;
                }
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

        // List of Text files in a folder

        File directoryPath = new File("C:\\Users\\timni\\IdeaProjects\\BankingSystem");
        FilenameFilter textFilefilter = (dir, name1) -> {
            String lowercaseName = name1.toLowerCase();
            return lowercaseName.endsWith(".txt");
        };

        //List of all the text files
        String textFilesList[] = directoryPath.list(textFilefilter);
        System.out.println("List of the text files in the specified directory:");
        for(String fileName : textFilesList) {
            count++;
            System.out.println(fileName);
        }

        count--;
        count /= 2;

        // End : List of Text files in a folder

        // Create Account Number
        int accountNumber = count++;


        // Create User Data file as username.txt
        try {
            // File name should be the same as the username
            File file = new File(username + ".txt");
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
            FileWriter myWriter = new FileWriter(username + ".txt");
            myWriter.write("Account Number: " + accountNumber + "\n");
            myWriter.write("Name: " + name + "\n");
            myWriter.write("Username: " + username + "\n");
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
            File file = new File(username + "account.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Write user data to usernameaccount.txt
        try {
            FileWriter myWriter = new FileWriter(username + "account.txt",true);
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
            FileWriter myWriter = new FileWriter("bank.txt",true);
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

    public static boolean login(String username, String password) {

        try {
            File file = new File(username + ".txt");
            Scanner myReader = new Scanner(file);
            boolean usernamecheck = false;
            boolean passwordcheck = false;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (data.contains(username)){
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
            return false;
        }
    }

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

        // Main Programme
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
                    // Login

                    //////// Create Account user object for current user
                    BankAccount account = new BankAccount();

                    System.out.println("\nLogin : \n");
                    Scanner logObj = new Scanner(System.in);  // Create a Scanner object

                    System.out.println("Enter your Username");
                    String username = logObj.nextLine();  // Read user input

                    System.out.println("Enter your Password");
                    String password = logObj.nextLine();  // Read user input

                    //////// Login
                    innerloop : while (login(username, password)) {
                        // Add data to the account object
                        try {
                            File file = new File(username + ".txt");
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
                                    case "Username":
                                        account.setAccountUserName(parts[1]);
                                        break;
                                }
                            }
                            myReader.close();

                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                            e.printStackTrace();
                        }

                        // You are successfully logged in
                        System.out.println("\nYou are successfully logged in\n");

                        // Login Screen
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
                                    System.out.println(account.getAccountBalance());
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
                                System.out.println(account.getAccountUserName() + ".txt");

                                ///// Need to save to file

                                // Write user data to usernameaccount.txt
                                //writeFiles(account, withdraw, 1);
                                System.out.println(account.getAccountUserName() + "account.txt" + "\n\n\n\n\n\n\n");

                                try {
                                    FileWriter myWriter = new FileWriter(account.getAccountUserName() + "account.txt", true);
                                    myWriter.write("Saad2222");
                                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                                    //timeStamp,0,balance,balance,Bank
                                    myWriter.write(timeStamp + " , " + "1" + " , " + withdraw + " , " + account.getAccountBalance() + " , " + "Bank\n");

                                    myWriter.close();
                                    System.out.println("Successfully wrote to the file.");
                                }
                                catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }


                                //////////// Open and Write Bank account files as bank.txt ////////////
                                try {
                                    FileWriter myWriter = new FileWriter( "bank.txt",true);
                                    myWriter.write("Saad2222");
                                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                                    //timeStamp,0,balance,balance,Bank
                                    myWriter.write(timeStamp + " , " + "1" + " , " + withdraw + " , " + account.getAccountBalance() + " , " + account.getAccountNumber() + "\n");

                                    myWriter.close();
                                    System.out.println("Successfully wrote to the file.");
                                }
                                catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }


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

                                ///// Need to save to file

                                // Write user data to usernameaccount.txt
                                //writeFiles(account, deposit,2);
                                System.out.println(account.getAccountUserName() + "account.txt");

                                try {
                                    FileWriter myWriter = new FileWriter(account.getAccountUserName() + "account.txt",true);
                                    myWriter.write("Saad2222");
                                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                                    //timeStamp,0,balance,balance,Bank
                                    myWriter.write(timeStamp + " , " + "2" + " , " + deposit + " , " + account.getAccountBalance() + " , " +  "Bank\n");

                                    myWriter.close();
                                    System.out.println("Successfully wrote to the file.");
                                }
                                catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }

                                //////////// Open and Write Bank account files as bank.txt ////////////
                                try {
                                    FileWriter myWriter = new FileWriter( "bank.txt",true);
                                    myWriter.write("Saad2222");
                                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                                    //timeStamp,0,balance,balance,Bank
                                    myWriter.write(timeStamp + " , " + "2" + " , " + deposit + " , " + account.getAccountBalance() + " , " + account.getAccountNumber() + "\n");

                                    myWriter.close();
                                    System.out.println("Successfully wrote to the file.");
                                }
                                catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }

                                break;
                            case 4:
                                Scanner traObj = new Scanner(System.in);  // Create a Scanner object

                                // Transfer Money
                                System.out.println("\nTransfer Money : \n");

                                // Get Destination Account
                                System.out.println("Enter destination account username : ");
                                String destinationAccountName = traObj.nextLine();

                                BankAccount destinationAccount = new BankAccount();

                                ////// Read Data from Destination Account //////

                                try {
                                    File file = new File(destinationAccountName + ".txt");
                                    Scanner myReader = new Scanner(file);

                                    while (myReader.hasNextLine()) {
                                        String data = myReader.nextLine();
                                        String[] parts = data.split(": ");

                                        switch (parts[0]) {
                                            case "Account Number":
                                                destinationAccount.setAccountNumber(Integer.parseInt(parts[1]));
                                                break;
                                            case "Name":
                                                destinationAccount.setAccountName(parts[1]);
                                                break;
                                            case "Address":
                                                destinationAccount.setAccountAddress(parts[1]);
                                                break;
                                            case "Age":
                                                destinationAccount.setAccountAge(Integer.parseInt(parts[1]));
                                                break;
                                            case "Balance":
                                                destinationAccount.setAccountBalance(Double.parseDouble(parts[1]));
                                                break;
                                        }
                                    }
                                    myReader.close();

                                } catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }

                                // Transaction Process

                                System.out.println("Enter amount to transfer : ");
                                double transfer = traObj.nextDouble();
                                //account.transfer(transfer);


                                // Need to add to files

                                // Write File current account
                                try {
                                    System.out.println(account.getAccountUserName() + "account.txt");
                                    FileWriter myWriter = new FileWriter(account.getAccountUserName() + "account.txt",true);
                                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                                    //timeStamp,0,balance,balance,Bank
                                    myWriter.write(timeStamp + " , " + "3" + " , " + transfer + " , " + account.getAccountBalance() + " , " + "Bank\n");

                                    myWriter.close();
                                    System.out.println("Successfully wrote to the file.");
                                }
                                catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }

                                // Write File destination account
                                try {
                                    FileWriter myWriter = new FileWriter(destinationAccount.getAccountUserName() + "account.txt",true);
                                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                                    //timeStamp,0,balance,balance,Bank
                                    myWriter.write(timeStamp + " , " + "3" + " , " + transfer + " , " + destinationAccount.getAccountBalance() + " , " +  "Bank\n");

                                    myWriter.close();
                                    System.out.println("Successfully wrote to the file.");
                                }
                                catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }

                                // Write to bank file

                                System.out.println(account.getAccountUserName());
                                try {
                                    FileWriter myWriter = new FileWriter("bank.txt",true);
                                    myWriter.write("Saad");
                                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                                    //timeStamp,0,balance,balance,Bank
                                    myWriter.write(timeStamp + " , " + "3" + " , " + transfer + " , " + account.getAccountBalance() + " , Bank\n");
                                    myWriter.write(timeStamp + " , " + "3" + " , " + transfer + " , " + destinationAccount.getAccountBalance() + " , Bank\n");

                                    myWriter.close();
                                    System.out.println("Successfully wrote to the file.");
                                }
                                catch (IOException e) {
                                    System.out.println("An error occurred.");
                                    e.printStackTrace();
                                }

                                break;

                            case 5:
                                // Close Account
                                System.out.println("\nClose Account : \n");
                                System.out.println("Are you sure you want to delete account (Y or N)");
                                String answer = myObj.next();

                                if (answer.equals("Y")) {
                                    // Delete account
                                    File file = new File(account.getAccountUserName() + ".txt");
                                    if (file.delete()) {
                                        System.out.println("Deleted the file: " + file.getName());
                                    } else {
                                        System.out.println("Failed to delete the file.");
                                    }

                                    // Need to delete from file
                                    File fileAccount = new File(account.getAccountUserName() + "account.txt");
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


}