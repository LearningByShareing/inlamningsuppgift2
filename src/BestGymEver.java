
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class BestGymEver {

    Method method = new Method();
    Path path = Paths.get("src/costumers");
    final String fileCostumerVisit = "src/fileCostumerVisit";

    public static void main(String[] args) {
        BestGymEver bestGymEver = new BestGymEver();
        bestGymEver.mainProgram();
    }

    public void mainProgram()throws NullPointerException{
        List<Costumer> costumerList = method.readFromFile(path);
        while (true) {
                String receptionInput = method.searchForCostumer();
                System.out.println(findPayingCostumer(receptionInput, costumerList));
            }
    }


    public boolean validCostumer(String lastPayment ){
        LocalDate today = LocalDate.now();
       LocalDate paymentDate = LocalDate.parse(lastPayment);
        return paymentDate.isAfter(today.minusYears(1))
                || paymentDate.isAfter(today.minusYears(1));
    }

    public void saveCostumerVisit(String training, Costumer costumer) {

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(training, true))) {
            writer.append(costumer.getFullName()).append(" tränade ").append(String.valueOf(LocalDate.now())).append("}n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Filen hittades inte");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("något gick fel, kontakta din lokala programmerare");
        }
    }

    public String findPayingCostumer(String inputFromMain, List<Costumer> listFromMain){
        boolean payingCostumer;
        for (Costumer c : listFromMain){
            if(inputFromMain.equalsIgnoreCase(c.getFullName()) || inputFromMain.equals(c.getIdNumber())){
                String lastPayDate = c.getPaymentDate();
                payingCostumer = validCostumer(lastPayDate);
                if(payingCostumer){
                    saveCostumerVisit(fileCostumerVisit, c);
                    return c.getFullName() + " finns i listan och betalade medlemsavgiften "
                            + c.getPaymentDate();
                }else {
                    return c.getFullName() + " har inte betalat på över ett år.";
                }
            }
        }
        return inputFromMain + " finns inte i listan";
    }
}
