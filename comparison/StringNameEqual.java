public class StringNameEqual {
    public static void main(String[] args) {
        // String comparison
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        boolean areStringsEqual = str1.equals(str2); // true
        boolean areStringsEqual2 = str1.equals(str3); // true
        boolean areStringReferencesEqual = (str1 == str2); // true (because of string pool)
        boolean areStringReferencesEqual2 = (str1 == str3); // false (different references)

        System.out.println("areStringsEqual: " + areStringsEqual);
        System.out.println("areStringsEqual2: " + areStringsEqual2);
        System.out.println("areStringReferencesEqual: " + areStringReferencesEqual);
        System.out.println("areStringReferencesEqual2: " + areStringReferencesEqual2);

        // Numeric comparison
        int num1 = 10;
        int num2 = 10;
        boolean areIntegersEqual = (num1 == num2); // true

        System.out.println("areIntegersEqual: " + areIntegersEqual);

        // Floating-point comparison
        double num3 = 0.2;
        double num4 = 0.1 + 0.1;
        final double EPSILON = 1E-14;
        boolean areDoublesNearlyEqual = Math.abs(num3 - num4) < EPSILON; // true

        System.out.println("areDoublesNearlyEqual: " + areDoublesNearlyEqual);

        // Wrapped integers comparison
        Integer num5 = 10;
        Integer num6 = 10;
        boolean areWrappedIntegersEqual = num5.equals(num6); // true

        System.out.println("areWrappedIntegersEqual: " + areWrappedIntegersEqual);
    }
}
