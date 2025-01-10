package string;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int n = 0;
        for (int i = columnTitle.length()-1; i >= 0; i--) {
            int num = (int) Math.pow(26, n);
            int val = columnTitle.charAt(i) - 'A' + 1;
            sum += val * num;
            n++;
        }
        return sum;
    }

}
