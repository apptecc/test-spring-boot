package cn.nxnil.blueack.common.enums;

import static cn.nxnil.blueack.common.BizConstant.CACHE_PREFIX;

/**
 * @author by sonic on 16/11/7.
 */
public enum RedisEnum {

    START("START", "START FROM HERE", 60L * 10), //10分钟

    GOODS_DMS_INFOS(CACHE_PREFIX + "dms", "DMS信息", 60L * 10), //10分钟

    END("END", "END OF REDIS ENUM", 60L * 60 * 24); //1小时

    public final String key;
    public final String desc;
    public final long expired;

    RedisEnum(String key, String desc, long expired) {
        this.key = key;
        this.desc = desc;
        this.expired = expired;
    }

}
