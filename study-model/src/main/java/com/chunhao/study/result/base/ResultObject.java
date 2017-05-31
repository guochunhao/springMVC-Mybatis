package com.chunhao.study.result.base;

/**
 * Created by count on 17/3/17.
 */
public class ResultObject extends Result
{
    private Object object;

    public ResultObject(Integer resultCode, String resultMessage)
    {
        super(resultCode, resultMessage);
    }

    public ResultObject()
    {
        super();
    }

    public Object getObject()
    {
        return object;
    }

    public void setObject(Object object)
    {
        this.object = object;
    }
}

