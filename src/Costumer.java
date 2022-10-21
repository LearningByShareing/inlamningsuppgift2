public class Costumer {

    String idNumber;
    String fullName;
    String paymentDate;

    public Costumer(String idNumber, String fullName, String paymentDate) {
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.paymentDate = paymentDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
