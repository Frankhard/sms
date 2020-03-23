package com.sms.model;

public class ResponseModel {
    private boolean success;
    private String msg;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
    public ResponseModel(){}

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){this.success=success;}

    public String getMsg(){return msg;}

    public void setMsg(String msg){this.msg=msg;}

    public ResponseModel(String msg){
        this.setSuccess(true);
        this.setMsg(msg);
    }

    public ResponseModel(boolean success,String msg){
        this.setSuccess(success);
        this.setMsg(msg);
    }
    public ResponseModel(boolean success,String msg,String token){
        this.setSuccess(success);
        this.setMsg(msg);
        this.setToken(token);
    }

}
