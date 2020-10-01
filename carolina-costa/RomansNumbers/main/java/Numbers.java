public class Numbers {

    private String romanGroup[] = {"zero", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};

    public String convertIntToRoman(Integer number) {
        for (int i = 0; i < romanGroup.length; i++) {
            if (number != null && number > 0 && i == number) {
                return romanGroup[i];
            }
        }
        return null;
    }

    public Integer convertRomanToInt(String roman) {
        for (int i = 0; i < romanGroup.length; i++) {
            if (roman != null && romanGroup[i].equalsIgnoreCase(roman)) {
                return i;
            }
        }
        return null;
    }
}
