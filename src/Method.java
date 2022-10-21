import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Method {



    public String searchForCostumer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Var vänlig och mata in för-och " +
                "efetrnamn eller personnummer på den ni söker.");
        String receptionSearch = scanner.nextLine();
        while (receptionSearch.isBlank()){
            System.out.println("Ni verkar inte skrivit något, testa igen");
            receptionSearch = scanner.nextLine();
        }
        return receptionSearch;
    }
    public List<Costumer> readFromFile(Path costumerFile){
        List<Costumer> costumerFromFile = new ArrayList<>();

        String idNumber = "";
        String fullName = "";
        String paymentDate = "";

        try(Scanner scanner = new Scanner(costumerFile)){       //try with resources

            while (scanner.hasNext()){              //loop för att kapa upp och läsa in strängen från filen, enklare att använda scanner här än Buffered
                idNumber = scanner.next().replace("," , "").trim();
                if (scanner.hasNext()){
                    fullName = scanner.nextLine();
                    fullName = fullName.substring(1);
                    paymentDate = scanner.nextLine();
                }
                costumerFromFile.add(new Costumer(idNumber, fullName, paymentDate));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Filen hittades inte");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Något gick fel, kontakta din lokala programmerare");
        }
        return costumerFromFile;
    }







}
