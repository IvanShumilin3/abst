//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Создаем обычный счет с начальным балансом 1000
        Account simpleAccount = new SimpleAccount(1000);
        System.out.println("Баланс SimpleAccount: " + simpleAccount.getBalance());

        // Пополняем счет
        System.out.println("Пополнение на 500: " + simpleAccount.add(500));
        System.out.println("Баланс после пополнения: " + simpleAccount.getBalance());

        // Совершаем покупку
        System.out.println("Покупка на 800: " + simpleAccount.pay(800));
        System.out.println("Баланс после покупки: " + simpleAccount.getBalance());

        // Создаем кредитный счет с начальным балансом 1000 и кредитным лимитом 500
        Account creditAccount = new CreditAccount(1000, 500);
        System.out.println("\nБаланс CreditAccount: " + creditAccount.getBalance());

        // Совершаем покупку, превышающую баланс, но не лимит
        System.out.println("Покупка на 1200: " + creditAccount.pay(1200));
        System.out.println("Баланс после покупки: " + creditAccount.getBalance());

        // Переводим деньги с одного счета на другой
        System.out.println("Перевод с SimpleAccount на CreditAccount: " + simpleAccount.transfer(creditAccount, 300));
        System.out.println("Баланс SimpleAccount после перевода: " + simpleAccount.getBalance());
        System.out.println("Баланс CreditAccount после перевода: " + creditAccount.getBalance());
    }
}