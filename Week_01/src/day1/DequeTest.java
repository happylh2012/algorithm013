import java.util.*;
class DequeTest 
{
    public static void main(String[] args)
    {
        Deque<String> deque=new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str=deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size()>0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

}