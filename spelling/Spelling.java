class Spelling {
    static String[] pad = new String[8];

    public static void main(String[] args) {
        pad[0] = "abc";
        pad[1] = "def";
        pad[2] = "ghi";
        pad[3] = "jkl";
        pad[4] = "mno";
        pad[5] = "pqrs";
        pad[6] = "tuv";
        pad[7] = "wxyz";

        FastIO fio = new FastIO();

        int num = fio.nextInt();

        for(int a = 0; a < num; a++) {
            String input = fio.nextLine();
            fio.println("Case #" + (a + 1) + ": " + phoneKeypad(input));
        }

        fio.close();
    }

    public static String phoneKeypad(String input) {
        String output = "";
        int lastPadNumber = -1;

        for(int a = 0; a < input.length(); a++) {
            char letter = input.charAt(a);

            if (letter == ' ') {
                if(lastPadNumber == 0) {
                    output += " ";
                }
                output += 0;
                lastPadNumber = 0;
            } else {
                for(int b = 0; b < pad.length; b++) {
                    if (pad[b].indexOf(letter) != -1) {
                        if( b + 2 == lastPadNumber) {
                            output += " ";
                        }

                        lastPadNumber = b + 2;
                        for(int c = 0; c <= pad[b].indexOf(letter); c++) {
                            output += b + 2;
                        }
                    }
                }
            }
        }

        return output;
    }
}
