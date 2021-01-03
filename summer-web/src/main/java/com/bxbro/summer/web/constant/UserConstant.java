package com.bxbro.summer.web.constant;

/**
 * @Description 用户常量类
 * @Author dong
 * @Date 2020/12/6
 */
public class UserConstant {

    /**
     * 性別
     */
    public enum Gender{
        WOMEN("女", 0), MAN("男", 1), UNKNOWN("未知", 2);
        /**
         * 名称
         */
        private String name;
        /**
         * 编码
         */
        private Integer code;

        Gender(String name, Integer code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }

    /**
     * 在线状态
     */
    public enum Online{
        OFFLINE("离线", 0), ONLINE("在线", 1);

        /**
         * 名称
         */
        private String name;
        /**
         * 编码
         */
        private Integer code;

        Online(String name, Integer code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }
    }


}
