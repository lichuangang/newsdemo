package ${basepackage}.entity;

/**
 * Created by chuangang.li on 2017/1/19.
 */
public class MsxfResult {
    private int code = 200;

    private String msg = "";

    private Object data = null;

    public MsxfResult() {
    }

    public MsxfResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 默认code 500
     */
    public MsxfResult(String msg) {
        this.code = 500;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public void setData(Object data) {
        this.data = data;
    }
}
