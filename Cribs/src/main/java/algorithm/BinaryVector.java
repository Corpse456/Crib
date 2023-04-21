package algorithm;

public class BinaryVector {

    public int findUnitsSequential(byte[] array) {
        int maxSequential = 0;
        int currentSequential = 0;
        for (final byte number : array) {
            if (number == 1) {
                currentSequential++;
            } else {
                currentSequential = 0;
            }
            if (currentSequential > maxSequential) {
                maxSequential = currentSequential;
            }
        }
        return maxSequential;
    }
}
