public class Array <E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    // 在数组尾部插入元素
    public void addLast(E e){
        add(size,e);
    }

    // 在数组首部插入元素
    public void addFirst(E e){
        add(0, e);
    }

    // 在数组索引为index的位置插入元素
    public void add(int index, E e){
        if (index<0||index>size)
            throw new IllegalArgumentException("add failed, wrong index");

        if (size==getCapacity())
            resize(2*data.length);

        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取索引为index位置的元素
    public E get(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("get failed, wrong index");
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    // 修改索引为index位置的元素
    public void set(int index, E e){
        if (index<0||index>=size)
            throw new IllegalArgumentException("set failed, wrong index");
        data[index] = e;
    }

    // 包含
    public boolean contains(E e){
        for (int i=0; i<size; i++){
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找
    public int find(E e){
        for (int i=0; i<size; i++)
            if (data[i].equals(e))
                return i;
        return -1;
    }

    // 删除索引为index位置的元素
    public E remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("remove failed, wrong index");
        E res = data[index];

        for (int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        if (size==data.length/4 && data.length/2!=0)
            resize(data.length/2);

        return res;
    }

    // 删除数组首部元素
    public E removeFirst(){
        return remove(0);
    }

    // 删除数组尾部元素
    public E removeLast(){
        return remove(size-1);
    }

    // 删除指定元素
    public void removeElement(E e){
        int index = find(e);
        if (index!=-1)
            remove(index);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d\n", size, getCapacity()));
        res.append("[");
        for (int i=0; i<size; i++){
            res.append(data[i]);
            if (i!=size-1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];

        for (int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
