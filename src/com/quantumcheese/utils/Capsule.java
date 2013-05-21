package com.quantumcheese.utils;

public interface Capsule<T, R> {
    R call(T t);
}
