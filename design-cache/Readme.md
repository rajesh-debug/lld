# 🔒 Design-Cache1

A modular, extensible in-memory cache system written in Java, featuring **pluggable eviction policies**, a **generic storage abstraction**, and support for **LRU** eviction out of the box.

---

## 📦 Features

- ⚡️ Fast `O(1)` cache operations
- 🧠 Pluggable eviction strategies (`LRU` supported)
- 💃 Generic storage backend (`InMemoryStorage`)
- 🏗 Clean interface-based design (testable + extensible)
- 🧪 Ready for unit/integration testing

---

## 🚀 Getting Started

### ✅ Prerequisites
- Java 11+
- Maven / IntelliJ / Gradle (optional)

### 🧪 Example Usage

```java
import com.cache.core.Cache;
import com.cache.core.factory.CacheFactory;

public class CacheTest {
    public static void main(String[] args) {
        Cache<String, String> cache = new CacheFactory<String, String>()
                                          .newCacheInstant(CacheFactory.CacheType.DEFAULT);
        cache.put("user1", "Alice");
        cache.put("user2", "Bob");

        System.out.println(cache.get("user1")); // ➔ Alice
    }
}
```

---

## 🧱 Architecture Overview

```text
          +--------------------+
          |    Cache<K, V>     |
          |--------------------|
          |  EvictionPolicy<K> |
          |  StorageService<K> |
          +--------+-----------+
                   |
        +----------+-----------+
        |                      |
+-----------------+    +------------------+
| InMemoryStorage |    | LRUEvictionPolicy|
|     (Map)       |    | (DLL + HashMap)  |
+-----------------+    +------------------+
```

---

## 🔑 Core Modules

| Module                | Description                                                                 |
|-----------------------|-----------------------------------------------------------------------------|
| `Cache<K, V>`         | Main cache interface                                                        |
| `CacheImpl<K, V>`     | Manages key-value operations and delegates eviction                         |
| `EvictionPolicy<K>`   | Strategy interface for eviction                                             |
| `LRUEvictionPolicy`   | Tracks LRU keys using `HashMap + DoublyLinkedList`                          |
| `StorageService<K,V>` | Abstract storage layer (interface)                                          |
| `InMemoryStorage`     | HashMap-backed storage with capacity enforcement                            |
| `CacheFactory`        | Singleton factory for creating caches with different eviction strategies    |

---

## ⚙️ Eviction Strategy: LRU

- **Access Tracking:** Uses `DoublyLinkedList` to track recent usage.
- **Efficiency:** All operations in `O(1)` time.
- **Sync:** Maintains sync between eviction policy and storage service.

---

## 📋 Non-Functional Requirements (NFRs)

| NFR             | Support                                                                 |
|------------------|------------------------------------------------------------------------|
| Time Complexity  | `O(1)` for `put`, `get`, and `evict`                                   |
| Memory Efficiency| Evicts on capacity overflow; avoids leaks                              |
| Thread Safety    | ❌ Not thread-safe (future enhancement possible)                        |
| Extensibility    | ✅ Easily add new eviction policies or storage backends                 |
| Testability      | ✅ Modular and unit-test friendly                                       |

---

## 🧰 Future Enhancements

- [ ] Add support for MRU, LFU eviction policies
- [ ] Add TTL (Time-to-Live) expiry per key
- [ ] Thread-safe cache variant
- [ ] Persistent storage (e.g., disk-based cache)
- [ ] Monitoring: Hit/miss metrics

---

## 📁 Project Structure

```
src/
└── com.cache.core
    ├── Cache.java
    ├── factory/
    │   └── CacheFactory.java
    ├── storage/
    │   ├── StorageService.java
    │   └── InMemoryStorage.java
    ├── eviction/
    │   ├── EvictionPolicy.java
    │   └── LRUEvictionPolicy.java
    └── data/
        ├── DoublyLinkedList.java
        └── DoublyLinkedListNode.java
```

---

## 👨‍💼 Author

**Rajesh Dixit**  
Engineer, Systems Thinker, and Builder of Scalable Infrastructure  
GitHub: [@rajesh-debug](https://github.com/rajesh-debug)

---

## 📝 License

This project is licensed under the MIT License. See the `LICENSE` file for details.
