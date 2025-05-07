public abstract class Account {
    protected long balance; // Текущий баланс счета

    /**
     * Конструктор для инициализации начального баланса.
     *
     * @param initialBalance начальный баланс
     */
    public Account(long initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    /**
     * Метод для пополнения счета.
     *
     * @param amount сумма для пополнения
     * @return true, если пополнение успешно, иначе false
     */
    public boolean add(long amount) {
        if (amount <= 0) {
            return false; // Сумма должна быть положительной
        }
        balance += amount;
        return true;
    }

    /**
     * Абстрактный метод для совершения платежа.
     *
     * @param amount сумма платежа
     * @return true, если платеж успешен, иначе false
     */
    public abstract boolean pay(long amount);

    /**
     * Метод для перевода денег на другой счёт.
     *
     * @param account счёт, на который переводятся деньги
     * @param amount  сумма перевода
     * @return true, если перевод успешен, иначе false
     */
    public boolean transfer(Account account, long amount) {
        if (amount <= 0 || account == null) {
            return false; // Сумма должна быть положительной, а счёт не должен быть null
        }
        if (this.pay(amount)) { // Пытаемся совершить платёж
            account.add(amount); // Переводим деньги на другой счёт
            return true;
        }
        return false;
    }

    /**
     * Получение текущего баланса.
     *
     * @return текущий баланс
     */
    public long getBalance() {
        return balance;
    }
}