/*
 * Copyright (c) 2014 laidian. All Rights Reserved.
 * @author LYH
 * @date  2021-03-22 10:44
 */
package codeTimeStatistics.stopWatch;

import codeTimeStatistics.common.TimeUtils;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 通过调用 Start(name) 和 Stop() 方法，进行耗时统计。
 * 通过调用 Record(name, timeCost)，方法，直接记录耗时信息。
 *
 * @author LYH
 * @date 2021/03/22 10:44
 */
public class TraceWatch {

    /**
     * Start time of the current task.
     */
    private long startMs;

    /**
     * Name of the current task.
     */
    @Nullable
    private String currentTaskName;

    private final Map<String, List<TaskInfo>> taskMap = new HashMap<>();

    public Map<String, List<TaskInfo>> getTaskMap() {
        return taskMap;
    }

    /**
     * 开始时间差类型指标记录，如果需要终止，请调用 {@link #stop()}
     *
     * @param taskName 指标名
     */
    public void start(String taskName) throws IllegalStateException {
        if (this.currentTaskName != null) {
            throw new IllegalStateException("Can't start TraceWatch: it's already running");
        }
        this.currentTaskName = taskName;
        this.startMs = TimeUtils.nowMs();
    }

    /**
     * 终止时间差类型指标记录，调用前请确保已经调用
     */
    public void stop() throws IllegalStateException {
        if (this.currentTaskName == null) {
            throw new IllegalStateException("Can't stop TraceWatch: it's not running");
        }
        long lastTime = TimeUtils.nowMs() - this.startMs;

        TaskInfo info = new TaskInfo(this.currentTaskName, lastTime);

        this.taskMap.computeIfAbsent(this.currentTaskName, e -> new LinkedList<>()).add(info);

        this.currentTaskName = null;
    }

    /**
     * 直接记录指标数据，不局限于时间差类型
     *
     * @param taskName 指标名
     * @param data     指标数据
     */
    public void record(String taskName, Object data) {
        TaskInfo info = new TaskInfo(taskName, data);

        this.taskMap.computeIfAbsent(taskName, e -> new LinkedList<>()).add(info);
    }

    public static final class TaskInfo {
        private final String taskName;


        private final Object data;

        public TaskInfo(String taskName, Object data) {
            this.taskName = taskName;
            this.data = data;
        }

        public String getTaskName() {
            return taskName;
        }

        public Object getData() {
            return data;
        }
    }
}