import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Date;
import java.util.Random;

import static java.lang.System.out;

public class SiteStorage {

   private RedissonClient redissonClient;
   private RKeys rKeys;
   private RScoredSortedSet<String> users;

   private final static String KEY = "ONLINE_USERS";
   private static int promotionCounter = 1;

   private double getTs() {
      return (double) new Date().getTime() / 1000;
   }


   void init() {
      Config config = new Config();
      config.useSingleServer().setAddress("redis://127.0.0.1:6379");
      try {
         redissonClient = Redisson.create(config);
      } catch (RedisConnectionException Exc) {
         out.println("Не удалось подключиться к Redis");
         out.println(Exc.getMessage());
      }
      rKeys = redissonClient.getKeys();
      users = redissonClient.getScoredSortedSet(KEY);
      rKeys.delete(KEY);
   }

   void siteUser(int userId)
   {
      users.add(getTs(), String.valueOf(userId));
   }

   private String showSiteUser()
   {
      String user =  users.valueRange(0,0).toString();
      users.add(getTs(), users.first());
      return user;
   }
   public String showPaidPromotionUser(String userId)
   {
      double newScore = users.firstScore() - users.getScore(userId);
      users.add(newScore, userId);
      return users.valueRange(0,0).toString();
   }

   public void promotion() throws InterruptedException {

      for (;;) {
         Integer randomNum = new Random().nextInt(20) + 1;
         if (promotionCounter % 10 == 0) {
            String userPaid = showPaidPromotionUser("4");
            System.out.println("Пользователь "
                    .concat(userPaid)
                    .concat(" оплатил платный показ"));
         }
         System.out.println("На главной странице показываем пользователя ".concat(showSiteUser()));
         Thread.sleep(200);
         promotionCounter++;
      }
   }
}
