import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    private static ArrayList<Budget> budgets = new ArrayList<>();
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static User user;
    private static ArrayList<String> categories = new ArrayList<>();

    public static void main(String[] args) {
        
        // Set Defaults but you can create custom categories 
        categories.add("Food");
        categories.add("Transportation");
        categories.add("Entertainment");
        categories.add("Utilities");
        categories.add("Shopping");
        categories.add("Healthcare");
        categories.add("Education");
        categories.add("Other");
        expenses.add(new Expense("0", 10, "PHP", new DateTime("2025", "11", "1", "12", "00")));
        expenses.add(new Expense("1", 20, "PHP", new DateTime("2025", "11", "2", "12", "00")));
        expenses.add(new Expense("2", 10, "PHP", new DateTime("2025", "11", "3", "12", "00")));
        expenses.add(new Expense("3", 20, "PHP", new DateTime("2025", "11", "3", "12", "00")));

        for(Float f : getDailyExpenses()){
            System.out.println(f);
        }
        
    }
    
    public static boolean login(String email, String password) {
        if (user != null && 
            user.getUserEmail().equals(email) && 
            user.getUserPassword().equals(password)) {
            return true; // Login successful
        }
        return false; 
    }
    
    public static void setBudget() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Set Budget");
        System.out.println("==========");
        
        // Ask for total amount
        System.out.print("Enter total budget amount: ");
        float amount = sc.nextFloat();
        sc.nextLine(); 
        
        // Ask for start date
        DateTime startDate = getDate("Start");
        
        // Ask for end date
        DateTime endDate = getDate("End");
        
        // Ask for category
        displayCategories();
        String category = getCategory();
        
        String budgetID = generateID("BUDG", budgets.size() + 1, 6);

        // Create and store the budget
        Budget budget;
        if (category != null && !category.isEmpty()) {
            budget = new Budget(budgetID, amount, startDate, endDate, category);
            System.out.println("Budget set successfully for category: " + category);
        } else {
            budget = new Budget(budgetID, amount, startDate, endDate);
            System.out.println("Budget set successfully (no category)");
        }
        
        budgets.add(budget);
        
        // Display the summary of the budget
        System.out.println("\nBudget Summary:");
        System.out.println("Amount: " + amount);
        System.out.println("Start: " + startDate.getDateTimeString());
        System.out.println("End: " + endDate.getDateTimeString());
        if (category != null) {
            System.out.println("Category: " + category);
        }

        sc.close();

    }
    
    public static Budget getBudget() {
        if (!budgets.isEmpty()) {
            return budgets.get(budgets.size() - 1); // Return most recent budget
        }
        return null;
    }

    public static void recordExpense() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Record Expense");
        System.out.println("==========");
        
        // Ask for total amount
        System.out.print("Enter expense amount: ");
        float amount = sc.nextFloat();
        sc.nextLine(); 
        
        // Ask for date
        DateTime expenseDate = getDate("");
        
        System.out.print("Enter the name of the bank the expense was recorded in (Press enter for none): ");
        String bankName = ""; 
        bankName = sc.nextLine();

        String bankAccNum = "";
        String refNum = "";
        String recAccNum = "";
        if(!bankName.isEmpty()){
            System.out.print("Enter your bank account number: ");
            bankAccNum = sc.nextLine();

            System.out.print("Enter your expense's reference number: ");
            refNum = sc.nextLine();

            System.out.print("Enter the reciever's account number: ");
            recAccNum = sc.nextLine();
        }

        // Ask for category
        displayCategories();
        String category = getCategory();
        
        String expenseID = generateID("EXPN", expenses.size() + 1, 6);

        // Create and store the expense
        Expense expense;
        
        if(bankName.isEmpty()){

            if (category != null && !category.isEmpty()) {
                expense = new Expense(expenseID, amount, "PHP", expenseDate, category);
                System.out.println("Expense recorded successfully for category: " + category);
            } else {
                expense = new Expense(expenseID, amount, "PHP", expenseDate);
                System.out.println("Expense recorded successfully (no category)");
            }
            
        }else{

            if (category != null && !category.isEmpty()) {
                expense = new Expense(expenseID, bankName, bankAccNum, amount, "PHP", refNum, recAccNum, expenseDate, category);
                System.out.println("Digital Expense recorded successfully for category: " + category);
            } else {
                expense = new Expense(expenseID, bankName, bankAccNum, amount, "PHP", refNum, recAccNum, expenseDate);
                System.out.println("Digital Expense recorded successfully (no category)");
            }

        }
        
        expenses.add(expense);
        
        // Display the summary of the budget
        System.out.println("\nExpense Summary:");
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + expenseDate.getDateTimeString());
        if (category != null) {
            System.out.println("Category: " + category);
        }
        if(!bankName.isEmpty()){
            System.out.println("Bank Name: " + bankName);
            System.out.println("Bank Account Number: " + bankAccNum);
            System.out.println("Reference Number: " + refNum);
            System.out.println("Reciever's Account Number" + recAccNum);
        }

        sc.close();

    }

    public static float computeDailyAve() {
        
        float dailyAverage;
        ArrayList<Float> expensePerDay;
        int numOfDays;



        return 0.0f;

    }

    //Helper Functions;

    public static String generateID(String prefix, int idNum, int numOfDigits){

        String id = "";

        id = id.concat(prefix);

        String numString = Integer.toString(idNum);

        for(int i = numString.length(); i < numOfDigits; i++){
            id = id.concat("0");
        }

        id = id.concat(numString);

        return id; 

    }

    public static void displayCategories(){
        System.out.println("\nAvailable Categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
    }

    public static DateTime getDate(String s){

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter " + s + " Date:");
        System.out.print("Year: ");
        String year = sc.nextLine();
        System.out.print("Month: ");
        String month = sc.nextLine();
        System.out.print("Day: ");
        String day = sc.nextLine();
        System.out.print("Hour: ");
        String hour = sc.nextLine();
        System.out.print("Minute: ");
        String minute = sc.nextLine();
        
        DateTime date = new DateTime(year, month, day, hour, minute);

        sc.close();

        return date;

    }

    public static String getCategory(){

        Scanner sc = new Scanner(System.in);

        System.out.print("Choose a category (1-" + categories.size() + "), type a new category, or press ENTER to have no category: ");
        
        String categoryInput = sc.nextLine();
        String category = null;
        
        //this is for custom categories
        if (!categoryInput.isEmpty()) {
            try {
                int categoryChoice = Integer.parseInt(categoryInput);
                if (categoryChoice >= 1 && categoryChoice <= categories.size()) {
                    category = categories.get(categoryChoice - 1);
                }
            } catch (NumberFormatException e) {
                // If not a number, use the input as custom category
                category = categoryInput;
                // Add the custom category to the list
                if (!categories.contains(category)) {
                    categories.add(category);
                }
            }
        }

        sc.close();

        return category;

    }

    public static ArrayList<Float> getDailyExpenses(){

        ArrayList<Float> expensePerDay = new ArrayList<>();

        float currentTotal = -1;
        String currentDay = "";
        for(Expense e : expenses){
            
            if(!e.getExpenseDateTime().getDateString().equals(currentDay)){
                currentDay = e.getExpenseDateTime().getDateString();
                if(currentTotal != -1){
                    expensePerDay.add(currentTotal);
                }
                currentTotal = 0;
                currentTotal += e.getExpenseAmount();
            }else{

                currentTotal += e.getExpenseAmount();

            }

        }
        expensePerDay.add(currentTotal);

        return expensePerDay;

    }

    public static ArrayList<Float> getWeeklyExpenses(){
        
        ArrayList<Float> expensePerWeek = new ArrayList<>();



        return expensePerWeek;

    }

    public static ArrayList<Float> getMonthlyExpenses(){
        
        ArrayList<Float> expensePerMonth = new ArrayList<>();



        return expensePerMonth;

    }

}

    /*
    
    
    
    
    
    public float computeWeeklyAve() {
        
        return 0.0f;
    }
    
    public float computeMonthlyAve() {
        
        return 0.0f;
    }
    
    public void viewMonthlyExpense() {
        
    }
    
    public void viewDailyExpense() {
        
    }
    
    public void viewWeeklyExpense() {
        
    }
    
    public void viewTotalCategoryExpense() {
        
    }
    
    public void viewTotalExpense() {
        
    }
    
    public void viewCategoryExpensePercentage() {
        
    }

    public ArrayList<String> getCategories() {
        return categories;
    }
}*/
