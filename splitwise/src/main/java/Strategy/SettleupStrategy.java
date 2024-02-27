package Strategy;

import Dtos.Transaction;
import models.User;

import java.util.List;
import java.util.Map;

public interface SettleupStrategy {

    public List<Transaction> settleUpUsers(Map<User,Integer> map);
}
