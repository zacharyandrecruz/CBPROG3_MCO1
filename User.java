import java.util.ArrayList;

public class User {
    private String userID;
    private String userEmail;
    private String firstName;
    private String midName;
    private String surname;
    private String userPassword;
    private ArrayList<Bank> userBanks;
    
    public User(String email, String fName, String mName, String sName) {
        this.userEmail = email;
        this.firstName = fName;
        this.midName = mName;
        this.surname = sName;
        this.userBanks = new ArrayList<>(); //for storing banks at addBank
    }
    
    public String getUserID() {
        return userID;
    }
    
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public void setUserEmail(String email) {
        this.userEmail = email;
    }
    
    public String getUserPassword() {
        return userPassword;
    }
    
    public boolean setUserPassword(String pw) {

        if (pw != null && pw.length() >= 6) { //if the char length is lower than 6, return false
            this.userPassword = pw;
            return true;
        }
        return false; 
    }
    
    public void addBank(String bankName, String bankAccNum) {
        Bank newBank = new Bank(bankName, bankAccNum);
        userBanks.add(newBank);
    }
    
    //should add this sa uml
    public boolean removeBank(String bankAccNum) {
        for (int i = 0; i < userBanks.size(); i++) {
            if (userBanks.get(i).getBankAccNum().equals(bankAccNum)) {
                userBanks.remove(i);
                return true;
            }
        }
        return false;
    }

    // Additional helper methods that should prolly be added if you want

    public String getFullName() {
        if (midName != null && !midName.isEmpty()) {
            return firstName + " " + midName + " " + surname;
        } else {
            return firstName + " " + surname;
        }
    } 
    
    public ArrayList<Bank> getUserBanks() {
        return new ArrayList<>(userBanks); 
    }
    
    public int getBankCount() {
        return userBanks.size();
    }
    
    public boolean hasBank(String bankAccNum) {
        for (Bank bank : userBanks) {
            if (bank.getBankAccNum().equals(bankAccNum)) {
                return true;
            }
        }
        return false;
    }
}
