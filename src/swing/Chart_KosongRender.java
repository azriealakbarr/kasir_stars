package swing;

import java.awt.Graphics2D;

public abstract class Chart_KosongRender {

    public abstract String getLabelText(int index);

    public abstract void renderSeries(Chart_Kosong chart, Graphics2D g2, Chart_Ukuran size, int index);
}
