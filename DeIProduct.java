CÂU 1
/**
 * Giao diện IProduct định nghĩa các phương thức để lấy thông tin của một sản phẩm.
 */
interface IProduct {
    /**
     * Lấy tên của sản phẩm.
     *
     * @return Tên sản phẩm dạng chuỗi.
     */
    String getName();

    /**
     * Lấy mô tả của sản phẩm.
     *
     * @return Mô tả sản phẩm dạng chuỗi.
     */
    String getDescription();

    /**
     * Lấy giá của sản phẩm.
     *
     * @return Giá sản phẩm dạng số thực.
     */
    float getPrice();
}

/**
 * Lớp Phone triển khai giao diện IProduct, đại diện cho sản phẩm điện thoại.
 */
class Phone implements IProduct {
    private String model;          // Mẫu điện thoại
    private float screenSize;      // Kích thước màn hình (inch)
    private float price;           // Giá sản phẩm

    /**
     * Phương thức khởi tạo đối tượng Phone.
     *
     * @param model      Mẫu điện thoại.
     * @param screenSize Kích thước màn hình.
     * @param price      Giá sản phẩm.
     */
    public Phone(String model, float screenSize, float price) {
        this.model = model;
        this.screenSize = screenSize;
        this.price = price;
    }

    /**
     * Lấy tên của điện thoại.
     *
     * @return Tên điện thoại.
     */
    @Override
    public String getName() {
        return model;
    }

    /**
     * Lấy mô tả của điện thoại.
     *
     * @return Mô tả bao gồm kích thước màn hình.
     */
    @Override
    public String getDescription() {
        return "Phone with " + screenSize + " inches screen";
    }

    /**
     * Lấy giá của điện thoại.
     *
     * @return Giá điện thoại.
     */
    @Override
    public float getPrice() {
        return price;
    }
}

/**
 * Lớp Laptop triển khai giao diện IProduct, đại diện cho sản phẩm máy tính xách tay.
 */
class Laptop implements IProduct {
    private String model;
    private String screenResolution;
    private float price;

    /**
     * Phương thức khởi tạo đối tượng Laptop.
     *
     * @param model            Mẫu laptop.
     * @param screenResolution Độ phân giải màn hình.
     * @param price            Giá sản phẩm.
     */
    public Laptop(String model, String screenResolution, float price) {
        this.model = model;
        this.screenResolution = screenResolution;
        this.price = price;
    }

    /**
     * Lấy tên của laptop.
     *
     * @return Tên laptop.
     */
    @Override
    public String getName() {
        return model;
    }

    /**
     * Lấy mô tả của laptop.
     *
     * @return Mô tả bao gồm độ phân giải màn hình.
     */
    @Override
    public String getDescription() {
        return "Laptop with " + screenResolution + " screen resolution";
    }

    /**
     * Lấy giá của laptop.
     *
     * @return Giá laptop.
     */
    @Override
    public float getPrice() {
        return price;
    }
}

/**
 * Lớp cau1 chứa phương thức main để chạy chương trình.
 */
public class cau1 {
    /**
     * Phương thức main tạo đối tượng Phone và Laptop, sau đó hiển thị thông tin của chúng.
     *
     * @param args Tham số dòng lệnh (không sử dụng).
     */
    public static void main(String[] args) {
        IProduct phone = new Phone("iPhone 13", 6.1f, 999.99f);
        IProduct laptop = new Laptop("Macbook Pro", "Retina 4K", 1799.99f);

        System.out.println("Phone information:");
        System.out.println("Name: " + phone.getName());
        System.out.println("Description: " + phone.getDescription());
        System.out.println("Price: " + phone.getPrice() + " USD");

        System.out.println("\nLaptop information:");
        System.out.println("Name: " + laptop.getName());
        System.out.println("Description: " + laptop.getDescription());
        System.out.println("Price: " + laptop.getPrice() + " USD");
    }
}


CÂU 2
import java.io.*;
/**
 * Chương trình ghi dữ liệu vào file và đọc nội dung từ file, đồng thời đế đếm số dòng trong file.
 */
