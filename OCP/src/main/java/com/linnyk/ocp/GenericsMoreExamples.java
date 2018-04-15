package com.linnyk.ocp;

import java.util.List;

public class GenericsMoreExamples {

    static class Booby{}
    static class Dooby extends Booby{}
    static class Tooby extends Dooby{}

    Booby booby = new Booby();
    Tooby tooby = new Tooby();
    Dooby dooby = new Dooby();

    public void addList1(List<? super Dooby> dataList){
        dataList.add(tooby);
        dataList.add(dooby);

//        dataList.add(booby); Compilation error. ? super Dooby
//        dataList.add(new Object()); Compilation error. ? super Dooby
//        dooby = dataList.get(0); Compilation error. If super NO get at all only add

    }

    public void addList2(List<? extends Dooby> dataList){
        booby = dataList.get(0);
        dooby = dataList.get(0);
        Object o = dataList.get(0);

//        tooby = dataList.get(0); Compilation error. ? super Dooby
//        dataList.add(dooby); Compilation error. If extends NO add at all only get
    }

}
