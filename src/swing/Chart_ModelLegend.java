package swing;

import java.awt.Color;

public class Chart_ModelLegend {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Chart_ModelLegend(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Chart_ModelLegend() {
    }

    private String name;
    private Color color;
}
