package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String[] args){

        // 数据库图标(数据库框架的)
        // 参数1 数据库的版本号(具体数字无所谓,有一个就行)
        // 参数2 自动生成代码的包名
        Schema schema =new Schema(1,"com.roy.coffeetrip.greendaolite");
        addNote(schema);

        // 自动生成代码
        // 参数1 图标对象 参数2 自动生成的代码路径
        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java/");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addNote(Schema schema) {

        // ()里添加表名
        Entity entity =schema.addEntity("Collection");
        // 添加ID 并ID自增
        entity.addIdProperty().autoincrement().primaryKey();
        //添加类的属性 根据属性生成相对应的队列
        entity.addStringProperty("Title");
        entity.addStringProperty("Url");
        entity.addIntProperty("ContentId");

        Entity entity1 = schema.addEntity("UserName");
        entity1.addIdProperty().autoincrement().primaryKey();
        entity1.addStringProperty("userName");
        entity1.addStringProperty("passWord");
    }

}
