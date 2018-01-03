package cn.nxnil.blueack.common;

import lombok.Data;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 业态常量类
 * Created by lumian on 2017/5/11.
 */
@Data
public class BizConstant {

    public static final String ENV_PROD = "prod";
    public static final Date MYSQL_LARGE_DATE = DateTime.parse("2038-01-01").toDate();
    //订单追踪明细操作类型
    public static final int CREATE = 0; //创建
    public static final int AUDIT = 1;//审核
    public static final int ORDER = 2;//出单
    public static final int DISTRIBUTION = 3;//分配
    public static final int SEND = 4;//发货
    public static final int RECEIVE = 5;//收货
    public static final int FINISH = 6;//完成
    public static final int CANCEL = 7;//取消
    public static final int SYSTEM_RESET = 8;//系统置零
    public static final int NEGATIVE_ONE = -1;
    public static final String SAP_ORDER_DISTRIBUTE_REMARKS = "无法匹配详情";
    // sync_flag，处理标识 0未处理 1已处理
    public static final int UNHANDLED = 0; // 0未处理
    public static final int HANDLED = 1;  // 1已处理
    public static final int HANDLE_ERR = 2;  // 2处理异常

    //枚举 全部
    public static final String ALL_STR = "999";
    public static final Integer ALL_INT = 999;
    public static final String CACHE_PREFIX = "yh:b2b:dmscenter:";
    public static final String CALC_INV_ONWAY_QUEUE = CACHE_PREFIX + "QUEUE_INV_ONWAY_CALC"; //在途库存的redis的队列名


    //字符
    public static final String ZERO_STR = "0";
    public static final String UNDERLINE = "_";
    public static final String MID_LINE = "-";
    public static final String EMPTY_STRING = "";
    public static final String COMMA = ",";
    public static final String SPACE = " ";
    public static final String SYS = "SYS";

    public static final Date LOGIC_NULL_TIME = DateTime.parse("1990-09-09T09:09:09").toDate();
    public static final String LOGIC_NULL_STRING = "-999999999"; //逻辑空
    public static final int LOGIC_NULL = -999999999; //逻辑空
    public static final BigDecimal LOGIC_NULL_DECIMAL = BigDecimal.valueOf(LOGIC_NULL); //逻辑空


    //http price incre 状态码
//    S200 请求成功
//    E416 返回数量⼤于等于10000
//    E404 找不到结果
    public static final String HTTP_PRICE_INCRE_SUCCESS = "S200";
    public static final String HTTP_PRICE_INCRE_RESULT_TOO_LARGE = "E416";
    public static final String HTTP_PRICE_INCRE_FAIL = "E404";

    //batch update size
    public static final int BATCH_UPDATE_SIZE = 2000;
    public static final String DEFAULT_PROMO_NO = "";
    public static final String IS_MEMBER_STR = "1";//会员
    public static final String NOT_MEMBER_STR = "0";//非会员

    //
    public static final DateTimeFormatter PROMO_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
    //时区
    public static final ZoneOffset ZONE_OFFSET = ZoneOffset.of("+8");

    //商品校验批处理阈值
    public static final int HTTP_LOCATION_BATCH_SIZE = 100;
    public static final int INCRE_RETRY_TIMES = 10;

}
