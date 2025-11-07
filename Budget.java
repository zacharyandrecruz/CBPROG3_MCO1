public class Budget {
    private String budgetID;
    private float budgetAmt;
    private DateTime budgetStart;
    private DateTime budgetEnd;
    private String budgetCategory;
    
    
    public Budget(String budgetID, float amount, DateTime start, DateTime end, String category) {
        this.budgetID = budgetID;
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
        this.budgetCategory = category;
    }
    
    public Budget(String budgetID, float amount, DateTime start, DateTime end) {
        this.budgetID = budgetID;
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
        this.budgetCategory = null; 
    }
    
    // Getters
    public String getBudgetID(){
        return this.budgetID;
    }

    public float getBudgetAmt() {
        return this.budgetAmt;
    }
    
    public void setBudgetAmt(float amount) {
        this.budgetAmt = amount;
    }
    
    public DateTime getBudgetStart() {
        return this.budgetStart;
    }
    
    public DateTime getBudgetEnd() {
        return this.budgetEnd;
    }
    
    public String getBudgetCategory() {
        return this.budgetCategory;
    }
    
    // Helper
    public boolean hasCategory() {
        return this.budgetCategory != null && !budgetCategory.isEmpty();
    }
}