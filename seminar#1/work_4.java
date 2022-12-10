public class work_4 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String equal = "1?+?5=59";
        int x = 0; // Инициируем искомое число
        char question = '?';
        // Находим число после знака равно
        int sum = Character.getNumericValue(equal.charAt(6)) * 10 + Character.getNumericValue(equal.charAt(7));
        // В зависимости от местонахождения знака "?" находим искомое число
        if (equal.charAt(0) == question && equal.charAt(3) == question) {
            x = (sum - (Character.getNumericValue(equal.charAt(1)) + Character.getNumericValue(equal.charAt(4)))) / 20;
        } else if (equal.charAt(1) == question && equal.charAt(3) == question) {
            x = (sum - (Character.getNumericValue(equal.charAt(0)) * 10 + Character.getNumericValue(equal.charAt(4))))
                    / 11;
        } else if (equal.charAt(1) == question && equal.charAt(4) == question) {
            x = (sum - (Character.getNumericValue(equal.charAt(0)) * 10
                    + Character.getNumericValue(equal.charAt(3)) * 10)) / 2;
        } else if (equal.charAt(0) == question && equal.charAt(4) == question) {
            x = (sum - (Character.getNumericValue(equal.charAt(1)) + Character.getNumericValue(equal.charAt(3)) * 10))
                    / 11;
        }
        System.out.printf("Искомое число: %d", x);
    }
    
}
