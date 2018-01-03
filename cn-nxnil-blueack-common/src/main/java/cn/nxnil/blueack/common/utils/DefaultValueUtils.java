package cn.nxnil.blueack.common.utils;


import cn.nxnil.blueack.common.BizConstant;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 校验入参
 *
 * @author: liuyangsheng
 * @return 错误返回出错信息，正确返回null
 */
public class DefaultValueUtils {
    public static String null2BlankStr(Object src) {
        if (Objects.isNull(src)) {
            return BizConstant.EMPTY_STRING;
        } else {
            return src.toString();
        }
    }

    public static Integer null2MinusOne(Integer src) {
        if (Objects.isNull(src)) {
            return -1;
        } else {
            return src;
        }
    }

    public static Integer null2LogicNull(Integer src) {
        if (Objects.isNull(src)) {
            return BizConstant.LOGIC_NULL;
        } else {
            return src;
        }
    }

    public static Integer null2Zero(Integer src) {
        if (Objects.isNull(src)) {
            return 0;
        } else {
            return src;
        }
    }

    public static BigDecimal null2BigDecimalMinusOne(BigDecimal src) {
        if (Objects.isNull(src)) {
            return new BigDecimal(-1);
        } else {
            return src;
        }
    }

    public static BigDecimal nullDMS(Double src) {
        if (Objects.isNull(src)) {
            return new BigDecimal(0.01);
        } else {
            return new BigDecimal(src.toString());
        }
    }

    public static String logicNull2BlankStr(BigDecimal src) {
        return logicNull2BlankStrScale(src, 2);
    }

    public static String logicNull2Zero(BigDecimal src) {
        if (Objects.isNull(src) || src.compareTo(BigDecimal.valueOf(BizConstant.LOGIC_NULL)) == 0) {
            return BizConstant.ZERO_STR;
        } else {
            if (new BigDecimal(src.intValue()).compareTo(src) == 0) {
                return String.valueOf(src.setScale(0, BigDecimal.ROUND_HALF_UP));
            } else {
                return String.valueOf(src.setScale(2, BigDecimal.ROUND_HALF_UP));
            }
        }
    }

    /**
     * 仅保留整数部分
     *
     * @param src
     * @return
     */
    public static String logicNull2BlankStrTrim(BigDecimal src) {
        if (Objects.isNull(src) || src.compareTo(BigDecimal.valueOf(BizConstant.LOGIC_NULL)) == 0) {
            return BizConstant.EMPTY_STRING;
        } else {
            return String.valueOf(src.intValue());
        }
    }

    /**
     * 精度换算
     *
     * @param src
     * @return
     */
    public static String logicNull2BlankStrScale(BigDecimal src, int scale) {
        if (Objects.isNull(src) || src.compareTo(BigDecimal.valueOf(BizConstant.LOGIC_NULL)) == 0) {
            return BizConstant.EMPTY_STRING;
        } else {
            if (new BigDecimal(src.intValue()).compareTo(src) == 0) {
                return String.valueOf(src.setScale(0, BigDecimal.ROUND_HALF_UP));
            } else {
                return String.valueOf(src.setScale(scale, BigDecimal.ROUND_HALF_UP));
            }
        }
    }

    public static Date logicNull2Null(Date src) {
        if (Objects.isNull(src) || src.compareTo(BizConstant.LOGIC_NULL_TIME) == 0) {
            return null;
        } else {
            return src;
        }
    }

    public static String logicNull2BlankStr(Double src) {
        if (Objects.isNull(src) || src.intValue() == BizConstant.LOGIC_NULL) {
            return BizConstant.EMPTY_STRING;
        } else {
            return src.toString();
        }
    }

    public static String logicNull2BlankStr(Integer src) {
        if (Objects.isNull(src) || src.intValue() == BizConstant.LOGIC_NULL) {
            return BizConstant.EMPTY_STRING;
        } else {
            return src.toString();
        }
    }

    public static String logicNull2BlankStr(String src) {
        if (Objects.isNull(src) || src.equals(BizConstant.LOGIC_NULL_STRING)) {
            return BizConstant.EMPTY_STRING;
        } else {
            return src;
        }
    }
}
