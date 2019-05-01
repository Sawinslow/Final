import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private String CustomerID;
    private double priorityNum;
// Constructor
    public Customer(String CustomerID, double priorityNum) {
        this.CustomerID = CustomerID;
        this.priorityNum = priorityNum;
    }
// Getters and setters
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public double getpriorityNum() {
        return priorityNum;
    }

    public void setpriorityNum(double priorityNum) {
        this.priorityNum = priorityNum;
    }
// end of getters and setters
    @Override
    // Sorts the priority queue
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer Customer = (Customer) o;
        return Double.compare(Customer.priorityNum, priorityNum) == 0 &&
                Objects.equals(CustomerID, Customer.CustomerID);
    }
// Prints out the customers in what line and their priority number
    @Override
    public String toString() {
        return 
        		"Song:'" + CustomerID + '\'' +
                ", Queue=" + priorityNum;
    }

    
    @Override
    public int compareTo(Customer Customer) {
        if(this.getpriorityNum() < Customer.getpriorityNum()) {
            return 1;
        } else if (this.getpriorityNum() > Customer.getpriorityNum()) {
            return -1;
        } else {
            return 0;
        }
    }
}