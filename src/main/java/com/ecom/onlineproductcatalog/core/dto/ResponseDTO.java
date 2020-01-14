package com.ecom.onlineproductcatalog.core.dto;

import java.util.Map;

public class ResponseDTO {
    private String Comment;
    private String code;
    private Map<String,Object> responseData;
    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getResponseData() {
        return responseData;
    }

    public void setResponseData(Map<String, Object> responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" + "Comment='" + Comment + '\'' + ", code='" + code + '\'' + ", responseData=" + responseData + '}';
    }
}
