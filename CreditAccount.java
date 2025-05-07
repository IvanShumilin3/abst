public class CreditAccount extends Account {
    private final long creditLimit; // Кредитный лимит

    /**
     * Конструктор для инициализации начального баланса и кредитного лимита.
     *
     * @param initialBalance начальный баланс
     * @param creditLimit    кредитный лимит
     */
    public CreditAccount(long initialBalance, long creditLimit) {
        super(initialBalance);
        if (creditLimit < 0) {
            throw new IllegalArgumentException("Кредитный лимит не может быть отрицательным");
        }
        this.creditLimit = creditLimit;
    }

    /**
     * Метод для совершения платежа.
     * Платеж возможен, если баланс не уйдет ниже кредитного лимита.
     *
     * @param amount сумма платежа
     * @return true, если платеж успешен, иначе false
     */
    @Override
    public boolean pay(long amount) {
        if (amount <= 0) {
            return false; // Сумма должна быть положительной
        }
        if (balance - amount >= -creditLimit) {
            balance -= amount;
            return true;
        }
        return false;
    }
}