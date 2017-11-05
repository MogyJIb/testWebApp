package by.gstu.training.model;

import java.io.Serializable;

public class TravelAgent extends Entity {
    private Account account;
    private int accountId;
    private int agencyId;
    private Agency agency;
    private double salary;

    public TravelAgent(int id, int accountId, int agencyId, double salary) {
        super(id);
        this.accountId = accountId;
        this.agencyId = agencyId;
        this.salary = salary;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    @Override
    public String toString() {
        return getId()+" " +salary;
    }
}
