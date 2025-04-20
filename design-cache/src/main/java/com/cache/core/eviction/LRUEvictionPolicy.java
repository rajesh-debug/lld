package com.cache.core.eviction;

import com.cache.core.data.DoublyLinkedList;
import com.cache.core.data.DoublyLinkedListNode;
import com.cache.core.eviction.EvictionPolicy;

import java.util.HashMap;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    private final DoublyLinkedList<Key> ddl;

    private final HashMap<Key, DoublyLinkedListNode<Key>> map;

    public LRUEvictionPolicy() {
        this.ddl = new DoublyLinkedList<>();
        this.map = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if (map.containsKey(key)) {
            DoublyLinkedListNode<Key> node = map.get(key);
            ddl.detachNode(node);
            ddl.addNodeAtLast(node);  // move to tail (most recently used)
        } else {
            DoublyLinkedListNode<Key> newNode = new DoublyLinkedListNode<>(key);
            ddl.addNodeAtLast(newNode);
            map.put(key, newNode);
        }
    }


    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> eligibleNode = this.ddl.getFirstNode();

        if (eligibleNode == null) {
            return null;
        }
        ddl.detachNode(eligibleNode);

        return eligibleNode.getElement();
    }
}
