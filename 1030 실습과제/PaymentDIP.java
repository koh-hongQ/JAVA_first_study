// PaymentMethod 추상화 클래스 정의
abstract class PaymentMethod {
    public abstract void pay(double amount);
}

// CreditCardPayment 클래스
class CreditCardPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

// PayPalPayment 클래스
class PayPalPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// BankTransferPayment 클래스
class BankTransferPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bank Transfer.");
    }
}

// PaymentProcessor 클래스
class PaymentProcessor {
    private PaymentMethod paymentMethod;

    // 생성자에서 PaymentMethod 타입을 받아옴
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // processPayment 메서드
    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

// 테스트용 메인 클래스
public class PaymentDIP {
    public static void main(String[] args) {
        PaymentMethod creditCardPayment = new CreditCardPayment();
        PaymentMethod payPalPayment = new PayPalPayment();
        PaymentMethod bankTransferPayment = new BankTransferPayment();

        PaymentProcessor paymentProcessor1 = new PaymentProcessor(creditCardPayment);
        paymentProcessor1.processPayment(100.0);

        PaymentProcessor paymentProcessor2 = new PaymentProcessor(payPalPayment);
        paymentProcessor2.processPayment(150.0);

        PaymentProcessor paymentProcessor3 = new PaymentProcessor(bankTransferPayment);
        paymentProcessor3.processPayment(200.0);
    }
}