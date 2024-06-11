public class P4GenericInterfacesImpl<K, V> implements P4GenericInterfaces<K, V> {
    private K key;
    private V value;

    // 构造方法
    public P4GenericInterfacesImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}