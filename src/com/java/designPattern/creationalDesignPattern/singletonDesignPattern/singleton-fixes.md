| Break           | Fix                                                        |
|-----------------|------------------------------------------------------------|
| Reflection      | Throw `RuntimeException` inside constructor if instance exists |
| Deserialization | Implement `readResolve()` to return existing instance      |
| Cloning         | Override `clone()` to return `instance`, not `super.clone()` |
| Multithreading  | Use `volatile` + double-checked locking                    |
| All 4 at once   | Use `enum` — the JVM handles everything                    |