package com.cache.core.eviction;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evictKey();
}
