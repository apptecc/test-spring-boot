package cn.nxnil.blueack.common.enums;

import cn.nxnil.blueack.common.BizConstant;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author apptec
 */
public enum PromoIncreInfoResponseCodeEnum implements GenericStringEnum {
    //S200 请求成功
    HTTP_PRICE_INCRE_SUCCESS(BizConstant.HTTP_PRICE_INCRE_SUCCESS, "请求成功"),
    //E416 返回数量大于等于10000
    HTTP_PRICE_INCRE_RESULT_TOO_LARGE(BizConstant.HTTP_PRICE_INCRE_RESULT_TOO_LARGE, "返回数量大于等于10000"),
    //E404 找不到结果(增量数据为空, 不认为是错误)
    HTTP_PRICE_INCRE_FAIL(BizConstant.HTTP_PRICE_INCRE_FAIL, "找不到结果"),;

    /*******************************************
     * 注意：如果添加枚举类型，请修改Map容器的大小
     ******************************************/
    private static final Map<String, PromoIncreInfoResponseCodeEnum> valueLookup = new ConcurrentHashMap<String, PromoIncreInfoResponseCodeEnum>(values().length);

    static {
        for (PromoIncreInfoResponseCodeEnum type : EnumSet.allOf(PromoIncreInfoResponseCodeEnum.class)) {
            valueLookup.put(type.value, type);
        }
    }

    private final String value;
    private final String name;

    PromoIncreInfoResponseCodeEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public static PromoIncreInfoResponseCodeEnum resolve(String value) {

        return (value != null ? valueLookup.get(value) : null);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getName() {

        return name;
    }
}
