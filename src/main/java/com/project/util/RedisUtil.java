package com.project.util;

import com.alibaba.fastjson.JSONObject;
import com.project.common.utils.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 缓存工具类
 */
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    public HashOperations opsHash(){
        return redisTemplate.opsForHash();
    }

    public boolean set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        return redisTemplate.hasKey(key);
    }

    public  <T extends Serializable> boolean  set(String key, T t){
        return set(key, JSONObject.toJSONString(t));
    }
    public String get(String key){
        if(StringUtils.isEmpty(key)){
            return null;
        }
        if(redisTemplate.hasKey(key)){
            Object val=redisTemplate.opsForValue().get(key);
            return Objects.isNull(val)?"":val.toString();
        }
        return null;
    }

    public <T> T get(String key,Class<T> cls){
        String val=get(key);
      return StringUtils.isEmpty(val)?null:JSONObject.parseObject(val,cls);
    }

    public boolean delete(String key){
     return   redisTemplate.delete(key);
    }

    public boolean hput(String key,String hkey,String value){
        redisTemplate.opsForHash().put(key,hkey,value);
        return redisTemplate.opsForHash().hasKey(key,hkey);
    }

    public <T extends Serializable> boolean hput(String key,String hkey,T value){
        return hput(key,hkey,JSONObject.toJSONString(value));
    }


    public String hget(String key,String hkey){

        if(StringUtils.isEmpty(key)||StringUtils.isEmpty(hkey)){
            return null;
        }

        if(redisTemplate.opsForHash().hasKey(key,hkey)){
            Object val=   redisTemplate.opsForHash().get(key,hkey);
            return Objects.isNull(val)?"":val.toString();
        }
    return null;
    }

    public <T> T hget(String key,String hkey,Class<T> cls){

        String val=hget(key,hkey);
        return StringUtils.isEmpty(val)?null:JSONObject.parseObject(val,cls);
    }
    public <T> List<T> hgetArray(String key,String hkey,Class<T> cls){
        String val=hget(key,hkey);
        return StringUtils.isEmpty(val)?new ArrayList<>():JSONObject.parseArray(val,cls);
    }
//
//    public <T  extends Serializable> boolean setList(String key, T... ts){
//        long size=redisTemplate.opsForList().size(key);
//        List<String> list=new ArrayList<>();
//        for (T t : ts) {
//            list.add(JSONObject.toJSONString(t));
//        }
//        redisTemplate.opsForList().leftPushAll(key,list);
//        return redisTemplate.opsForList().size(key)-list.size()!=size?false:true;
//    }
//
//    public  List<T> getList(String key){
//        List<T> list=redisTemplate.opsForList().range(key,0,-1);
//        return list;
//    }



}
