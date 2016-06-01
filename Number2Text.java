/**
 * Prints out text representation of an integer. For example,
 * 333: three hundred thirty-three
 *
 * @author Ilya Ilyankou <ilya.ilyankou@trincoll.edu>
 * @version 0.1, 06/01/2016
 */

public class Number2Text {

  public static void main(String[] args) {

    if (args.length != 1) {
      System.out.println("Usage: java Number2Text [integer]\nAborting.");
  		return;
  	}

    int n = Integer.parseInt(args[0]);

    String[] ones = { "",
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

    String[] tens = { "",   // first 20 numbers are hardcoded
                      "",   // in ones[] above
                      "twenty",
                      "thirty",
                      "forty",
                      "fifty",
                      "sixty",
                      "seventy",
                      "eighty",
                      "ninety",
                    };

    String[] huge = { "",   // nothing for integers <= 999
                      "thousand",
                      "million",
                      "trillion",
                      "quadrillion",
                      "quintillion",
                      "sextillion",
                    };

    String nStr = "";
    String hundred = " hundred ";
    String piece = "";

    int a, b, c, t;
    int triple = 0;

    if (n == 0) {
      nStr = "zero";
    }

    while (n > 0) {
      t = n % 1000;
      n /= 1000;

      if (t < 20) {
        piece = ones[t];
      } else {
        a = t / 100;
        b = (t - a * 100) / 10;
        c = t % 10;

        if (a > 0) {
          if (10 * b + c < 20) {
            piece = ones[a] + hundred + ones[10 * b + c];
          } else {
            piece = ones[a] + hundred + tens[b] + "-" + ones[c];
          }
        } else {
          piece = tens[b] + "-" + ones[c];
        }
      }

      if (t == 0) {
        nStr = piece + " " + nStr;
      } else {
        nStr = piece + " " + huge[triple] + " " + nStr;
      }

      triple++;
    }

    // Removing extra spaces
    nStr = nStr.trim().replaceAll(" +", " ");

    System.out.print(nStr + "\n");
  }

}
