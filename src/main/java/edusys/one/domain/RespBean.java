package edusys.one.domain;

/**
 * @Author: 张灿
 * @Time: 2020/1/2 22:22
 * 返回类
 */

public class RespBean {
    /**
     * 状态码
     */
    private Integer status;

    /**
     * 返回信息
     */
    private String msg=null;

    /**
     * 返回数据
     */
    private Object data;

    public static RespBean ok(String msg){
        return new RespBean(200,null,null);
    }

    public static RespBean ok(String msg,Object obj){
        return new RespBean(200,msg,obj);
    }

    public static RespBean error(String msg){
        return new RespBean(500,null,null);
    }

    public static RespBean error(String msg,Object obj){
        return new RespBean(500,msg,obj);
    }

    private RespBean(){
    }

    private RespBean(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }
}
