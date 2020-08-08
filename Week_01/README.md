学习笔记

Day1：

一、一维数据结构
基本结构：数组、链表
高级结构:Stack、Queue、Deque
Stack:先进后出
Queue:新进先出
Deque：双端队列
添加删除的时间复杂度O(1)，查询O(N)

二、如何查询接口信息？如何使用？
直接在Google查Stack java {version} 查看API文档
类似的Python: Stack Python {verion}

删除排序数组中的重复项

给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

输入:排序数组
输出:数组长度
动作:删除重复元素，每个元素只出现一次
约束:不使用额外数组，原地修改数组，使用O(1)额外空间


方案：
1、两个指针i,j指向数组a i从0开始，j从1开始
   如果a[i]==a[j]，j加1，否则i加1后a[i]=a[j]
   返回i+1的长度
   
Day2：
   
旋转数组

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

输入:数组
输出:无
动作:数组中的元素向右移动 k 个位置

解决方案:
1、暴力法 时间 O(K*N） 空间O（1） 
2、使用另外一个数组 时间 O（N） 空间 O(N）
3、使用反转

Day3：
分析Queue和Priority Queue源码
Queue继承自Collection，
除了基本的集合操作，队列提供了额外的插入、提取和检查操作。 每个方法都有两种形式:一种是在操作失败时抛出一个异常，另一个则返回一个特殊值(根据操作的不同)(返回null或false)。

public interface Queue<E> extends Collection<E> {
    //插入（抛出异常）
    boolean add(E e);
    //插入（返回特殊值）
    boolean offer(E e);
    //移除（抛出异常）
    E remove();
    //移除（返回特殊值）
    E poll();
    //检查（抛出异常）
    E element();
    //检查（返回特殊值）
    E peek();
}

PriorityQueue又叫做优先级队列，保存队列元素的顺序不是按照及加入队列的顺序，而是按照队列元素的大小进行重新排序。
因此当调用peek()或pool()方法取出队列中头部的元素时，并不是取出最先进入队列的元素，而是取出队列的最小元素。
 public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

public PriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

PriorityQueue调用默认的构造方法时，使用默认的初始容量（DEFAULT_IITIAL_CAPACITY = 11）创建一个PriorityQueue，并根据其自然顺序来排序其元素（使用加入其中的集合元素实现的Comparable）。
当使用指定容量的构造方法时，使用指定的初始容量创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用加入其中的集合元素实现的Comparable）
当使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器comparator来排序其元素。当添加元素到集合时，会先检查数组是否还有余量，有余量则把新元素加入集合，没余量则调用  grow()方法增加容量，然后调用siftUp将新加入的元素排序插入对应位置。
除了这些，还要注意的是：
  1.PriorityQueue不是线程安全的。如果多个线程中的任意线程从结构上修改了列表， 则这些线程不应同时访问 PriorityQueue 实例，这时请使用线程安全的PriorityBlockingQueue 类。
  2.不允许插入 null 元素。
  3.PriorityQueue实现插入方法（offer、poll、remove() 和 add 方法） 的时间复杂度是O(log(n)) ；实现 remove(Object) 和 contains(Object) 方法的时间复杂度是O(n) ；实现检索方法（peek、element 和 size）的时间复杂度是O(1)。所以在遍历时，若不需要删除元素，则以peek的方式遍历每个元素。
  4.方法iterator()中提供的迭代器并不保证以有序的方式遍历PriorityQueue中的元素。
  
 合并两个有序链表
 
 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 
 输入:两个升序链表
 输出:新的 升序 链表
 动作：合并
 
 合并两个有序数组
 
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

输入:两个有序整数数组 
输出:有序数组
动作:请你将 nums2 合并到 nums1 中


Day 4:

两数之和
        
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

输入:一个整数数组 nums ,一个目标值 target
输出:数组下标

Day5:
设计实现双端队列。
你的实现需要支持以下操作：

MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。

