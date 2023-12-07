public class Elevator {
    private int curretFlour = 1;
    private int minFlour;
    private int maxFlour;

    public Elevator(int minFlour, int maxFlour) {
        this.minFlour = minFlour;
        this.maxFlour = maxFlour;
    }

    public int getCurretFlour() {
        return curretFlour;
    }

    public void moveDown() {
        curretFlour = curretFlour - 1;
    }
    public void moveUp() {
        curretFlour = curretFlour + 1;
    }
    public void move(int flour) {
        if (curretFlour == flour) {
            System.out.println("Вы находитесь на этом этаже");
        } else if (curretFlour <= flour && flour >= minFlour && flour <= maxFlour) {
            while (curretFlour != flour) {
                moveUp();
                System.out.println("Этаж: " + curretFlour);
            }
        } else if (curretFlour >= flour && flour >= minFlour && flour <= maxFlour) {
            while (curretFlour != flour){
                moveDown();
                System.out.println("Этаж: " + curretFlour);
            }
        } else {
            System.out.println("В доме нет данного этажа");
        }
    }
}
