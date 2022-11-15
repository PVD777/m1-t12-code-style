import java.util.Scanner;       // отличный Code style, комментировать нечего!

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double amountWithPercent = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundOff(amountWithPercent, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double amountWithPercent = amount + amount * yearRate * depositPeriod;
        return roundOff(amountWithPercent, 2);
    }

    double roundOff(double value, int decimals) {
        double scale = Math.pow(10, decimals);
        return Math.round(value * scale) / scale;
    }

    void callMenu() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double amountWithPercent = 0;

        if (action == 1) {
            amountWithPercent = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            amountWithPercent = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + amountWithPercent);
    }

    public static void main(String[] args) {
        new DepositCalculator().callMenu();
    }

}
