package enums;

public enum Specialization {

    CARDIOLOGIST("cardiologist"),
    DERMATOLOGIST("dermatologist");

    private final String specialization;

    Specialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return specialization;
    }

    public static Specialization fromString(String text) {
        for (Specialization s : Specialization.values()) {
            if (s.specialization.equalsIgnoreCase(text)) {
                return s;
            }
        }
        throw new IllegalArgumentException("No enum constant for specialization: " + text);
    }
}
