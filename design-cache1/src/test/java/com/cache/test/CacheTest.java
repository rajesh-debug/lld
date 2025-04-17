package com.cache.test;

import com.cache.core.Cache;
import com.cache.core.factory.CacheFactory;
import com.cache.core.factory.CacheFactory.CacheType;

public class CacheTest {
    public static void main(String[] args) {
        // Get the singleton CacheFactory instance
        Cache<String, String> cache = new CacheFactory<String, String>().newCacheInstant(CacheType.DEFAULT, 2);

        // Test: put
        cache.put("apple", "red");
        cache.put("banana", "yellow");
        cache.put("grape", "purple");

        // Test: get
        System.out.println("apple: " + cache.get("apple"));     // Expected: red
        System.out.println("banana: " + cache.get("banana"));   // Expected: yellow
        System.out.println("grape: " + cache.get("grape"));     // Expected: purple

        // Test: update value
        cache.put("apple", "green");
        System.out.println("updated apple: " + cache.get("apple"));  // Expected: green

        // Test: get non-existent key
        System.out.println("orange: " + cache.get("orange"));   // Expected: null or appropriate fallback

        // Optional: If `remove()` is implemented
        // cache.remove("banana");
        // System.out.println("banana after remove: " + cache.get("banana")); // Expected: null
    }
}
