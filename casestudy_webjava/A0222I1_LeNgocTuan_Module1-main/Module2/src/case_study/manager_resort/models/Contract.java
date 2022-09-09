package java_basic.manager_resort.models;

public class Contract {
    private String codeInvoice;
    private String bookingCode;
    private String voucher;
    private double discount;
    private double total;

    public Contract() {
    }

    public Contract(String codeInvoice, String bookingCode, String voucher, double discount, double total) {
        this.codeInvoice = codeInvoice;
        this.bookingCode = bookingCode;
        this.voucher = voucher;
        this.discount = discount;
        this.total = total;
    }

    public String getCodeInvoice() {
        return codeInvoice;
    }

    @Override
    public String toString() {
        return String.format("Contract{codeInvoice= %s, bookingCode= %s, voucher= %s, discount = %.2f %%, total = %.2f ",
                codeInvoice, bookingCode, voucher, discount * 100, total);
    }
}
