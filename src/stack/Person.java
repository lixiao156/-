package stack;

/**
 * @author lixw
 * @date created in 22:27 2019/1/19
 */
public class Person {
    private  int age;
    private  String  name;

    public int getAge() {
        return age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
