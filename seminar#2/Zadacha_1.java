package seminar#2;

// Задача 1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE 
// этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class Zadacha_1 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        String sql = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        sql = sql.substring(1, sql.length() - 1);
        String[] arr_sql = sql.split(",");
        for (int i = 0; i < arr_sql.length; i++) {
            String[] subarr_sql = arr_sql[i].trim().split(":");
            if (!subarr_sql[1].equals("\"null\"")) {
                subarr_sql[0] = subarr_sql[0].replace("\"", "");
                if (i == 0) {
                    result.append(subarr_sql[0] + "=" + subarr_sql[1]);
                } else {
                    result.append(" AND " + subarr_sql[0] + "=" + subarr_sql[1]);
                }
            }
        }
        System.out.println(result);
    }
}
