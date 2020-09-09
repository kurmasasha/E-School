package com.jm.dto;

public class ResponseDto<T> {

    private Integer code;
    private Boolean success;
    private String text;
    private PageDto<T> data;

    public ResponseDto(Integer code, Boolean success, String text, PageDto<T> data) {
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

    public PageDto<T> getData() {
        return data;
    }

    public void setData(PageDto<T> data) {
        this.data = data;
    }


    public ResponseDto() {}

    public static ResponseBuilder error(){
        return new ResponseBuilder(404, false);
    }

    public static ResponseBuilder ok(){
        return new ResponseBuilder(200, true);
    }

    public static <T> ResponseBuilder ok(T object){
        return new <T> ResponseBuilder(object);
    }


    private static class ResponseBuilder{

        private static final ResponseDto<?> build = new ResponseDto<>();

        public ResponseBuilder(Integer status, Boolean success) {
            build.setCode(status);
            build.setSuccess(success);
        }

        public <T> ResponseBuilder(T object) {
            build.setData((PageDto) object);
            build.setCode(200);
            build.setSuccess(true);
        }

        public ResponseBuilder code(Integer code){
            build.setCode(code);
            return this;
        }

        public ResponseBuilder text(String text){
            build.setText(text);
            return this;
        }

        public ResponseDto<?> build(){
            return build;
        }

    }

}
