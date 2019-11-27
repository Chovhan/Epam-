package com.company;

import java.util.Comparator;
import java.util.Map;

class ValueComporator implements Comparator<Object> {

    Map base;
    public ValueComporator(Map base) {
        this.base = base;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if ((Integer)base.get(o1) <= (Integer) base.get(o2)) {
            return 1;
        }else if((Integer)base.get(o1) == (Integer) base.get(o2)){
            return 0;
        }
        else {
            return -1;
        }
    }
}
