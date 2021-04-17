package oop.lectures.lecture_4.ex05;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;

public class MyCollectionTask {

    List<MyItem> list = new LinkedList<>();

    private Integer x, y;

    public void accept(Integer i) {
        x = y;
        y = i;
        if(x != null) {
            list.add(new MyItem(x, y));
            y = null;
        }
    }

    public MyCollectionTask combine(MyCollectionTask other) {
        this.list.addAll(other.list);
        return this;
    }

    public List<MyItem> finish() {
        return list;
    }

    public static Collector<Integer, ?, List<MyItem>> collector() {
        return Collector.of(
                MyCollectionTask::new,
                MyCollectionTask::accept,
                MyCollectionTask::combine,
                MyCollectionTask::finish
        );
    }
}
