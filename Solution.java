package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

   /* public static String getWeekdayOfBirthday(String birthday, String year) {
      String currentBirthday = birthday.substring(0,birthday.length()-4)+year;
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
      LocalDate localDate =LocalDate.parse(currentBirthday,formatter);
      String s = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ITALIAN).toString();
      //System.out.println(localDate.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ITALIAN));
        return s;
    }*/
   public static String getWeekdayOfBirthday(String birthday, String year) {
       DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.y");
       //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.y",Locale.ITALIAN);  вот так локаль не подхватывается
       //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.y").withLocale(Locale.ITALIAN);  и так тоже не идёт
       LocalDate localDate = LocalDate.parse(birthday,dateTimeFormatter);

       DateTimeFormatter yearFormater = DateTimeFormatter.ofPattern("y");
       Year year1 = Year.parse(year,yearFormater);
       //localDate.withYear(year1.getValue())  - возвращает новый объект localDate с той же датой, но в году который
       // передаётся как аргумент функции withYear(int year), а дальше можно так
       String s = localDate.withYear(year1.getValue()).format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN));
       // где "EEEE" шаблон полного названия дня недели
       //String s = localDate.withYear(year1.getValue()).format(DateTimeFormatter.ofPattern("EEEE",Locale.ITALIAN));// а так можно
       s = localDate.withYear(year1.getValue()).getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ITALIAN).toString();// но можно и так

       return s;

   }
}
