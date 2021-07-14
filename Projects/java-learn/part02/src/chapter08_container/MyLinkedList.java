package chapter08_container;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/7/6 16:24
 */
public class MyLinkedList {
    abstract class AbsMyList{
        // 长度
        protected int len = 0;

        // 默认构造方法
        protected AbsMyList() {

        }

        // 向链表末尾添加一个元素
        abstract public boolean add(Object o);

        // 获得指定元素
        abstract public Object getElement(int index);

        // 判断是否包含元素
        abstract public boolean isElement(Object o);

        // 判断元素的位置
        abstract int indexOf(Object o);

        // 移除元素
        abstract public boolean deleteElement(Object o);

        // 清空
        abstract public void clear();

        // 获得长度大小
        public int len() {
            return this.len;
        }

        // 判断是否为空
        public boolean isEmpty() {
            return this.len == 0;
        }
    }

    // 队列接口
    interface ImpQueue {
        // 入队
        void inQueue(String o);

        // 出队
        Object outQueue();

        // 判断是否为空
        boolean isEmpty();
    }

    // 栈接口
    interface ImpStack {
        // 入栈
        void push(Object o);

        // 出栈
        Object pop();

        // 判断是否为空
        boolean isEmpty();
    }

    class LinkedList extends AbsMyList implements ImpQueue, ImpStack {
        // 静态内部类
        private class InnerMyEntry {
            Object object;
            InnerMyEntry next;
            InnerMyEntry previous;

            public InnerMyEntry(Object object, InnerMyEntry next, InnerMyEntry previous) {
                this.object = object;
                this.next = next;
                this.previous = previous;
            }
        }

        private InnerMyEntry header = new InnerMyEntry(null, null, null);

        public LinkedList() {
            this.header.next = this.header.previous;
        }

        private InnerMyEntry addBefore(Object o, InnerMyEntry entry) {
            // 添加对象之前的操作方法
            InnerMyEntry newEntry = new InnerMyEntry(o, entry, entry.previous);
            newEntry.previous.next = newEntry;
            newEntry.next.previous = newEntry;
            this.len++;
            return newEntry;
        }

        @Override
        public boolean add(Object o) {
            // 添加对象
            this.addBefore(o, header);
            return true;
        }

        @Override
        public Object getElement(int index) {
            if(index > len-1 || index < 0)
                return null;
            InnerMyEntry e = this.header.next;
            for (int i = 0; i < index; i++) {
                e = e.next;
            }
            return e.next;
        }

        @Override
        public boolean isElement(Object o) {
            return this.indexOf(o) != -1;
        }

        @Override
        int indexOf(Object o) {
            int index = 0;
            if (o == null) {
                for (InnerMyEntry e = this.header.next; e != this.header; e = e.next) {
                    if (e.object == null) {
                        return index;
                    }
                    index++;
                }
            } else {
                for (InnerMyEntry e = this.header.next; e != this.header; e = e.next) {
                    if (e.object.equals(o)) {
                        return index;
                    }
                    index++;
                }
            }
            return -1;
        }

        @Override
        public boolean deleteElement(Object o) {
            if (o == null) {
                for (InnerMyEntry e = this.header.next; e != this.header; e = e.next) {
                    if (e.object == null) {
                        return this.deleteElement(e);
                    }
                }
            } else {
                for (InnerMyEntry e = this.header.next; e != this.header; e = e.next) {
                    if (e.object.equals(o)) {
                        return this.deleteElement(e);
                    }
                }
            }
            return false;
        }

        @Override
        public void clear() {
            // 清空对象
            InnerMyEntry e = this.header.next;
            while (e != header) {
                InnerMyEntry next = e.next;
                e.next = e.previous = null;
                e.object = null;
                e = next;
            }
            this.header.next = this.header.previous = this.header;
            this.len = 0;
        }

        @Override
        public void inQueue(String o) {
            this.addBefore(o, header);
        }

        @Override
        public Object outQueue() {
            // 出队方法
            // 获得对象
            Object result = this.header.next.object;
            // 移除对象
            this.deleteElement(this.header.next);

            return result;
        }

        @Override
        public void push(Object o) {
            this.addBefore(o, header);
        }

        @Override
        public Object pop() {
            Object result = this.header.previous.object;
            this.deleteElement(this.header.previous);
            return result;
        }


        private InnerMyEntry entry(int index) {
            if (index < 0 || index >= this.len) {
                return null;
            }
            InnerMyEntry e = header;

            if (index < (this.len >> 1)) {
                for (int i = 0; i <= index; i++) {
                    e = e.next;
                }
            } else {
                for (int i = this.len; i > index; i--) {
                    e = e.previous;
                }
            }

            return e;
        }

        private boolean deleteElement(InnerMyEntry e) {
            if (e == header) {
                return false;
            }
            e.previous.next = e.next;
            e.next.previous = e.previous;
            e.next = e.previous = null;
            e.object = null;
            this.len--;
            return true;
        }
    }

}
