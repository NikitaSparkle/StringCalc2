package org.example.org.itstep;

import java.util.Arrays;

// это шняга

public class StringCalculator {
    public static int add(String input) throws SpliterFormatException, NumberNegativeException{
        if (input == null || input.equals("")) {
            return 0;
        }
        String[] nums;
        if (input.startsWith("//")) { // kata05 and next
            String[] parts = input.split("\n");
            String divider;
            String[] delimiters = getDelimiters(parts[0].substring(2).trim());
            if (delimiters.length <= 1) {
                divider = parts[0].substring(2).trim();
                divider = divider.replace("[", "")
                        .replace("]", "")
                        .replace("*", "\\D")
                        .replace("$","");
                if (!divider.contains("\\D") && !parts[1].contains(divider)) {
                    throw new SpliterFormatException();
                }
                for (char sym : divider.toCharArray()) {
                    if (Character.isDigit(sym)) {
                        throw new SpliterFormatException();
                    }
                }
            } else {
                divider = makeDivider(delimiters);
            }
            nums = parts[1].replace(" ", "").split(divider);
        } else {
            nums = input.split(",|\n");
        }
        int sum = 0;
        for (String n : nums) {
            int num = Integer.parseInt(n.trim());
            if(num<0){
                throw new NumberNegativeException();
            }
            if (num > 1000) {
                continue;
            }
            sum += num;
        }
        return sum;
    }

    public static int add(String input, String input2) throws SpliterFormatException, NumberNegativeException {
        int sum=add(input)+add(input2);
        return sum;
    }

    public static int add(String input, String input2, String input3) throws SpliterFormatException, NumberNegativeException {
        int sum=add(input)+add(input2)+add(input3);
        return sum;
    }

    public static String[] getDelimiters(String input) {
        String[] delimiters = new String[0];
        int start = -1;
        int end;
        while ((start = input.indexOf("[", start + 1)) >= 0) {
            end = input.indexOf("]", start + 1);
            delimiters = Arrays.copyOf(delimiters, delimiters.length + 1);
            delimiters[delimiters.length - 1] = input.substring(start + 1, end);
        }
        return delimiters;
    }

    public static String makeDivider(String[] input) {
        StringBuilder sb = new StringBuilder();
        for (String d : input) {
            sb.append("(").append(d.replace("*", "\\*").replace("|", "\\|")).append(")").append("|");
        }
        return sb.toString();
    }

}
