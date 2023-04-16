package 题库.offer.I栈;

import java.util.Stack;

/*
 知识点：单调栈 单调最小站

  题目：
    请根据每日 气温 列表 temperatures ，重新生成一个列表
    ，要求其对应位置的输出为：要想观测到更高的气温，
    至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
    输入：temperatures = [73,74,75,71,69,72,76,73]
    输出: [1,1,4,2,1,1,0,0]
    思路：

     stack 中保留的是日期而不是温度
     题目要求：想要观测到更高的气温，至少需要等待的天数
     因此我们在栈中仅保留比当天温度更低的日子，这样可保证
     在找到一个高于栈顶的高温时候，可以将低于该高温的日子全部找出来

    下文具体进行了说明：

temperatures = [73(0),74(1),75(2),71(3),69(4),72(5),76(6),73(7)]

i = 0, stack = [], 将 0 放入栈中；
i = 1, stack = [0], temperatures[1] 高于 temperatures[0]，将 0 从 stack 中取出，result[0] = 1 - 0 = 1，将 1 放入栈中；
i = 2, stack = [1], temperatures[2] 高于 temperatures[1]，将 1 从 stack 中取出，result[2] = 2 - 1 = 1，将 2 放入栈中；
i = 3, stack = [2], temperatures[3] 低于 temperatures[2]，将 3 放入栈中；
i = 4，stack = [2,3]，temperatures[4] 低于 temperatures[3]，将 4 放入栈中；
i = 5，stack = [2,3,4]，temperatures[5] 高于 temperatures[4]，将 4 从 stack 中取出，result[4] = 5 - 4 = 1，temperatures[5] 高于 temperatures[3]，将 3 从 stack 中取出，result[3] = 5 - 3 = 2，将 5 放入栈中；
i = 6，stack = [2,5]，temperatures[6] 高于 temperatures[5]，将 5 从 stack 中取出，result[5] = 6 - 5 = 1，，将 6 放入栈中；
i = 7，stack = [2,6]，temperatures[7] 低于 temperatures[6]，将 7 放入栈中；


 */
public class offer_038 {
    public int[] dailyTemperatures(int[] temp) {
        int size = temp.length;
        int[] ans = new int[size];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {

            while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.add(i);
        }
        return ans;
    }

    public int[] dailyTemperatures1(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.add(i);
        }
        return ans;
    }

}