public class cau2 {
    /**
     * Phương thức main thực hiện các thao tác ghi và đọc file.
     *
     * @param args Đối số dòng lệnh (không sử dụng trong chương trình này)
     */
    public static void main(String[] args) {
        /**
         * Ghi dữ liệu vào file text.txt sử dụng FileWriter.
         *
         * @throws IOException Nếu có lỗi xảy ra trong quá trình ghi file.
         */
        try (FileWriter writer = new FileWriter("text.txt")) {
            writer.write("Kết nối tri thức\n");
            writer.write("Đại học Kinh tế Quốc dân\n");
            writer.write("Vũng bước tương lai\n");
            System.out.println("Ghi file thành công.");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        int lineCount = 0;
        /**
         * Đọc dữ liệu từ file text.txt sử dụng BufferedReader.
         *
         * @throws IOException Nếu có lỗi xảy ra trong quá trình đọc file.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }

        /**
         * Hiển thị tổng số dòng trong file.
         */
        System.out.println("Số dòng: " + lineCount);
    }
}

CÂU 3
/**
 * Chương trình tạo hai luồng (Thread) để hiển thị các số nguyên tăng dần và giảm dần.
 */
public class cau3 {
    /**
     * Phương thức main thực thi chương trình.
     *
     * @param args Đối số dòng lệnh (không sử dụng trong chương trình này)
     */
    public static void main(String[] args) {
        /**
         * Tạo luồng để in các số nguyên tăng dần từ 1 đến 10000.
         */
        Thread tangdan = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                System.out.print(i + " ");
            }
        });

        /**
         * Tạo luồng để in các số nguyên giảm dần từ 10000 đến 1.
         */
        Thread giamdan = new Thread(() -> {
            for (int i = 10000; i >= 1; i--) {
                System.out.print(i + " ");
            }
        });

        tangdan.start();
        giamdan.start();
    }
}

CÂU 4
/**
 * Chương trình đảo ngược một mảng sử dụng phương thức tổng quát (Generic method).
 */
public class cau4 {
    /**
     * Phương thức tổng quát để đảo ngược một mảng.
     *
     * @param <T>   Kiểu dữ liệu tổng quát của mảng
     * @param array Mảng cần đảo ngược
     */
    public static <T> void reverseArray(T[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            T temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Phương thức tổng quát để in ra các phần tử trong một mảng.
     *
     * @param <T>   Kiểu dữ liệu tổng quát của mảng
     * @param array Mảng cần in ra
     */
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Phương thức main để thử nghiệm việc đảo ngược và in mảng.
     *
     * @param args Đối số dòng lệnh (không sử dụng trong chương trình này)
     */
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5};
        System.out.println("Mảng Integer ban đầu:");
        printArray(integerArray);
        reverseArray(integerArray);
        System.out.println("Mảng Integer sau khi đảo ngược:");
        printArray(integerArray);

        String[] stringArray = {"hello", "world", "java", "programing"};
        System.out.println("Mảng String ban đầu:");
        printArray(stringArray);
        reverseArray(stringArray);
        System.out.println("Mảng String sau khi đảo ngược:");
        printArray(stringArray);
    }
}


CÂU 5
        import java.util.*;
        import java.util.stream.*;
/**
 * Chương trình tính tổng các số lẻ trong danh sách số nguyên sử dụng tham chiếu phương thức và Stream API.
 */
public class cau5 {
    /**
     * Phương thức xác định một số có phải là số lẻ hay không.
     *
     * @param number số cần kiểm tra
     * @return true nếu số là số lẻ, false ngược lại
     */
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    /**
     * Phương thức main thực thi chương trình.
     *
     * @param args đối số dòng lệnh (không sử dụng trong chương trình này)
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(41, 43, 22, 46, 35, 69, 71, 84, 97);

        int sumOdd = numbers.stream()
                .filter(cau5::isOdd)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Tổng các số lẻ trong danh sách là: " + sumOdd);
    }
}
