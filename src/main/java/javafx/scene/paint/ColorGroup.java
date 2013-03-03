package javafx.scene.paint;

import java.util.*;

public class ColorGroup {

    private final Color mainColor;
    private final List<Color> groupColors = new LinkedList<>();
    private final Deque<Color> availableColors = new ArrayDeque<>();

    public ColorGroup(Color mainColor, int size) {
        this.mainColor = mainColor;
        size += 1;
        double rangeStart = 0.5;
        double rangeEnd = 1.2;
        double step = (rangeEnd - rangeStart)  / size;

        double brightness = rangeStart;
        for (int i = 0; i < size; i++) {
            brightness += step;
            groupColors.add(mainColor.deriveColor(1.0, 1.0, brightness, 1.0));
        }

        availableColors.addAll(groupColors);
    }

    public Color fetchColor() {
        if (availableColors.isEmpty()) {
            availableColors.addAll(groupColors);
        }
        return availableColors.pop();
    }

    public Color getMainColor() {
        return mainColor;
    }
}
