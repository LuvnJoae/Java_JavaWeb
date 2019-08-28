package Demo6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        1. 键盘录入，接收用户名和密码
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String username = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();
//        2. 调用方法
            boolean loginFlag = new jdbc2().login2(username, password);
//        3. 判断结果，输出不同语句
            if (loginFlag){
                System.out.println("登陆成功");
            }else {
                System.out.println("登录失败,用户名或密码错误");
            }
        }
}
