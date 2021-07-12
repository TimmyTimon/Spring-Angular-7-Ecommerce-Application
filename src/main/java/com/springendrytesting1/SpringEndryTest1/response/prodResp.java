package com.springendrytesting1.SpringEndryTest1.response;

import java.util.*;
import com.springendrytesting1.SpringEndryTest1.model.*;

public class prodResp {

    private String message;

    private List<Product> oblist;

    public prodResp(){

    }

    public prodResp(String message, List<Product> oblist) {
        this.message = message;
        this.oblist = oblist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getOblist() {
        return oblist;
    }

    public void setOblist(List<Product> oblist) {
        this.oblist = oblist;
    }
}
