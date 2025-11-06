public class Bank {
    private String bankName;
    private String bankAccNum;
    
    public Bank(String name, String accNum) {
        this.bankName = name;
        this.bankAccNum = accNum;
    }
    
    public String getBankName() {
        return bankName;
    }
    
    public String getBankAccNum() {
        return bankAccNum;
    }
    
    public String stringInfo() {
        return bankName + " - " + bankAccNum;
    }
}