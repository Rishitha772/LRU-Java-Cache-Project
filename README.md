# In-Memory Cache System with LRU Eviction and TTL

## Overview

This project implements a custom in-memory cache system in Java using HashMap and Doubly Linked List to achieve O(1) cache operations. The cache supports LRU (Least Recently Used) eviction, TTL-based expiration, background cleanup, and persistence.

---

## Problem Statement

Frequently accessed data should be retrieved quickly without repeatedly accessing databases or external systems. This project simulates how modern caching systems work by storing frequently used data in memory.

---

## Features

- O(1) get operation
- O(1) put operation
- LRU (Least Recently Used) eviction
- TTL (Time-To-Live) expiration
- Background cleaner thread
- Automatic removal of expired entries
- File-based persistence
- Cache restoration after restart

---

## Technologies Used

- Java
- HashMap
- Doubly Linked List
- Multithreading
- Serialization
- File Handling

---

## Project Structure

```text
LRUCacheProject
│
├── CacheNode.java
├── DoublyLinkedList.java
├── LRUCache.java
├── CleanerThread.java
├── CachePersistence.java
└── Main.java
```

---

## How LRU Works

When the cache reaches its maximum capacity:

1. The least recently used item is removed.
2. The new item is inserted.
3. Recently accessed items move to the front.

Example:

```text
Capacity = 3

A B C

Access A:

A C B

Insert D:

A D C

B removed.
```

---

## TTL (Time-To-Live)

Each cache entry has an expiration time.

```text
Key: OTP
Value: 1234
TTL: 5 seconds
```

After expiration:

```text
Entry becomes invalid.
```

---

## Background Cleaner Thread

The cleaner thread periodically:

- Checks expired entries.
- Removes expired cache items.
- Frees memory automatically.

---

## Persistence

Cache entries are serialized and stored in:

```text
cache.dat
```

After application restart:

- Cache entries are restored.
- Expired entries are ignored.

---

## Time Complexity

| Operation | Complexity |
|----------|------------|
| get() | O(1) |
| put() | O(1) |
| remove() | O(1) |

---

## Sample Output

```text
Apple
null

A removed.

Total cache entries: 2
```

---

## Concepts Demonstrated

- Data Structures
- Object-Oriented Programming
- HashMap
- Doubly Linked List
- Multithreading
- Serialization
- Memory Management
- Cache Design
- System Design

---

## Future Improvements

- Spring Boot REST APIs
- Redis Integration
- Cache Statistics Dashboard
- Distributed Cache Support

---

## Resume Description

Developed an in-memory cache system in Java using HashMap and Doubly Linked List to achieve O(1) operations, implementing LRU eviction, TTL-based expiration, background cleanup threads, and file-based persistence.
