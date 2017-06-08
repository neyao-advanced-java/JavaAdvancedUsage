package org.oursight.neyao.java.advanced.apache.commons.lang3;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by yaonengjun on 170506.
 */
public class ToStringStyleUsage {

    public static void main(String[] args) {
        ToStringStyleUsage usage = new ToStringStyleUsage("zhangsna", "lisi");

        System.out.println(ToStringBuilder.reflectionToString(usage, ToStringStyle.DEFAULT_STYLE));
        System.out.println();

        System.out.println(ToStringBuilder.reflectionToString(usage, ToStringStyle.SHORT_PREFIX_STYLE));
        System.out.println();

        System.out.println(ToStringBuilder.reflectionToString(usage, ToStringStyle.JSON_STYLE));
        System.out.println();
    }

    public ToStringStyleUsage(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private String name;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
