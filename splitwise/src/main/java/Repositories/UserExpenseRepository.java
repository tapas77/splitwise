package Repositories;

import models.UserExpense;

import java.util.ArrayList;
import java.util.List;

public class UserExpenseRepository {
    private List<UserExpense> userExpenses = new ArrayList<>();

    public List<UserExpense> getUserExpenses() {
        return userExpenses;
    }

    public void setUserExpenses(List<UserExpense> userExpenses) {
        this.userExpenses = userExpenses;
    }

    public List<UserExpense> findUserExpenseByExpense(String desc) {
        List<UserExpense> userExpenseList = new ArrayList<>();
        for(UserExpense userExpense : userExpenses) {
            if(userExpense.getExpense().getDescription().equals(desc)) {
                userExpenseList.add(userExpense);
            }
        }
        return userExpenseList;
    }

}
