package bowling.Entities;

import java.util.ArrayList;
import java.util.Iterator;

public class FramesList implements Iterable<Frame> {

    private ArrayList<Frame> frames;

    public FramesList() {
        frames = new ArrayList<Frame>();
    }

    public Frame getFrame(int index) {
        return frames.get(index-1);
    }

    public FramesList addFrame(Frame frame) {
        frames.add(frame);
        return this;
    }

    public int count() {
        return frames.size();
    }

    public Iterator<Frame> iterator() {
        return frames.iterator();
    }

    /*@Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("FramesList[ ");
        for (Frame frame:this) {
            builder.append(frame.toString()).append(" ");
        }
        return builder.append("]").toString();

    }*/

}
