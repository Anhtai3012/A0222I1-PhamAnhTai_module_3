package ss6_inheritance.thuchanh;

public class Geometric {
    private String color = "blue";
    private String filler = null;

    public Geometric() {
    }

    ;

    public Geometric(String color, String filler) {
        this.color = color;
        this.filler = filler;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public void toStringGeometric() {
        if (getFiller() == null) {
            System.out.println("Not fill ... ");
        } else {
            System.out.printf("Geometric have color %s with filler is %s\n", getColor(), getFiller());
        }
    }

}

