package Java.Code.HackerRank.WarmUpChallenges;

public class RepeatedString {
  /*
  There is a string, <string>, of lowercase English letters that is repeated infinitely many times. Given an integer,
   N , find and print the number of letter a's in the first N letters of the infinite string.
  Example
  <string> = 'abcac'
  N = 10
  The substring we consider is 'abcacabcac', the first 10 characters of the infinite string. There are 4
   occurrences of a in the substring.
  Function Description
    Complete the repeatedString function in the editor below.
    repeatedString has the following parameter(s):
      s: a string to repeat
      n: the number of characters to consider
  Returns
      int: the frequency of a in the substring
  Input Format
    The first line contains a single string, <string>
    The second line contains an integer, N
  Constraints
  Sample Input
  Sample Input 0
    aba
    10
  Sample Output 0
    7
  Explanation 0
    The first n = 10 letters of the infinite string are abaabaabaa. Because there are 7 a's, we return 7.
  Sample Input 1
    a
    1000000000000
  Sample Output 1
    1000000000000
  Explanation 1
    Because all of the first n = 1000000000000 letters of the infinite string are a, we return 1000000000000. */

  public static long repeatedString(String s, long n) {
    long count = 0;
    for (int index = 0; index < s.length(); index++) {
      if (s.charAt(index % s.length()) == 'a') {
        count++;
      }
    }
    count *= n / s.length();
    for (int index = 0; index < n % s.length(); index++) {
      if (s.charAt(index % s.length()) == 'a') {
        count++;
      }
    }
    return count;
  }
}
