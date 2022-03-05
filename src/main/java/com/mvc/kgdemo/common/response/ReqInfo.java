package com.mvc.kgdemo.common.response;

import com.mvc.kgdemo.common.constant.ResponseMsgConstant;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;


import java.util.*;

/**
 * 请求数据对象工具类，对应老系统格式
 *  * @author lxf
 */
public class ReqInfo extends HashMap<String, Object> {
    public ReqInfo() {
    }

    public  ReqInfo ok() {
        return ok(ResponseMsgConstant.SUCCESS.getMsg());
    }
    public  ReqInfo ok(String msg) {
        this.put(ResponseMsgConstant.CODE_KEY, ResponseMsgConstant.SUCCESS.getCode());
        this.put(ResponseMsgConstant.MSG_KEY, msg);
        return this;
    }
    public  ReqInfo error(String msg) {
        this.put(ResponseMsgConstant.CODE_KEY, ResponseMsgConstant.ERROR.getCode());
        this.put(ResponseMsgConstant.MSG_KEY, msg);
        return this;
    }
    public  ReqInfo status(int status) {
        this.put("status",status);
        return this;
    }
    /**
     * 获取对象的子数组集
     * @param arrayKey 数组对象属性名
     * @return
     * @throws Exception
     */
    public BlockList getBlockList(String arrayKey) {
        Object blockList=this.get(arrayKey);
        if(blockList==null){
            this.put(arrayKey,new BlockList());
        }
        if(!blockList.getClass().equals(BlockList.class)){
            BlockList blockListNew=  new BlockList();
            blockListNew.addAll((Collection<? extends Map<String, Object>>) blockList);
            this.put(arrayKey,blockListNew);
            return blockListNew;
        }
        return (BlockList) blockList;
    }
    /**
     * 获取对象的子数组集
     * @param arrayKey 数组对象属性名
     * @return
     * @throws Exception
     */
    public BlockList addBlockList(String arrayKey,List arrays){
        BlockList blockList=new BlockList();
        blockList.addAll(arrays);
        this.put(arrayKey,blockList);
        return blockList;
    }

    /**
     * 获取对象的子对象
     * @param objectKey 数组对象属性名
     * @return
     * @throws Exception
     */
    public Block getBlock(String objectKey)  {
        Object block=this.get(objectKey);
        if(block==null){
            return null;
        }
        if(block instanceof  Block){
        }else{
            if(block instanceof List){
                BlockList blockList=new BlockList();
                blockList.addAll(block);
                this.put(objectKey,blockList);
                return blockList;
            }else{
                BlockObject blockNew=  new BlockObject();
                blockNew.putAll((Map<? extends String, ?>) block);
                this.put(objectKey,blockNew);
                return blockNew;
            }
        }
        return (Block) this.get(objectKey);
    }

    public Object getCell(String objectKey, int i, String key) throws Exception {
        Block block=getBlock(objectKey);
        if(block instanceof  BlockList ){
           return block.getCell(i,key);
        }else{
           return block.getValue(key);
        }
    }
    public String getCellStr(String objectKey, int i, String key) throws Exception {
        Object obj= getCell(objectKey, i,  key);
        if(obj!=null){
            return obj.toString();
        }
        return "";
    }

    public void addBlock(String objectKey,Object object) {
        if(object!=null && object instanceof  List){
            addBlockList(objectKey, (List) object);
        }else{
            this.put(objectKey,object);
        }
    }
    public Block addBlock(String objectKey) {
        Block block=getBlock(objectKey);
        if(block==null){
            block=new BlockObject();
            this.put(objectKey,block);
        }
        return block;
    }

    public void setCell(String objectKey, int i, String name, Object value) {
        addBlock(objectKey).putValue(name,value);
    }

    public void set(String k, Object v) {
        this.put(k,v);
    }

    public int getStatus() {
        Object v= this.get("status");
        if(v!=null){
            return Integer.parseInt(v.toString());
        }
        return 0;
    }

    public String getMsg() {
        Object v= this.get(ResponseMsgConstant.MSG_KEY);
        if(v!=null){
            return v.toString();
        }
        return "";
    }

    public void setStatus(int i) {
        status(i);
    }

    public void setMsg(String s) {
        this.put(ResponseMsgConstant.MSG_KEY,s);
    }

