package seminar#2;

// Задача 3. Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class Zadacha_3 {
    static void json(String sql_js) {
        StringBuilder text = new StringBuilder();
        sql_js = sql_js.substring(2, sql_js.length() - 2);
        sql_js = sql_js.replace("},{", "<>");
        String[] arr_sql = sql_js.split("<>");
        for (int i = 0; i < arr_sql.length; i++) {
            String[] subarr_sql = arr_sql[i].trim().split(",");
            for (int j = 0; j < subarr_sql.length; j++) {
                String[] ssarr_sql = subarr_sql[j].trim().split(":");
                ssarr_sql[1] = ssarr_sql[1].replace("\"", "");
                if (j == 0)
                    text.append("Студент " + ssarr_sql[1]);
                if (j == 1)
                    text.append(" получил " + ssarr_sql[1]);
                if (j == 2)
                    text.append(" по предмету " + ssarr_sql[1]);
            }
            System.out.println(text);
            text.setLength(0);
        }
    }

    public static void main(String[] args) {
        String sql = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        json(sql);
    }
}
