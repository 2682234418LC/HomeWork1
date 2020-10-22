package Test_1;

/**
 * 此类封装动物信息的代码
 */
public class Animal {
    private String kind;
    private String sex;
    private int age;

    public Animal(String kind,int age,String sex) {
        this.kind = kind;
        this.sex = sex;
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
