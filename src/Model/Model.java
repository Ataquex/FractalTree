package Model;

public class Model {
    private int FirstBranchLength = 100;
    private float BranchLengthScaling = (float)0.67;
    private int NumberBranchesPerNode = 2;
    private double AngleBranchesPerNode = 120;
    private double AngleMotherToDaughterBranch = 120;
    private int RealizationLimit = 6;
    private int randomness = 0;

    public int getFirstBranchLength() {
        return FirstBranchLength;
    }

    public void setFirstBranchLength(int firstBranchLength) {
        FirstBranchLength = firstBranchLength;
    }

    public float getBranchLengthScaling() {
        return BranchLengthScaling;
    }

    public void setBranchLengthScaling(float branchLengthScaling) {
        branchLengthScaling /= 100;
        BranchLengthScaling = branchLengthScaling;
    }

    public int getNumberBranchesPerNode() {
        return NumberBranchesPerNode;
    }

    public void setNumberBranchesPerNode(int numberBranchesPerNode) {
        NumberBranchesPerNode = numberBranchesPerNode;
    }

    public double getAngleBranchesPerNode() {
        return AngleBranchesPerNode;
    }

    public void setAngleBranchesPerNode(int angleBranchesPerNode) {
        double angleBranchesPerNodef = angleBranchesPerNode;
        angleBranchesPerNodef /= 180;
        AngleBranchesPerNode = angleBranchesPerNodef;
    }

    public double getAngleMotherToDaughterBranch() {
        return AngleMotherToDaughterBranch;
    }

    public void setAngleMotherToDaughterBranch(int angleMotherToDaughterBranch) {
        double angleMotherToDaughterBranchf = angleMotherToDaughterBranch;
        angleMotherToDaughterBranchf /= 180;
        AngleMotherToDaughterBranch = angleMotherToDaughterBranchf;
    }

    public int getRealizationLimit() {
        return RealizationLimit;
    }

    public void setRealizationLimit(int realizationLimit) {
        RealizationLimit = realizationLimit;
    }

    public int getRandomness() {
        return randomness;
    }

    public void setRandomness(int randomness) {
        this.randomness = randomness;
    }
}