public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank(100);
        System.out.println(bank.getSumAllAccounts());

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                String from = bank.getRandomAccNum();
                String to = bank.getRandomAccNum();
                try {
                    bank.transfer(from, to, 60_000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
            thread.join();
        }

        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                String from = bank.getRandomAccNum();
                String to = bank.getRandomAccNum();
                try {
                    bank.transfer(from, to, 10_000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        Thread thread = new Thread(() -> {
            System.out.println(bank);
            System.out.println(bank.getSumAllAccounts());
        });
        thread.join();
        thread.start();

    }
}
