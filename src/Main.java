import java.io.IOException;

public class Main {
    // Checked Exceptions - will be picked up at compile time / in IDE
    // Unchecked Exceptions - unforeseen and seen at run time - falls under RuntimeException type
    public static void main(String[] args) {
        System.out.println("Hello world!");
        bad();
    }

    private void good() throws IOException {
        // if using @Override the sub class/method cannot throw a
        // higher level exception than the super class
        try {
            // doing something
        } catch (IOException ex) {
            throw new IOException("Broken" + ex);
        } finally {
            // used for tidy up and closure - always runs unless System.exit(0) has been invoked
        }
    }

    private static void bad() throw IOException {
        StringBuilder sb = new StringBuilder();
        String str = null; // throw a NullPointerException
        try {
            sb.append("a");
            str.toUpperCase();
            sb.append("b");
        } catch (IllegalArgumentException ex) {
            sb.append("C");
            throws new IllegalArgumentException();
        } catch (Exception e) {
            sb.append("D");
        } finally {
            sb.append("e");
        }
        System.out.println(sb);
    }
}