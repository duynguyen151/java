CÂU 1
/**
 * Giao diện IAnimal định nghĩa hành vi của các loài động vật.
 */
interface IAnimal {
    int MAX_AGE = 100; // Tuổi tối đa

    /**
     * Phát ra âm thanh của động vật.
     */
    void makeSound();
}

/**
 * Lớp cha Animal đại diện cho động vật, cài đặt một phần của IAnimal.
 */
class Animal implements IAnimal {
    private int age;

    /**
     * Khởi tạo đối tượng Animal với tuổi cụ thể.
     * @param age Tuổi của động vật.
     */
    public Animal(int age) {
        this.age = age;
    }

    /**
     * Lấy tuổi của động vật.
     * @return Tuổi.
     */
    public int getAge() {
        return age;
    }

    /**
     * Hiển thị thông tin.
     */
    public void showInfo() {
        System.out.println("Age of animal: " + age);
        System.out.println("MAX_AGE: " + MAX_AGE);
    }

    @Override
    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

/**
 * Lớp Cat mô tả loài mèo, kế thừa từ Animal.
 */
class Cat extends Animal {
    public String name;

    /**
     * Khởi tạo mèo.
     * @param name Tên mèo.
     * @param age Tuổi mèo.
     */
    public Cat(String name, int age) {
        super(age);
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Meow");
    }

    @Override
    public void showInfo() {
        System.out.println("Cat name: " + name);
        super.showInfo();
    }
}

/**
 * Lớp Dog mô tả loài chó.
 */
class Dog extends Animal {
    public String name;

    /**
     * Khởi tạo chó.
     * @param name Tên chó.
     * @param age Tuổi chó.
     */
    public Dog(String name, int age) {
        super(age);
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Woof");
    }

    @Override
    public void showInfo() {
        System.out.println("Dog name: " + name);
        super.showInfo();
    }
}

/**
 * Lớp chứa phương thức main chạy chương trình.
 */
public class Cau1 {
    public static void main(String[] args) {
        Animal animal = new Animal(5);
        Cat cat = new Cat("Mimi", 5);
        Dog dog = new Dog("Hachi", 5);

        animal.makeSound();
        cat.makeSound();
        dog.makeSound();

        animal.showInfo();
    }
}


CÂU 2
        import java.io.*;

/**
 * Lớp thực hiện ghi và đọc tên sinh viên từ file bằng OutputStreamWriter và InputStreamReader.
 */
public class Cau2 {
    public static void main(String[] args) {
        String[] names = {"Nguyễn Văn Minh", "Trần Đức Trung", "Lê Xuân Toàn"};
        String fileName = "students.txt";

        // Ghi tên vào file
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName))) {
            for (String name : names) {
                writer.write(name + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc và in ra nội dung file
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName))) {
            int ch;
            System.out.println("Nội dung file:");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


CÂU 3
/**
 * Lớp tính tổng hai đoạn số bằng hai luồng (Thread).
 */
public class Cau3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            long sum = 0;
            for (int i = 1; i <= 10000; i++) {
                sum += i;
            }
            System.out.println("Thread 1 - Tổng của các số từ 1 đến 10000: " + sum);
        });

        Thread t2 = new Thread(() -> {
            long sum = 0;
            for (int i = 10001; i <= 20000; i++) {
                sum += i;
            }
            System.out.println("Thread 2 - Tổng của các số từ 10001 đến 20000: " + sum);
        });

        t1.start();
        t2.start();
    }
}


CÂU 4
        import java.util.*;

/**
 * Lớp loại bỏ các phần tử trùng lặp trong mảng bằng HashSet.
 */
public class Cau4 {
    /**
     * Loại bỏ phần tử trùng lặp và in ra phần tử duy nhất.
     * @param array Mảng số nguyên.
     */
    public static void removeDuplicates(Integer[] array) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        System.out.println("Các phần tử duy nhất trong mảng:");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 2, 4, 5, 2, 4, 7, 7, 7, 4, 9, 1, 4};
        removeDuplicates(array);
    }
}


CÂU 5
        import java.util.*;
        import java.util.function.Consumer;

/**
 * Lớp Person lưu trữ thông tin một người gồm tên và tuổi.
 */
class Person {
    private String name;
    private int age;

    /**
     * Khởi tạo Person.
     * @param name Tên người.
     * @param age Tuổi người.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Trả về thông tin chi tiết của Person.
     * @return Chuỗi mô tả tên và tuổi.
     */
    @Override
    public String toString() {
        return "Tên: " + name + ", Tuổi: " + age;
    }
}

/**
 * Lớp chính dùng Consumer để in thông tin Person.
 */
public class Cau5 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", 30),
                new Person("Alice", 25),
                new Person("Bob", 35)
        );

        Consumer<Person> printPerson = p -> System.out.println(p.toString());

        System.out.println("Thông tin chi tiết của từng Person:");
        people.forEach(printPerson);
    }
}
