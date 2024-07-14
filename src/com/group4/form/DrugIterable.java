package com.group4.form;

import java.util.Iterator;
import java.util.List;
import com.group4.model.Drug;

public class DrugIterable implements Iterable<Drug> {
    private List<Drug> drugList;

    public DrugIterable(List<Drug> drugList) {
        this.drugList = drugList;
    }

    @Override
    public Iterator<Drug> iterator() {
        return new DrugIterator();
    }

    private class DrugIterator implements Iterator<Drug> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < drugList.size();
        }

        @Override
        public Drug next() {
            return drugList.get(currentIndex++);
        }
    }
}
