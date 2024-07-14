package com.group4.form;

import java.util.Iterator;
import java.util.List;
import com.group4.model.Sales;

public class SaleIterable implements Iterable<Sales> {
    private List<Sales> saleList;

    public SaleIterable(List<Sales> saleList) {
        this.saleList = saleList;
    }

    @Override
    public Iterator<Sales> iterator() {
        return new SaleIterator();
    }

    private class SaleIterator implements Iterator<Sales> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < saleList.size();
        }

        @Override
        public Sales next() {
            return saleList.get(currentIndex++);
        }
    }
}
