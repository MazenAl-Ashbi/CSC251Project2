
/**
 * The Policy class represents an insurance policy with associated policyholder information.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds

    /**
     * Constructs a Policy object with specified information.
     * @param policyNumber The policy number.
     * @param providerName The provider name.
     * @param policyholderFirstName The policyholder's first name.
     * @param policyholderLastName The policyholder's last name.
     * @param policyholderAge The policyholder's age.
     * @param smokingStatus The smoking status ("smoker" or "non-smoker").
     * @param height The height in inches.
     * @param weight The weight in pounds.
     */
    public Policy(int policyNumber, String providerName, String policyholderFirstName,
                  String policyholderLastName, int policyholderAge, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * @return the BMI calculated from height and weight.
     */
    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * @return the calculated price of the policy based on age, smoking status, and BMI.
     */
    public double getPolicyPrice() {
        double price = 600.0;
        if (policyholderAge > 50) price += 75;
        if (smokingStatus.equalsIgnoreCase("smoker")) price += 100;
        if (getBMI() > 35) price += 75;
        return price;
    }

    /**
     * Displays policy information.
     */
    public void displayPolicyInfo() {
        System.out.printf("Policy Number: %d\n", policyNumber);
        System.out.printf("Provider Name: %s\n", providerName);
        System.out.printf("Policyholder's First Name: %s\n", policyholderFirstName);
        System.out.printf("Policyholder's Last Name: %s\n", policyholderLastName);
        System.out.printf("Policyholder's Age: %d\n", policyholderAge);
        System.out.printf("Policyholder's Smoking Status (smoker/non-smoker): %s\n", smokingStatus);
        System.out.printf("Policyholder's Height: %.1f inches\n", height);
        System.out.printf("Policyholder's Weight: %.1f pounds\n", weight);
        System.out.printf("Policyholder's BMI: %.2f\n", getBMI());
        System.out.printf("Policy Price: $%.2f\n\n", getPolicyPrice());
    }

    /**
     * @return the smoking status of the policyholder.
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }
}
