class Bank {
    private long[] balance; // ✅ Class field

    public Bank(long[] balance) {
        this.balance = balance; // ✅ Store initial balances
    }

    public boolean transfer(int account1, int account2, long money) {
        // ✅ Validate account numbers
        if (!isValid(account1) || !isValid(account2)) return false;

        // ✅ Check if account1 has enough money
        if (balance[account1 - 1] < money) return false;

        // ✅ Perform transfer
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValid(account)) return false;

        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValid(account)) return false;

        if (balance[account - 1] < money) return false;

        balance[account - 1] -= money;
        return true;
    }

    // ✅ Helper method to check valid account range
    private boolean isValid(int account) {
        return account >= 1 && account <= balance.length;
    }
}
