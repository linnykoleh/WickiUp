package com.linnyk.ocp.concurrency.course_3.fork_join;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ValueSumCounter extends RecursiveTask<Long> {
    private final Node node;

    public ValueSumCounter(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {
        long sum = node.getValue();
        List<ValueSumCounter> subTasks = new LinkedList<>();

        for(Node child : node.getChildren()) {
            ValueSumCounter task = new ValueSumCounter(child);
            task.fork(); // запустим асинхронно
            subTasks.add(task);
        }

        for(ValueSumCounter task : subTasks) {
            sum += task.join(); // дождёмся выполнения задачи и прибавим результат
        }

        return sum;
    }
}