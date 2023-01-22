package function;

import Db.DBManager;
import entity.*;

import java.util.ArrayList;
import java.util.List;

public class Func {
    public static Term getTermbyID(ArrayList<Term> arr, String id) {
        //Придумать через equals вытянуть семестр по id
        for (Term term : arr) {
            if (term.getId() == Integer.parseInt(id)) {
                return term;
            }
        }
        //Второй вариант
        // List<Term> terms = arr.stream().filter(term -> term.getId() == Integer.parseInt(id)).toList();
        //if(terms.size() == 0)
        //return arr.get(0);
        //else return terms.get(0);

        return arr.get(0);
    }

    public static double getAverageMark(ArrayList<DisciplineMark> disciplineMark) {
//        double result = 0;
//        for (DisciplineMark mark : disciplineMark) {
//            result += Double.parseDouble(mark.getMark());
// }

        final double asDouble = disciplineMark.stream().mapToInt(value -> Integer.parseInt(value.getMark())).average().getAsDouble();
        return asDouble;


        //return result / disciplineMark.size();
    }

    public static boolean loginMatch(String login) {
        DBManager manager = new DBManager();

        ArrayList<User> getLogin = manager.getLogins();

        for (User user : getLogin) {

            if (user.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }
}
