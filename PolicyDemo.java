import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PolicyDemo {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("PolicyInformation (1).txt"));

        int smokerCount = 0;
        int nonSmokerCount = 0;

        while (input.hasNext()) {
            int policyNumber = input.nextInt();
            input.nextLine(); // consume newline
            String providerName = input.nextLine();
            String firstName = input.nextLine();
            String lastName = input.nextLine();
            int age = input.nextInt();
            input.nextLine();
            String smokingStatus = input.nextLine();
            double height = input.nextDouble();
            double weight = input.nextDouble();
            if (input.hasNext()) input.nextLine(); // skip line

            PolicyHolder holder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
            Policy policy = new Policy(policyNumber, providerName, holder);

            if (smokingStatus.equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }

            System.out.println(policy);
            System.out.println();
        }

        input.close();

        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
