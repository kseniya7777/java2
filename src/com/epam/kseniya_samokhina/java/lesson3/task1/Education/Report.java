package com.epam.kseniya_samokhina.java.lesson3.task1.Education;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Report {

    public void getReport(int reportSelection, Date startDate, ArrayList<Course> courses) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat simpleHourFormat = new SimpleDateFormat("HH");
        Date currentDate = new Date();
        Date currentHour = new Date();
        simpleDateFormat.format(currentDate);
        simpleHourFormat.format(currentHour);

        int HoursOfCourse = 0;
        for (Course course : courses) {
            HoursOfCourse += course.duration;
        }
        int daysOfCourse = HoursOfCourse / 8;
        int hoursOfCourse = HoursOfCourse % 8;
        long difBetweenDates = currentDate.getTime() - startDate.getTime();
        int passedDays = (int) (difBetweenDates / (24 * 60 * 60 * 1000));
        int passedHours = Integer.parseInt(simpleHourFormat.format(currentHour));
        if (reportSelection == 1) {
            if (passedDays > daysOfCourse || (passedDays == daysOfCourse && passedHours >= hoursOfCourse + 10)) {
                System.out.print("Обучение закончено.");
                int laterDays = passedDays - daysOfCourse;
                int laterHours = Math.min(18, passedHours) - (hoursOfCourse + 10);
                System.out.print(" После окончания прошло " + laterDays + " д " + laterHours + " ч" + "\n");
            } else {
                System.out.print("Обучение не закончено.");
                int leftDays = daysOfCourse - passedDays;
                if (passedHours >= 18) {
                    leftDays--;
                }
                int leftHours = (hoursOfCourse + 10) - Math.min(10, Math.max(10, passedHours));
                System.out.print(" До окончания осталось " + leftDays + " д " + leftHours + " ч" + "\n");
            }
        } else {
            System.out.println("Длительность программы в часах - " + HoursOfCourse + " ч");
            System.out.println("Дата старта: " + simpleDateFormat.format(startDate));

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            int addDays = daysOfCourse;
            if (hoursOfCourse != 0)
                addDays++;
            calendar.add(Calendar.DAY_OF_MONTH, addDays - 1);
            Date finishDate = calendar.getTime();
            System.out.println("Дата завершения: " + simpleDateFormat.format(finishDate));

            if (passedDays > daysOfCourse || (passedDays == daysOfCourse && Integer.parseInt(String.valueOf(currentHour)) >= hoursOfCourse + 10)) {
                int laterDays = passedDays - daysOfCourse;
                int laterHours = Math.min(18, passedHours) - (hoursOfCourse + 10);
                System.out.print(" После окончания прошло " + laterDays + " д " + laterHours + " ч" + "\n");
            } else {
                int leftDays = daysOfCourse - passedDays;
                if (passedHours >= 18) {
                    leftDays--;
                }
                int leftHours = (hoursOfCourse + 10) - Math.min(10, Math.max(10, passedHours));
                System.out.print(" До окончания осталось " + leftDays + " д " + leftHours + " ч" + "\n");
            }
        }
    }
}
