package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;


public class Car {

        @Max(value = 100 ,message = "id不能大于100")
        private Integer id;
        @NotBlank(message="用户名不能为空")
        @Length(min = 2, max = 10, message = "用户名 长度必须在 {min} - {max} 之间")
        private String name;
        @DecimalMin(value="1.0",message="价格最低1元")
        @DecimalMax(value="10.0",message="价格最高10元")
        private Float price;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM+8")
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date createdate;
        //忽略字段不能转化为json
        @JsonIgnore
        private String memo;
        //当属性为空的时候不能转化为json
        @JsonInclude
        @NotNull(message="属性字段不能为空")
        @NotBlank(message="属性字段不能为空白")
        private String isnull;
        @NotBlank(message="手机号不能为空")
        @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",
                message = "手机号格式不合法")
        private String mobeil;

        //验证邮箱格式
        @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",
                message = "邮箱格式不合法")
        private String email;

        public String getMobeil() {
                return mobeil;
        }

        public void setMobeil(String mobeil) {
                this.mobeil = mobeil;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Car(Integer id, String name, Float price, Date createdate, String memo, String isnull) {
                this.id = id;
                this.name = name;
                this.price = price;
                this.createdate = createdate;
                this.memo = memo;
                this.isnull = isnull;
        }

        public Car() {
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Float getPrice() {
                return price;
        }

        public void setPrice(Float price) {
                this.price = price;
        }

        public Date getCreatedate() {
                return createdate;
        }

        public void setCreatedate(Date createdate) {
                this.createdate = createdate;
        }

        public String getMemo() {
                return memo;
        }

        public void setMemo(String memo) {
                this.memo = memo;
        }

        public String getIsnull() {
                return isnull;
        }

        public void setIsnull(String isnull) {
                this.isnull = isnull;
        }

}
