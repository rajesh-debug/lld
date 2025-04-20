package com.cache.core;

import com.cache.core.eviction.EvictionPolicy;
import com.cache.core.exception.MaxSizeReachedException;
import com.cache.core.storage.Storage;

public class Cache<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;

    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
            System.out.println("added element to list => " + key + ":" + value);
        } catch (MaxSizeReachedException e) {
            System.out.println(e.getMessage());

            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove != null) {
                this.storage.remove(keyToRemove);
            }
            put(key, value);
        }
    }

    public Value get(Key key) {
        Value value = storage.get(key);
        evictionPolicy.keyAccessed(key);
        return value;
    }
}
