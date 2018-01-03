package cn.nxnil.blueack.common.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 任务类型
 */
public enum TaskTypeEnum implements GenericStringEnum {

    INCRE_PROM("增量促销任务"),
    FULL_PROM("全量促销任务"),;


    /*******************************************
     * 注意：如果添加枚举类型，请修改Map容器的大小
     ******************************************/
    private static final Map<String, TaskTypeEnum> valueLookup = new ConcurrentHashMap<String, TaskTypeEnum>(values().length);

    static {
        for (TaskTypeEnum type : EnumSet.allOf(TaskTypeEnum.class)) {
            valueLookup.put(type.name(), type);
        }
    }

    private final String name;

    TaskTypeEnum(String name) {

        this.name = name;
    }

    public static TaskTypeEnum resolve(String value) {

        return (value != null ? valueLookup.get(value) : null);
    }

    public static TaskTypeEnum fromValue(String value) {

        TaskTypeEnum data = valueLookup.get(value);
        if (data == null) {
            throw new IllegalArgumentException("参数[" + value + "]不正确，没有找到对应的BusinessTypeEnum");
        }
        return data;
    }

    public boolean match(String value) {

        return (this == resolve(value));
    }

    @Override
    public String getValue() {

        return name();
    }

    @Override
    public String getName() {

        return name;
    }
}
