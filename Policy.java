public class Policy {
    private static int policyCount = 0;

    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(
            policyHolder.getFirstName(),
            policyHolder.getLastName(),
            policyHolder.getAge(),
            policyHolder.getSmokingStatus(),
            policyHolder.getHeight(),
            policyHolder.getWeight()
        );
        policyCount++;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(
            policyHolder.getFirstName(),
            policyHolder.getLastName(),
            policyHolder.getAge(),
            policyHolder.getSmokingStatus(),
            policyHolder.getHeight(),
            policyHolder.getWeight()
        );
    }

    public double getPolicyPrice() {
        double bmi = policyHolder.calculateBMI();
        double price = 600.0;

        if (policyHolder.getAge() > 50) price += 75.0;
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) price += 100.0;
        if (bmi > 35) price += 75.0;

        return price;
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\n" + policyHolder.toString() +
               String.format("\nPolicy Price: $%.2f", getPolicyPrice());
    }
}
