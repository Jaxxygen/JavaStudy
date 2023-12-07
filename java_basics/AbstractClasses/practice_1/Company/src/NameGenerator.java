public class NameGenerator {
    private static final String[] NAMES = {"Александр", "Максим", "Михаил", "Марк", "Иван", "Артем", "Лев",
            "Дмитрий", "Матвей", "Даниил", "София", "Анна", "Мария", "Алиса", "Ева", "Виктория",
            "Полина", "Варвара", "Александра", "Анастасия"};
    private static final String[] SURNAMES = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров",
            "Соколов", "Михайлов", "Новиков", "Федоров", "Морозов", "Волков", "Алексеев", "Лебедев",
            "Семенов", "Егоров", "Павлов", "Козлов", "Степанов", "Орлов"};
    private static String fullName;
    public NameGenerator() {
        int randomNumber = (int) Math.round(Math.random() * 19);
        fullName = surnameCheck(NAMES[randomNumber].concat(" ").concat(SURNAMES[randomNumber]));
    }
    private String surnameCheck (String string) {
        String[] words = string.split(" ");
        String[] nameLetters = words[0].split("");
        String regex = "[ая]";
        if (nameLetters[nameLetters.length - 1].matches(regex)) {
            return string.concat("a");
        } else {
            return string;
        }
    }
    @Override
    public String toString() {
        return fullName;
    }
}