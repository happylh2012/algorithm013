Week2:
day1:
HashMap put get源码分析
异位值：
1、排序法
2、哈希法
day2:
day3:
day4:
day5:
day6:
day7:

Hash:
哈希表是数组和链表的组合使用，通过哈希函数获取到存储的索引值，选择哈希函数很关键，好的哈希函数可以减少碰撞，所谓
碰撞即通过哈希函数映射到同一个索引位置，这时在碰撞处引入链表来存储多个值。

     public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
		//如果table未初始化，则初始化数组，重新调整容量和阈值
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
		//根据hash找到下标,如果下标处没有数据，则把数据存在指定下标处
        else {
		    //如果下标处已经存在数据，发生碰撞
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
			//如果插入的key和hash和指定下标的Key一样
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
			//如果插入的是TreeNode
            else {
		    //数据类型为链表
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
					 //如果链表中没有最新插入的节点，将新放入的数据放到链表的末尾
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
				      //如果链表过长，达到树化阈值，将链表转化成树
                        break;
                    }
					
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
					//如果链表中有新插入的节点位置数据不为空，则此时e 赋值为节点的值，跳出循环
                    p = e;
                }
            }
			 //如果e不为空，则说明上面插入的值已经存在于当前的hashMap中，那么更新指定位置的键值对
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
		//如果此时hashMap size大于阈值，则进行扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
	
	
	 public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    /**
     * Implements Map.get and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @return the node, or null if none
     */
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
			//1、根据hash算法找到对应位置的第一个数据，如果是指定的key，则直接返回
            if ((e = first.next) != null) {
			 //如果该节点为树，则通过树进行查找
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
				  //如果该节点是链表，则遍历查找到数据
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }