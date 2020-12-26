package classesInstance;

public class Tank {

    private int size;
    private int currentVolume = 0;

    public Tank(int startSize) {
        this.size = startSize;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isPositive(int value) {
        return value >= 0;
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
}