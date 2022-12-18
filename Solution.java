import java.util.Scanner;

class Solution {
    public static void main(String args[]) {

        Scanner ch = new Scanner(System.in);
        System.out.println("How Many Object do you want to create : ");
        int numberObj = ch.nextInt();

        AutonomousCar obj[] = new AutonomousCar[numberObj];

        for (int i = 0; i < obj.length; i++) {

            int cardId;
            String brand;
            int noOfTestConducted;
            int noOfTestPassed;
            String environment;
            System.out.println("Enter Card Id : ");
            cardId = ch.nextInt();
            System.out.println("Enter Brand Name : ");
            brand = ch.next();
            System.out.println("Enter No of Test Conducted : ");
            noOfTestConducted = ch.nextInt();
            System.out.println("Enter Np of Test Passed  :");
            noOfTestPassed = ch.nextInt();
            System.out.println("Enter the Envirmonent : ");
            environment = ch.next();
            obj[i] = new AutonomousCar(cardId, brand, noOfTestConducted, noOfTestPassed, environment);

        }
        System.out.println("Enter the Environment for Method : ");
        String methodEnvironment = ch.next();
        System.out.println(findTestPassedByEnv(obj, methodEnvironment));
        System.out.println("Enter the Brand name for Method : ");
        String methodBrand = ch.next();
        AutonomousCar res = updateCarGrade(obj, methodBrand);
        if (res != null) {
            System.out.println(res.getBrand() + " :: " + res.getGrade());
        } else {
            System.out.println("not found");
        }

        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i].getCardId() + " - " + obj[i].getSuccessRate());
        }

        ch.close();

    }

    public static int findTestPassedByEnv(AutonomousCar obj[], String envorinment) {

        // if(vikas.equals(shanno))
        int sum = 0;
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].getEnvironment().equals(envorinment)) {
                sum = sum + obj[i].getNoOfTestPassed();
            }
            calculateSuccessRate(obj[i]);
        }
        return sum;
    }

    public static AutonomousCar updateCarGrade(AutonomousCar obj[], String brand) {
        AutonomousCar res = null;
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].getBrand().equals(brand)) {
                int rating = (obj[i].getNoOfTestPassed() * 100) / obj[i].getNoOfTestConducted();
                if (rating >= 80) {
                    obj[i].setGrade("A1");
                    obj[i].getGrade();

                } else {
                    obj[i].setGrade("B2");
                    obj[i].getGrade();
                }
                res = obj[i];

            }

        }
        return res;

    }

    public static void calculateSuccessRate(AutonomousCar obj) {
        double successRate;
        double TestPassed = 0.0;
        double TestConducted = 0.0;
        TestPassed = obj.getNoOfTestPassed();
        TestConducted = obj.getNoOfTestConducted();
        successRate = (TestPassed / TestConducted) * 100;
        obj.setSuccessRate(successRate);
    }

    // public static double[] calculateSuccessRate(AutonomousCar obj[]) {
    // double successrate[] = null;
    // double TestPassed =0.0;
    // double TestConducted = 0.0;
    // for(int i = 0;i<obj.length;i++){
    // TestPassed = obj[i].getNoOfTestPassed();
    // TestConducted = obj[i].getNoOfTestConducted();
    // successrate[i] = (TestPassed/TestConducted)*100;
    // }
    // return successrate[];
    // }

}

class AutonomousCar {

    private int cardId;
    private String brand;
    private int noOfTestConducted;
    private int noOfTestPassed;
    private String environment;
    private String grade;
    private double successRate;

    AutonomousCar(int cardId, String brand, int noOfTestConducted, int noOfTestPassed, String environment) {
        setCardId(cardId);
        setBrand(brand);
        setNoOfTestConducted(noOfTestConducted);
        setNoOfTestPassed(noOfTestPassed);
        setEnviornment(environment);

        System.out.println("Card no : " + getCardId() + " " + "Brand : " + getBrand() + " " + "No of Test Conducted : "
                + getNoOfTestConducted() + " " + "Number of Test Passed : " + getNoOfTestPassed() + " "
                + "Envornment : " + getEnvironment());

    }

    // Setter Methods
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNoOfTestConducted(int noOfTestConducted) {
        this.noOfTestConducted = noOfTestConducted;
    }

    public void setNoOfTestPassed(int noOfTestPassed) {
        this.noOfTestPassed = noOfTestPassed;
        ;
    }

    public void setEnviornment(String environment) {
        this.environment = environment;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    // Getter Methods
    public int getCardId() {
        return this.cardId;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getNoOfTestConducted() {
        return this.noOfTestConducted;
    }

    public int getNoOfTestPassed() {
        return this.noOfTestPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getGrade() {
        return this.grade;
    }

    public double getSuccessRate() {
        return this.successRate;
    }

}
