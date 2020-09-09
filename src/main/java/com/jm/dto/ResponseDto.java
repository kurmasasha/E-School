package com.jm.dto;

public class ResponseDto<T> {

    private Integer code;
    private Boolean success;
    private String text;
    private T data;

    public ResponseDto(Integer code, Boolean success, String text, T data) {
        this.code = code;
        this.success = success;
        this.text = text;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public ResponseDto() {}

    public static ResponseBuilder<?> error(){
        return new ResponseBuilder<>(404, false);
    }

    public static ResponseBuilder<?> ok(){
        return new ResponseBuilder<>(200, true);
    }

    public static <T> ResponseBuilder<T> ok(T object){
        return new ResponseBuilder<>(object);
    }


    private static class ResponseBuilder<T>{

        private final ResponseDto<T> build = new ResponseDto<>();

        public ResponseBuilder(Integer status, Boolean success) {
            build.setCode(status);
            build.setSuccess(success);
        }

        public ResponseBuilder(T object) {
            build.setData(object);
            build.setCode(200);
            build.setSuccess(true);
        }

        public ResponseBuilder<?> code(Integer code){
            build.setCode(code);
            return this;
        }

        public ResponseBuilder<?> text(String text){
            build.setText(text);
            return this;
        }

        public ResponseDto<?> build(){
            return build;
        }

    }


}
