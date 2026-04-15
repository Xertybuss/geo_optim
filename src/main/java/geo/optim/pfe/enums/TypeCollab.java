package geo.optim.pfe.enums;

public enum TypeCollab {
    DRIVER("Driver"), 
    PASSANGER("Passenger");

    private String label;

    private TypeCollab(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static TypeCollab fromLabel(String label) {
        for (TypeCollab type : TypeCollab.values()) {
            if (type.getLabel().equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with label " + label);
    }
}
