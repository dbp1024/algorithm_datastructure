import com.sun.javafx.binding.StringFormatter;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Student implements Comparable<Student>{
    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object another){
        if (this==another)
            return true;
        if (another == null)
            return false;
        if (this.getClass()!=another.getClass())
            return false;

       return this.name.equals(((Student)another).name);
    }

    @Override
    public int compareTo(Student another){
        return this.score - another.score;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, score:%d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("alice", 100));
        arr.addLast(new Student("bob", 90));
        arr.addLast(new Student("charles", 88));
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }
}