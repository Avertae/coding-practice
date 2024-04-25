class Solution {
    public int dayOfYear(String date) {
        int year, month, day, yday = 0;
        year = Integer.parseInt(date.substring(0, 4));
        month = Integer.parseInt(date.substring(5, 7));
        day = Integer.parseInt(date.substring(8, 10));
        int[] monthday = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) monthday[1]++;
        for (int i = 0; i < month - 1; i++)
            yday += monthday[i];
        yday += day;
        return yday;
    }
}