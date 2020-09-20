package com.example.suvodeep.reach

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Database(context:Context):SQLiteOpenHelper(context,dbname,factory,version){

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user(id integer primary key autoincrement,"+
                "name varchar(30),email varchar(100), password varchar(20),identity_number varchar(30),mobile_no varchar(10),address varchar(100)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertUserData(name:String, email:String, password:String){
        val db:SQLiteDatabase = writableDatabase
        val values:ContentValues= ContentValues()
        values.put("name",name)
        values.put("email",email)
        values.put("password",password)

        db.insert("user",null,values)
        db.close()
    }

    fun userPresent(email:String,password:String):Boolean{
        val db=writableDatabase
        val query="select * from user where email='$email' and password='$password'"
        val cursor=db.rawQuery(query,null )
        if (cursor.count<=0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    companion object {
        internal  val dbname="userDB"
        internal val factory=null
        internal val version=1
    }
}