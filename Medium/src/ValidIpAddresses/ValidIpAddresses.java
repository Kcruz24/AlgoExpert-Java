package ValidIpAddresses;

import java.util.ArrayList;

public class ValidIpAddresses
{
    public static void main(String[] args) {
        String ipAddress = "3700100";
        String ipAddress2 = "1921680";
        String ipAddress3 = "00010";
        String ipAddress4 = "100100"; // Failed
        String ipAddress5 = "1072310"; // Failed
        String ipAddress6 = "00001";

        int i = 1;
        for (String str : validIPAddresses(ipAddress5)) {
            System.out.println(i + ") " + str);
            i++;
        }
    }

    // O(1) time | O(1) space
    public static ArrayList<String> validIPAddresses(String string) {
        if (string.length() < 4)
            return new ArrayList<>();

        var ipAddresses = new ArrayList<String>();
        StringBuilder address = new StringBuilder(string);

        String insertPoint = ".";
        int point1 = 1, point2 = 3, point3 = 5;

        address.insert(point1, insertPoint);
        address.insert(point2, insertPoint);
        address.insert(point3, insertPoint);

        String section1 = address.substring(0, point1);
        String section2 = address.substring(point1 + 1, point2);
        String section3 = address.substring(point2 + 1, point3);
        String section4 = address.substring(point3 + 1, address.length());

        // Moving first point forward loop
        while (point1 < point2 - 1 && point2 < point3 - 1 && point3 < address.length() - 1) {
            // Moving second point forward loop
            while (point2 < point3 - 1 && point3 < address.length() - 1) {
                // Moving third point forward loop
                while (point3 < address.length() - 1) {
                    if (isValid(section1) && isValid(section2) && isValid(section3) && isValid(section4))
                        ipAddresses.add(address.toString());

                    // Moving the third point forward
                    address.replace(point3, point3 + 1, "");
                    point3++;
                    address.insert(point3, insertPoint);

                    // Update section 3
                    if (point2 < point3 - 1)
                        section3 = address.substring(point2 + 1, point3);

                    // Update section 4
                    if (point3 < address.length() - 1)
                        section4 = address.substring(point3 + 1, address.length());
                }

                // Moving the second point forward
                if (point2 < point3 - 2) {
                    address.replace(point2, point2 + 1, "");
                    point2++;
                    address.insert(point2, insertPoint);
                }

                // Update section 2
                if (point1 < point2 - 1)
                    section2 = address.substring(point1 + 1, point2);

                // Reset third point
                address.replace(point3, point3 + 1, "");
                point3 = point2 + 2;
                address.insert(point3, insertPoint);

                // Update section 3
                if (point2 < point3 - 1)
                    section3 = address.substring(point2 + 1, point3);

                // Update section 4
                if (point3 < address.length() - 1)
                    section4 = address.substring(point3 + 1, address.length());
            }

            // Moving the first point forward
            address.replace(point1, point1 + 1, "");
            point1++;
            address.insert(point1, insertPoint);

            // Update section 1
            section1 = address.substring(0, point1);

            // Reset second point
            address.replace(point2, point2 + 1, "");
            point2 = point1 + 2;
            address.insert(point2, insertPoint);

            // Update section 2
            if (point1 < point2 - 1)
                section2 = address.substring(point1 + 1, point2);

            // Reset third point
            address.replace(point3, point3 + 1, "");
            point3 = point2 + 2;
            address.insert(point3, insertPoint);

            // Update section 3
            if (point2 < point3 - 1)
                section3 = address.substring(point2 + 1, point3);

            // Update section 4
            if (point3 < address.length() - 1)
                section4 = address.substring(point3 + 1, address.length());
        }

        return ipAddresses;
    }

    public static boolean isValid(String section) {
        if (Integer.parseInt(section) > 255)
            return false;

        return section.charAt(0) != '0' || section.length() <= 1;
    }
}