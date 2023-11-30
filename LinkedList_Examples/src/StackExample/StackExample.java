package StackExample;

import java.util.LinkedList;


//LinkedList的特有方法(本身定义的方法)如:addFirst()、addLast()、getFirst()、getLast()、removeFirst()、removeLast()等
//LinkedList是使用链表实现的,若要从链表中删除或插入某一个对象,只需要改变前后对象的引用即可!因此在进行insert和remove动作时在效率上要比ArrayList要好得多!
//适合用来实现Stack(堆栈)与Queue(队列),前者先进后出，后者是先进先出.
//这里用了Stack（先进后出）

public class StackExample {
    
	private LinkedList<String> linkedList   = new LinkedList<String>();  
  

	//将元素加入LinkedList容器 (即插入到链表的第一个位置) 
    public void push(String name)
    {  
        linkedList.addFirst(name);  
    }  

    //取出堆栈中最上面的元素 (即取出链表linkedList的第一个元素) 
    public String getTop()
    {  
        return linkedList.getFirst();  
    }  

    //取出并删除最上面的元素 (即移出linkedList的第一个元素) 
    public String pop()
    {  
        return linkedList.removeFirst();  
    }  

    //获取元素个数  
    public int size()
    {  
        return linkedList.size();  
    }  
      

    //判断堆栈是否为空 (即判断 linkedList是否为空) 
    public boolean isEmpty()
    {  
        return linkedList.isEmpty();  
    }  
    
    //测试  
    public static void main(String[] args) 
    {  
    	StackExample stack = new StackExample();  
        stack.push("yulon");  
        stack.push("xiaoyun");  
        stack.push("羽龙共舞");  
        System.out.print("第一个元素是:\t");  
        System.out.println(stack.getTop());  
        System.out.println();  
        System.out.println("全部元素:");  
        while(!stack.isEmpty()){  
            System.out.println("\t"+stack.pop());  
        }  
    }
}
