public class SimpleAccount extends Account {

    /**
     * Конструктор для инициализации начального баланса.
     *
     * @param initialBalance начальный баланс
     */
    public SimpleAccount(long initialBalance) {
        super(initialBalance);
    }

    /**
     * Метод для совершения платежа.
     * Платеж возможен только если на счете достаточно средств.
     *
     * @param amount сумма платежа
     * @return true, если платеж успешен, иначе false
     */
    @Override
    public boolean pay(long amount) {
        if (amount <= 0) {
            return false; // Сумма должна быть положительной
        }
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}