package com.quantumcheese.utils;

public final class Range {
    public static final Range EMPTY_RANGE = new Range(0, 0);

    /**
     * The first index.
     */
    private final int start;
    /**
     * The number of items in the range (0 is valid).
     */
    private final int extent;

    public Range(final int location, final int length) {
        if (location < 0) {
            throw new IllegalArgumentException("Cannot have a range with a negative start:" + location);
        }
        if (length < 0) {
            throw new IllegalArgumentException("Cannot have a range with a negative length:" + length);
        }
        this.start = location;
        this.extent = length;
    }

    /**
     * Generates a range from l to h, inclusive; cannot generate an empty range.
     * @param l The lowest number in the range.
     * @param h The highest number in the range.
     * @return A Range from l to h, inclusive.
     */
    public static Range rangeFromLocations(final int l, final int h) {
        if (l < 0) {
            throw new IllegalArgumentException("Cannot have a range with a negative index:" + l);
        }
        if (h < 0) {
            throw new IllegalArgumentException("Cannot have a range with a negative index:" + h);
        }
        final int low = Math.min(l,  h);
        final int high = Math.max(l, h);
        return new Range(low, high - low + 1);
    }

    public int getStart() {
        return start;
    }

    public int getExtent() {
        return extent;
    }

    public boolean contains(final int i) {
        return start <= i && i < start + extent;
    }
}