    public Integer getLimit() {
        Object v= this.get("size");
        if(v!=null){
            return Integer.parseInt(v.toString());
        }
        return 50;
    }
    public Integer getSize() {
        Object v= this.get("size");
        if(v!=null){
            return Integer.parseInt(v.toString());
        }
        return 50;
    }

    public Integer getPage() {
        Object v= this.get("page");
        if(v!=null){
            return Integer.parseInt(v.toString());
        }
        return 1;
    }

    public interface Block {
        public void setCell(int i, String name, Object value)throws Exception ;
        public Object getCell(int i, String name)throws Exception;
        public String getCellStr(int i, String name)throws Exception;
        public int getRowCount()throws Exception;
        public void putAll(Object block);
        public void putValue(String name, Object value);
        public Object getValue(String name);

        Object getRow(int i) throws Exception;
        Map<String ,?extends Object> getRowMap(int i) throws Exception;

        String getCellNStr(int i, String tareWeight)throws Exception;
    }
    /**
     * 数组集
     */
    public class BlockList extends ArrayList<Object> implements Block {
        public int getRowCount() {
            return this.size();
        }

        @Override
        public void putAll(Object block)  {
            new Exception("BlockList集合不能批量放入属性").printStackTrace();
        }
        public void putValue(String name, Object value)  {
            new Exception("BlockList集合不能放入属性").printStackTrace();
        }
        public Object getValue(String name)  {
            throw new UnsupportedOperationException();
           /* new Exception("BlockList集合不能获取属性").printStackTrace();
            return null;*/
        }
        public void addAll(Object block) {
            super.addAll((Collection<? extends Map<String, Object>>) block);
        }

        public Object getRow(int i) throws Exception {
            if(i>=this.size()){
                throw new Exception("数组没有索引号:"+i+"为的对象！") ;
            }
            Object row =this.get(i);
            return row;
        }
        public Map<String ,?extends Object> getRowMap(int i) throws Exception {
            if(i>=this.size()){
                throw new Exception("数组没有索引号:"+i+"为的对象！") ;
            }
            Object row =this.get(i);
            if(row instanceof  Map){
                return (Map<String, ? extends Object>) row;
            }
            else{
              return  BeanUtils.describe(row) ;
            }
        }

        public String getCellStr(int i, String key) throws Exception {
            Map map=getRowMap(i);
            Object v= map.get(key);
            if(v==null){
                return "";
            }
            return v.toString();
        }
        /**
         * 获得数字字符串，默认0
         * @param i
         * @param key
         * @return
         * @throws Exception
         */
        public String getCellNStr(int i, String key) throws Exception {
            Map map=getRowMap(i);
            Object v= map.get(key);
            if(v==null){
                return "0";
            }
            return v.toString();
        }
        public Object getCell(int i, String key) throws Exception {
            Map map=getRowMap(i);
            Object v= map.get(key);
            return v;
        }

        public void setCell(int i, String itemName, Object value) throws Exception {
            Map map=getRowMap(i);
            map.put(itemName,value);
            this.set(i,map);
        }
    }
    /**
     * 对象，map
     */
    public class BlockObject extends HashMap implements Block{
        public int getRowCount() {
            return 0;
        }
        @Override
        public void putAll(Object block) {
            try{
                if(block instanceof  Map){
                    super.putAll((Map) block);
                }else{
                    Map map=  PropertyUtils.describe(this);
                    super.putAll(map);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        @Override
        public void putValue(String name, Object value) {
            super.put(name,value);
        }
        @Override
        public Object getValue(String name) {
            return this.get(name);
        }

        @Override
        public Map<String,? extends Object> getRowMap(int i) {
            throw new UnsupportedOperationException();
        }  @Override
        public Object getRow(int i) {
            throw new UnsupportedOperationException();
        }


        public void setCell(int i, String name, Object value) {
            this.put(name,value);
        }

        public Object getCell(int i, String name) throws Exception {
            return this.get(name);
        }
        public String getCellStr(int i, String name) throws Exception {
            Object value=this.get(name);
            if(value==null){
                return "";
            }
            return value.toString();
        }
        /**
         * 获得数字字符串，默认0
         * @param i
         * @param key
         * @return
         * @throws Exception
         */
        public String getCellNStr(int i, String key) throws Exception {
            Object v= this.get(key);
            if(v==null){
                return "0";
            }
            return v.toString();
        }
    }
}
