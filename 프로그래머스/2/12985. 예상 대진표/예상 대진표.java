import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        if (a % 2 == 0) {
            if (b + 1 == a) {
                return answer;
            }
        } else {
            if (a + 1 == b) {
                return answer;
            }
        }

        while (answer < n) {
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = a / 2 + 1;
            }
            
            if (b % 2 == 0) {
                b /= 2;
            } else {
                b = b / 2 + 1;
            }
            
            
            if (a % 2 == 0) {
                if (b + 1 == a) {
                    answer++;
                    break;
                }
            } else {
                if (a + 1 == b) {
                    answer++;
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}