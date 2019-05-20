package jdk8;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description Nashorn  JavaScript
 * @create 2018-12-12 8:59
 * @since 1.7
 */
public class Java8Tester10 {
    //Java中调用JavaScript
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Runoob";
        Integer result = null;

        try{
            nashorn.eval("print('"+name+"')");
            result = (Integer) nashorn.eval("10 + 2");

        } catch (ScriptException e) {
            System.out.println("执行脚本错误:" + e.getMessage());
        }

        System.out.println(result.toString());
    }
}
