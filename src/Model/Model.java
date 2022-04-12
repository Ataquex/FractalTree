package Model;

public class Model {
    private int FirstBranchLength = 100;
    private float BranchLengthScaling = (float)0.67;
    private int NumberBranchesPerNode = 2;
    private float AngleBranchesPerNode = (float)2.0944;
    private float AngleMotherToDaughterBranch = (float)2.0944;
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
        BranchLengthScaling = branchLengthScaling;
    }

    public int getNumberBranchesPerNode() {
        return NumberBranchesPerNode;
    }

    public void setNumberBranchesPerNode(int numberBranchesPerNode) {
        NumberBranchesPerNode = numberBranchesPerNode;
    }

    public float getAngleBranchesPerNode() {
        return AngleBranchesPerNode;
    }

    public void setAngleBranchesPerNode(float angleBranchesPerNode) {
        AngleBranchesPerNode = angleBranchesPerNode;
    }

    public float getAngleMotherToDaughterBranch() {
        return AngleMotherToDaughterBranch;
    }

    public void setAngleMotherToDaughterBranch(float angleMotherToDaughterBranch) {
        AngleMotherToDaughterBranch = angleMotherToDaughterBranch;
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