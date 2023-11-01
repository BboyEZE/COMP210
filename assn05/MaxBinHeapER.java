package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO (Part 3): overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
        for(int i = 0; i < initialEntries.length; i++) {
            _heap.add(i, initialEntries[i]);
        }
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        Patient joe = new Patient(value, priority);
        if(_heap.isEmpty()){
            _heap.add(joe);
        }
        else{
            _heap.add(joe);
            heapifyUp(_heap.size() - 1);
        }

    }

    // TODO: enqueue
    public void enqueue(V value) {
        Prioritized<V, P> joe = new Patient<>(value);
        _heap.add(joe);
        if(!_heap.isEmpty()){
            heapifyDown(_heap.size() - 1]

            );
        }
    }

    // TODO: dequeue
    @Override
    public V dequeue() {
        if(_heap.isEmpty() ){
            return null;
        }

        V max = _heap.get(0).getValue();
        if(_heap.size() == 1){
            _heap.clear();

        }
        else{
            _heap.set(0, _heap.remove(_heap.size() - 1));
            heapifyDown(0);
        }
        return max;
    }
    private void heapifyDown(int index) {
        int leftChildIdx = 2 * index + 1;
        int rightChildIdx = 2 * index + 2;
        int largest = index;

        if (leftChildIdx < _heap.size() && _heap.get(leftChildIdx).getPriority().compareTo(_heap.get(largest).getPriority()) > 0) {
            largest = leftChildIdx;
        }

        if (rightChildIdx < _heap.size() && _heap.get(rightChildIdx).getPriority().compareTo(_heap.get(largest).getPriority()) > 0) {
            largest = rightChildIdx;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void heapifyUp(int index){
        int child = index;
        int parent = (index - 1) / 2;
        if(parent >= 0 && _heap.get(parent).getPriority().compareTo(_heap.get(child).getPriority()) < 0){
            child = parent;
            parent = (index - 1) / 2;
        }
        Prioritized<V, P> joe = _heap.get(parent);
        _heap.set(parent, _heap.get(child));
        _heap.set(child, joe);
    }


    private void swap(int i, int j) {
        Prioritized<V, P> temp = _heap.get(i);
        _heap.set(i, _heap.get(j));
        _heap.set(j, temp);
    }

    // TODO: getMax
    @Override
    public V getMax() {
       return null;
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }






}
