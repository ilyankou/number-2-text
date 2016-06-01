public class Number2Text {
  static String[] ones = { "",
                    "one",
                    "two",
                    "three",
                    "four",
                    "five",
                    "six",
                    "seven",
                    "eight",
                    "nine",
                    "ten",
                    "eleven",
                    "twelve",
                    "thirteen",
                    "forteen",
                    "fifteen",
                    "sixteen",
                    "seventeen",
                    "eighteen",
                    "nineteen",
                  };

  static String[] tens = { "", "", "twenty",
                    "thirty",
                    "forty",
                    "fifty",
                    "sixty",
                    "seventy",
                    "eighty",
                    "ninety",
                  };

  static String[] big = {
                    "",
                    "thousand",
                    "million",
                    "trillion",
                    "quadrillion",
                    "quintillion",
                    "sextillion",
                  };

  public static void main(String[] args) {
    String numberStr = "";
    String hundred = " hundred ";
    String toAdd = "";
    int numberInt = Integer.parseInt(args[0]);
    int a, b, c, t;

    int triple = 0;

    while (numberInt > 0) {
      t = numberInt % 1000;
      numberInt /= 1000;

      if (t < 20) {
        toAdd = ones[t];
      } else {
        a = t / 100;
        b = (t - a * 100) / 10;
        c = t % 10;

        if (a > 0) {
          if (10 * b + c < 20) {
            toAdd = ones[a] + hundred + ones[10 * b + c];
          } else {
            toAdd = ones[a] + hundred + tens[b] + "-" + ones[c];
          }
        } else {
          toAdd = tens[b] + "-" + ones[c];
        }
      }

      numberStr = toAdd + " " + big[triple] + " " + numberStr;

      triple++;
    }

    System.out.print(numberStr + "\n");
  }

}
