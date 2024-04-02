public class Main {

        // И всего на сайт заходило 1000 различных пользователей
    private static final int USERS = 20;


    public static void main(String[] args) throws InterruptedException {

            SiteStorage redis = new SiteStorage();
            redis.init();
            for(int i = 1; i <= USERS; i++) {
                redis.siteUser(i);
            }
            redis.promotion();
        }
}
