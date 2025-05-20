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
