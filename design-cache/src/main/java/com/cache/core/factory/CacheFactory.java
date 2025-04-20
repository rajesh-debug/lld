package com.cache.core.factory;

import com.cache.core.Cache;
import com.cache.core.eviction.LRUEvictionPolicy;
import com.cache.core.storage.InMemoryStorage;

public class CacheFactory<Key, Value> {

    private final int DEFAULT_CAPACITY = 1000;

    public Cache<Key, Value> newCacheInstant(CacheType cacheType) {
        return newCacheInstant(cacheType, DEFAULT_CAPACITY);
    }

    public Cache<Key, Value> newCacheInstant(CacheType cacheType, int capacity) {
        return switch (cacheType) {
            case DEFAULT, LRU -> new Cache<>(new LRUEvictionPolicy<>(), new InMemoryStorage<>(capacity));
            case MRU -> throw new RuntimeException("Not support MRU");
        };
    }

    public enum CacheType {
        DEFAULT, LRU, MRU
    }
}
