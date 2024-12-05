package swing;

import swing.Chart_Kosong;
import swing.Chart_KosongRender;
import swing.Chart_Ukuran;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Chart extends javax.swing.JPanel {

    private List<Chart_ModelLegend> legends = new ArrayList<>();
    private List<Chart_Model> model = new ArrayList<>();
    private final int seriesSize = 12;
    private final int seriesSpace = 6;
    private final Animator animator;
    private float animate;

    public Chart() {
        initComponents();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                repaint();
            }
        };
        animator = new Animator(800, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        chart_Kosong.setBlankPlotChatRender(new Chart_KosongRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
            public void renderSeries(Chart_Kosong chart, Graphics2D g2, Chart_Ukuran size, int index) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                for (int i = 0; i < legends.size(); i++) {
                    Chart_ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight()) * animate;
                    g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                    x += seriesSpace + seriesSize;
                }
            }
        });
    }

    public void addLegend(String name, Color color) {
        Chart_ModelLegend data = new Chart_ModelLegend(name, color);
        legends.add(data); 
        panelLegend.add(new Chart_LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(Chart_Model data) {
        model.add(data);
        chart_Kosong.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > chart_Kosong.getMaxValues()) {
            chart_Kosong.setMaxValues(max);
        }
    }

    public void clear() {
        animate = 0;
        chart_Kosong.setLabelCount(0);
        model.clear();
        repaint();
    }

    public void start() {
        if (!animator.isRunning()) {
            animator.start();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart_Kosong = new swing.Chart_Kosong();
        panelLegend = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart_Kosong, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chart_Kosong, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Chart_Kosong chart_Kosong;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
