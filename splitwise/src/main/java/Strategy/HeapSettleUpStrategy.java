package Strategy;

import Dtos.Transaction;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapSettleUpStrategy implements SettleupStrategy{
    @Override
    public List<Transaction> settleUpUsers(Map<User, Integer> map) {
        PriorityQueue<Pair> receivers = new PriorityQueue<>();
        PriorityQueue<Pair> givers = new PriorityQueue<>();
        List<Transaction> transactions = new ArrayList<>();
        for(User user : map.keySet()){
            if(map.get(user)>0){
                receivers.add(new Pair(user,map.get(user)));
            }
            else{
                givers.add(new Pair(user,-1*map.get(user)));
            }
        }
        while(!receivers.isEmpty() && !givers.isEmpty()){
            Pair receiver = receivers.poll();
            Pair giver = givers.poll();
            transactions.add(new Transaction(giver.user.getName(),receiver.user.getName(),giver.amount));
            if(giver.amount<receiver.amount){
                receivers.add(new Pair(receiver.user,receiver.amount-giver.amount));
            }
        }
        return transactions;
    }
}

class Pair implements Comparable<Pair>{

    User user;
    int amount;
    public Pair(User user,int amount){
        this.amount = amount;
        this.user = user;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.amount <= o.amount){
            return -1;
        }
        return 1;
    }
}
