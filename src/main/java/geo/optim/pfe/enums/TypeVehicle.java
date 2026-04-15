package geo.optim.pfe.enums;

public enum TypeVehicle {
    MOTORCYCLE("Motorcycle"), 
    HATCHBACK("Hatchback"), 
    SEDAN("Sedan"), SUV("SUV"), 
    STATION_WAGON("Station Wagon"), 
    VAN("Van"), 
    PICKUP("Pickup");

    private String label;

    private TypeVehicle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static TypeVehicle fromLabel(String label) {
        for (TypeVehicle type : TypeVehicle.values()) {
            if (type.getLabel().equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with label " + label);
    }
}
