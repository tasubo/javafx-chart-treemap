package javafx.scene.chart.treemap;

import java.util.SortedSet;

/**
 *
 * @author Tadas Subonis <tadas.subonis@gmail.com>
 */
public interface Item extends Comparable<Item> {

    Object getId();

    double getSize();

    String getLabel();

    boolean isContainer();

    SortedSet<Item> getItems();
}
