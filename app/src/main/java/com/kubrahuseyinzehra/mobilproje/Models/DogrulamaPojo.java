package com.kubrahuseyinzehra.mobilproje.Models;

public class DogrulamaPojo {
    private String result;
    private Object kadi;
    private Object id;

    private boolean tf;


    public void setResult(String result){
        this.result = result;
    }

    public String getResult(){
        return result;
    }

    public void setKadi(Object kadi){
        this.kadi = kadi;
    }

    public Object getKadi(){
        return kadi;
    }

    public void setId(Object id){
        this.id = id;
    }

    public Object getId(){
        return id;
    }

    public boolean isTf() {return tf;}

    @Override
    public String toString(){
        return
                "DogrulamaPojo{" +
                        "result = '" + result + '\'' +
                        ",kadi = '" + kadi + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}
