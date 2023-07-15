package Java.code.unsorted.classes.classesInstance;

public class Tank {
    private int currentVolume = 0;
    private int size;

    public Tank(int startSize) {
        this.size = startSize;
    }

    public void addValue(int value) {
        this.currentVolume += value;
        if (!isPositive(this.currentVolume)) {
            this.size -= this.currentVolume;
            this.currentVolume = 0;
        } else if (this.size < this.currentVolume) {
            this.size = this.currentVolume;
        }
    }

    public boolean isPositive(int value) {
        return value >= 0;
    }

    public int getSize() {
        return this.size;
    }
}
