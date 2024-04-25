class Solution {

    boolean isLeap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    int dateToDays(String date) {
        int year, month, day, amt = 0;
        year = Integer.parseInt(date.substring(0, 4));
        month = Integer.parseInt(date.substring(5, 7));
        day = Integer.parseInt(date.substring(8, 10));
        int[] monthday = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};

        for (int i = 1970; i < year; i++) {
            amt += 365;
            if (isLeap(i)) amt++;
        }
        for (int i = 0; i < month - 1; i++) {
            amt += monthday[i];
            if (i == 1 && isLeap(year)) 
                amt++;
        }
        amt += day;
        return amt;
    }

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(dateToDays(date1)- dateToDays(date2));
    }
}