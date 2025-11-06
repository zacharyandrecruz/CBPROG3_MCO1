public class Budget {
    private String budgetID;
    private float budgetAmt;
    private DateTime budgetStart;
    private DateTime budgetEnd;
    private String budgetCategory;
    
    
    public Budget(float amount, DateTime start, DateTime end, String category) {
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
        this.budgetCategory = category;
    }
    
    public Budget(float amount, DateTime start, DateTime end) {
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
        this.budgetCategory = null; 
    }
    
    // Getters
    public float getBudgetAmt() {
        return budgetAmt;
    }
    
    public void setBudgetAmt(float amount) {
        this.budgetAmt = amount;
    }
    
    public DateTime getBudgetStart() {
        return budgetStart;
    }
    
    public DateTime getBudgetEnd() {
        return budgetEnd;
    }
    
    public String getBudgetCategory() {
        return budgetCategory;
    }
    
    // Helper
    public boolean hasCategory() {
        return budgetCategory != null && !budgetCategory.isEmpty();
    }
}