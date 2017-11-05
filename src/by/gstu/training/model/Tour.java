package by.gstu.training.model;


import java.sql.Date;


public class Tour extends Entity {
    private String startDate;
    private String endDate;
    private double price;
    private String type;
    private Account userAccount;
    private TravelAgent travelAgent;
    private int userAccountId;
    private int travelAgentId;

    public Tour(int id, String startDate, String endDate, double price,
                String type, int userAccountId, int travelAgentId) {
        super(id);
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.type = type;
        this.travelAgentId = travelAgentId;
        this.userAccountId = userAccountId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public TravelAgent getTravelAgent() {
        return travelAgent;
    }

    public void setTravelAgent(TravelAgent travelAgent) {
        this.travelAgent = travelAgent;
    }

    @Override
    public String toString() {
        return price+"  "+type;
    }
}
