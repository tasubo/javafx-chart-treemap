package javafx.scene.chart.treemap;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ColorGroup;
import javafx.scene.shape.Rectangle;

import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Tadas Subonis <tadas.subonis@gmail.com>
 */
class TreemapRectangle extends Parent {

    private static final Logger LOG = Logger.getLogger(TreemapRectangle.class.getName());
    private Random random = new Random();
    private final Color rectangleColor;
    private final Rectangle rectangle = new Rectangle();

    public TreemapRectangle(final TreemapDtoElement child, Color color) {
        rectangle.setHeight(child.getHeight());
        rectangle.setWidth(child.getWidth());
        rectangle.addEventHandler(MouseEvent.MOUSE_ENTERED, new HoverOnEventHandler());
        rectangle.addEventHandler(MouseEvent.MOUSE_EXITED, new HoverOffEventHandler());
        rectangleColor = color;
        rectangle.setFill(rectangleColor);
        this.getChildren().add(rectangle);
        NodeTooltip nodeTooltip = new NodeTooltip(child);
        Tooltip.install(this, nodeTooltip);
    }

    private class NodeTooltip extends Tooltip {

        public NodeTooltip(final TreemapDtoElement child) {
            setText(child.getLabel());
        }
    }

    private class HoverOnEventHandler implements EventHandler<Event> {

        @Override
        public void handle(Event t) {
            Color brighter = rectangleColor.brighter();
            TreemapRectangle.this.rectangle.setFill(brighter);
        }
    }

    private class HoverOffEventHandler implements EventHandler<Event> {

        @Override
        public void handle(Event t) {
            TreemapRectangle.this.rectangle.setFill(rectangleColor);
        }
    }
}
