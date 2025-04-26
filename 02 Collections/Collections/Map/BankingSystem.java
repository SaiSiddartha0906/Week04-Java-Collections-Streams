package Map;
import java.util.*;

class BankingSystem {
    private Map<Integer, Integer> accounts = new HashMap<>();                     // AccountNumber -> Balance
    private TreeMap<Integer, List<Integer>> balanceMap = new TreeMap<>();        // Balance -> List of AccountNumbers
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, int balance) {
        accounts.put(accountNumber, balance);
        balanceMap.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void requestWithdrawal(int accountNumber, int amount) {
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accNum = request.accountNumber;
            int amount = request.amount;

            if (accounts.containsKey(accNum) && accounts.get(accNum) >= amount) {
                int oldBalance = accounts.get(accNum);
                int newBalance = oldBalance - amount;
                accounts.put(accNum, newBalance);

                balanceMap.get(oldBalance).remove(Integer.valueOf(accNum));
                if (balanceMap.get(oldBalance).isEmpty()) {
                    balanceMap.remove(oldBalance);
                }
                balanceMap.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accNum);

                System.out.println("Withdrawal of " + amount + " from Account " + accNum + " successful.");
            } else {
                System.out.println("Withdrawal failed for Account " + accNum);
            }
        }
    }

    public void displayAccountsByBalance() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Integer, List<Integer>> entry : balanceMap.entrySet()) {
            for (int accNum : entry.getValue()) {
                System.out.println("Account " + accNum + " → Balance: " + entry.getKey());
            }
        }
    }

    private static class WithdrawalRequest {
        int accountNumber;
        int amount;

        WithdrawalRequest(int accountNumber, int amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 3000);
        bank.addAccount(1003, 7000);

        bank.requestWithdrawal(1001, 1000);
        bank.requestWithdrawal(1002, 4000); // Should fail
        bank.requestWithdrawal(1003, 2000);

        bank.processWithdrawals();

        System.out.println();
        bank.displayAccountsByBalance();
    }
}
