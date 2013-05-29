package com.quantumcheese.utils;

public final class Range {
    public static final Range EMPTY_RANGE = new Range(Long.MAX_VALUE, 0);

    /**
     * The first index.
     */
    private final long start;
    /**
     * The number of items in the range (0 is valid).
     */
    private final long extent;

    public Range(final long location, final long length) {
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
    public static Range rangeFromLocations(final long l, final long h) {
        if (l < 0) {
            throw new IllegalArgumentException("Cannot have a range with a negative index:" + l);
        }
        if (h < 0) {
            throw new IllegalArgumentException("Cannot have a range with a negative index:" + h);
        }
        final long low = Math.min(l,  h);
        final long high = Math.max(l, h);
        return new Range(low, high - low + 1);
    }

    public long getStart() {
        return start;
    }

    public long getExtent() {
        return extent;
    }

    public boolean contains(final long i) {
        return start <= i && i < start + extent;
    }

    /**
     * @return "one past the end" of the range.
     */
    public long getMax() {
        return start + extent;
    }
}
