
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    // 覆盖object父类的equals方法
    @Override
    public boolean equals(Object another) {
        // 同一个对象
        if (this == another)
            return true;

        // 判断传进来的对象是否是空对象
        if (another == null)
            return false;

        // 判断是否可以强制类型转换
        if (this.getClass() != another.getClass())
            return false;

        // 强制类型转换
        return this.name.equals(((Student) another).name);
    }
}
