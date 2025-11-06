public class DateTime {
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;
    
    public DateTime(String year, String month, String day, String hour, String minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    
    public void displayDate() {
        System.out.println(month + "/" + day + "/" + year);
    }
    
    public void displayTime() {
        System.out.println(hour + ":" + minute);
    }
    
    // Getters for individual components
    public String getYear() {
        return year;
    }
    
    public String getMonth() {
        return month;
    }
    
    public String getDay() {
        return day;
    }
    
    public String getHour() {
        return hour;
    }
    
    public String getMinute() {
        return minute;
    }
    

    // Additional
    //Gets date in MM/DD/YYYY format

    public String getDateString() {
        return month + "/" + day + "/" + year;
    }
    
    
    //Gets time in HH:MM format
  
    public String getTimeString() {
        return hour + ":" + minute;
    }
    
    
    //Gets full datetime in MM/DD/YYYY HH:MM format

    public String getDateTimeString() {
        return getDateString() + " " + getTimeString();
    }
    
}