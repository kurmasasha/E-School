package com.jm.dto;

import java.util.List;

public class ResponseDto<T> {

    private Integer code;
    private Boolean success;
    private String text;
    private List<FieldError> errors;
    private PageDto<T> data;

    public ResponseDto(Integer code, Boolean success, String text, List<FieldError> errors, PageDto<T> data) {
        this.code = code;
        this.success = success;
        this.text = text;
        this.errors = errors;
        this.data = data;
    }

    /* GETTERS AND SETTERS */

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }

    public PageDto<T> getData() {
        return data;
    }

    public void setData(PageDto<T> data) {
        this.data = data;
    }
}
