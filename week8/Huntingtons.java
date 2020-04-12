public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna)
    {
        int maxrepeats = 0;
        // StdOut.println(dna.substring(dna.length() - 3, dna.length()));
        for (int i = 0; i <= dna.length() - 3; i++)
            {
                int k = 0;
                int repeats = 0;
                while (i + k <= dna.length() - 3 &&
                       (dna.substring(i + k, i + 3 + k)).equals("CAG"))
                    {
                        k += 3;
                        repeats++;
                    }
                maxrepeats = Math.max(maxrepeats, repeats);
            }
        return maxrepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
        public static String removeWhitespace(String s)
    {
        // Strings in Java are immutable, so there is no way to change a string’s length or individual characters. The method removeWhitespace(s) returns a reference to a new string, which you can then assign to the variable s via the assignment statement s = removeWhitespace(s). Now, s refers to the new string, which has the same characters as the original string, but with the whitespace removed
        String c = s.replace("\n", ""); // new lines
        String d = c.replace("\t", ""); // tabs
        String e = d.replace(" ", ""); // spaces
        return e;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
        public static String diagnose(int maxRepeats)
    {
        if (maxRepeats >= 0 && maxRepeats <= 9)
            return "not human";
        if (maxRepeats >= 10 && maxRepeats <= 35)
            return "normal";
        if (maxRepeats >= 36 && maxRepeats <= 39)
            return "high risk";
        if (maxRepeats >= 40 && maxRepeats <= 180)
            return "Huntington’s";
        if (maxRepeats >= 181)
            return "not human";
        return "";
    }

    // Sample client (see below).
        public static void main(String[] args)
    {
        // Take the name of a file as a command-line argument
        String filename = args[0];
        // Read the genetic sequence from the file using the In class.
        In in = new In(filename);
        String inputStr = in.readAll();
        // StdOut.println(inputStr);

        // removing spaces, tabs and newlines from inputStr
        String withoutWhitespaceStr = removeWhitespace(inputStr);
        // Count the number of CAG repeats
        int maxNumberCAGrepeats = maxRepeats(withoutWhitespaceStr);
        StdOut.println("max repeats = " + maxNumberCAGrepeats);

        // Print a medical diagnosis 
        String medDiagnosis = diagnose(maxNumberCAGrepeats);
        StdOut.println(medDiagnosis);
    }


}
