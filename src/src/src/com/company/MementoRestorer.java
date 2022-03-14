package com.company;

import java.util.ArrayList;

public class MementoRestorer {
    private ArrayList<Memento> mementoList = new ArrayList<Memento>();

    public void addMementoToList(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMementoFromList(int index) {
        return mementoList.get(index);
    }
}