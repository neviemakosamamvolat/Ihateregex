import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean emailMatches(String e) {
        return Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$").matcher(e).matches();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,String> accinfo = new HashMap<>();
        while (true){
            System.out.println("Pre ukoncenie programu napiste frazu exit");
            System.out.println("Login(L) or Register(R)");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("exit")){
                System.exit(0);
            }
            if (input.equalsIgnoreCase("R")){
                System.out.println("Zadajte email:  ");
                String registermeno = scanner.nextLine();
                if (!emailMatches(registermeno)){
                    System.out.println("Meno neplatne prosim skuste znovu");
                    continue;
                }
                else{
                    System.out.println("Zadajte heslo(minimalne 6 znakov):  ");
                    String registerheslo = scanner.nextLine();
                    if (registerheslo.length()<6){
                        System.out.println("Heslo neplatne skuste znovu");
                        continue;
                    }
                    else {
                        accinfo.put(registermeno,registerheslo);
                        System.out.println("Registracia uspesna!");
                    }
                }
            }
            if (input.equalsIgnoreCase("L")){
                if (accinfo.isEmpty()){
                    System.out.println("Ziadny uzivatel nacitany prosim registrujte sa");
                    continue;
                }
                System.out.println("Zadajte prihlasovacie meno:  ");
                String loginname = scanner.nextLine();
                if (accinfo.containsKey(loginname)){
                    System.out.println("Zadajte heslo:"  );
                    String heslo = scanner.nextLine();
                    if(accinfo.get(loginname).equals(heslo)){
                        System.out.println("Vytajte v systeme pan prezident");
                    }
                    else {
                        System.out.println("Heslo nespravne skuste znova prosim(treba davat pozorn a male a velke pismena)");
                    }
                }
                else {
                    System.out.println("Meno neplatne vyskusajte znovu(odporucam davat pozor na male velke pismena)");
                    continue;
                }

            }

        }

    }
}
