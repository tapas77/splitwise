package Repositories;

import models.Expense;
import models.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    private List<Group> groups = new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Expense> findExpensesByGroup(String groupName) {
        for (Group group : groups) {
            if (group.getName().equals(groupName)) {
                return group.getExpenses();
            }
        }
        return null;
    }
}
