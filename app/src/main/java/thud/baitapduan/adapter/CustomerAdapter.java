package thud.baitapduan.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import thud.baitapduan.dbhelper.DbHelper;
import thud.baitapduan.model.Customer;

public class CustomerAdapter {
    private DbHelper myDbHelper;
    private SQLiteDatabase db;
    private String[] allColumns = {
            DbHelper.C_ID,
            DbHelper.C_NAME,
            DbHelper.C_PWD,
            DbHelper.C_EMAIL,
            DbHelper.C_PHONE,
    };

    public CustomerAdapter(Context context) {
        myDbHelper = new DbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }

    public long insertCustomer(Customer customer) {
        db = myDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbHelper.C_NAME, customer.getCustomer_name());
        values.put(DbHelper.C_PWD, customer.getCustomer_password());
        values.put(DbHelper.C_EMAIL, customer.getCustomer_email());
        values.put(DbHelper.C_PHONE, customer.getCustomer_phoneNumber());
        return db.insert(DbHelper.TABLE_CUSTOMER, null, values);
    }

//    public int updateCustomer(int id, String name, String email, String phoneNumber) {
//        ContentValues values = new ContentValues();
//        values.put(DbHelper.C_NAME, name);
//        values.put(DbHelper.C_EMAIL, email);
//        values.put(DbHelper.C_PHONE, phoneNumber);
//        return db.update(DbHelper.TABLE_CUSTOMER, values,
//                DbHelper.C_ID + "=" + id, null);
//    }
//
//    public int deleteCustomer(int id) {
//        return db.delete(DbHelper.TABLE_CUSTOMER,
//                DbHelper.C_ID + "=" + id, null);
//    }

    private Customer cursorToCustomer(Cursor cursor) {
        Customer value = new Customer();
        value.setCustomer_id(cursor.getInt(0));
        value.setCustomer_name(cursor.getString(1));
        value.setCustomer_email(cursor.getString(2));
        value.setCustomer_phoneNumber(cursor.getString(3));
        return value;
    }

    public List<Customer> ListAllCustomer() {
        List<Customer> listCustomer = new ArrayList<Customer>();
        Cursor cursor = db.query(DbHelper.TABLE_CUSTOMER, allColumns,
                null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Customer value = cursorToCustomer(cursor);
                listCustomer.add(value);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return listCustomer;
    }

//    public Boolean checkIfExisted(int id) {
//        Boolean existed = false;
//        List<Customer> listCustomer = ListAllCustomer();
//        int i = 0;
//        while ((!existed) && (i < listCustomer.size()))
//            if (listCustomer.get(i).getCustomer_id() == id)
//                existed = true;
//            else
//                i++;
//        return existed;
//    }

    public void Close() {
        db.close();
        myDbHelper.close();
    }
}
