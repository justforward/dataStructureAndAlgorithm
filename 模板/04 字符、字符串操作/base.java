package 模板.字符串操作;

public class base {
    public static void main(String[] args) {
        // char 和 数字互转
        // 1、给定单词 小写字母
        int[] nums = new int[26];
        char cur = 'b';
        int index = cur - 'a'; // index=1 从a=0开始

        // int 转byte
        char toChar = (char) (index + 'a'); // toChar=b
    }
}
