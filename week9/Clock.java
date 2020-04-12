public class Clock {

    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m)
    {
        if (h < 0 || h > 23 || m < 0 || m > 59)
            throw new IllegalArgumentException("Outside of range");
        hours = h;
        minutes = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s)
    {
        if (s.length() != 5 || s.charAt(2) != ':') 
            throw new IllegalArgumentException("Wrong format");
        String s1 = s.substring(0, 2);
        String s2 = s.substring(3, s.length());
        int h = Integer.parseInt(s1);
        int m = Integer.parseInt(s2);
        if (h < 0 || h > 23 || m < 0 || m > 59)
            throw new IllegalArgumentException("Wrong format");
        hours = h;
        minutes = m;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString()
    {
        String s1 = "" + hours;
        String s2 = "" + minutes;
        if (hours < 10)
            s1 =  "0" + s1;
        if (minutes < 10)
            s2 = "0" + s2;
        return s1 + ":" + s2;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that)
    {
        if (this.hours == that.hours && this.minutes == that.minutes)
            return false;
        if (this.hours < that.hours)
            return true;
        if (this.hours == that.hours && this.minutes <= that.minutes)
            return true;
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic()
    {
        if (minutes == 59)
            hours = (hours + 1) % 24;
        minutes = (minutes + 1) % 60;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta)
    {
        if (delta < 0)
            throw new IllegalArgumentException("Negative delta");
      
        int currentTimeMinutes = hours * 60 + minutes;
        int minutesPerDay = 24 * 60;
        int newTimeMinutes = (currentTimeMinutes + delta) % minutesPerDay;

        hours = newTimeMinutes / 60;
        minutes = newTimeMinutes % 60;
    }

    // Test client (see below).
    public static void main(String[] args)
    {
        Clock currentTime1 = new Clock(5, 8);
        Clock currentTime2 = new Clock(5, 8);
        System.out.println(currentTime1.isEarlierThan(currentTime2));
    }
}
