public class Expense {
    private String expenseID;
    private float expenseAmount;
    private String expenseCurrency;
    private String expenseRefNum;
    private String expenseReceiverAccNo;
    private DateTime expenseDateTime;
    private String expenseCategory;
    private Bank expenseBank;
    
    
    //Constructor with bank details and category (digital expense with category)
    
    public Expense(String bankName, String bankAccNum, float amount, String currency, 
                  String refNum, String receiverAccNo, DateTime dateTime, String category) {
        this.expenseBank = new Bank(bankName, bankAccNum);
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseRefNum = refNum;
        this.expenseReceiverAccNo = receiverAccNo;
        this.expenseDateTime = dateTime;
        this.expenseCategory = category;
    }
    
    
    //Constructor with bank details but without category 
     
    public Expense(String bankName, String bankAccNum, float amount, String currency, 
                  String refNum, String receiverAccNo, DateTime dateTime) {
        this(bankName, bankAccNum, amount, currency, refNum, receiverAccNo, dateTime, null);
    }
    
    //Constructor without bank details but with category 
    
    public Expense(float amount, String currency, DateTime dateTime, String category) {
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseDateTime = dateTime;
        this.expenseCategory = category;
        this.expenseBank = null; // No bank for cash expenses
        this.expenseRefNum = null;
        this.expenseReceiverAccNo = null;
    }
    
    //Constructor without bank details and without category 
    
    public Expense(float amount, String currency, DateTime dateTime) {
        this(amount, currency, dateTime, null);
    }
    
    // Getters
    
    public float getExpenseAmount() {
        return expenseAmount;
    }
    
    public String getExpenseCurrency() {
        return expenseCurrency;
    }
    
    public String getExpenseRefNum() {
        return expenseRefNum;
    }
    
    public String getExpenseReceiverAccNo() {
        return expenseReceiverAccNo;
    }
    
    public DateTime getExpenseDateTime() {
        return expenseDateTime;
    }
    
    public String getExpenseCategory() {
        return expenseCategory;
    }
    
    public Bank getExpenseBank() {
        return expenseBank;
    }
    
    // Additional helper methods
    
    public String getExpenseID() {
        return expenseID;
    }
    
    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }   
}