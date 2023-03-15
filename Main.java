import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        String[] RIM = {"I","II","III",	"IV","V","VI","VII","VIII",	"IX","X","XI","XII",
                "XIII",	"XIV","XV","XVI","XVII","XVIII","XIX","XX",	"XXI","XXII","XXIII","XXIV",
                "XXV",	"XXVI",	"XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV",
                "XXXV",	"XXXVI","XXXVII","XXXVIII",	"XXXIX","XL","XLI",	"XLII",	"XLIII","XLIV",	"XLV",
                "XLVI",	"XLVII","XLVIII","XLIX","L","LI","LII",	"LIII",	"LIV","LV","LVI","LVII",
                "LVIII","LIX",	"LX",	"LXI",	"LXII",	"LXIII","LXIV",	"LXV","LXVI","LXVII","LXVIII",
                "LXIX",	"LXX",	"LXXI",	"LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII",
                "LXXIX","LXXX",	"LXXXI","LXXXII","LXXXIII",	"LXXXIV","LXXXV","LXXXVI","LXXXVII",
                "LXXXVIII",	"LXXXIX","XC","XCI","XCII",	"XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"
        };
        //System.out.println("Консольный калькулятор.");
        //System.out.println("Введите выражение. В конце нажмите клавишу Enter.");
        //Scanner in = new Scanner(System.in);
        ////System.out.print("Input: ");
        //String Stroka = in.nextLine();  // Вводим строку
        String Stroka = input;// in.nextLine();  // Вводим строку
        ////System.out.print("Вы ввели: " + Stroka);  // Подтверждаем ввод
        //Stroka = Stroka.trim();  // Удаляем пробелы в начале и конце строки
        Stroka = Stroka.replaceAll(" ", ""); // удаляем все пробелы из строки
        ////System.out.print("    Строка без пробелов: " + Stroka);  // Подтверждаем ввод
        int index_deistvie = 0;
        //int index_deistvie = Stroka.indexOf("*");
        //System.out.println("Позиция *: " + index_deistvie);
        String Deistvie = Stroka.replaceAll("[0-9]", "" ).replaceAll("[I,V,X]", "");
        if (Deistvie.length() != 1) {
            try{
                throw new IOException();
            }
            catch (IOException e) {
                System.out.println("throws Exception //т.к. строка не является математической операцией, либо ");//  Выход с ошибкой
                System.out.println("throws Exception //т.к. введены недопустимые символы. Разрешнно только 1-10, I-X, либо ");//  Выход с ошибкой
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - допустимы только два операнда и один оператор (+, -, /, *) ");//  Выход с ошибкой
                System.exit(0);
            }
        }

        //  ===== -  Добавлена обработка некорректных операторов 14.03.2023 по замечанию Ментора.==============
        if (Deistvie.replaceAll("[*,+, //,-]", "" ).length() >= 1) {
            try{
                throw new IOException();
            }
            catch (IOException e) {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - допустим только один из операторов: (+, -, /, *) ");//  Выход с ошибкой
                System.exit(0);
            }
        }

        index_deistvie = Stroka.indexOf(Deistvie);
        ////System.out.print("   Место действия " + index_deistvie);

        char[] op1 = new char[index_deistvie];
        Stroka.getChars(0, index_deistvie, op1, 0);
        String Operator1 = new String(op1);
        //// System.out.print("   Первый Операнд " + Operator1);

        char[] op2 = new char[Stroka.length() - index_deistvie - 1];
        Stroka.getChars(index_deistvie + 1, Stroka.length(), op2, 0);
        String Operator2 = new String(op2);
        ////System.out.print("   Второй Операнд " + Operator2);

        ////System.out.println("   Действие : " + Deistvie);

        int Op1 = 0;
        int Op2 = 0; // Инициализация начальных значений операндов

        switch (Operator1) {
            case "1", "I":                Op1 = 1; break;
            case "2", "II":               Op1 = 2; break;
            case "3", "III":              Op1 = 3; break;
            case "4", "IV":               Op1 = 4; break;
            case "5", "V":                Op1 = 5; break;
            case "6", "VI":               Op1 = 6; break;
            case "7", "VII":              Op1 = 7; break;
            case "8", "VIII":             Op1 = 8; break;
            case "9", "IX":               Op1 = 9; break;
            case "10", "X":               Op1 = 10;break;
        }

        switch (Operator2) {
            case "1","I":              Op2 = 1; break;
            case "2", "II":            Op2 = 2; break;
            case "3", "III":           Op2 = 3; break;
            case "4", "IV":            Op2 = 4; break;
            case "5", "V":             Op2 = 5; break;
            case "6", "VI":            Op2 = 6; break;
            case "7", "VII":           Op2 = 7; break;
            case "8", "VIII":          Op2 = 8; break;
            case "9", "IX":            Op2 = 9; break;
            case "10", "X":            Op2 = 10; break;
        }

        if ((Op2==0)||(Op1==0))
        {
            try{ throw new IOException(); }
            catch (IOException e) {
                System.out.println("throws Exception //Ошибка в цифрах т.к. введены недопустимые числа. Разрешнны только числа от 1 до 10, и от I до X");//  Выход с ошибкой
                System.exit(0);
            }
        }

        if ((Operator1.replaceAll("[0-9]", "" ).length() ==
             Operator2.replaceAll("[I,V,X]", "").length()) ||
           (Operator2.replaceAll("[0-9]", "" ).length() ==
             Operator1.replaceAll("[I,V,X]", "").length())        )
        {
            try{ throw new IOException();  }
            catch (IOException e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");//  Выход с ошибкой
                System.exit(0);
            }
        }

        String type="0";
        if  (Operator1.replaceAll("[0-9]", "" ).length() == 0 &
            Operator2.replaceAll("[0-9]", "").length() == 0)
        { type = "ARABCHAR";
        }

        if  (Operator1.replaceAll("[I,V,X]", "" ).length() == 0 &
             Operator2.replaceAll("[I,V,X]", "").length() == 0)
        { type = "RIMCHAR";
        }

        int Result = 0;
        switch (Deistvie) {
            case "*":
                Result = Op1 * Op2; break;
            case "/":
                Result = Op1 / Op2;  break; // Проверить на 0 Op2
            case "+":
                Result = Op1 + Op2; break;
            case "-":
                Result = Op1 - Op2; break; //  Проверить на отрицательные значения
        }
        String RES = "";
        if (type == "RIMCHAR") {
            if (Result<=0)
            {
                try{ throw new IOException(); }
                catch (IOException e) {
                    System.out.println("throws Exception //т.к. получен 0, лтбо отрицательный результат, римские цифры меньше единицы не бывают");//  Выход с ошибкой
                    System.exit(0);
                }
            }
            //// System.out.println("Op1 = " + Op1 + " OP2 = " + Op2 + " Результат RIM " + RIM[Result - 1]);
            RES = RIM[Result - 1];
        }

        if (type == "ARABCHAR") {
            //// System.out.println("Op1 = " + Op1 + " OP2 = " + Op2 + " Результат : " + Result);
            RES = String.valueOf(Result);
        }
        return RES;
    }

    public static void main(String[] args)    {
        // ========  Ввод перенесен в Main по просьбе Ментора 15.03.2023г. ===============
        Scanner in = new Scanner(System.in);
        int n = 100;
        while(n>20) {
            System.out.print("Input: ");
            String user_input_stroka = in.nextLine();  // Вводим строку
            System.out.println("Output: " + calc(user_input_stroka));
        }

    }


}