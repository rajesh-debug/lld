package com.cache.core.storage;

import com.cache.core.exception.MaxSizeReachedException;

public interface Storage<K, V> {

    V get(K key);

    void add(K key, V value) throws MaxSizeReachedException;

    void remove(K key);
}
