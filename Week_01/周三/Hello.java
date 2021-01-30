package com.rongsoft.week1;

/**
 * 作业1_1
 */
public class Hello {
    public static void main(String[] args) {
        //  0: iconst_3 将int型(3)推送至栈顶
        //  1: istore_1  将栈顶int型数值存入第二个本地变量
        int a = 3;
        //  2: iconst_2 将int型(2)推送至栈顶
        //  3: istore_2  将栈顶int型数值存入第三个本地变量
        int b = 2;
        // 4: iload_1 将第二个int型本地变量推送至栈顶
        // 5: iload_2 将第三个int型本地变量推送至栈顶
        // 6: imul 将栈顶两int型数值相乘并将结果压入栈顶
        // 7: istore_3 将栈顶int型数值存入第四个本地变量
        int d = a * b;
        // 8: iload_1 将第二个int型本地变量推送至栈顶
        // 9: iload_3 将第四个int型本地变量推送至栈顶
        // 10: iadd  将栈顶两int型数值相加并将结果压入栈顶
        // 11: istore   4 将栈顶int型数值存入第五个本地变量
        int e = a + d;
        // 13: iload_1 将第二个int型本地变量推送至栈顶
        // 14: iload_2 如上
        // 15: if_icmple 23 若栈顶两int类型值前小于等于后则跳转。
        if (a > b) {
            // 18: iload_1
            // 19: iload_2
            // 20: isub 将栈顶两int类型数相减，结果入栈。
            // 21: istore 5
            int f = a - b;
        }
        // 23: iload_1
        // 24: iload_2
        // 25: idiv 将栈顶两int类型数相除，结果入栈
        // 26: istore 5
        int g = a / b;
        // 28: ldc       #2   // String abc 常量池中的常量值（int, float, string reference, object reference）入栈。
        String str = "abc";
        // 30: astore 6  将栈顶引用类型值保存到局部变量indexbyte中。
        char[] chars = str.toCharArray();
        // 32: iconst_0  将int型(0)推送至栈顶
        // 33: istore  7
        // 35: iload   7
        // 37: aload  6 从局部变量indexbyte中装载引用类型值入栈。
        // 39: invokevirtual #3   // Method java/lang/String.length:()I 运行时方法绑定调用方法。
        // 42: if_icmpge 59  若栈顶两int类型值前大于等于后则跳转。
        for (int i = 0; i < str.length(); i++) {
            // 45: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
            // 48: ldc           #5                  // String Hello
            // 50: invokevirtual #6                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
            // 53: iinc          7, 1  将整数值constbyte加到indexbyte指定的int类型的局部变量中。
            // 56: goto          35
            System.out.println("Hello:" + chars[i]);
        }
        // 59: return
    }
}
