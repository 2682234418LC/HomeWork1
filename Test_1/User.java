package Test_1;

import java.util.*;

/**
 * 此类为用户类
 * 编写用户需要执行的增删改查的判断代码
 */
public class User {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CRUDS cruds = new CRUDS();
        System.out.println("请输入您想要执行的操作：");
        System.out.println("输入  1：增加动物   2：删除动物  3：修改动物   4：查询动物");
        try {
            int i = scanner.nextInt();
            switch (i) {
                //增
                case 1:
                    System.out.println("请输入您想要增加的动物种类:");
                    //从控制器拿到用户输入的值，存入Animal对象中
                    String kind = scanner.next();
                    System.out.println("请输入您想要增加的动物的年龄:");
                    int age = scanner.nextInt();
                    if (age <= 0) {
                        System.out.println("您输入的年龄有误，请重新输入！！！");
                        break;
                    }
                    System.out.println("请输入您想要增加的动物性别:");
                    String sex = scanner.next();
                    cruds.add(new Animal(kind, age, sex));
                    break;
                //删
                case 2:
                    System.out.println("请输入您希望删除的动物：");
                    String Kind = scanner.next();
                    cruds.delete(Kind);
                    break;
                //改
                case 3:
                    System.out.println("请输入您希望修改的动物：");
                    String Kind1 = scanner.next();
                    System.out.println("请输入修改后的动物：");
                    String Kind2 = scanner.next();
                    System.out.println("请输入您希望修改动物的年龄:");
                    int Age = scanner.nextInt();
                    System.out.println("请输入您希望修改动物的性别:");
                    String Sex = scanner.next();
                    cruds.update(Kind1, Kind2, Age, Sex);
                    break;
                //查
                case 4:
                    System.out.println("请输入您希望查询的动物姓名:");
                    String Kind3 = scanner.next();
                    cruds.query(Kind3);
                    break;
                default:
                    System.out.println("请输入1~4范围内的整数！！！");
                    break;
            }
        } catch (Exception e) {
            System.out.println("请输入合法的字符！！！");
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("当前动物表为：");
        cruds.sort(cruds.list);
    }
}
