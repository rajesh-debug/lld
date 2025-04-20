package com.cache.core.storage;

import com.cache.core.exception.MaxSizeReachedException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStorage<K, V> implements Storage<K, V> {

    private final int size;
    private final Map<K, V> storage;

    public InMemoryStorage(int size) {
        this.size = size;
        this.storage = new HashMap<>();
    }

    @Override
    public V get(K key) {
        return storage.get(key);
    }

    @Override
    public void add(K key, V value) throws MaxSizeReachedException {
        if (storage.size() < size) {
            storage.put(key, value);
        } else {
            throw new MaxSizeReachedException("Storage is full");
        }

    }

    @Override
    public void remove(K key) {
        storage.remove(key);
    }
}
