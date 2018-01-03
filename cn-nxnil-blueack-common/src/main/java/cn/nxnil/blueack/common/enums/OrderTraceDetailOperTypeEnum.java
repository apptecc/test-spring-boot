package cn.nxnil.blueack.common.enums;

import cn.nxnil.blueack.common.BizConstant;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 订单追踪明细操作类型
 * 0-创建 1-审核 2-出单 3-分配 4-发货 5-收货 6-完成 7-取消
 */
public enum OrderTraceDetailOperTypeEnum implements GenericIntegerEnum {
    CREATE(BizConstant.CREATE, "创建"), AUDIT(BizConstant.AUDIT, "审核"),
    ISSUE(BizConstant.ORDER, "出单"), DISTRIBUTION(BizConstant.DISTRIBUTION, "分配"),
    SEND(BizConstant.SEND, "发货"), RECEIVE(BizConstant.RECEIVE, "收货"),
    FINISH(BizConstant.FINISH, "完成"), CANCEL(BizConstant.CANCEL, "取消");

    private static final Map<Integer, OrderTraceDetailOperTypeEnum> valueLookup = new ConcurrentHashMap<>(values().length);

    static {
        for (OrderTraceDetailOperTypeEnum type : EnumSet.allOf(OrderTraceDetailOperTypeEnum.class)) {
            valueLookup.put(type.value, type);
        }
    }

    private final Integer value;
    private final String name;

    OrderTraceDetailOperTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public static OrderTraceDetailOperTypeEnum fromValue(Integer value) {
        OrderTraceDetailOperTypeEnum data = valueLookup.get(value);
        return data;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }
}
