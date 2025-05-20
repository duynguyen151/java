CÂU 1

/**
 * Giao diện Customer định nghĩa các phương thức cho khách hàng.
 */
interface Customer {
    /**
     * Tính tổng số tiền khách hàng đã mua.
     *
     * @return Tổng số tiền sau khi áp dụng giảm giá hoặc tính điểm.
     */
    double calculateTotalPurchase();

    /**
     * Hiển thị thông tin khách hàng.
     */
    void showInfo();
}

/**
 * Lớp PremiumCustomer đại diện cho khách hàng cao cấp.
 */
class PremiumCustomer implements Customer {
    private String name;
    private int id;
    private double discountRate;
    private double totalPurchase;

    /**
     * Khởi tạo đối tượng PremiumCustomer.
     *
     * @param name          Tên khách hàng.
     * @param id            Mã khách hàng.
     * @param discountRate  Tỷ lệ giảm giá.
     * @param totalPurchase Tổng tiền mua ban đầu.
     */
    public PremiumCustomer(String name, int id, double discountRate, double totalPurchase) {
        this.name = name;
        this.id = id;
        this.discountRate = discountRate;
        this.totalPurchase = totalPurchase;
    }

    @Override
    public double calculateTotalPurchase() {
        return totalPurchase * (1 - discountRate / 100);
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Discount rate: " + discountRate + "%");
        System.out.println("Total purchase after discount: " + calculateTotalPurchase());
    }
}

/**
 * Lớp RegularCustomer đại diện cho khách hàng thông thường.
 */
class RegularCustomer implements Customer {
    private String name;
    private int id;
    private int point;
    private double totalPurchase;

    /**
     * Khởi tạo đối tượng RegularCustomer.
     *
     * @param name          Tên khách hàng.
     * @param id            Mã khách hàng.
     * @param point         Điểm tích lũy.
     * @param totalPurchase Tổng tiền mua ban đầu.
     */
    public RegularCustomer(String name, int id, int point, double totalPurchase) {
        this.name = name;
        this.id = id;
        this.point = point;
        this.totalPurchase = totalPurchase;
    }

    @Override
    public double calculateTotalPurchase() {
        return totalPurchase;
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Total purchase: " + totalPurchase);
        System.out.println("Points after purchase: " + (point + (int)(totalPurchase / 10)));
    }
}

/**
 * Lớp chính để chạy chương trình quản lý khách hàng.
 */
public class Cau1 {
    public static void main(String[] args) {
        Customer john = new PremiumCustomer("John", 12345, 10.0, 450.0);
        Customer jane = new RegularCustomer("Jane", 67890, 50, 800.0);

        john.showInfo();
        System.out.println();
        jane.showInfo();
    }
}


CÂU 2
        import java.io.*;

/**
 * Lớp Cau2 thực hiện ghi và đọc tên sinh viên vào/ra file văn bản.
 * Sử dụng BufferedWriter để ghi tiếng Việt (có dấu) và BufferedReader để đọc lại nội dung từ file.
 * Khi đọc, chương trình in phần họ của mỗi tên bằng chữ hoa và giữ nguyên phần còn lại.
 */
public class Cau2 {
    /**
     * Phương thức main là điểm khởi đầu của chương trình.
     * Ghi hai dòng họ tên sinh viên vào file "names_utf8.txt", sau đó đọc lại và in ra với phần họ in hoa.
     *
     * @param args Tham số dòng lệnh (không sử dụng trong chương trình này).
     */
    public static void main(String[] args) {
        // Ghi tên vào file với định dạng UTF-8
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("names_utf8.txt"), "UTF-8"))) {
            writer.write("Nguyễn Văn An\n");
            writer.write("Trần Thị Bình\n");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        // Đọc và hiển thị tên với phần họ in hoa
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("names_utf8.txt"), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Tách phần họ và phần còn lại
                String[] parts = line.trim().split(" ", 2);
                if (parts.length == 2) {
                    System.out.println(parts[0].toUpperCase() + " " + parts[1]);
                } else {
                    // Nếu dòng không chia tách được, in nguyên dòng
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}

CÂU 3.
/**
 * Lớp Cau3 tạo và chạy hai luồng (Thread) thực hiện các nhiệm vụ khác nhau:
 * - Thread 1: In ra các số chia hết cho 2 từ 1 đến 50.
 * - Thread 2: In ra các số nguyên tố từ 50 đến 100.
 */
public class Cau3 {

    public static void main(String[] args) {
        // Tạo luồng in số chia hết cho 2 từ 1 đến 50
        Thread evenThread = new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                if (i % 2 == 0) {
                    System.out.println("Thread 1 - Số chia hết cho 2: " + i);
                    try {
                        Thread.sleep(10); // giúp output xen kẽ rõ ràng hơn
                    } catch (InterruptedException e) {
                        System.out.println("Even thread interrupted.");
                    }
                }
            }
        });

        // Tạo luồng in số nguyên tố từ 50 đến 100
        Thread primeThread = new Thread(() -> {
            for (int i = 50; i <= 100; i++) {
                if (isPrime(i)) {
                    System.out.println("Thread 2 - Số nguyên tố: " + i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("Prime thread interrupted.");
                    }
                }
            }
        });

        // Khởi động cả hai luồng
        primeThread.start();
        evenThread.start();
    }

    /**
     * Phương thức kiểm tra một số có phải là số nguyên tố hay không.
     *
     * @param n Số cần kiểm tra.
     * @return true nếu là số nguyên tố, ngược lại false.
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

CÂU 4.
        import java.util.*;

/**
 * Lưu trữ danh sách sinh viên và điểm theo thứ tự tên.
 */
public class Cau4 {
    public static void main(String[] args) {
        Map<String, Integer> students = new LinkedHashMap<>();
        students.put("Nguyen Bao Ngoc", 88);
        students.put("Tran Tuan Anh", 92);
        students.put("Le Tuan Anh", 85);
        students.put("Nguyen Phuong An", 79);
        students.put("Le Van Cong", 95);

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(students.entrySet());
        sorted.sort(Comparator.comparing(Map.Entry::getKey));

        System.out.println("Danh sách sinh viên theo thứ tự họ tên:");
        for (Map.Entry<String, Integer> entry : sorted) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}


CÂU 5.
        import java.util.*;
        import java.util.stream.Collectors;

/**
 * Dùng lambda để chuyển các chuỗi thành viết hoa.
 */
public class Cau5 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape", "watermelon");

        List<String> uppercased = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Danh sách các chuỗi viết hoa:");
        uppercased.forEach(System.out::println);
    }
}

