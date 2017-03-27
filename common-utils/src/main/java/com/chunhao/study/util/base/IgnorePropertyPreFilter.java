package com.chunhao.study.util.base;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by count on 17/3/17.
 */
public class IgnorePropertyPreFilter extends SimplePropertyPreFilter
{
    private Set<String> excludes = new HashSet<String>();

    public void setExcludes(Set<String> excludes)
    {
        this.excludes = excludes;
    }

    public IgnorePropertyPreFilter(String... properties)
    {
        this.excludes.addAll(Arrays.asList(properties));
    }

    @Override
    public Set<String> getExcludes()
    {
        return super.getExcludes();
    }

    @Override
    public boolean apply(JSONSerializer serializer, Object source, String name)
    {
        if (null == source)
        {
            return true;
        }

        return !this.excludes.contains(name);
    }
}
