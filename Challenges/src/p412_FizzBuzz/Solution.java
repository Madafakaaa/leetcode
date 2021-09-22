package p412_FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 16:59
 */
class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        String fizzBuzz = "FizzBuzz";
        String fizz = "Fizz";
        String buzz = "Buzz";
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                res.add(fizzBuzz);
            } else if (i % 3 == 0) {
                res.add(fizz);
            } else if (i % 5 == 0) {
                res.add(buzz);
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
